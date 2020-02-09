package at.o2xfs.xfs.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import at.o2xfs.memory.databind.annotation.MemoryDeserialize;
import at.o2xfs.memory.databind.annotation.MemorySerialize;
import at.o2xfs.xfs.databind.deser.UnitIdDeserializer;
import at.o2xfs.xfs.databind.ser.UnitIdSerializer;

@MemorySerialize(using = UnitIdSerializer.class)
@MemoryDeserialize(using = UnitIdDeserializer.class)
public final class UnitId {

	private static final UnitId EMPTY = UnitId.of('\0', '\0', '\0', '\0', '\0');

	public static final int BYTES = 5;

	private final char[] value;

	private UnitId(char c1, char c2, char c3, char c4, char c5) {
		value = new char[] { c1, c2, c3, c4, c5 };
	}

	public char[] getValue() {
		return value.clone();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(value).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnitId) {
			UnitId unitId = (UnitId) obj;
			return new EqualsBuilder().append(value, unitId.value).isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new String(value);
	}

	public static UnitId empty() {
		return EMPTY;
	}

	public static UnitId of(char c1, char c2, char c3, char c4, char c5) {
		return new UnitId(c1, c2, c3, c4, c5);
	}
}
