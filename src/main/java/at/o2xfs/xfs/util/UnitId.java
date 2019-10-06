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

	public static final int BYTES = 5;
	private static final UnitId EMPTY = UnitId.of(new String(new byte[BYTES]));

	private final String value;

	private UnitId(String value) {
		if (value.length() != BYTES) {
			throw new IllegalArgumentException(value);
		}
		this.value = value;
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

	public static UnitId of(String value) {
		return new UnitId(value);
	}
}
