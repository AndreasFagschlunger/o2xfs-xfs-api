package at.o2xfs.xfs.databind.deser;

import java.util.HashSet;
import java.util.Set;

import at.o2xfs.memory.databind.BeanProperty;
import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.memory.databind.deser.ContextualDeserializer;
import at.o2xfs.memory.databind.deser.std.StdDeserializer;
import at.o2xfs.memory.databind.deser.win32.ULongDeserializer;
import at.o2xfs.memory.databind.type.CollectionType;
import at.o2xfs.xfs.XfsConstant;

public class XfsEnumSet32Deserializer extends StdDeserializer<Set<Object>> implements ContextualDeserializer {

	public XfsEnumSet32Deserializer() {
		this(null);
	}

	public XfsEnumSet32Deserializer(Class<?> valueClass) {
		super(valueClass);
	}

	@Override
	public Set<Object> deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		Set<Object> result = new HashSet<>();
		long value = ULongDeserializer.instance.deserialize(memory, ctxt).longValue();
		for (Object each : valueClass.getEnumConstants()) {
			XfsConstant constant = (XfsConstant) each;
			if (constant.getValue() == 0L) {
				continue;
			} else if ((value & constant.getValue()) == constant.getValue()) {
				result.add(each);
			}
		}
		return result;
	}

	@Override
	public MemoryDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) {
		return new XfsEnumSet32Deserializer(((CollectionType) property.getType()).getContentType().getRawClass());
	}

}
