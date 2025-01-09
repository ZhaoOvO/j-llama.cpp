package cn.hthcorp.llama.args;

/**
 * @ClassName Sampler
 * @Description TODO
 * @Author Aaron
 * @Date 2025/1/9 17:00
 * @Version V1.0
 */
public enum Sampler {
	TOP_K,
	TFS_Z,
	TYPICAL_P,
	TOP_P,
	MIN_P,
	TEMPERATURE;

	Sampler() {
	}
}