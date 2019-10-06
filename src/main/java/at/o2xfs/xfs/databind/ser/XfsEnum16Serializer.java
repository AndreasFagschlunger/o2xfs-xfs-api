package at.o2xfs.xfs.databind.ser;

import at.o2xfs.memory.databind.MemoryGenerator;
import at.o2xfs.memory.databind.MemorySerializer;
import at.o2xfs.memory.databind.SerializerProvider;
import at.o2xfs.win32.Bits;
import at.o2xfs.xfs.XfsConstant;

public class XfsEnum16Serializer<E extends Enum<E> & XfsConstant> extends MemorySerializer<E> {

	@Override
	public void serialize(E value, MemoryGenerator gen, SerializerProvider provider) {
		gen.write(Bits.toByteArray((short) value.getValue()));
	}

}
