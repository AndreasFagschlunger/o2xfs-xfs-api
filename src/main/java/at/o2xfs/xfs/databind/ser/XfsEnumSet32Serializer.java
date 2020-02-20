package at.o2xfs.xfs.databind.ser;

import java.util.Set;

import at.o2xfs.common.Bits;
import at.o2xfs.memory.core.MemoryGenerator;
import at.o2xfs.memory.databind.BeanProperty;
import at.o2xfs.memory.databind.MemorySerializer;
import at.o2xfs.memory.databind.SerializerProvider;
import at.o2xfs.memory.databind.ser.std.StdSerializer;
import at.o2xfs.xfs.XfsConstant;
import at.o2xfs.xfs.databind.annotation.XfsEnumSet32;

public class XfsEnumSet32Serializer<E extends Enum<E> & XfsConstant> extends StdSerializer<Set<E>> {

	private final boolean zeroTerminated;

	public XfsEnumSet32Serializer() {
		this(false);
	}

	protected XfsEnumSet32Serializer(boolean zeroTerminated) {
		super(Set.class);
		this.zeroTerminated = zeroTerminated;
	}

	@Override
	public MemorySerializer<?> createContextual(SerializerProvider provider, BeanProperty prop) {
		XfsEnumSet32 enumSet = prop.getMember().getAnnotation(XfsEnumSet32.class);
		if (enumSet != null && zeroTerminated != enumSet.zeroTerminated()) {
			return new XfsEnumSet32Serializer<>(enumSet.zeroTerminated());
		}
		return this;
	}

	@Override
	public void serialize(Set<E> value, MemoryGenerator gen, SerializerProvider provider) {
		if (zeroTerminated) {
			for (E each : value) {
				gen.writeUnsignedLong(each.getValue());
			}
			gen.writeUnsignedLong(0L);
		} else {
			int i = 0;
			for (E each : value) {
				i |= each.getValue();
			}
			gen.write(Bits.toByteArray(i));
		}
	}
}
