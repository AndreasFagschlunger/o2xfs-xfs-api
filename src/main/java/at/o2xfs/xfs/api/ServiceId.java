package at.o2xfs.xfs.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.memory.databind.annotation.win32.UShort;

public final class ServiceId {

	public static class Builder {

		private int value;

		public Builder value(int value) {
			this.value = value;
			return this;
		}

		public ServiceId build() {
			return new ServiceId(this);
		}

	}

	public static final ServiceId ZERO = new ServiceId.Builder().build();

	@UShort
	private final int value;

	private ServiceId(Builder builder) {
		value = builder.value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ServiceId) {
			ServiceId service = (ServiceId) obj;
			return new EqualsBuilder().append(value, service.value).isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(value).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("value", value).toString();
	}

	public static ServiceId of(int value) {
		return new ServiceId.Builder().value(value).build();
	}
}
