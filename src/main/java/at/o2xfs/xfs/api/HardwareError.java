package at.o2xfs.xfs.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.memory.databind.annotation.MemoryPropertyOrder;
import at.o2xfs.xfs.databind.annotation.XfsEnum32;

@MemoryPropertyOrder({ "logicalName", "physicalName", "workstationName", "appId", "action", "description" })
public final class HardwareError {

	public static class Builder {

		private String logicalName;
		private String physicalName;
		private String workstationName;
		private String appId;
		private ErrorAction action;
		private byte[] description;

		public Builder logicalName(String logicalName) {
			this.logicalName = logicalName;
			return this;
		}

		public Builder physicalName(String physicalName) {
			this.physicalName = physicalName;
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

		public Builder action(ErrorAction action) {
			this.action = action;
			return this;
		}

		public Builder description(byte[] description) {
			this.description = description;
			return this;
		}

		public HardwareError build() {
			return new HardwareError(this);
		}
	}

	private final String logicalName;
	private final String physicalName;
	private final String workstationName;
	private final String appId;

	@XfsEnum32
	private final ErrorAction action;
	private final byte[] description;

	private HardwareError(Builder builder) {
		logicalName = builder.logicalName;
		physicalName = builder.physicalName;
		workstationName = builder.workstationName;
		appId = builder.appId;
		action = builder.action;
		description = builder.description;
	}

	public String getLogicalName() {
		return logicalName;
	}

	public String getPhysicalName() {
		return physicalName;
	}

	public String getWorkstationName() {
		return workstationName;
	}

	public String getAppId() {
		return appId;
	}

	public ErrorAction getAction() {
		return action;
	}

	public byte[] getDescription() {
		return description.clone();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(logicalName)
				.append(physicalName)
				.append(workstationName)
				.append(appId)
				.append(action)
				.append(description)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HardwareError) {
			HardwareError hardwareError = (HardwareError) obj;
			return new EqualsBuilder()
					.append(logicalName, hardwareError.logicalName)
					.append(physicalName, hardwareError.physicalName)
					.append(workstationName, hardwareError.workstationName)
					.append(appId, hardwareError.appId)
					.append(action, hardwareError.action)
					.append(description, hardwareError.description)
					.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("logicalName", logicalName)
				.append("physicalName", physicalName)
				.append("workstationName", workstationName)
				.append("appId", appId)
				.append("action", action)
				.append("description", description)
				.toString();
	}
}
