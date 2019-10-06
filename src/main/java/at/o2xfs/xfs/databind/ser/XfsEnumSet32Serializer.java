package at.o2xfs.xfs.databind.ser;

import java.util.Set;

import at.o2xfs.common.Bits;
import at.o2xfs.memory.databind.MemoryGenerator;
import at.o2xfs.memory.databind.MemorySerializer;
import at.o2xfs.memory.databind.SerializerProvider;
import at.o2xfs.xfs.XfsConstant;

public class XfsEnumSet32Serializer<E extends Enum<E> & XfsConstant> extends MemorySerializer<Set<E>> {

	@Override
	public void serialize(Set<E> value, MemoryGenerator gen, SerializerProvider provider) {
		int i = 0;
		for (E each : value) {
			i |= each.getValue();
		}
		gen.write(Bits.toByteArray(i));
	}
}
