package at.o2xfs.xfs.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import at.o2xfs.common.Hex;
import at.o2xfs.memory.core.Address;
import at.o2xfs.memory.core.util.ByteArrayMemoryGenerator;
import at.o2xfs.memory.core.util.ByteArrayMemorySystem;
import at.o2xfs.memory.databind.MemoryMapper;
import at.o2xfs.xfs.ptr.PtrMessage;

class UndeliverableMessageTest {

	private MemoryMapper memoryMapper;
	private ByteArrayMemorySystem memorySystem;

	public UndeliverableMessageTest() {
		memoryMapper = new MemoryMapper();
		memorySystem = new ByteArrayMemorySystem();
	}

	@Test
	final void test() throws IOException {
		UndeliverableMessage expected = new UndeliverableMessage.Builder()
				.logicalName("PASSBOOKPTR3")
				.workstationName("ATM_XYZ")
				.appId("APP_XYZ")
				.description(Hex.decode("CAFEBABE"))
				.msg(PtrMessage.SRVE_PTR_MEDIATAKEN.getValue())
				.wfsResult(new WfsResult.Builder()
						.requestId(RequestId.of(123L))
						.serviceId(ServiceId.of(1))
						.eventId(XfsMessage.EXECUTE_EVENT.getValue())
						.build())
				.build();
		Address address;
		try (ByteArrayMemoryGenerator gen = memorySystem.createGenerator()) {
			memoryMapper.write(gen, expected);
			address = gen.allocate();
		}
		UndeliverableMessage actual = memoryMapper.read(memorySystem.dereference(address), UndeliverableMessage.class);
		assertEquals(expected, actual);
	}
}
