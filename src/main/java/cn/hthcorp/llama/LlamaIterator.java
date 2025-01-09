package cn.hthcorp.llama;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName LlamaIterator
 * @Description TODO
 * @Author Aaron
 * @Date 2025/1/9 16:54
 * @Version V1.0
 */
public final class LlamaIterator implements Iterator<LlamaOutput> {
	private final LlamaModel model;
	private final int taskId;
	private boolean hasNext = true;

	LlamaIterator(LlamaModel model, InferenceParameters parameters) {
		this.model = model;
		parameters.setStream(true);
		this.taskId = model.requestCompletion(parameters.toString());
	}

	public boolean hasNext() {
		return this.hasNext;
	}

	public LlamaOutput next() {
		if (!this.hasNext) {
			throw new NoSuchElementException();
		} else {
			LlamaOutput output = this.model.receiveCompletion(this.taskId);
			this.hasNext = !output.stop;
			return output;
		}
	}

	public void cancel() {
		this.model.cancelCompletion(this.taskId);
		this.hasNext = false;
	}
}