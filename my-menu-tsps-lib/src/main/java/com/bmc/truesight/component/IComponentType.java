package com.bmc.truesight.component;

import com.bmc.truesight.api.dto.Component;
import com.bmc.truesight.api.dto.exceptions.ComponentManagementException;

/**
 * Classes mimicking BMC TSPS code that is necessary to compile the Java code
 * that declares our menu.
 *
 * These classes are excluded from the .war artifact and from the plugin .zip
 * file as their "real" counterparts will be provided at runtime in the
 * classpath of the JVM executing TSPS and our code.
 *
 * DO NOT CHANGE.
 */
public interface IComponentType {

	int getServerID();

	String getType();

	String getServerDNSName();

	String getComponentAttributeValue(String paramString) throws ComponentManagementException;

	boolean updateComponentAttribute(String paramString1, String paramString2);

	String getComponentAttribute(String paramString) throws ComponentManagementException;

	Integer getComponentAttributeAsInt(String paramString);

	String getServerTenant();

	Component.ConnectionStatus getConnectionStatus();

	String getServerProtocol();

	int getServerPort();

	String getServerIPAddress();

	String getServerOs();

	String getServerVersion();

	String getServerDescription();

	String getAPIKey();
}
