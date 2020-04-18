package at.o2xfs.xfs.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import at.o2xfs.common.Hex;
import at.o2xfs.memory.core.Address;
import at.o2xfs.memory.core.util.ByteArrayMemoryGenerator;
import at.o2xfs.memory.core.util.ByteArrayMemorySystem;
import at.o2xfs.memory.databind.MemoryMapper;

class HardwareErrorTest {

	private MemoryMapper memoryMapper;
	private ByteArrayMemorySystem memorySystem;

	public HardwareErrorTest() {
		memoryMapper = new MemoryMapper();
		memorySystem = new ByteArrayMemorySystem();
	}

	@Test
	final void test() throws IOException {
		HardwareError expected = new HardwareError.Builder()
				.logicalName("PASSBOOKPTR3")
				.physicalName("NAME_XYZ")
				.workstationName("ATM_XYZ")
				.appId("APP_XYZ")
				.action(ErrorAction.RESET)
				.description(Hex.decode("CAFEBABE"))
				.build();
		Address address;
		try (ByteArrayMemoryGenerator gen = memorySystem.createGenerator()) {
			memoryMapper.write(gen, expected);
			address = gen.allocate();
		}
		HardwareError actual = memoryMapper.read(memorySystem.dereference(address), HardwareError.class);
		assertEquals(expected, actual);
	}
}
