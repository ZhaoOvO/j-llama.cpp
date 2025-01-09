package cn.hthcorp.llama;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @ClassName LlamaOutput
 * @Description TODO
 * @Author Aaron
 * @Date 2025/1/9 16:50
 * @Version V1.0
 */
public final class LlamaOutput {
	public final @NotNull String text;
	public final @NotNull Map<String, Float> probabilities;
	@Getter
	final boolean stop;

	LlamaOutput(byte[] generated, @NotNull Map<String, Float> probabilities, boolean stop) {
		this.text = new String(generated, StandardCharsets.UTF_8);
		this.probabilities = probabilities;
		this.stop = stop;
	}

	public String toString() {
		return this.text;
	}
}
