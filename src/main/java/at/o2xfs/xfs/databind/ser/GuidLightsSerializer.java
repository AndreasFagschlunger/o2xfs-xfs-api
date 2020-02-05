package at.o2xfs.xfs.databind.ser;

import java.util.List;
import java.util.Set;

import at.o2xfs.memory.core.MemoryGenerator;
import at.o2xfs.memory.databind.MemorySerializer;
import at.o2xfs.memory.databind.SerializerProvider;
import at.o2xfs.xfs.XfsConstant;

public class GuidLightsSerializer<E extends Enum<E> & XfsConstant> extends MemorySerializer<List<Set<E>>> {

	@Override
	public void serialize(List<Set<E>> value, MemoryGenerator gen, SerializerProvider provider) {
		XfsEnumSet32Serializer<E> serializer = new XfsEnumSet32Serializer<E>();
		for (Set<E> each : value) {
			serializer.serialize(each, gen, provider);
		}
	}
}
