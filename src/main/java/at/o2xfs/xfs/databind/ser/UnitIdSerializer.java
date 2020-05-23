package at.o2xfs.xfs.databind.ser;

import java.nio.charset.StandardCharsets;

import at.o2xfs.memory.core.MemoryGenerator;
import at.o2xfs.memory.databind.MemorySerializer;
import at.o2xfs.memory.databind.SerializerProvider;
import at.o2xfs.xfs.util.UnitId;

public class UnitIdSerializer extends MemorySerializer<UnitId> {

	@Override
	public void serialize(UnitId value, MemoryGenerator gen, SerializerProvider provider) {
		gen.write(value.getValue().getBytes(StandardCharsets.US_ASCII));
	}
}
