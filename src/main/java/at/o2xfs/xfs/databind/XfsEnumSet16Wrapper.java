package at.o2xfs.xfs.databind;

import java.util.EnumSet;

import at.o2xfs.memory.databind.annotation.win32.UShort;
import at.o2xfs.xfs.api.XfsConstant;

public class XfsEnumSet16Wrapper {

	public final static class Builder {

		private int value;

		public Builder value(int value) {
			this.value = value;
			return this;
		}

		public XfsEnumSet16Wrapper build() {
			return new XfsEnumSet16Wrapper(this);
		}

	}

	@UShort
	private final int value;

	private XfsEnumSet16Wrapper(int value) {
		this.value = value;
	}

	private XfsEnumSet16Wrapper(Builder builder) {
		value = builder.value;
	}

	public int getValue() {
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

	public static <E extends Enum<E> & XfsConstant> EnumSet<E> of(int value, Class<E> enumType) {
		return new XfsEnumSet16Wrapper(value).get(enumType);
	}
}
