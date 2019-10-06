package at.o2xfs.xfs.util;

public final class StandardCurrencyIds {

	public static final CurrencyId EUR = CurrencyId.of("EUR");
	public static final CurrencyId USD = CurrencyId.of("USD");

	private StandardCurrencyIds() {
		throw new AssertionError();
	}
}
