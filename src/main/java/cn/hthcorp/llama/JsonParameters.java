package cn.hthcorp.llama;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JsonParameters
 * @Description TODO
 * @Author Aaron
 * @Date 2025/1/9 16:56
 * @Version V1.0
 */
abstract class JsonParameters {
	final Map<String, String> parameters = new HashMap<>();

	JsonParameters() {
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\n");
		int i = 0;

		for(Map.Entry<String, String> entry : this.parameters.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			builder.append("\t\"").append(key).append("\": ").append(value);
			if (i++ < this.parameters.size() - 1) {
				builder.append(",");
			}

			builder.append("\n");
		}

		builder.append("}");
		return builder.toString();
	}

	String toJsonString(String text) {
		if (text == null) {
			return null;
		} else {
			StringBuilder builder = new StringBuilder(text.length() + 2);
			char c = 0;
			int len = text.length();
			builder.append('"');

			for(int i = 0; i < len; ++i) {
				char b = c;
				c = text.charAt(i);
				switch (c) {
					case '\b':
						builder.append("\\b");
						break;
					case '\t':
						builder.append("\\t");
						break;
					case '\n':
						builder.append("\\n");
						break;
					case '\f':
						builder.append("\\f");
						break;
					case '\r':
						builder.append("\\r");
						break;
					case '"':
					case '\\':
						builder.append('\\');
						builder.append(c);
						break;
					case '/':
						if (b == '<') {
							builder.append('\\');
						}

						builder.append(c);
						break;
					default:
						if (c >= ' ' && (c < 128 || c >= 160) && (c < 8192 || c >= 8448)) {
							builder.append(c);
						} else {
							builder.append("\\u");
							String hhhh = Integer.toHexString(c);
							builder.append("0000", 0, 4 - hhhh.length());
							builder.append(hhhh);
						}
				}
			}

			builder.append('"');
			return builder.toString();
		}
	}
}
