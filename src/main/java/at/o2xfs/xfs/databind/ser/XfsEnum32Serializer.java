package at.o2xfs.xfs.databind.ser;

import at.o2xfs.common.Bits;
import at.o2xfs.memory.core.MemoryGenerator;
import at.o2xfs.memory.databind.MemorySerializer;
import at.o2xfs.memory.databind.SerializerProvider;
import at.o2xfs.xfs.api.XfsConstant;

public class XfsEnum32Serializer<E extends Enum<E> & XfsConstant> extends MemorySerializer<E> {

	@Override
	public void serialize(E value, MemoryGenerator gen, SerializerProvider provider) {
		gen.write(Bits.toByteArray((int) value.getValue()));
	}

}
