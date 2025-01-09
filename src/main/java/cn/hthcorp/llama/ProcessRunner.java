package cn.hthcorp.llama;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName a
 * @Description TODO
 * @Author Aaron
 * @Date 2025/1/9 16:31
 * @Version V1.0
 */
class ProcessRunner {
	ProcessRunner() {
	}

	String runAndWaitFor(String command) throws IOException, InterruptedException {
		Process p = Runtime.getRuntime().exec(command);
		p.waitFor();
		return getProcessOutput(p);
	}

	String runAndWaitFor(String command, long timeout, TimeUnit unit) throws IOException, InterruptedException {
		Process p = Runtime.getRuntime().exec(command);
		p.waitFor(timeout, unit);
		return getProcessOutput(p);
	}

	private static String getProcessOutput(Process process) throws IOException {
		InputStream in = process.getInputStream();

		String processStr;
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] buf = new byte[32];

			int readLen;
			while((readLen = in.read(buf, 0, buf.length)) >= 0) {
				byteArrayOutputStream.write(buf, 0, readLen);
			}
			processStr = byteArrayOutputStream.toString();
		} catch (Throwable e) {
			if (in != null) {
				try {
					in.close();
				} catch (Throwable throwable) {
					e.addSuppressed(throwable);
				}
			}
			throw e;
		}
		in.close();
		return processStr;
	}
}
