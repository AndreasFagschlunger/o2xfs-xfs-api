package at.o2xfs.xfs.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.memory.databind.annotation.MemoryPropertyOrder;
import at.o2xfs.memory.databind.annotation.Pointer;
import at.o2xfs.memory.databind.annotation.win32.ULong;

@MemoryPropertyOrder({ "logicalName", "workstationName", "appId", "description", "msg", "wfsResult" })
public final class UndeliverableMessage {

	public static class Builder {

		private String logicalName;
		private String workstationName;
		private String appId;
		private byte[] description;
		private long msg;
		private WfsResult wfsResult;

		public Builder logicalName(String logicalName) {
			this.logicalName = logicalName;
			return this;
		}

		public Builder workstationName(String workstationName) {
			this.workstationName = workstationName;
			return this;
		}

		public Builder appId(String appId) {
			this.appId = appId;
			return this;
		}

		public Builder description(byte[] description) {
			this.description = description;
			return this;
		}

		public Builder msg(long msg) {
			this.msg = msg;
			return this;
		}

		public Builder wfsResult(WfsResult wfsResult) {
			this.wfsResult = wfsResult;
			return this;
		}

		public UndeliverableMessage build() {
			return new UndeliverableMessage(this);
		}
	}

	private final String logicalName;
	private final String workstationName;
	private final String appId;
	private final byte[] description;

	@ULong
	private final long msg;

	@Pointer
	private final WfsResult wfsResult;

	private UndeliverableMessage(Builder builder) {
		logicalName = builder.logicalName;
		workstationName = builder.workstationName;
		appId = builder.appId;
		description = builder.description;
		msg = builder.msg;
		wfsResult = builder.wfsResult;
	}

	public String getLogicalName() {
		return logicalName;
	}

	public String getWorkstationName() {
		return workstationName;
	}

	public String getAppId() {
		return appId;
	}

	public byte[] getDescription() {
		return description.clone();
	}

	public long getMsg() {
		return msg;
	}

	public WfsResult getWfsResult() {
		return wfsResult;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(logicalName)
				.append(workstationName)
				.append(appId)
				.append(description)
				.append(msg)
				.append(wfsResult)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UndeliverableMessage) {
			UndeliverableMessage undeliverableMessage = (UndeliverableMessage) obj;
			return new EqualsBuilder()
					.append(logicalName, undeliverableMessage.logicalName)
					.append(workstationName, undeliverableMessage.workstationName)
					.append(appId, undeliverableMessage.appId)
					.append(description, undeliverableMessage.description)
					.append(msg, undeliverableMessage.msg)
					.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("logicalName", logicalName)
				.append("workstationName", workstationName)
				.append("appId", appId)
				.append("description", description)
				.append("msg", msg)
				.append("wfsResult", wfsResult)
				.toString();
	}
}
