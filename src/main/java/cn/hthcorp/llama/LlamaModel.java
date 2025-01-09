package cn.hthcorp.llama;

import cn.hthcorp.llama.args.LogFormat;
import cn.hthcorp.llama.args.LogLevel;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.StandardCharsets;
import java.util.function.BiConsumer;

/**
 * @ClassName LlamaModel
 * @Description TODO
 * @Author Aaron
 * @Date 2025/1/9 16:52
 * @Version V1.0
 */
public class LlamaModel implements AutoCloseable {
	private long ctx;

	public LlamaModel(ModelParameters parameters) {
//		setLogger(LogFormat.TEXT, (logLevel, s) -> {
//			System.out.println(logLevel + ": " + s);
//		});
		this.loadModel(parameters.toString());
	}

	public String complete(InferenceParameters parameters) {
		parameters.setStream(false);
		int taskId = this.requestCompletion(parameters.toString());
		LlamaOutput output = this.receiveCompletion(taskId);
		return output.text;
	}

	public LlamaIterable generate(InferenceParameters parameters) {
		return () -> new LlamaIterator(this, parameters);
	}

	public native float[] embed(String var1);

	public native int[] encode(String var1);

	public String decode(int[] tokens) {
		byte[] bytes = this.decodeBytes(tokens);
		return new String(bytes, StandardCharsets.UTF_8);
	}

	public static native void setLogger(LogFormat logFormat, @Nullable BiConsumer<LogLevel, String> var1);

	public void close() {
		this.delete();
	}

	native int requestCompletion(String var1) throws LlamaException;

	native LlamaOutput receiveCompletion(int var1) throws LlamaException;

	native void cancelCompletion(int var1);

	native byte[] decodeBytes(int[] var1);

	private native void loadModel(String var1) throws LlamaException;

	private native void delete();

	static {
		LlamaLoader.initialize();
	}
}
