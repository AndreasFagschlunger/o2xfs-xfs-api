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

package at.o2xfs.xfs.pin;

import at.o2xfs.xfs.api.DeviceState;
import at.o2xfs.xfs.api.XfsConstant;

public enum PINDeviceState implements XfsConstant {

	/**
	 * {@link at.o2xfs.xfs.api.DeviceState#ONLINE}
	 */
	ONLINE(DeviceState.ONLINE),

	/**
	 * {@link at.o2xfs.xfs.api.DeviceState#OFFLINE}
	 */
	OFFLINE(DeviceState.OFFLINE),

	/**
	 * {@link at.o2xfs.xfs.api.DeviceState#POWEROFF}
	 */
	POWEROFF(DeviceState.POWEROFF),

	/**
	 * {@link at.o2xfs.xfs.api.DeviceState#BUSY}
	 */
	BUSY(DeviceState.BUSY),

	/**
	 * {@link at.o2xfs.xfs.api.DeviceState#NODEVICE}
	 */
	NODEVICE(DeviceState.NODEVICE),

	/**
	 * {@link at.o2xfs.xfs.api.DeviceState#HWERROR}
	 */
	HWERROR(DeviceState.HWERROR),

	/**
	 * {@link at.o2xfs.xfs.api.DeviceState#USERERROR}
	 */
	USERERROR(DeviceState.USERERROR),

	/**
	 * The device is present but has detected a fraud attempt.
	 *
	 * {@link at.o2xfs.xfs.api.DeviceState#FRAUDATTEMPT}
	 *
	 * @since 3.10
	 */
	FRAUDATTEMPT(DeviceState.FRAUDATTEMPT),

	/**
	 * {@link at.o2xfs.xfs.api.DeviceState#POTENTIALFRAUD}
	 *
	 * @since 3.20
	 */
	POTENTIALFRAUD(DeviceState.POTENTIALFRAUD);

	private final long value;

	private PINDeviceState(final DeviceState xfsDeviceState) {
		this.value = xfsDeviceState.getValue();
	}

	@Override
	public long getValue() {
		return value;
	}
}