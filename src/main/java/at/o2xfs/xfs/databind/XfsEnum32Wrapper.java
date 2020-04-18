package at.o2xfs.xfs.databind;

import at.o2xfs.memory.databind.annotation.MemoryPropertyOrder;
import at.o2xfs.memory.databind.annotation.win32.ULong;
import at.o2xfs.xfs.api.XfsConstant;

@MemoryPropertyOrder({ "value" })
public final class XfsEnum32Wrapper {

	public final static class Builder {

		private long value;

		public Builder value(long value) {
			this.value = value;
			return this;
		}

		public XfsEnum32Wrapper build() {
			return new XfsEnum32Wrapper(this);
		}

	}

	@ULong
	private final long value;

	private XfsEnum32Wrapper(long value) {
		this.value = value;
	}

	private XfsEnum32Wrapper(Builder builder) {
		value = builder.value;
	}

	public long getValue() {
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

	public static <E extends Enum<E> & XfsConstant> E of(long value, Class<E> enumType) {
		return new XfsEnum32Wrapper(value).get(enumType);
	}

	public static <E extends Enum<E> & XfsConstant> XfsEnum32Wrapper build(E value) {
		return new XfsEnum32Wrapper(value.getValue());
	}
}
