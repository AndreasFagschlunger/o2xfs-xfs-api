package at.o2xfs.xfs.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import at.o2xfs.memory.databind.annotation.MemoryDeserialize;
import at.o2xfs.memory.databind.annotation.MemorySerialize;
import at.o2xfs.xfs.databind.deser.UnitIdDeserializer;
import at.o2xfs.xfs.databind.ser.UnitIdSerializer;

@MemorySerialize(using = UnitIdSerializer.class)
@MemoryDeserialize(using = UnitIdDeserializer.class)
public final class UnitId {

	private static final UnitId EMPTY = UnitId.of('\0', '\0', '\0', '\0', '\0');

	public static final int BYTES = 5;

	private final String value;

	private UnitId(char c1, char c2, char c3, char c4, char c5) {
		value = new String(new char[] { c1, c2, c3, c4, c5 });
	}

	@JsonValue
	public String getValue() {
		return value;
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
		return value;
	}

	public static UnitId empty() {
		return EMPTY;
	}

	public static UnitId of(char c1, char c2, char c3, char c4, char c5) {
		return new UnitId(c1, c2, c3, c4, c5);
	}

	@JsonCreator
	public static UnitId of(String value) {
		return new UnitId(value.charAt(0), value.charAt(1), value.charAt(2), value.charAt(3), value.charAt(4));
	}
}
