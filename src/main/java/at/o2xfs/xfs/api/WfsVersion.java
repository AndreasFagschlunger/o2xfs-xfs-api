package at.o2xfs.xfs.api;

import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.memory.databind.annotation.MemoryPropertyOrder;
import at.o2xfs.memory.databind.annotation.win32.CharArray;

@MemoryPropertyOrder({ "version", "lowVersion", "highVersion", "description", "systemStatus" })
public final class WfsVersion {

	private static final int WFSDDESCRIPTION_LEN = 256;
	private static final int WFSDSYSSTATUS_LEN = 256;

	private static final WfsVersion EMPTY = new WfsVersion.Builder().build();

	public static final class Builder {

		private XfsVersion version;
		private XfsVersion lowVersion;
		private XfsVersion highVersion;
		private String description;
		private String systemStatus;

		public Builder() {
			version = XfsVersion.empty();
			lowVersion = XfsVersion.empty();
			highVersion = XfsVersion.empty();
			description = "";
			systemStatus = "";
		}

		public Builder version(XfsVersion version) {
			this.version = Objects.requireNonNull(version);
			return this;
		}

		public Builder lowVersion(XfsVersion lowVersion) {
			this.lowVersion = Objects.requireNonNull(lowVersion);
			return this;
		}

		public Builder highVersion(XfsVersion highVersion) {
			this.highVersion = Objects.requireNonNull(highVersion);
			return this;
		}

		public Builder description(String description) {
			this.description = Objects.requireNonNull(description);
			return this;
		}

		public Builder systemStatus(String systemStatus) {
			this.systemStatus = Objects.requireNonNull(systemStatus);
			return this;
		}

		public WfsVersion build() {
			return new WfsVersion(this);
		}
	}

	private final XfsVersion version;
	private final XfsVersion lowVersion;
	private final XfsVersion highVersion;

	@CharArray(length = WFSDDESCRIPTION_LEN + 1)
	private final String description;

	@CharArray(length = WFSDSYSSTATUS_LEN + 1)
	private final String systemStatus;

	private WfsVersion(Builder builder) {
		version = builder.version;
		lowVersion = builder.lowVersion;
		highVersion = builder.highVersion;
		description = builder.description;
		systemStatus = builder.systemStatus;
	}

	public XfsVersion getVersion() {
		return version;
	}

	public XfsVersion getLowVersion() {
		return lowVersion;
	}

	public XfsVersion getHighVersion() {
		return highVersion;
	}

	public String getDescription() {
		return description;
	}

	public String getSystemStatus() {
		return systemStatus;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof WfsVersion) {
			WfsVersion wfsVersion = (WfsVersion) obj;
			return new EqualsBuilder()
					.append(version, wfsVersion.version)
					.append(lowVersion, wfsVersion.lowVersion)
					.append(highVersion, wfsVersion.highVersion)
					.append(description, wfsVersion.description)
					.append(systemStatus, wfsVersion.systemStatus)
					.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(version)
				.append(lowVersion)
				.append(highVersion)
				.append(description)
				.append(systemStatus)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("version", version)
				.append("lowVersion", lowVersion)
				.append("highVersion", highVersion)
				.append("description", description)
				.append("systemStatus", systemStatus)
				.toString();
	}

	public static final WfsVersion empty() {
		return EMPTY;
	}
}
