package at.o2xfs.xfs.databind.deser;

import java.util.HashSet;
import java.util.Set;

import at.o2xfs.memory.databind.BeanProperty;
import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.memory.databind.deser.std.StdDeserializer;
import at.o2xfs.memory.databind.type.JavaType;
import at.o2xfs.memory.databind.type.TypeFactory;
import at.o2xfs.xfs.XfsConstant;

public class XfsEnumSet32Deserializer<E extends Enum<E> & XfsConstant> extends StdDeserializer<Set<E>> {

	public XfsEnumSet32Deserializer() {
		this(null);
	}

	public XfsEnumSet32Deserializer(Class<E> valueClass) {
		super(valueClass);
	}

	@Override
	public Set<E> deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		Set<E> result = new HashSet<>();
		long value = memory.nextUnsignedLong();
		for (Object each : valueClass.getEnumConstants()) {
			XfsConstant constant = (XfsConstant) each;
			if (constant.getValue() == 0L) {
				continue;
			} else if ((value & constant.getValue()) == constant.getValue()) {
				result.add((E) each);
			}
		}
		return result;
	}

	@Override
	public MemoryDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) {
		TypeFactory tf = ctxt.getTypeFactory();
		JavaType[] tps = tf.findTypeParameters(property.getType(), Iterable.class);
		JavaType elemType = tps[0];
		return new XfsEnumSet32Deserializer(elemType.getRawClass());
	}

}
