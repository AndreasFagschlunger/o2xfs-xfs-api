package at.o2xfs.xfs.databind.deser;

import at.o2xfs.memory.databind.DeserializationContext;
import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.memory.databind.deser.std.StdDeserializer;
import at.o2xfs.xfs.api.XfsVersion;

public class XfsVersionDeserializer extends StdDeserializer<XfsVersion> {

	public XfsVersionDeserializer() {
		super(XfsVersion.class);
	}

	@Override
	public XfsVersion deserialize(ReadableMemory memory, DeserializationContext ctxt) {
		return XfsVersion.of(memory.nextUnsignedShort());
	}
}
