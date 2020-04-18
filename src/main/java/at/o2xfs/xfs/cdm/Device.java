package at.o2xfs.xfs.cdm;

import at.o2xfs.xfs.api.DeviceState;
import at.o2xfs.xfs.api.XfsConstant;

public enum Device implements XfsConstant {

	/*
	 * @since v3.00
	 */
	ONLINE(DeviceState.ONLINE.getValue()),

	/*
	 * @since v3.00
	 */
	OFFLINE(DeviceState.OFFLINE.getValue()),

	/*
	 * @since v3.00
	 */
	POWEROFF(DeviceState.POWEROFF.getValue()),

	/*
	 * @since v3.00
	 */
	NODEVICE(DeviceState.NODEVICE.getValue()),

	/*
	 * @since v3.00
	 */
	HWERROR(DeviceState.HWERROR.getValue()),

	/*
	 * @since v3.00
	 */
	USERERROR(DeviceState.USERERROR.getValue()),

	/*
	 * @since v3.00
	 */
	BUSY(DeviceState.BUSY.getValue()),

	/*
	 * @since v3.10
	 */
	FRAUDATTEMPT(DeviceState.FRAUDATTEMPT.getValue()),

	/*
	 * @since v3.20
	 */
	POTENTIALFRAUD(DeviceState.POTENTIALFRAUD.getValue());

	private final long value;

	private Device(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}
