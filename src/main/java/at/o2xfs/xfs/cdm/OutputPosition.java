package at.o2xfs.xfs.cdm;

import at.o2xfs.xfs.api.XfsConstant;

public enum OutputPosition implements XfsConstant {

	/*
	 * @since v3.00
	 */
	NULL(0x0000L),

	/*
	 * @since v3.00
	 */
	LEFT(0x0001L),

	/*
	 * @since v3.00
	 */
	RIGHT(0x0002L),

	/*
	 * @since v3.00
	 */
	CENTER(0x0004L),

	/*
	 * @since v3.00
	 */
	TOP(0x0040L),

	/*
	 * @since v3.00
	 */
	BOTTOM(0x0080L),

	/*
	 * @since v3.00
	 */
	REJECT(0x0100L),

	/*
	 * @since v3.00
	 */
	FRONT(0x0800L),

	/*
	 * @since v3.00
	 */
	REAR(0x1000L);

	private final long value;

	private OutputPosition(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}
