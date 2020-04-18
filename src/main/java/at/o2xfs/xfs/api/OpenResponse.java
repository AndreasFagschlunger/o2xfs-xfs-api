package at.o2xfs.xfs.api;

public final class OpenResponse {

	private final RequestId requestId;
	private final ServiceId serviceId;
	private final WfsVersion srvcVersion;
	private final WfsVersion spiVersion;

	public OpenResponse(RequestId requestId, ServiceId serviceId, WfsVersion srvcVersion, WfsVersion spiVersion) {
		this.requestId = requestId;
		this.serviceId = serviceId;
		this.srvcVersion = srvcVersion;
		this.spiVersion = spiVersion;
	}

	public RequestId getRequestId() {
		return requestId;
	}

	public ServiceId getServiceId() {
		return serviceId;
	}

	public WfsVersion getSrvcVersion() {
		return srvcVersion;
	}

	public WfsVersion getSpiVersion() {
		return spiVersion;
	}

	public static OpenResponse build(RequestId requestId, ServiceId serviceId, WfsVersion srvcVersion,
			WfsVersion spiVersion) {
		return new OpenResponse(requestId, serviceId, srvcVersion, spiVersion);
	}
}
