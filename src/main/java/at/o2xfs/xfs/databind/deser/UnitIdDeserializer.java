package at.o2xfs.xfs.databind.deser;

import java.nio.charset.StandardCharsets;

import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.xfs.util.UnitId;

public class UnitIdDeserializer extends MemoryDeserializer<UnitId> {

	@Override
	public UnitId deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		return UnitId.of(new String(memory.read(UnitId.BYTES), StandardCharsets.US_ASCII));
	}
}
