package at.o2xfs.xfs.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.memory.databind.annotation.MemoryPropertyOrder;

@MemoryPropertyOrder({ "logicalName", "workstationName", "appId" })
public final class AppDisconnect {

	public static class Builder {

		private String logicalName;
		private String workstationName;
		private String appId;

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

		public AppDisconnect build() {
			return new AppDisconnect(this);
		}
	}

	private final String logicalName;
	private final String workstationName;
	private final String appId;

	private AppDisconnect(Builder builder) {
		logicalName = builder.logicalName;
		workstationName = builder.workstationName;
		appId = builder.appId;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(logicalName).append(workstationName).append(appId).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AppDisconnect) {
			AppDisconnect appDisconnect = (AppDisconnect) obj;
			return new EqualsBuilder()
					.append(logicalName, appDisconnect.logicalName)
					.append(workstationName, appDisconnect.workstationName)
					.append(appId, appDisconnect.appId)
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
				.toString();
	}
}
