package cn.hthcorp.llama;

import cn.hthcorp.llama.args.MiroStat;
import cn.hthcorp.llama.args.Sampler;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName InferenceParameters
 * @Description TODO
 * @Author Aaron
 * @Date 2025/1/9 16:56
 * @Version V1.0
 */
public final class InferenceParameters extends JsonParameters {
	private static final String PARAM_PROMPT = "prompt";
	private static final String PARAM_INPUT_PREFIX = "input_prefix";
	private static final String PARAM_INPUT_SUFFIX = "input_suffix";
	private static final String PARAM_CACHE_PROMPT = "cache_prompt";
	private static final String PARAM_N_PREDICT = "n_predict";
	private static final String PARAM_TOP_K = "top_k";
	private static final String PARAM_TOP_P = "top_p";
	private static final String PARAM_MIN_P = "min_p";
	private static final String PARAM_TFS_Z = "tfs_z";
	private static final String PARAM_TYPICAL_P = "typical_p";
	private static final String PARAM_TEMPERATURE = "temperature";
	private static final String PARAM_DYNATEMP_RANGE = "dynatemp_range";
	private static final String PARAM_DYNATEMP_EXPONENT = "dynatemp_exponent";
	private static final String PARAM_REPEAT_LAST_N = "repeat_last_n";
	private static final String PARAM_REPEAT_PENALTY = "repeat_penalty";
	private static final String PARAM_FREQUENCY_PENALTY = "frequency_penalty";
	private static final String PARAM_PRESENCE_PENALTY = "presence_penalty";
	private static final String PARAM_MIROSTAT = "mirostat";
	private static final String PARAM_MIROSTAT_TAU = "mirostat_tau";
	private static final String PARAM_MIROSTAT_ETA = "mirostat_eta";
	private static final String PARAM_PENALIZE_NL = "penalize_nl";
	private static final String PARAM_N_KEEP = "n_keep";
	private static final String PARAM_SEED = "seed";
	private static final String PARAM_N_PROBS = "n_probs";
	private static final String PARAM_MIN_KEEP = "min_keep";
	private static final String PARAM_GRAMMAR = "grammar";
	private static final String PARAM_PENALTY_PROMPT = "penalty_prompt";
	private static final String PARAM_IGNORE_EOS = "ignore_eos";
	private static final String PARAM_LOGIT_BIAS = "logit_bias";
	private static final String PARAM_STOP = "stop";
	private static final String PARAM_SAMPLERS = "samplers";
	private static final String PARAM_STREAM = "stream";
	private static final String PARAM_USE_CHAT_TEMPLATE = "use_chat_template";

	public InferenceParameters(String prompt) {
		this.setPrompt(prompt);
	}

	public InferenceParameters setPrompt(String prompt) {
		this.parameters.put("prompt", this.toJsonString(prompt));
		return this;
	}

	public InferenceParameters setInputPrefix(String inputPrefix) {
		this.parameters.put("input_prefix", this.toJsonString(inputPrefix));
		return this;
	}

	public InferenceParameters setInputSuffix(String inputSuffix) {
		this.parameters.put("input_suffix", this.toJsonString(inputSuffix));
		return this;
	}

	public InferenceParameters setCachePrompt(boolean cachePrompt) {
		this.parameters.put("cache_prompt", String.valueOf(cachePrompt));
		return this;
	}

	public InferenceParameters setNPredict(int nPredict) {
		this.parameters.put("n_predict", String.valueOf(nPredict));
		return this;
	}

	public InferenceParameters setTopK(int topK) {
		this.parameters.put("top_k", String.valueOf(topK));
		return this;
	}

	public InferenceParameters setTopP(float topP) {
		this.parameters.put("top_p", String.valueOf(topP));
		return this;
	}

	public InferenceParameters setMinP(float minP) {
		this.parameters.put("min_p", String.valueOf(minP));
		return this;
	}

	public InferenceParameters setTfsZ(float tfsZ) {
		this.parameters.put("tfs_z", String.valueOf(tfsZ));
		return this;
	}

	public InferenceParameters setTypicalP(float typicalP) {
		this.parameters.put("typical_p", String.valueOf(typicalP));
		return this;
	}

	public InferenceParameters setTemperature(float temperature) {
		this.parameters.put("temperature", String.valueOf(temperature));
		return this;
	}

	public InferenceParameters setDynamicTemperatureRange(float dynatempRange) {
		this.parameters.put("dynatemp_range", String.valueOf(dynatempRange));
		return this;
	}

	public InferenceParameters setDynamicTemperatureExponent(float dynatempExponent) {
		this.parameters.put("dynatemp_exponent", String.valueOf(dynatempExponent));
		return this;
	}

	public InferenceParameters setRepeatLastN(int repeatLastN) {
		this.parameters.put("repeat_last_n", String.valueOf(repeatLastN));
		return this;
	}

	public InferenceParameters setRepeatPenalty(float repeatPenalty) {
		this.parameters.put("repeat_penalty", String.valueOf(repeatPenalty));
		return this;
	}

	public InferenceParameters setFrequencyPenalty(float frequencyPenalty) {
		this.parameters.put("frequency_penalty", String.valueOf(frequencyPenalty));
		return this;
	}

	public InferenceParameters setPresencePenalty(float presencePenalty) {
		this.parameters.put("presence_penalty", String.valueOf(presencePenalty));
		return this;
	}

	public InferenceParameters setMiroStat(MiroStat mirostat) {
		this.parameters.put("mirostat", String.valueOf(mirostat.ordinal()));
		return this;
	}

	public InferenceParameters setMiroStatTau(float mirostatTau) {
		this.parameters.put("mirostat_tau", String.valueOf(mirostatTau));
		return this;
	}

	public InferenceParameters setMiroStatEta(float mirostatEta) {
		this.parameters.put("mirostat_eta", String.valueOf(mirostatEta));
		return this;
	}

	public InferenceParameters setPenalizeNl(boolean penalizeNl) {
		this.parameters.put("penalize_nl", String.valueOf(penalizeNl));
		return this;
	}

	public InferenceParameters setNKeep(int nKeep) {
		this.parameters.put("n_keep", String.valueOf(nKeep));
		return this;
	}

	public InferenceParameters setSeed(int seed) {
		this.parameters.put("seed", String.valueOf(seed));
		return this;
	}

	public InferenceParameters setNProbs(int nProbs) {
		this.parameters.put("n_probs", String.valueOf(nProbs));
		return this;
	}

	public InferenceParameters setMinKeep(int minKeep) {
		this.parameters.put("min_keep", String.valueOf(minKeep));
		return this;
	}

	public InferenceParameters setGrammar(String grammar) {
		this.parameters.put("grammar", this.toJsonString(grammar));
		return this;
	}

	public InferenceParameters setPenaltyPrompt(String penaltyPrompt) {
		this.parameters.put("penalty_prompt", this.toJsonString(penaltyPrompt));
		return this;
	}

	public InferenceParameters setPenaltyPrompt(int[] tokens) {
		if (tokens.length > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");

			for(int i = 0; i < tokens.length; ++i) {
				builder.append(tokens[i]);
				if (i < tokens.length - 1) {
					builder.append(", ");
				}
			}

			builder.append("]");
			this.parameters.put("penalty_prompt", builder.toString());
		}

		return this;
	}

	public InferenceParameters setIgnoreEos(boolean ignoreEos) {
		this.parameters.put("ignore_eos", String.valueOf(ignoreEos));
		return this;
	}

	public InferenceParameters setTokenIdBias(Map<Integer, Float> logitBias) {
		if (!logitBias.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			int i = 0;

			for(Map.Entry<Integer, Float> entry : logitBias.entrySet()) {
				Integer key = (Integer)entry.getKey();
				Float value = (Float)entry.getValue();
				builder.append("[").append(key).append(", ").append(value).append("]");
				if (i++ < logitBias.size() - 1) {
					builder.append(", ");
				}
			}

			builder.append("]");
			this.parameters.put("logit_bias", builder.toString());
		}

		return this;
	}

	public InferenceParameters disableTokenIds(Collection<Integer> tokenIds) {
		if (!tokenIds.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			int i = 0;

			for(Integer token : tokenIds) {
				builder.append("[").append(token).append(", ").append(false).append("]");
				if (i++ < tokenIds.size() - 1) {
					builder.append(", ");
				}
			}

			builder.append("]");
			this.parameters.put("logit_bias", builder.toString());
		}

		return this;
	}

	public InferenceParameters setTokenBias(Map<String, Float> logitBias) {
		if (!logitBias.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			int i = 0;

			for(Map.Entry<String, Float> entry : logitBias.entrySet()) {
				String key = (String)entry.getKey();
				Float value = (Float)entry.getValue();
				builder.append("[").append(this.toJsonString(key)).append(", ").append(value).append("]");
				if (i++ < logitBias.size() - 1) {
					builder.append(", ");
				}
			}

			builder.append("]");
			this.parameters.put("logit_bias", builder.toString());
		}

		return this;
	}

	public InferenceParameters disableTokens(Collection<String> tokens) {
		if (!tokens.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			int i = 0;

			for(String token : tokens) {
				builder.append("[").append(this.toJsonString(token)).append(", ").append(false).append("]");
				if (i++ < tokens.size() - 1) {
					builder.append(", ");
				}
			}

			builder.append("]");
			this.parameters.put("logit_bias", builder.toString());
		}

		return this;
	}

	public InferenceParameters setStopStrings(String... stopStrings) {
		if (stopStrings.length > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");

			for(int i = 0; i < stopStrings.length; ++i) {
				builder.append(this.toJsonString(stopStrings[i]));
				if (i < stopStrings.length - 1) {
					builder.append(", ");
				}
			}

			builder.append("]");
			this.parameters.put("stop", builder.toString());
		}

		return this;
	}

	public InferenceParameters setSamplers(Sampler... samplers) {
		if (samplers.length > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");

			for(int i = 0; i < samplers.length; ++i) {
				switch (samplers[i]) {
					case TOP_K:
						builder.append("\"top_k\"");
						break;
					case TFS_Z:
						builder.append("\"tfs_z\"");
						break;
					case TYPICAL_P:
						builder.append("\"typical_p\"");
						break;
					case TOP_P:
						builder.append("\"top_p\"");
						break;
					case MIN_P:
						builder.append("\"min_p\"");
						break;
					case TEMPERATURE:
						builder.append("\"temperature\"");
				}

				if (i < samplers.length - 1) {
					builder.append(", ");
				}
			}

			builder.append("]");
			this.parameters.put("samplers", builder.toString());
		}

		return this;
	}

	InferenceParameters setStream(boolean stream) {
		this.parameters.put("stream", String.valueOf(stream));
		return this;
	}

	public InferenceParameters setUseChatTemplate(boolean useChatTemplate) {
		this.parameters.put("use_chat_template", String.valueOf(useChatTemplate));
		return this;
	}
}
