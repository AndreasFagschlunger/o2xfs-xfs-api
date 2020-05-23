package at.o2xfs.xfs.util;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import at.o2xfs.xfs.api.BaseTest;

class UnitIdTest extends BaseTest {

	@Test
	final void shouldSerializeAndDesrializeFromJson() throws JsonProcessingException {
		shouldSerializeAndDesrializeFromJson(UnitId.of("SLOT1"));
	}

}
