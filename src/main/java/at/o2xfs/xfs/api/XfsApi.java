package at.o2xfs.xfs.api;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

import at.o2xfs.memory.core.Address;
import at.o2xfs.memory.core.MemorySystem;

public interface XfsApi {

	RequestId asyncClose(ServiceId serviceId, Address windowHandle) throws XfsException;

	RequestId asyncDeregister(ServiceId serviceId, Set<XfsEventClass> eventClasses, Address regWindowHandle,
			Address windowHandle) throws XfsException;

	RequestId asyncLock(ServiceId serviceId, OptionalInt timeOut, Address windowHandle) throws XfsException;

	<E extends Enum<E> & XfsConstant> OpenResponse asyncOpen(OpenRequest request) throws XfsException;

	RequestId asyncRegister(ServiceId serviceId, Set<XfsEventClass> eventClasses, Address regWindowHandle,
			Address windowHandle) throws XfsException;

	<E extends Enum<E> & XfsConstant> RequestId asyncExecute(ServiceId serviceId, E command, Optional<Object> cmdData,
			OptionalInt timeOut, Address windowHandle) throws XfsException;

	<E extends Enum<E> & XfsConstant> RequestId asyncGetInfo(ServiceId serviceId, E category,
			Optional<Object> queryDetails, OptionalInt timeOut, Address windowHandle) throws XfsException;

	RequestId asyncUnlock(ServiceId serviceId, Address windowHandle) throws XfsException;

	void cancelAsyncRequest(ServiceId serviceId, RequestId requestId) throws XfsException;

	void cleanUp() throws XfsException;

	Address createAppHandle() throws XfsException;

	void destroyAppHandle(Address address) throws XfsException;

	void freeResult(Address address) throws XfsException;

	MemorySystem getMemorySystem();

	<E extends Enum<E> & XfsConstant> void setTraceLevel(ServiceId serviceId, Set<E> traceLevel) throws XfsException;

	WfsVersion startUp(XfsVersion lowVersion, XfsVersion highVersion) throws XfsException;
}
