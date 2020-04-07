/**
 * Classes mimicking BMC TSPS code that is necessary to compile the Java code
 * that declares our menu.
 *
 * These classes are excluded from the .war artifact and from the plugin .zip file
 * as their "real" counterparts will be provided at runtime in the classpath of
 * the JVM executing TSPS and our code.
 *
 * DO NOT CHANGE.
 */
package com.bmc.tsps.common.services.i18n;

import java.util.ArrayList;
import java.util.List;

public class I18nRegistry {

	private static final I18nRegistry instance = new I18nRegistry();
	private final List<I18nProvider> providers = new ArrayList<>();

	public static I18nRegistry getInstance() {
		return instance;
	}

	public void register(final I18nProvider provider) {
		providers.add(provider);
	}

	public void unregister(final I18nProvider provider) {
		providers.remove(provider);
	}

}
