package at.o2xfs.xfs.databind.ser;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import at.o2xfs.memory.core.MemoryGenerator;
import at.o2xfs.memory.databind.MemorySerializer;
import at.o2xfs.memory.databind.SerializerProvider;

public class XfsMultiByteMapSerializer extends MemorySerializer<Map<String, String>> {

	@Override
	public void serialize(Map<String, String> value, MemoryGenerator gen, SerializerProvider provider) {
		if (value.isEmpty()) {
			gen.write(new byte[] { 0, 0 });
		} else {
			StringBuilder builder = new StringBuilder();
			for (Map.Entry<String, String> entry : value.entrySet()) {
				builder.append(entry.getKey()).append('=').append(entry.getValue()).append('\0');
			}
			gen.write(builder.append('\0').toString().getBytes(StandardCharsets.US_ASCII));
		}
	}
}
