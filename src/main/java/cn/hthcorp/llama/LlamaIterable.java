package cn.hthcorp.llama;

import org.jetbrains.annotations.NotNull;

/**
 * @ClassName LlamaIterable
 * @Description TODO
 * @Author Aaron
 * @Date 2025/1/9 16:55
 * @Version V1.0
 */
@FunctionalInterface
public interface LlamaIterable extends Iterable<LlamaOutput> {
	@NotNull LlamaIterator iterator();
}
