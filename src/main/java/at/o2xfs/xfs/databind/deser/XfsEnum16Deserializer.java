package at.o2xfs.xfs.databind.deser;

import at.o2xfs.memory.databind.BeanProperty;
import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.memory.databind.deser.ContextualDeserializer;
import at.o2xfs.memory.databind.deser.std.StdDeserializer;
import at.o2xfs.memory.databind.deser.win32.UShortDeserializer;
import at.o2xfs.xfs.XfsConstant;

public class XfsEnum16Deserializer extends StdDeserializer<Object> implements ContextualDeserializer {

	public XfsEnum16Deserializer() {
		this(null);
	}

	public XfsEnum16Deserializer(Class<?> valueClass) {
		super(valueClass);
	}

	@Override
	public Object deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		Object result = null;
		long value = UShortDeserializer.instance.deserialize(memory, ctxt).longValue();
		for (Object each : valueClass.getEnumConstants()) {
			if (((XfsConstant) each).getValue() == value) {
				result = each;
				break;
			}
		}
		return result;
	}

	@Override
	public MemoryDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) {
		return new XfsEnum16Deserializer(property.getType().getRawClass());
	}

}
