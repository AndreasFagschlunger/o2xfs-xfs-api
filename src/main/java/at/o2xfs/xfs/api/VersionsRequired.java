package at.o2xfs.xfs.api;

import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.memory.databind.annotation.MemoryPropertyOrder;

@MemoryPropertyOrder({ "highVersion", "lowVersion" })
public final class VersionsRequired {

	private final XfsVersion lowVersion;

	private final XfsVersion highVersion;

	private VersionsRequired(XfsVersion lowVersion, XfsVersion highVersion) {
		this.lowVersion = Objects.requireNonNull(lowVersion);
		this.highVersion = Objects.requireNonNull(highVersion);
	}

	public XfsVersion getLowVersion() {
		return lowVersion;
	}

	public XfsVersion getHighVersion() {
		return highVersion;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(lowVersion).append(highVersion).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof VersionsRequired) {
			VersionsRequired versionsRequired = (VersionsRequired) obj;
			return new EqualsBuilder()
					.append(lowVersion, versionsRequired.lowVersion)
					.append(highVersion, versionsRequired.highVersion)
					.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("lowVersion", lowVersion).append("highVersion", highVersion).toString();
	}

	public static VersionsRequired build(XfsVersion lowVersion, XfsVersion highVersion) {
		return new VersionsRequired(lowVersion, highVersion);
	}
}
