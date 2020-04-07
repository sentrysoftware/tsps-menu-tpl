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

public class Log {

	private final String log;
	public Log(final String log) {
		this.log = log;
	}
	public String getLog() {
		return log;
	}

	public void info(final String log) {
		
	}

	public void error(final String log) {

	}

	public void info(final String log, final Object... e) {

	}

	public void error(final String log, final Object... e) {

	}
}
