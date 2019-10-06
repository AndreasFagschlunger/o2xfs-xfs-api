package at.o2xfs.xfs.databind.ser;

import java.nio.charset.StandardCharsets;

import at.o2xfs.memory.databind.MemoryGenerator;
import at.o2xfs.memory.databind.MemorySerializer;
import at.o2xfs.memory.databind.SerializerProvider;
import at.o2xfs.xfs.util.CurrencyId;

public class CurrencyIdSerializer extends MemorySerializer<CurrencyId> {

	@Override
	public void serialize(CurrencyId value, MemoryGenerator gen, SerializerProvider provider) {
		gen.write(value.getValue().getBytes(StandardCharsets.US_ASCII));
	}
}
