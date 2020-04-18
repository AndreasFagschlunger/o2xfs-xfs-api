package at.o2xfs.xfs.databind.deser;

import java.util.HashSet;
import java.util.Set;

import at.o2xfs.memory.databind.BeanProperty;
import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.memory.databind.deser.std.StdDeserializer;
import at.o2xfs.memory.databind.deser.win32.UShortDeserializer;
import at.o2xfs.xfs.api.XfsConstant;

public class XfsEnumSet16Deserializer extends StdDeserializer<Set<Object>> {

	public XfsEnumSet16Deserializer() {
		this(null);
	}

	public XfsEnumSet16Deserializer(Class<?> valueClass) {
		super(valueClass);
	}

	@Override
	public Set<Object> deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		Set<Object> result = new HashSet<>();
		long value = UShortDeserializer.instance.deserialize(memory, ctxt).longValue();
		for (Object each : valueClass.getEnumConstants()) {
			XfsConstant constant = (XfsConstant) each;
			if (constant.getValue() == 0L) {
				continue;
			}
			if ((value & constant.getValue()) == constant.getValue()) {
				result.add(each);
			}
		}
		return result;
	}

	@Override
	public MemoryDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) {
		return new XfsEnumSet16Deserializer(property.getType().getBindings().getBoundType(0).getRawClass());
	}

}
