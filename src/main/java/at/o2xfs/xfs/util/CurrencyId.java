package at.o2xfs.xfs.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import at.o2xfs.memory.databind.annotation.MemoryDeserialize;
import at.o2xfs.memory.databind.annotation.MemorySerialize;
import at.o2xfs.xfs.databind.deser.CurrencyIdDeserializer;
import at.o2xfs.xfs.databind.ser.CurrencyIdSerializer;

@MemorySerialize(using = CurrencyIdSerializer.class)
@MemoryDeserialize(using = CurrencyIdDeserializer.class)
public final class CurrencyId {

	public static final int BYTES = 3;
	private static final CurrencyId NONE = new CurrencyId(' ', ' ', ' ');

	private final String value;

	private CurrencyId(char c1, char c2, char c3) {
		value = new String(new char[] { c1, c2, c3 });
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(value).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CurrencyId) {
			CurrencyId currencyId = (CurrencyId) obj;
			return new EqualsBuilder().append(value, currencyId.value).isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return value;
	}

	public static CurrencyId of(char c1, char c2, char c3) {
		return new CurrencyId(c1, c2, c3);
	}

	public static CurrencyId of(String value) {
		return of(value.charAt(0), value.charAt(1), value.charAt(2));
	}

	public static CurrencyId empty() {
		return NONE;
	}
}
