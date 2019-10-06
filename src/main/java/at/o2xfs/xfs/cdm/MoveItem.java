package at.o2xfs.xfs.cdm;

import at.o2xfs.xfs.XfsConstant;

public enum MoveItem implements XfsConstant {

	/*
	 * @since v3.00
	 */
	FROMCU(0x0001L),

	/*
	 * @since v3.00
	 */
	TOCU(0x0002L),

	/*
	 * @since v3.00
	 */
	TOTRANSPORT(0x0004L),

	/*
	 * @since v3.30
	 */
	TOSTACKER(0x0008L);

	private final long value;

	private MoveItem(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}
