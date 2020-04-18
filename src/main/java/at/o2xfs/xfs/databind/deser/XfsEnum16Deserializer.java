package at.o2xfs.xfs.databind.deser;

import at.o2xfs.memory.databind.BeanProperty;
import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.memory.databind.deser.std.StdDeserializer;
import at.o2xfs.xfs.api.XfsConstant;

public class XfsEnum16Deserializer extends StdDeserializer<Object> {

	public XfsEnum16Deserializer() {
		this(null);
	}

	public XfsEnum16Deserializer(Class<?> valueClass) {
		super(valueClass);
	}

	@Override
	public Object deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		Object result = null;
		long value = memory.nextUnsignedShort();
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
