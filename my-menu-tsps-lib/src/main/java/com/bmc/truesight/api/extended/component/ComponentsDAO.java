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
package com.bmc.truesight.api.extended.component;

import java.util.List;
import java.util.Optional;

import com.bmc.truesight.component.IComponentType;

public class ComponentsDAO {

	public static Optional<List<IComponentType>> getComponentsByType(final String componentType) {
		return Optional.empty();
	}

	public static Optional<List<IComponentType>> getComponentsByTenantAndType(final String string,
			final String componentType) {
		return Optional.empty();
	}

}
