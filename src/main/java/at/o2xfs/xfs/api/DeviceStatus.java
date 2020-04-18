package at.o2xfs.xfs.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.memory.databind.annotation.MemoryPropertyOrder;
import at.o2xfs.xfs.databind.annotation.XfsEnum32;

@MemoryPropertyOrder({ "physicalName", "workstationName", "state" })
public final class DeviceStatus {

	public static class Builder {

		private String physicalName;
		private String workstationName;
		private DeviceState state;

		public Builder physicalName(String physicalName) {
			this.physicalName = physicalName;
			return this;
		}

		public Builder workstationName(String workstationName) {
			this.workstationName = workstationName;
			return this;
		}

		public Builder state(DeviceState state) {
			this.state = state;
			return this;
		}

		public DeviceStatus build() {
			return new DeviceStatus(this);
		}
	}

	private final String physicalName;
	private final String workstationName;

	@XfsEnum32
	private final DeviceState state;

	private DeviceStatus(Builder builder) {
		physicalName = builder.physicalName;
		workstationName = builder.workstationName;
		state = builder.state;
	}

	public String getPhysicalName() {
		return physicalName;
	}

	public String getWorkstationName() {
		return workstationName;
	}

	public DeviceState getState() {
		return state;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(physicalName).append(workstationName).append(state).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DeviceStatus) {
			DeviceStatus hardwareError = (DeviceStatus) obj;
			return new EqualsBuilder()
					.append(physicalName, hardwareError.physicalName)
					.append(workstationName, hardwareError.workstationName)
					.append(state, hardwareError.state)
					.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("physicalName", physicalName)
				.append("workstationName", workstationName)
				.append("state", state)
				.toString();
	}
}
