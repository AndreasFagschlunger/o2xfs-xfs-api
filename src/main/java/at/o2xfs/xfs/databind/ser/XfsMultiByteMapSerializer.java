package at.o2xfs.xfs.databind.ser;

import java.util.Map;

import at.o2xfs.memory.databind.MemoryGenerator;
import at.o2xfs.memory.databind.MemorySerializer;
import at.o2xfs.memory.databind.SerializerProvider;
import at.o2xfs.memory.databind.ser.std.StringSerializer;

public class XfsMultiByteMapSerializer extends MemorySerializer<Map<String, String>> {

	@Override
	public void serialize(Map<String, String> value, MemoryGenerator gen, SerializerProvider provider) {
		if (value.isEmpty()) {
			gen.write(new byte[] { 0, 0 });
		} else {
			for (Map.Entry<String, String> entry : value.entrySet()) {
				StringSerializer.instance.serialize(entry.getKey() + "=" + entry.getValue(), gen, provider);
			}
			gen.write(new byte[] { 0 });
		}
	}
}
