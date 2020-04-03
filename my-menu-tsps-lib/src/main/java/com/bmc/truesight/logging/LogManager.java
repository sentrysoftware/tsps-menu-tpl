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
package com.bmc.truesight.logging;

public class LogManager {

	private static final LogManager LOG_MANAGER = new LogManager();

	public static LogManager getInstance() {
		return LOG_MANAGER;
	}

	public Log getLogger(final String log) {
		return new Log(log);
	}
}
