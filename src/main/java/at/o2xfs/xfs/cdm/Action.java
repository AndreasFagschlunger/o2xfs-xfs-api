package at.o2xfs.xfs.cdm;

import at.o2xfs.xfs.XfsConstant;

public enum Action implements XfsConstant {

	/*
	 * @since v3.10
	 */
	START(1L),

	/*
	 * @since v3.10
	 */
	STOP(2L);

	private final long value;

	private Action(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}
