package at.o2xfs.xfs.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.memory.core.util.ByteArrayMemoryGenerator;

class WfsVersionTest extends BaseTest {

	@Test
	final void test() throws IOException {
		WfsVersion expected = new WfsVersion.Builder()
				.version(XfsVersion.V3_10)
				.lowVersion(XfsVersion.V2_00)
				.highVersion(XfsVersion.V3_30)
				.description("XFS API v2.00 to v3.30")
				.systemStatus("Impl 1.0")
				.build();
		Address address;
		try (ByteArrayMemoryGenerator gen = memorySystem.createGenerator()) {
			memoryMapper.write(gen, expected);
			address = gen.allocate();
		}
		WfsVersion actual = memoryMapper.read(memorySystem.dereference(address), WfsVersion.class);
		assertEquals(expected, actual);
	}

	@Test
	public void emptyVersion() throws IOException {
		WfsVersion expected = new WfsVersion.Builder().build();
		Address address;
		try (ByteArrayMemoryGenerator gen = memorySystem.createGenerator()) {
			memoryMapper.write(gen, expected);
			address = gen.allocate();
		}
		WfsVersion actual = memoryMapper.read(memorySystem.dereference(address), WfsVersion.class);
		assertEquals(expected, actual);
	}
}
