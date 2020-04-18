package at.o2xfs.xfs.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.memory.core.util.ByteArrayMemoryGenerator;
import at.o2xfs.memory.core.util.ByteArrayMemorySystem;
import at.o2xfs.memory.databind.MemoryMapper;

class WfsDeviceStatusTest {

	private MemoryMapper memoryMapper;
	private ByteArrayMemorySystem memorySystem;

	public WfsDeviceStatusTest() {
		memoryMapper = new MemoryMapper();
		memorySystem = new ByteArrayMemorySystem();
	}

	@Test
	final void test() throws IOException {
		DeviceStatus expected = new DeviceStatus.Builder()
				.physicalName("NAME_XYZ")
				.workstationName("ATM_XYZ")
				.state(DeviceState.HWERROR)
				.build();
		Address address;
		try (ByteArrayMemoryGenerator gen = memorySystem.createGenerator()) {
			memoryMapper.write(gen, expected);
			address = gen.allocate();
		}
		DeviceStatus actual = memoryMapper.read(memorySystem.dereference(address), DeviceStatus.class);
		assertEquals(expected, actual);
	}
}
