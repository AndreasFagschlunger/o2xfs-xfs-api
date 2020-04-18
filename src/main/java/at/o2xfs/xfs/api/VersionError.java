package at.o2xfs.xfs.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.memory.databind.annotation.MemoryPropertyOrder;
import at.o2xfs.memory.databind.annotation.Pointer;

@MemoryPropertyOrder({ "logicalName", "workstationName", "appId", "description", "version" })
public final class VersionError {

	public static class Builder {

		private String logicalName;
		private String workstationName;
		private String appId;
		private byte[] description;
		private WfsVersion version;

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

		public Builder version(WfsVersion version) {
			this.version = version;
			return this;
		}

		public VersionError build() {
			return new VersionError(this);
		}
	}

	private final String logicalName;
	private final String workstationName;
	private final String appId;
	private final byte[] description;

	@Pointer
	private final WfsVersion version;

	private VersionError(Builder builder) {
		logicalName = builder.logicalName;
		workstationName = builder.workstationName;
		appId = builder.appId;
		description = builder.description;
		version = builder.version;
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

	public WfsVersion getVersion() {
		return version;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(logicalName)
				.append(workstationName)
				.append(appId)
				.append(description)
				.append(version)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof VersionError) {
			VersionError versionError = (VersionError) obj;
			return new EqualsBuilder()
					.append(logicalName, versionError.logicalName)
					.append(workstationName, versionError.workstationName)
					.append(appId, versionError.appId)
					.append(description, versionError.description)
					.append(version, versionError.version)
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
				.append("version", version)
				.toString();
	}
}
