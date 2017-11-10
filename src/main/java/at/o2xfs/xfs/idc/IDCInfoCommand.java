package at.o2xfs.xfs.idc;

import at.o2xfs.xfs.XfsConstant;

public enum IdcInfoCommand implements XfsConstant {

	/*
	 * @since v3.00
	 */
	STATUS(201L),

	/*
	 * @since v3.00
	 */
	CAPABILITIES(202L),

	/*
	 * @since v3.00
	 */
	FORM_LIST(203L),

	/*
	 * @since v3.00
	 */
	QUERY_FORM(204L),

	/*
	 * @since v3.10
	 */
	QUERY_IFM_IDENTIFIER(205L),

	/*
	 * @since v3.30
	 */
	EMVCLESS_QUERY_APPLICATIONS(206L);

	private final long value;

	private IdcInfoCommand(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}