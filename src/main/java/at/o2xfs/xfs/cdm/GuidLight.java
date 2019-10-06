package at.o2xfs.xfs.cdm;

import at.o2xfs.xfs.XfsConstant;

public enum GuidLight implements XfsConstant {

	/*
	 * @since v3.10
	 */
	OFF(0x00000001L),

	/*
	 * @since v3.10
	 */
	SLOW_FLASH(0x00000004L),

	/*
	 * @since v3.10
	 */
	MEDIUM_FLASH(0x00000008L),

	/*
	 * @since v3.10
	 */
	QUICK_FLASH(0x00000010L),

	/*
	 * @since v3.10
	 */
	CONTINUOUS(0x00000080L),

	/*
	 * @since v3.10
	 */
	RED(0x00000100L),

	/*
	 * @since v3.10
	 */
	GREEN(0x00000200L),

	/*
	 * @since v3.10
	 */
	YELLOW(0x00000400L),

	/*
	 * @since v3.10
	 */
	BLUE(0x00000800L),

	/*
	 * @since v3.10
	 */
	CYAN(0x00001000L),

	/*
	 * @since v3.10
	 */
	MAGENTA(0x00002000L),

	/*
	 * @since v3.10
	 */
	WHITE(0x00004000L),

	/*
	 * @since v3.10
	 */
	NOT_AVAILABLE(0x0000L),

	/*
	 * @since v3.30
	 */
	EXIT(0x00200000L);

	private final long value;

	private GuidLight(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}
