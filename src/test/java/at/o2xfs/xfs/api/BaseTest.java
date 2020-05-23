package at.o2xfs.xfs.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import at.o2xfs.memory.core.Address;
import at.o2xfs.memory.core.util.ByteArrayMemoryGenerator;
import at.o2xfs.memory.core.util.ByteArrayMemorySystem;
import at.o2xfs.memory.databind.MemoryMapper;

public class BaseTest {

	protected MemoryMapper memoryMapper;
	protected ByteArrayMemorySystem memorySystem;

	protected final ObjectMapper objectMapper;

	public BaseTest() {
		memoryMapper = new MemoryMapper();
		memorySystem = new ByteArrayMemorySystem();
		objectMapper = new ObjectMapper().registerModule(new Jdk8Module());
	}

	protected void testMemoryDeSerialization(Object expected) throws IOException {
		Address address;
		try (ByteArrayMemoryGenerator gen = memorySystem.createGenerator()) {
			memoryMapper.write(gen, expected);
			address = gen.allocate();
		}
		Object actual = memoryMapper.read(memorySystem.dereference(address), expected.getClass());
		assertEquals(expected, actual);
	}

	protected void shouldSerializeAndDesrializeFromJson(Object expected) throws JsonProcessingException {
		String content = objectMapper.writeValueAsString(expected);
		Object actual = objectMapper.readValue(content, expected.getClass());
		assertEquals(expected, actual);
	}
}
