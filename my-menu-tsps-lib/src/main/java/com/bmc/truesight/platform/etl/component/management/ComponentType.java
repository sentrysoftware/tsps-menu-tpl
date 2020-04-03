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
package com.bmc.truesight.platform.etl.component.management;

import com.bmc.truesight.api.dto.Component;
import com.bmc.truesight.api.dto.exceptions.ComponentManagementException;
import com.bmc.truesight.component.IComponentType;
import com.bmc.truesight.platform.etl.component.management.listener.CMEventListener;

public abstract class ComponentType extends Component implements IComponentType {

	public abstract void registerationErrorNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void initializationErrorNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void updateErrorNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void deleteErrorNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void initializationNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void registrationNotification(boolean paramBoolean, CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void updateNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void componentInfoNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void deleteNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void forceDeleteNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void heartbeatNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void initDeleteNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void connectedNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void disconnectedNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void errorNotification(CMEventListener.CalledFrom paramCalledFrom)
			throws ComponentManagementException;

	public abstract void relatedComponentChangedNotification(ComponentType paramComponentType, String paramString)
			throws ComponentManagementException;

	@Override
	public String getComponentAttributeValue(final String attrKey) throws ComponentManagementException {
		return null;
	}

	@Override
	public boolean updateComponentAttribute(final String attKey, final String attValue) {

		return false;
	}

	@Override
	public String getComponentAttribute(final String attKey) throws ComponentManagementException {
		return null;
	}

	@Override
	public Integer getComponentAttributeAsInt(final String paramString) {
		return null;
	}
}
