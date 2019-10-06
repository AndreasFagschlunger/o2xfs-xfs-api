package at.o2xfs.xfs.databind.deser;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import at.o2xfs.common.ByteArrayBuffer;
import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;

public class XfsMultiByteMapDeserializer extends MemoryDeserializer<Map<String, String>> {

	@Override
	public Map<String, String> deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		Map<String, String> result = Collections.emptyMap();
		ByteArrayBuffer buffer = new ByteArrayBuffer(128);
		do {
			buffer.append(memory.read(1));
		} while (buffer.length() == 1 || buffer.byteAt(buffer.length() - 2) != 0
				|| buffer.byteAt(buffer.length() - 1) != 0);

		result = decode(new String(buffer.buffer(), 0, buffer.length() - 2, StandardCharsets.US_ASCII));
		return result;
	}

	private Map<String, String> decode(String s) {
		Map<String, String> result = new LinkedHashMap<String, String>();
		for (String each : s.split("\0")) {
			int beginIndex = each.indexOf('=');
			if (beginIndex == -1) {
				result.put(each, null);
				continue;
			}
			String key = each.substring(0, beginIndex);
			String value = each.substring(beginIndex + 1);
			result.put(key, value);
		}
		return result;
	}
}
