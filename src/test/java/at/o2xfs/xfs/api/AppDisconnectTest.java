package at.o2xfs.xfs.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.memory.core.util.ByteArrayMemoryGenerator;
import at.o2xfs.memory.core.util.ByteArrayMemorySystem;
import at.o2xfs.memory.databind.MemoryMapper;

class AppDisconnectTest {

	private MemoryMapper memoryMapper;
	private ByteArrayMemorySystem memorySystem;

	public AppDisconnectTest() {
		memoryMapper = new MemoryMapper();
		memorySystem = new ByteArrayMemorySystem();
	}

	@Test
	final void test() throws IOException {
		AppDisconnect expected = new AppDisconnect.Builder()
				.logicalName("PASSBOOKPTR3")
				.workstationName("ATM_XYZ")
				.appId("APP_XYZ")
				.build();
		Address address;
		try (ByteArrayMemoryGenerator gen = memorySystem.createGenerator()) {
			memoryMapper.write(gen, expected);
			address = gen.allocate();
		}
		AppDisconnect actual = memoryMapper.read(memorySystem.dereference(address), AppDisconnect.class);
		assertEquals(expected, actual);
	}
}
