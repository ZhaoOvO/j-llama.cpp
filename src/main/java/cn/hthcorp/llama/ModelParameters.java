package cn.hthcorp.llama;

import cn.hthcorp.llama.args.GpuSplitMode;
import cn.hthcorp.llama.args.NumaStrategy;
import cn.hthcorp.llama.args.PoolingType;
import cn.hthcorp.llama.args.RopeScalingType;

import java.util.Map;

/**
 * @ClassName ModelParameters
 * @Description TODO
 * @Author Aaron
 * @Date 2025/1/9 16:49
 * @Version V1.0
 */
public final class ModelParameters extends JsonParameters {
	private static final String PARAM_SEED = "seed";
	private static final String PARAM_N_THREADS = "n_threads";
	private static final String PARAM_N_THREADS_DRAFT = "n_threads_draft";
	private static final String PARAM_N_THREADS_BATCH = "n_threads_batch";
	private static final String PARAM_N_THREADS_BATCH_DRAFT = "n_threads_batch_draft";
	private static final String PARAM_N_PREDICT = "n_predict";
	private static final String PARAM_N_CTX = "n_ctx";
	private static final String PARAM_N_BATCH = "n_batch";
	private static final String PARAM_N_UBATCH = "n_ubatch";
	private static final String PARAM_N_KEEP = "n_keep";
	private static final String PARAM_N_DRAFT = "n_draft";
	private static final String PARAM_N_CHUNKS = "n_chunks";
	private static final String PARAM_N_PARALLEL = "n_parallel";
	private static final String PARAM_N_SEQUENCES = "n_sequences";
	private static final String PARAM_P_SPLIT = "p_split";
	private static final String PARAM_N_GPU_LAYERS = "n_gpu_layers";
	private static final String PARAM_N_GPU_LAYERS_DRAFT = "n_gpu_layers_draft";
	private static final String PARAM_SPLIT_MODE = "split_mode";
	private static final String PARAM_MAIN_GPU = "main_gpu";
	private static final String PARAM_TENSOR_SPLIT = "tensor_split";
	private static final String PARAM_GRP_ATTN_N = "grp_attn_n";
	private static final String PARAM_GRP_ATTN_W = "grp_attn_w";
	private static final String PARAM_ROPE_FREQ_BASE = "rope_freq_base";
	private static final String PARAM_ROPE_FREQ_SCALE = "rope_freq_scale";
	private static final String PARAM_YARN_EXT_FACTOR = "yarn_ext_factor";
	private static final String PARAM_YARN_ATTN_FACTOR = "yarn_attn_factor";
	private static final String PARAM_YARN_BETA_FAST = "yarn_beta_fast";
	private static final String PARAM_YARN_BETA_SLOW = "yarn_beta_slow";
	private static final String PARAM_YARN_ORIG_CTX = "yarn_orig_ctx";
	private static final String PARAM_DEFRAG_THOLD = "defrag_thold";
	private static final String PARAM_NUMA = "numa";
	private static final String PARAM_ROPE_SCALING_TYPE = "rope_scaling_type";
	private static final String PARAM_POOLING_TYPE = "pooling_type";
	private static final String PARAM_MODEL = "model";
	private static final String PARAM_MODEL_DRAFT = "model_draft";
	private static final String PARAM_MODEL_ALIAS = "model_alias";
	private static final String PARAM_MODEL_URL = "model_url";
	private static final String PARAM_HF_REPO = "hf_repo";
	private static final String PARAM_HF_FILE = "hf_file";
	private static final String PARAM_LOOKUP_CACHE_STATIC = "lookup_cache_static";
	private static final String PARAM_LOOKUP_CACHE_DYNAMIC = "lookup_cache_dynamic";
	private static final String PARAM_LORA_ADAPTER = "lora_adapter";
	private static final String PARAM_EMBEDDING = "embedding";
	private static final String PARAM_CONT_BATCHING = "cont_batching";
	private static final String PARAM_FLASH_ATTENTION = "flash_attn";
	private static final String PARAM_INPUT_PREFIX_BOS = "input_prefix_bos";
	private static final String PARAM_IGNORE_EOS = "ignore_eos";
	private static final String PARAM_USE_MMAP = "use_mmap";
	private static final String PARAM_USE_MLOCK = "use_mlock";
	private static final String PARAM_NO_KV_OFFLOAD = "no_kv_offload";
	private static final String PARAM_SYSTEM_PROMPT = "system_prompt";
	private static final String PARAM_CHAT_TEMPLATE = "chat_template";

	public ModelParameters() {
	}

	public ModelParameters setSeed(int seed) {
		this.parameters.put("seed", String.valueOf(seed));
		return this;
	}

	public ModelParameters setNThreads(int nThreads) {
		this.parameters.put("n_threads", String.valueOf(nThreads));
		return this;
	}

	public ModelParameters setNThreadsDraft(int nThreadsDraft) {
		this.parameters.put("n_threads_draft", String.valueOf(nThreadsDraft));
		return this;
	}

	public ModelParameters setNThreadsBatch(int nThreadsBatch) {
		this.parameters.put("n_threads_batch", String.valueOf(nThreadsBatch));
		return this;
	}

	public ModelParameters setNThreadsBatchDraft(int nThreadsBatchDraft) {
		this.parameters.put("n_threads_batch_draft", String.valueOf(nThreadsBatchDraft));
		return this;
	}

	public ModelParameters setNPredict(int nPredict) {
		this.parameters.put("n_predict", String.valueOf(nPredict));
		return this;
	}

	public ModelParameters setNCtx(int nCtx) {
		this.parameters.put("n_ctx", String.valueOf(nCtx));
		return this;
	}

	public ModelParameters setNBatch(int nBatch) {
		this.parameters.put("n_batch", String.valueOf(nBatch));
		return this;
	}

	public ModelParameters setNUbatch(int nUbatch) {
		this.parameters.put("n_ubatch", String.valueOf(nUbatch));
		return this;
	}

	public ModelParameters setNKeep(int nKeep) {
		this.parameters.put("n_keep", String.valueOf(nKeep));
		return this;
	}

	public ModelParameters setNDraft(int nDraft) {
		this.parameters.put("n_draft", String.valueOf(nDraft));
		return this;
	}

	public ModelParameters setNChunks(int nChunks) {
		this.parameters.put("n_chunks", String.valueOf(nChunks));
		return this;
	}

	public ModelParameters setNParallel(int nParallel) {
		this.parameters.put("n_parallel", String.valueOf(nParallel));
		return this;
	}

	public ModelParameters setNSequences(int nSequences) {
		this.parameters.put("n_sequences", String.valueOf(nSequences));
		return this;
	}

	public ModelParameters setPSplit(float pSplit) {
		this.parameters.put("p_split", String.valueOf(pSplit));
		return this;
	}

	public ModelParameters setNGpuLayers(int nGpuLayers) {
		this.parameters.put("n_gpu_layers", String.valueOf(nGpuLayers));
		return this;
	}

	public ModelParameters setNGpuLayersDraft(int nGpuLayersDraft) {
		this.parameters.put("n_gpu_layers_draft", String.valueOf(nGpuLayersDraft));
		return this;
	}

	public ModelParameters setSplitMode(GpuSplitMode splitMode) {
		this.parameters.put("split_mode", String.valueOf(splitMode.ordinal()));
		return this;
	}

	public ModelParameters setMainGpu(int mainGpu) {
		this.parameters.put("main_gpu", String.valueOf(mainGpu));
		return this;
	}

	public ModelParameters setTensorSplit(float[] tensorSplit) {
		if (tensorSplit.length > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");

			for(int i = 0; i < tensorSplit.length; ++i) {
				builder.append(tensorSplit[i]);
				if (i < tensorSplit.length - 1) {
					builder.append(", ");
				}
			}

			builder.append("]");
			this.parameters.put("tensor_split", builder.toString());
		}

		return this;
	}

	public ModelParameters setGrpAttnN(int grpAttnN) {
		this.parameters.put("grp_attn_n", String.valueOf(grpAttnN));
		return this;
	}

	public ModelParameters setGrpAttnW(int grpAttnW) {
		this.parameters.put("grp_attn_w", String.valueOf(grpAttnW));
		return this;
	}

	public ModelParameters setRopeFreqBase(float ropeFreqBase) {
		this.parameters.put("rope_freq_base", String.valueOf(ropeFreqBase));
		return this;
	}

	public ModelParameters setRopeFreqScale(float ropeFreqScale) {
		this.parameters.put("rope_freq_scale", String.valueOf(ropeFreqScale));
		return this;
	}

	public ModelParameters setYarnExtFactor(float yarnExtFactor) {
		this.parameters.put("yarn_ext_factor", String.valueOf(yarnExtFactor));
		return this;
	}

	public ModelParameters setYarnAttnFactor(float yarnAttnFactor) {
		this.parameters.put("yarn_attn_factor", String.valueOf(yarnAttnFactor));
		return this;
	}

	public ModelParameters setYarnBetaFast(float yarnBetaFast) {
		this.parameters.put("yarn_beta_fast", String.valueOf(yarnBetaFast));
		return this;
	}

	public ModelParameters setYarnBetaSlow(float yarnBetaSlow) {
		this.parameters.put("yarn_beta_slow", String.valueOf(yarnBetaSlow));
		return this;
	}

	public ModelParameters setYarnOrigCtx(int yarnOrigCtx) {
		this.parameters.put("yarn_orig_ctx", String.valueOf(yarnOrigCtx));
		return this;
	}

	public ModelParameters setDefragmentationThreshold(float defragThold) {
		this.parameters.put("defrag_thold", String.valueOf(defragThold));
		return this;
	}

	public ModelParameters setNuma(NumaStrategy numa) {
		this.parameters.put("numa", String.valueOf(numa.ordinal()));
		return this;
	}

	public ModelParameters setRopeScalingType(RopeScalingType ropeScalingType) {
		this.parameters.put("rope_scaling_type", String.valueOf(ropeScalingType.ordinal()));
		return this;
	}

	public ModelParameters setPoolingType(PoolingType poolingType) {
		this.parameters.put("pooling_type", String.valueOf(poolingType.ordinal()));
		return this;
	}

	public ModelParameters setModelFilePath(String model) {
		this.parameters.put("model", this.toJsonString(model));
		return this;
	}

	public ModelParameters setModelDraft(String modelDraft) {
		this.parameters.put("model_draft", this.toJsonString(modelDraft));
		return this;
	}

	public ModelParameters setModelAlias(String modelAlias) {
		this.parameters.put("model_alias", this.toJsonString(modelAlias));
		return this;
	}

	public ModelParameters setModelUrl(String modelUrl) {
		this.parameters.put("model_url", this.toJsonString(modelUrl));
		return this;
	}

	public ModelParameters setHuggingFaceRepository(String hfRepo) {
		this.parameters.put("hf_repo", this.toJsonString(hfRepo));
		return this;
	}

	public ModelParameters setHuggingFaceFile(String hfFile) {
		this.parameters.put("hf_file", this.toJsonString(hfFile));
		return this;
	}

	public ModelParameters setLookupCacheStaticFilePath(String lookupCacheStatic) {
		this.parameters.put("lookup_cache_static", this.toJsonString(lookupCacheStatic));
		return this;
	}

	public ModelParameters setLookupCacheDynamicFilePath(String lookupCacheDynamic) {
		this.parameters.put("lookup_cache_dynamic", this.toJsonString(lookupCacheDynamic));
		return this;
	}

	public ModelParameters setLoraAdapters(Map<String, Float> loraAdapters) {
		if (!loraAdapters.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			builder.append("{");
			int i = 0;

			for(Map.Entry<String, Float> entry : loraAdapters.entrySet()) {
				String key = (String)entry.getKey();
				Float value = (Float)entry.getValue();
				builder.append(this.toJsonString(key)).append(": ").append(value);
				if (i++ < loraAdapters.size() - 1) {
					builder.append(", ");
				}
			}

			builder.append("}");
			this.parameters.put("lora_adapter", builder.toString());
		}

		return this;
	}

	public ModelParameters setEmbedding(boolean embedding) {
		this.parameters.put("embedding", String.valueOf(embedding));
		return this;
	}

	public ModelParameters setContinuousBatching(boolean contBatching) {
		this.parameters.put("cont_batching", String.valueOf(contBatching));
		return this;
	}

	public ModelParameters setFlashAttention(boolean flashAttention) {
		this.parameters.put("flash_attn", String.valueOf(flashAttention));
		return this;
	}

	public ModelParameters setInputPrefixBos(boolean inputPrefixBos) {
		this.parameters.put("input_prefix_bos", String.valueOf(inputPrefixBos));
		return this;
	}

	public ModelParameters setIgnoreEos(boolean ignoreEos) {
		this.parameters.put("ignore_eos", String.valueOf(ignoreEos));
		return this;
	}

	public ModelParameters setUseMmap(boolean useMmap) {
		this.parameters.put("use_mmap", String.valueOf(useMmap));
		return this;
	}

	public ModelParameters setUseMlock(boolean useMlock) {
		this.parameters.put("use_mlock", String.valueOf(useMlock));
		return this;
	}

	public ModelParameters setNoKvOffload(boolean noKvOffload) {
		this.parameters.put("no_kv_offload", String.valueOf(noKvOffload));
		return this;
	}

	public ModelParameters setSystemPrompt(String systemPrompt) {
		this.parameters.put("system_prompt", this.toJsonString(systemPrompt));
		return this;
	}

	public ModelParameters setChatTemplate(String chatTemplate) {
		this.parameters.put("chat_template", this.toJsonString(chatTemplate));
		return this;
	}
}
