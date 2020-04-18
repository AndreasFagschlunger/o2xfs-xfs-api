package at.o2xfs.xfs.api;

public class StartUpException extends XfsException {

	private final WfsVersion version;

	private StartUpException(int errorCode, WfsVersion version) {
		super(errorCode);
		this.version = version;
	}

	public static StartUpException build(int errorCode, WfsVersion version) {
		return new StartUpException(errorCode, version);
	}
}
