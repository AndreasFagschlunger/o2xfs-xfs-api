package at.o2xfs.xfs.cdm;

import at.o2xfs.xfs.XfsConstant;

public enum RetractTransportAction implements XfsConstant {

	/*
	 * @since v3.00
	 */
	PRESENT(0x0001L),

	/*
	 * @since v3.00
	 */
	RETRACT(0x0002L),

	/*
	 * @since v3.00
	 */
	REJECT(0x0004L),

	/*
	 * @since v3.00
	 */
	NOTSUPP(0x0008L),

	/*
	 * @since v3.10
	 */
	ITEMCASSETTE(0x0010L);

	private final long value;

	private RetractTransportAction(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}
