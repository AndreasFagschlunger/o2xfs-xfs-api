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

package at.o2xfs.xfs.ttu;

import at.o2xfs.xfs.api.DeviceState;
import at.o2xfs.xfs.api.XfsConstant;

public enum TTUDevice implements XfsConstant {

	/**
	 * The device is on-line. The device is present and operational (i.e. not
	 * busy processing a request and not having a hardware error).
	 */
	ONLINE(DeviceState.ONLINE),

	/**
	 * The device is off-line. The device is present and powered on but it is
	 * not operational (e.g. a switch may have been used to change it to an
	 * off-line state).
	 */
	OFFLINE(DeviceState.OFFLINE),

	/**
	 * The device is powered off. The device is present, but is currently
	 * powered off.
	 */
	POWEROFF(DeviceState.POWEROFF),

	/**
	 * The device is busy processing a request. The device is present and an
	 * EXECUTE request is currently being processed.
	 */
	BUSY(DeviceState.BUSY),

	/**
	 * There is no device connected.
	 */
	NODEVICE(DeviceState.NODEVICE),

	/**
	 * The device is inoperable due to a hardware error. The device is present
	 * but a hardware fault prevents it from being used.
	 */
	HWERROR(DeviceState.HWERROR),

	/**
	 * The device is present but a person is preventing proper operation. The
	 * application should suspend the device operation or remove the device from
	 * service until the service provider generates a device state change event
	 * indicating the condition of the device has changed i.e. the error is
	 * removed ({@link #ONLINE}) or a permanent error condition has occurred ( {@link #HWERROR}).
	 */
	USERERROR(DeviceState.USERERROR),

	/**
	 *
	 */
	FRAUDATTEMPT(DeviceState.FRAUDATTEMPT),

	/**
	 *
	 * @since 3.20
	 */
	POTENTIALFRAUD(DeviceState.POTENTIALFRAUD);

	private final long value;

	private TTUDevice(final DeviceState deviceState) {
		this.value = deviceState.getValue();
	}

	@Override
	public long getValue() {
		return value;
	}
}