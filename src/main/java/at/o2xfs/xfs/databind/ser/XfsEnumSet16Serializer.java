package at.o2xfs.xfs.databind.ser;

import java.util.Set;

import at.o2xfs.common.Bits;
import at.o2xfs.memory.core.MemoryGenerator;
import at.o2xfs.memory.databind.MemorySerializer;
import at.o2xfs.memory.databind.SerializerProvider;
import at.o2xfs.xfs.api.XfsConstant;

public class XfsEnumSet16Serializer extends MemorySerializer<Set<Enum<?>>> {

	@Override
	public void serialize(Set<Enum<?>> value, MemoryGenerator gen, SerializerProvider provider) {
		int i = 0;
		for (Enum<?> each : value) {
			i |= ((XfsConstant) each).getValue();
		}
		gen.write(Bits.toByteArray((short) i));
	}
}
