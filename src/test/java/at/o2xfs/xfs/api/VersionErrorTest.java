package at.o2xfs.xfs.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import at.o2xfs.common.Hex;
import at.o2xfs.memory.core.Address;
import at.o2xfs.memory.core.util.ByteArrayMemoryGenerator;
import at.o2xfs.memory.core.util.ByteArrayMemorySystem;
import at.o2xfs.memory.databind.MemoryMapper;

class VersionErrorTest {

	private MemoryMapper memoryMapper;
	private ByteArrayMemorySystem memorySystem;

	public VersionErrorTest() {
		memoryMapper = new MemoryMapper();
		memorySystem = new ByteArrayMemorySystem();
	}

	@Test
	final void test() throws IOException {
		VersionError expected = new VersionError.Builder()
				.logicalName("PASSBOOKPTR3")
				.workstationName("ATM_XYZ")
				.appId("APP_XYZ")
				.description(Hex.decode("CAFEBABE"))
				.version(new WfsVersion.Builder()
						.version(XfsVersion.V3_10)
						.lowVersion(XfsVersion.V3_00)
						.highVersion(XfsVersion.V3_30)
						.description("Description")
						.systemStatus("SystemStatus")
						.build())
				.build();
		Address address;
		try (ByteArrayMemoryGenerator gen = memorySystem.createGenerator()) {
			memoryMapper.write(gen, expected);
			address = gen.allocate();
		}
		VersionError actual = memoryMapper.read(memorySystem.dereference(address), VersionError.class);
		assertEquals(expected, actual);
	}
}
