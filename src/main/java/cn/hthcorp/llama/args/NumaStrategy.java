package cn.hthcorp.llama.args;

/**
 * @ClassName NumaStrategy
 * @Description TODO
 * @Author Aaron
 * @Date 2025/1/9 16:59
 * @Version V1.0
 */
public enum NumaStrategy {
	DISABLED,
	DISTRIBUTE,
	ISOLATE,
	NUMA_CTL,
	MIRROR;

	NumaStrategy() {
	}
}