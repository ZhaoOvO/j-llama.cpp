package cn.hthcorp.llama;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.jetbrains.annotations.Nullable;

/**
 * @ClassName LlamaLoader
 * @Description TODO
 * @Author Aaron
 * @Date 2025/1/9 16:52
 * @Version V1.0
 */
class LlamaLoader {
	private static boolean extracted = false;

	LlamaLoader() {
	}

	static synchronized void initialize() throws UnsatisfiedLinkError {



		if (!extracted) {
			cleanup();
		}

		if ("Mac".equals(OSInfo.getOSName())) {
			String nativeDirName = getNativeResourcePath();
			String tempFolder = getTempDir().getAbsolutePath();
			System.out.println(nativeDirName);
			Path metalFilePath = extractFile(nativeDirName, "ggml-metal.metal", tempFolder, false);
			if (metalFilePath == null) {
				System.err.println("'ggml-metal.metal' not found");
			}
		}

		loadNativeLibrary("ggml");
		loadNativeLibrary("llama");
		loadNativeLibrary("jllama");
		extracted = true;
	}

	private static void cleanup() {
		try {
			Stream<Path> dirList = Files.list(getTempDir().toPath());

			try {
				dirList.filter(LlamaLoader::shouldCleanPath).forEach(LlamaLoader::cleanPath);
			} catch (Throwable e) {
				try {
					dirList.close();
				} catch (Throwable throwable) {
					e.addSuppressed(throwable);
				}
				throw e;
			}
			dirList.close();
		} catch (IOException e) {
			System.err.println("Failed to open directory: " + e.getMessage());
		}

	}

	private static boolean shouldCleanPath(Path path) {
		String fileName = path.getFileName().toString();
		return fileName.startsWith("jllama") || fileName.startsWith("llama");
	}

	private static void cleanPath(Path path) {
		try {
			Files.delete(path);
		} catch (Exception e) {
			System.err.println("Failed to delete old native lib: " + e.getMessage());
		}

	}

	private static void loadNativeLibrary(String name) {
		List<String> triedPaths = new LinkedList<>();
		String nativeLibName = System.mapLibraryName(name);
		String nativeLibPath = System.getProperty("cn.hthcorp.llama.lib.path");
		if (nativeLibPath != null) {
			Path path = Paths.get(nativeLibPath, nativeLibName);
			if (loadNativeLibrary(path)) {
				return;
			}

			triedPaths.add(nativeLibPath);
		}

		if (OSInfo.isAndroid()) {
			try {
				System.loadLibrary(name);
				return;
			} catch (UnsatisfiedLinkError var10) {
				triedPaths.add("Directly from .apk/lib");
			}
		}

		String javaLibraryPath = System.getProperty("java.library.path", "");

		for(String ldPath : javaLibraryPath.split(File.pathSeparator)) {
			if (!ldPath.isEmpty()) {
				Path path = Paths.get(ldPath, nativeLibName);

				if (loadNativeLibrary(path)) {
					return;
				}

				triedPaths.add(ldPath);
			}
		}

		nativeLibPath = getNativeResourcePath();
		if (hasNativeLib(nativeLibPath, nativeLibName)) {
			String tempFolder = getTempDir().getAbsolutePath();
			if (extractAndLoadLibraryFile(nativeLibPath, nativeLibName, tempFolder)) {
				return;
			}

			triedPaths.add(nativeLibPath);
		}

		throw new UnsatisfiedLinkError(String.format("No native library found for os.name=%s, os.arch=%s, paths=[%s]", OSInfo.getOSName(), OSInfo.getArchName(), String.join(File.pathSeparator, triedPaths)));
	}

	private static boolean loadNativeLibrary(Path path) {
		if (!Files.exists(path)) {
			return false;
		} else {
			String absolutePath = path.toAbsolutePath().toString();

			try {
				System.load(absolutePath);
				return true;
			} catch (UnsatisfiedLinkError e) {
				System.err.println(e.getMessage());
				System.err.println("Failed to load native library: " + absolutePath + ". osinfo: " + OSInfo.getNativeLibFolderPathForCurrentOS());
				return false;
			}
		}
	}

	private static @Nullable Path extractFile(String sourceDirectory, String fileName, String targetDirectory, boolean addUuid) {
		String nativeLibraryFilePath = sourceDirectory + "/" + fileName;
		Path extractedFilePath = Paths.get(targetDirectory, fileName);

		try {
			try {
				InputStream reader = LlamaLoader.class.getResourceAsStream(nativeLibraryFilePath);

				label205: {
					try {
						if (reader != null) {
							Files.copy(reader, extractedFilePath, StandardCopyOption.REPLACE_EXISTING);
							break label205;
						}
					} catch (Throwable e) {
						try {
							reader.close();
						} catch (Throwable throwable) {
							e.addSuppressed(throwable);
						}
						throw e;
					}
					return null;
				}
				reader.close();
			} finally {
				extractedFilePath.toFile().deleteOnExit();
			}

			extractedFilePath.toFile().setReadable(true);
			extractedFilePath.toFile().setWritable(true, true);
			extractedFilePath.toFile().setExecutable(true);
			InputStream inputStream = LlamaLoader.class.getResourceAsStream(nativeLibraryFilePath);

			try {
				InputStream extractedLibIn = Files.newInputStream(extractedFilePath);
				try {
					if (!contentsEquals(inputStream, extractedLibIn)) {
						throw new RuntimeException(String.format("Failed to write a native library file at %s", extractedFilePath));
					}
				} catch (Throwable e) {
					try {
						extractedLibIn.close();
					} catch (Throwable throwable) {
						e.addSuppressed(throwable);
					}
					throw e;
				}

				extractedLibIn.close();
			} catch (Throwable e) {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (Throwable throwable) {
						e.addSuppressed(throwable);
					}
				}
				throw e;
			}

			if (inputStream != null) {
				inputStream.close();
			}

			System.out.println("Extracted '" + fileName + "' to '" + extractedFilePath + "'");
			return extractedFilePath;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	private static boolean extractAndLoadLibraryFile(String libFolderForCurrentOS, String libraryFileName, String targetFolder) {
		Path path = extractFile(libFolderForCurrentOS, libraryFileName, targetFolder, true);
		System.out.println(path);
		return path != null && loadNativeLibrary(path);
	}

	private static boolean contentsEquals(InputStream in1, InputStream in2) throws IOException {
		if (!(in1 instanceof BufferedInputStream)) {
			in1 = new BufferedInputStream(in1);
		}

		if (!(in2 instanceof BufferedInputStream)) {
			in2 = new BufferedInputStream(in2);
		}

		for(int ch = in1.read(); ch != -1; ch = in1.read()) {
			int ch2 = in2.read();
			if (ch != ch2) {
				return false;
			}
		}

		int ch2 = in2.read();
		return ch2 == -1;
	}

	private static File getTempDir() {
		return new File(System.getProperty("cn.hthcorp.llama.tmpdir", System.getProperty("java.io.tmpdir")));
	}

	private static String getNativeResourcePath() {
		String packagePath = LlamaLoader.class.getPackage().getName().replace(".", "/");
		return String.format("/%s/%s", packagePath, OSInfo.getNativeLibFolderPathForCurrentOS());
	}

	private static boolean hasNativeLib(String path, String libraryName) {
		return LlamaLoader.class.getResource(path + "/" + libraryName) != null;
	}
}