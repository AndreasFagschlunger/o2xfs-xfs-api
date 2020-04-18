package at.o2xfs.xfs.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.memory.core.util.ByteArrayMemoryGenerator;

class WfsResultTest extends BaseTest {

	@Test
	final void test() throws IOException {
		Address buffer;
		try (ByteArrayMemoryGenerator gen = memorySystem.createGenerator()) {
			memoryMapper.write(gen, WfsVersion.empty());
			buffer = gen.allocate();
		}
		WfsResult expected = new WfsResult.Builder()
				.requestId(RequestId.of(5))
				.serviceId(ServiceId.of(1))
				.errorCode(-15)
				.buffer(buffer)
				.build();
		testMemoryDeSerialization(expected);
	}

	@Test
	final void testEmpty() throws IOException {
		WfsResult expected = WfsResult.empty();
		Address address;
		try (ByteArrayMemoryGenerator gen = memorySystem.createGenerator()) {
			memoryMapper.write(gen, expected);
			address = gen.allocate();
		}
		WfsResult actual = memoryMapper.read(memorySystem.dereference(address), WfsResult.class);
		assertEquals(expected.getRequestId(), actual.getRequestId());
		assertEquals(expected.getServiceId(), actual.getServiceId());
		assertEquals(expected.getErrorCode(), actual.getErrorCode());
		assertEquals(expected.getEventId(), actual.getEventId());
	}
}
