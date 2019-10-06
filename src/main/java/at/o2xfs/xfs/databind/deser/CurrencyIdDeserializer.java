package at.o2xfs.xfs.databind.deser;

import java.nio.charset.StandardCharsets;

import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.xfs.util.CurrencyId;

public class CurrencyIdDeserializer extends MemoryDeserializer<CurrencyId> {

	@Override
	public CurrencyId deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		return CurrencyId.of(new String(memory.read(CurrencyId.BYTES), StandardCharsets.US_ASCII));
	}
}
