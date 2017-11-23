package at.o2xfs.xfs;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.common.Bytes;
import at.o2xfs.win32.ByteArray;
import at.o2xfs.win32.DWORD;
import at.o2xfs.win32.LPSTR;
import at.o2xfs.win32.Pointer;
import at.o2xfs.win32.Struct;

public class WfsUndeliverableMessage extends Struct {

	protected final LPSTR logicalName = new LPSTR();
	protected final LPSTR workstationName = new LPSTR();
	protected final LPSTR appId = new LPSTR();
	protected final DWORD length = new DWORD();
	protected final Pointer description = new Pointer();
	protected final DWORD message = new DWORD();
	protected final Pointer wfsResult = new Pointer();

	protected WfsUndeliverableMessage() {
		add(logicalName);
		add(workstationName);
		add(appId);
		add(length);
		add(description);
		add(message);
		add(wfsResult);
	}

	public WfsUndeliverableMessage(Pointer p) {
		this();
		assignBuffer(p);
	}

	public WfsUndeliverableMessage(WfsUndeliverableMessage copy) {
		this();
		allocate();
		logicalName.set(copy.getLogicalName());
		workstationName.set(copy.getWorkstationName());
		appId.set(copy.getAppId());
		length.set(copy.length);
		description.pointTo(new ByteArray(copy.getDescription()));
		wfsResult.pointTo(new WFSResult(copy.getWfsResult()));
	}

	public String getLogicalName() {
		return logicalName.get();
	}

	public String getWorkstationName() {
		return workstationName.get();
	}

	public String getAppId() {
		return appId.get();
	}

	public byte[] getDescription() {
		byte[] result = Bytes.EMPTY;
		if (length.intValue() > 0) {
			result = description.buffer(length.intValue()).get();
		}
		return result;
	}

	public long getMessage() {
		return message.longValue();
	}

	public WFSResult getWfsResult() {
		return new WFSResult(wfsResult);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(getLogicalName())
				.append(getWorkstationName())
				.append(getAppId())
				.append(getDescription())
				.append(getWfsResult())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof WfsUndeliverableMessage) {
			WfsUndeliverableMessage undeliverableMessage = (WfsUndeliverableMessage) obj;
			return new EqualsBuilder()
					.append(getLogicalName(), undeliverableMessage.getLogicalName())
					.append(getWorkstationName(), undeliverableMessage.getWorkstationName())
					.append(getAppId(), undeliverableMessage.getAppId())
					.append(getDescription(), undeliverableMessage.getDescription())
					.append(getWfsResult(), undeliverableMessage.getWfsResult())
					.isEquals();
		}
		return result;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("logicalName", getLogicalName())
				.append("workstationName", getWorkstationName())
				.append("appId", getAppId())
				.append("description", getDescription())
				.append("wfsResult", getWfsResult())
				.toString();
	}
}
