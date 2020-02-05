package at.o2xfs.xfs.databind.deser;

import at.o2xfs.memory.databind.BeanProperty;
import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.memory.databind.deser.std.StdDeserializer;
import at.o2xfs.memory.databind.deser.win32.ULongDeserializer;
import at.o2xfs.xfs.XfsConstant;

public class XfsEnum32Deserializer extends StdDeserializer<Object> {

	public XfsEnum32Deserializer() {
		this(null);
	}

	public XfsEnum32Deserializer(Class<?> valueClass) {
		super(valueClass);
	}

	@Override
	public Object deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		Object result = null;
		long value = ULongDeserializer.instance.deserialize(memory, ctxt).longValue();
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
		return new XfsEnum32Deserializer(property.getType().getRawClass());
	}

}
