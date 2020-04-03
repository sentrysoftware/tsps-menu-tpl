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
package com.bmc.sas.ngp.service.security;

import com.bmc.sas.domain.user.User;

public class SecurityServiceImpl {

	public User getUser(final String serverTenant, final String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
