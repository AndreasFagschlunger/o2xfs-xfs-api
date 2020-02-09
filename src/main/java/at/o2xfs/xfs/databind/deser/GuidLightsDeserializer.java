package at.o2xfs.xfs.databind.deser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import at.o2xfs.memory.databind.BeanProperty;
import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.memory.databind.deser.std.StdDeserializer;
import at.o2xfs.memory.databind.type.JavaType;
import at.o2xfs.xfs.databind.annotation.XfsGuidLights;

public class GuidLightsDeserializer extends StdDeserializer<List<Set<Object>>> {

	private final int length;

	public GuidLightsDeserializer() {
		super(Object.class);
		length = 0;
	}

	protected GuidLightsDeserializer(Class<?> valueClass, int length) {
		super(valueClass);
		this.length = length;
	}

	protected GuidLightsDeserializer(JavaType valueType, int length) {
		super(valueType);
		this.length = length;
	}

	@Override
	public List<Set<Object>> deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		List<Set<Object>> result = new ArrayList<>(length);
		XfsEnumSet32Deserializer enumSetDeserializer = new XfsEnumSet32Deserializer(valueClass);
		for (int i = 0; i < length; i++) {
			result.add(enumSetDeserializer.deserialize(memory, ctxt));
		}
		return result;
	}

	@Override
	public MemoryDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) {
		XfsGuidLights guidLights = property.getMember().getAnnotation(XfsGuidLights.class);
		return new GuidLightsDeserializer(
				property.getType().getBindings().getBoundType(0).getBindings().getBoundType(0), guidLights.length());
	}
}
