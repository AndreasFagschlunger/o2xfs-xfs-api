package at.o2xfs.xfs.databind;

import at.o2xfs.memory.databind.annotation.MemoryPropertyOrder;
import at.o2xfs.memory.databind.annotation.win32.UShort;
import at.o2xfs.xfs.api.XfsConstant;

@MemoryPropertyOrder({ "value" })
public final class XfsEnum16Wrapper {

	public final static class Builder {

		private int value;

		public Builder value(int value) {
			this.value = value;
			return this;
		}

		public XfsEnum16Wrapper build() {
			return new XfsEnum16Wrapper(this);
		}

	}

	@UShort
	private final int value;

	private XfsEnum16Wrapper(int value) {
		this.value = value;
	}

	private XfsEnum16Wrapper(Builder builder) {
		value = builder.value;
	}

	public int getValue() {
		return value;
	}

	public <E extends Enum<E> & XfsConstant> E get(Class<E> enumType) {
		E result = null;
		for (E each : enumType.getEnumConstants()) {
			if (value == each.getValue()) {
				result = each;
				break;
			}
		}
		return result;
	}

	public static <E extends Enum<E> & XfsConstant> XfsEnum16Wrapper build(E value) {
		return new XfsEnum16Wrapper((int) value.getValue());
	}

	public static <E extends Enum<E> & XfsConstant> E of(int value, Class<E> enumType) {
		return new XfsEnum16Wrapper(value).get(enumType);
	}
}
