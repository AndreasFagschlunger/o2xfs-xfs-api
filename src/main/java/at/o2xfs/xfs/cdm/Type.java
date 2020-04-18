package at.o2xfs.xfs.cdm;

import at.o2xfs.xfs.api.XfsConstant;

public enum Type implements XfsConstant {

	/*
	 * @since v3.00
	 */
	NA(1L),

	/*
	 * @since v3.00
	 */
	REJECTCASSETTE(2L),

	/*
	 * @since v3.00
	 */
	BILLCASSETTE(3L),

	/*
	 * @since v3.00
	 */
	COINCYLINDER(4L),

	/*
	 * @since v3.00
	 */
	COINDISPENSER(5L),

	/*
	 * @since v3.00
	 */
	RETRACTCASSETTE(6L),

	/*
	 * @since v3.00
	 */
	COUPON(7L),

	/*
	 * @since v3.00
	 */
	DOCUMENT(8L),

	/*
	 * @since v3.00
	 */
	REPCONTAINER(11L),

	/*
	 * @since v3.00
	 */
	RECYCLING(12L);

	private final long value;

	private Type(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}
