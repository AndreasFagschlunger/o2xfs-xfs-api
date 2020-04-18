package at.o2xfs.xfs.api;

import java.util.HashMap;
import java.util.Map;

import at.o2xfs.xfs.cdm.CdmError;

public final class XfsExceptionFactory {

	private static Map<Integer, Enum<?>> ERRORS = new HashMap<>();

	static {
		addErrors(XfsError.class);
		addErrors(CdmError.class);
	}

	public static <E extends Enum<E> & XfsConstant> void addErrors(Class<E> enumType) {
		for (E each : enumType.getEnumConstants()) {
			ERRORS.put(Integer.valueOf((int) each.getValue()), each);
		}
	}

	public static XfsException create(int errorCode) {
		Enum<?> error = ERRORS.get(Integer.valueOf(errorCode));
		if (error == null) {
			return new XfsException(errorCode);
		}
		return new XfsException((Enum & XfsConstant) error);
	}
}
