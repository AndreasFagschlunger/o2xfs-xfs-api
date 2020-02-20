package at.o2xfs.xfs.databind.deser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import at.o2xfs.memory.databind.BeanProperty;
import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.MemoryDeserializer;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.memory.databind.type.JavaType;
import at.o2xfs.xfs.XfsConstant;
import at.o2xfs.xfs.databind.annotation.XfsGuidLights;

public class GuidLightsDeserializer<E extends Enum<E> & XfsConstant> extends MemoryDeserializer<List<Set<E>>> {

	private JavaType valueClass;
	private final int length;

	public GuidLightsDeserializer() {
		valueClass = null;
		length = 0;
	}

	protected GuidLightsDeserializer(JavaType valueClass, int length) {
		this.valueClass = valueClass;
		this.length = length;
	}

	@Override
	public List<Set<E>> deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		List<Set<E>> result = new ArrayList<>(length);
		XfsEnumSet32Deserializer<E> enumSetDeserializer = new XfsEnumSet32Deserializer<>(valueClass, false);
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
