package at.o2xfs.xfs.databind.deser;

import java.util.EnumSet;
import java.util.Set;

import at.o2xfs.memory.databind.BeanProperty;
import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.memory.databind.deser.std.StdDeserializer;
import at.o2xfs.memory.databind.type.JavaType;
import at.o2xfs.memory.databind.type.TypeFactory;
import at.o2xfs.xfs.XfsConstant;
import at.o2xfs.xfs.databind.annotation.XfsEnumSet32;

public class XfsEnumSet32Deserializer<E extends Enum<E> & XfsConstant> extends StdDeserializer<EnumSet<E>> {

	private final JavaType enumType;
	private final boolean zeroTerminated;

	public XfsEnumSet32Deserializer() {
		this(null, false);
	}

	public XfsEnumSet32Deserializer(JavaType enumType, boolean zeroTerminated) {
		super(Set.class);
		this.enumType = enumType;
		this.zeroTerminated = zeroTerminated;
	}

	private EnumSet<E> constructSet() {
		return EnumSet.noneOf((Class<E>) enumType.getRawClass());
	}

	private void deserialize(long bitmask, EnumSet<E> result) {
		for (Object each : enumType.getRawClass().getEnumConstants()) {
			XfsConstant constant = (XfsConstant) each;
			if (constant.getValue() == 0L) {
				continue;
			} else if ((bitmask & constant.getValue()) == constant.getValue()) {
				result.add((E) each);
			}
		}
	}

	@Override
	public EnumSet<E> deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		EnumSet<E> result = constructSet();
		if (zeroTerminated) {
			long value = 0L;
			while ((value = memory.nextUnsignedLong()) != 0L) {
				for (Object each : enumType.getRawClass().getEnumConstants()) {
					if (((XfsConstant) each).getValue() == value) {
						result.add((E) each);
						break;
					}
				}
			}
		} else {
			deserialize(memory.nextUnsignedLong(), result);
		}
		return result;
	}

	@Override
	public MemoryDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) {
		TypeFactory tf = ctxt.getTypeFactory();
		JavaType[] tps = tf.findTypeParameters(property.getType(), Iterable.class);
		JavaType elemType = tps[0];
		XfsEnumSet32 enumSet = property.getMember().getAnnotation(XfsEnumSet32.class);
		return new XfsEnumSet32Deserializer(elemType, enumSet == null ? false : enumSet.zeroTerminated());
	}

}
