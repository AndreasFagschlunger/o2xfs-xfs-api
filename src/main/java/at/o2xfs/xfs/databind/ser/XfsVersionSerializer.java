package at.o2xfs.xfs.databind.ser;

import java.io.IOException;

import at.o2xfs.memory.core.MemoryGenerator;
import at.o2xfs.memory.databind.SerializerProvider;
import at.o2xfs.memory.databind.ser.std.StdSerializer;
import at.o2xfs.xfs.api.XfsVersion;

public class XfsVersionSerializer extends StdSerializer<XfsVersion> {

	public XfsVersionSerializer() {
		super(XfsVersion.class);
	}

	@Override
	public void serialize(XfsVersion value, MemoryGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeUnsignedShort(value.intValue());
	}
}
