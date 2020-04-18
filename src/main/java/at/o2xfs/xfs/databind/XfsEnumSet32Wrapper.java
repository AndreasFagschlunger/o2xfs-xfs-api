package at.o2xfs.xfs.databind;

import java.util.EnumSet;
import java.util.Set;

import at.o2xfs.memory.databind.annotation.win32.ULong;
import at.o2xfs.xfs.api.XfsConstant;

public class XfsEnumSet32Wrapper {

	public final static class Builder {

		private long value;

		public Builder value(long value) {
			this.value = value;
			return this;
		}

		public XfsEnumSet32Wrapper build() {
			return new XfsEnumSet32Wrapper(this);
		}

	}

	@ULong
	private final long value;

	private XfsEnumSet32Wrapper(long value) {
		this.value = value;
	}

	private XfsEnumSet32Wrapper(Builder builder) {
		value = builder.value;
	}

	public long getValue() {
		return value;
	}

	public <E extends Enum<E> & XfsConstant> EnumSet<E> get(Class<E> elementType) {
		EnumSet<E> result = EnumSet.noneOf(elementType);
		for (E each : elementType.getEnumConstants()) {
			if ((each.getValue() & value) == each.getValue()) {
				result.add(each);
			}
		}
		return result;
	}

	public static <E extends Enum<E> & XfsConstant> EnumSet<E> of(long value, Class<E> enumType) {
		return new XfsEnumSet32Wrapper(value).get(enumType);
	}

	public static <E extends Enum<E> & XfsConstant> XfsEnumSet32Wrapper build(Set<E> values) {
		long value = 0;
		for (E each : values) {
			value |= each.getValue();
		}
		return new XfsEnumSet32Wrapper(value);
	}
}
