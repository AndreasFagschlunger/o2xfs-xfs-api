package at.o2xfs.xfs.api;

public enum TraceLevel implements XfsConstant {

	API(0x00000001L),
	ALL_API(0x00000002L),
	SPI(0x00000004L),
	ALL_SPI(0x00000008L),
	MGR(0x00000010L);

	private final long value;

	private TraceLevel(final long value) {
		this.value = value;
	}

	@Override
	public long getValue() {
		return value;
	}
}
