package at.o2xfs.xfs.databind.ser;

import java.util.List;
import java.util.Set;

import at.o2xfs.memory.core.MemoryGenerator;
import at.o2xfs.memory.databind.BeanProperty;
import at.o2xfs.memory.databind.MemorySerializer;
import at.o2xfs.memory.databind.SerializerProvider;
import at.o2xfs.xfs.api.XfsConstant;
import at.o2xfs.xfs.databind.annotation.XfsGuidLights;

public class GuidLightsSerializer<E extends Enum<E> & XfsConstant> extends MemorySerializer<List<Set<E>>> {

	private final int length;

	public GuidLightsSerializer() {
		length = 0;
	}

	protected GuidLightsSerializer(int length) {
		this.length = length;
	}

	@Override
	public MemorySerializer<?> createContextual(SerializerProvider provider, BeanProperty prop) {
		XfsGuidLights guidLights = prop.getMember().getAnnotation(XfsGuidLights.class);
		return new GuidLightsSerializer<>(guidLights.length());
	}

	@Override
	public void serialize(List<Set<E>> value, MemoryGenerator gen, SerializerProvider provider) {
		XfsEnumSet32Serializer<E> serializer = new XfsEnumSet32Serializer<>();
		for (int i = 0; i < length; i++) {
			Set<E> guidLights = value.get(i);
			serializer.serialize(guidLights, gen, provider);
		}
	}
}
