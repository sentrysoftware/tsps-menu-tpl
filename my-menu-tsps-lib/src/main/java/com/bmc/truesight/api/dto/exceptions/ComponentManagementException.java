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
package com.bmc.truesight.api.dto.exceptions;

public class ComponentManagementException extends Exception {

	private static final long serialVersionUID = -1140374757842203908L;

	public ComponentManagementException(final String message) {
		super(message);
	}

	public ComponentManagementException(final String message, final Exception e) {
		super(message, e);
	}

}
