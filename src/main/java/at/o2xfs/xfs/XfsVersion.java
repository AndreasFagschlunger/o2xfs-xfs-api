/*
 * Copyright (c) 2017, Andreas Fagschlunger. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package at.o2xfs.xfs;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import at.o2xfs.memory.databind.annotation.MemoryDeserialize;
import at.o2xfs.memory.databind.annotation.MemorySerialize;
import at.o2xfs.xfs.databind.deser.XfsVersionDeserializer;
import at.o2xfs.xfs.databind.ser.XfsVersionSerializer;
import at.o2xfs.xfs.util.XFSUtils;

/**
 * @author Andreas Fagschlunger
 */
@MemorySerialize(using = XfsVersionSerializer.class)
@MemoryDeserialize(using = XfsVersionDeserializer.class)
public final class XfsVersion implements Comparable<XfsVersion> {

	/**
	 * Release 2.00
	 */
	public final static XfsVersion V2_00 = XfsVersion.of("2.00");

	/**
	 * Release 3.00
	 */
	public final static XfsVersion V3_00 = XfsVersion.of("3.00");

	/**
	 * Release 3.10
	 */
	public final static XfsVersion V3_10 = XfsVersion.of("3.10");

	/**
	 * Release 3.20
	 */
	public final static XfsVersion V3_20 = XfsVersion.of("3.20");

	/**
	 * Release 3.30
	 */
	public final static XfsVersion V3_30 = XfsVersion.of("3.30");

	private final int majorVersion;

	private final int minorVersion;

	private XfsVersion(int majorVersion, int minorVersion) {
		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public int intValue() {
		int result = 0;
		result |= minorVersion;
		result <<= 8;
		result |= majorVersion;
		return result;
	}

	/**
	 * Greater than or equal to
	 *
	 * @param version
	 * @return true if {@link #compareTo(XfsVersion)} returns &gt;= 0, false
	 *         otherwise
	 */
	public boolean isGE(final XfsVersion version) {
		return compareTo(version) >= 0;
	}

	/**
	 * Greater than
	 *
	 * @param version
	 * @return
	 */
	public boolean isGT(final XfsVersion version) {
		return compareTo(version) > 0;
	}

	/**
	 * @param version
	 *            the version to be compared.
	 * @return true as this version is less than the specified version.
	 */
	public boolean isLT(final XfsVersion version) {
		return compareTo(version) < 0;
	}

	/**
	 * @param version
	 *            the version to be compared.
	 * @return true as this version is less than or equal to the specified
	 *         version.
	 */
	public boolean isLE(final XfsVersion version) {
		return compareTo(version) <= 0;
	}

	@Override
	public int compareTo(final XfsVersion version) {
		if (majorVersion > version.majorVersion) {
			return 1;
		} else if (majorVersion < version.majorVersion) {
			return -1;
		} else {
			if (minorVersion > version.minorVersion) {
				return 1;
			} else if (minorVersion < version.minorVersion) {
				return -1;
			}
		}
		return 0;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(majorVersion).append(minorVersion).toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof XfsVersion) {
			final XfsVersion v = (XfsVersion) obj;
			return new EqualsBuilder()
					.append(majorVersion, v.majorVersion)
					.append(minorVersion, v.minorVersion)
					.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("%d.%02d", Integer.valueOf(majorVersion), Integer.valueOf(minorVersion));
	}

	public static XfsVersion of(String s) {
		return XfsVersion.of(XFSUtils.getVersion(s));
	}

	public static XfsVersion of(final int version) {
		return new XfsVersion(version & 0xFF, (version >>> 8) & 0xFF);
	}
}