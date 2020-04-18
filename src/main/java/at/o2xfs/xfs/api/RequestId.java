package at.o2xfs.xfs.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.memory.databind.annotation.win32.ULong;

public final class RequestId {

	public static class Builder {

		private long value;

		public Builder value(long value) {
			this.value = value;
			return this;
		}

		public RequestId build() {
			return new RequestId(this);
		}

	}

	public static final RequestId ZERO = new RequestId.Builder().build();

	@ULong
	private final long value;

	private RequestId(Builder builder) {
		value = builder.value;
	}

	public long getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RequestId) {
			RequestId service = (RequestId) obj;
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

	public static RequestId of(long value) {
		return new RequestId.Builder().value(value).build();
	}
}
