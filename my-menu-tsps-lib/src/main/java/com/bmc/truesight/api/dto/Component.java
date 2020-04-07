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
package com.bmc.truesight.api.dto;

import java.util.Set;

public class Component {

	public enum ConnectionStatus {
		DISCONNECTED, REGISTRATION, INITIALIZING, CONNECTED, INITIALIZING_DELETE, DELETED, INITIALIZING_ERROR,
		REGISTRATION_ERROR, DELETE_ERROR, ERROR, UPDATING, UPDATE_ERROR;
	}

	private boolean checkProtocol;
	private String serverProtocol;
	private int serverDefaultHttpsPort;
	private int serverDefaultHttpPort;
	private String serverDescription;
	private String type;
	private Set<ComponentAttributeEntity> attributes;
	private String serverTenant;
	private String serverVersion;
	private String serverOs;
	private String APIKey;
	private String serverIPAddress;
	private int serverID;
	private String serverDNSName;
	private ConnectionStatus connectionStatus;
	private int serverPort;

	public boolean isCheckProtocol() {
		return checkProtocol;
	}

	public String getServerProtocol() {
		return serverProtocol;
	}

	public int getServerDefaultHttpsPort() {
		return serverDefaultHttpsPort;
	}

	public int getServerDefaultHttpPort() {
		return serverDefaultHttpPort;
	}

	public String getServerDescription() {
		return serverDescription;
	}

	public String getType() {
		return type;
	}

	public void setCheckProtocol(final boolean checkProtocol) {
		this.checkProtocol = checkProtocol;
	}

	public void setServerProtocol(final String serverProtocol) {
		this.serverProtocol = serverProtocol;

	}

	public void setServerDefaultHttpsPort(final int serverDefaultHttpsPort) {
		this.serverDefaultHttpsPort = serverDefaultHttpsPort;

	}

	public void setServerDefaultHttpPort(final int serverDefaultHttpPort) {
		this.serverDefaultHttpPort = serverDefaultHttpPort;

	}

	public void setServerDescription(final String serverDescription) {
		this.serverDescription = serverDescription;

	}

	public void setType(final String type) {
		this.type = type;

	}

	public Set<ComponentAttributeEntity> getAttributes() {
		return this.attributes;
	}

	public void setAttributes(final Set<ComponentAttributeEntity> attributes) {
		this.attributes = attributes;
	}

	public String getServerTenant() {
		return this.serverTenant;
	}

	public void setServerTenant(final String serverTenant) {
		this.serverTenant = serverTenant;
	}

	public String getServerVersion() {
		return this.serverVersion;
	}

	public void setServerVersion(final String serverVersion) {
		this.serverVersion = serverVersion;
	}

	public void setServerOs(final String serverOs) {
		this.serverOs = serverOs;
	}

	public String getServerOs() {
		return this.serverOs;
	}

	public int getServerID() {
		return this.serverID;
	}

	public void setAPIKey(final String aPIKey) {
		APIKey = aPIKey;
	}

	public void setServerIPAddress(final String serverIPAddress) {
		this.serverIPAddress = serverIPAddress;
	}

	public void setServerID(final int serverID) {
		this.serverID = serverID;
	}

	public void setServerDNSName(final String serverDNSName) {
		this.serverDNSName = serverDNSName;
	}

	public void setConnectionStatus(final ConnectionStatus connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public void setServerPort(final int serverPort) {
		this.serverPort = serverPort;
	}

	public String getServerDNSName() {
		return this.serverDNSName;
	}

	public ConnectionStatus getConnectionStatus() {
		return this.connectionStatus;
	}

	public int getServerPort() {
		return this.serverPort;
	}

	public String getServerIPAddress() {
		return this.serverIPAddress;
	}

	public String getAPIKey() {
		return this.APIKey;
	}
}
