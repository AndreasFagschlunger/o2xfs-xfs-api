package at.o2xfs.xfs.cim;

import at.o2xfs.xfs.XfsConstant;

public enum InputPosition implements XfsConstant {

	/*
	 * @since v3.00
	 */
	NULL(0x0000),

	/*
	 * @since v3.00
	 */
	INLEFT(0x0001),

	/*
	 * @since v3.00
	 */
	INRIGHT(0x0002),

	/*
	 * @since v3.00
	 */
	INCENTER(0x0004),

	/*
	 * @since v3.00
	 */
	INTOP(0x0008),

	/*
	 * @since v3.00
	 */
	INBOTTOM(0x0010),

	/*
	 * @since v3.00
	 */
	INFRONT(0x0020),

	/*
	 * @since v3.00
	 */
	INREAR(0x0040);

	private final long value;

	private InputPosition(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}