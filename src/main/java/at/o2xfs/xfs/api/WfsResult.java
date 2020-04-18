package at.o2xfs.xfs.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.memory.core.Address;
import at.o2xfs.memory.databind.annotation.MemoryPropertyOrder;
import at.o2xfs.memory.databind.annotation.win32.ULong;
import at.o2xfs.memory.databind.win32.Systemtime;
import at.o2xfs.xfs.databind.XfsEnum32Wrapper;

@MemoryPropertyOrder({ "requestId", "serviceId", "timestamp", "errorCode", "eventId", "buffer" })
public final class WfsResult {

	public static class Builder {

		private RequestId requestId;
		private ServiceId serviceId;
		private Systemtime timestamp;
		private int errorCode;
		private long eventId;
		private Address buffer;

		public Builder() {
			requestId = RequestId.of(0L);
			serviceId = ServiceId.of(0);
			timestamp = Systemtime.empty();
			errorCode = 0;
			eventId = 0;
		}

		public Builder requestId(RequestId requestId) {
			this.requestId = requestId;
			return this;
		}

		public Builder serviceId(ServiceId serviceId) {
			this.serviceId = serviceId;
			return this;
		}

		public Builder timestamp(Systemtime timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder errorCode(int errorCode) {
			this.errorCode = errorCode;
			return this;
		}

		public Builder eventId(long eventId) {
			this.eventId = eventId;
			return this;
		}

		public Builder buffer(Address buffer) {
			this.buffer = buffer;
			return this;
		}

		public WfsResult build() {
			return new WfsResult(this);
		}
	}

	private static final WfsResult EMPTY = new WfsResult.Builder().build();

	private final RequestId requestId;

	private final ServiceId serviceId;

	private final Systemtime timestamp;

	private final int errorCode;

	@ULong
	private final long eventId;

	private final Address buffer;

	private WfsResult(Builder builder) {
		requestId = builder.requestId;
		serviceId = builder.serviceId;
		timestamp = builder.timestamp;
		errorCode = builder.errorCode;
		eventId = builder.eventId;
		buffer = builder.buffer;
	}

	public RequestId getRequestId() {
		return requestId;
	}

	public ServiceId getServiceId() {
		return serviceId;
	}

	public Systemtime getTimestamp() {
		return timestamp;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public long getEventId() {
		return eventId;
	}

	public <E extends Enum<E> & XfsConstant> E getEventId(Class<E> enumType) {
		return XfsEnum32Wrapper.of(eventId, enumType);
	}

	public Address getBuffer() {
		return buffer;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(requestId)
				.append(serviceId)
				.append(timestamp)
				.append(errorCode)
				.append(eventId)
				.append(buffer)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof WfsResult) {
			WfsResult wfsResult = (WfsResult) obj;
			return new EqualsBuilder()
					.append(requestId, wfsResult.requestId)
					.append(serviceId, wfsResult.serviceId)
					.append(timestamp, wfsResult.timestamp)
					.append(errorCode, wfsResult.errorCode)
					.append(eventId, wfsResult.eventId)
					.append(buffer, wfsResult.buffer)
					.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("requestId", requestId)
				.append("serviceId", serviceId)
				.append("timestamp", timestamp)
				.append("errorCode", errorCode)
				.append("eventId", eventId)
				.append("buffer", buffer)
				.toString();
	}

	public static final WfsResult empty() {
		return EMPTY;
	}
}
