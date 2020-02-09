package at.o2xfs.xfs.databind.deser;

import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.xfs.util.UnitId;

public class UnitIdDeserializer extends MemoryDeserializer<UnitId> {

	@Override
	public UnitId deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		String s = new String(memory.read(UnitId.BYTES));
		return UnitId.of(s.charAt(0), s.charAt(1), s.charAt(2), s.charAt(3), s.charAt(4));
	}
}
