package at.o2xfs.xfs.databind;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import at.o2xfs.xfs.api.XfsEventClass;

class XfsEnumSet32WrapperTest {

	@Test
	final void test() {
		Set<XfsEventClass> expected = EnumSet.allOf(XfsEventClass.class);
		long value = XfsEnumSet32Wrapper.build(expected).getValue();
		Set<XfsEventClass> actual = XfsEnumSet32Wrapper.of(value, XfsEventClass.class);
		assertEquals(expected, actual);
	}

}
