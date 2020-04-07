package com.mycompany.mymenu.tsps.menu;

import java.util.Collections;

import com.bmc.truesight.api.extended.component.ComponentsDAO;
import com.bmc.truesight.platform.etl.component.management.types.MyMenuComponent;

public class MyMenuHelper {

	private MyMenuHelper() {
	}

	/**
	 * @return whether at least one MyMenuComponent component is loaded
	 */
	public static boolean isComponentPresent() {

		// First, check whether the MyMenuComponent class has been loaded already
		try {
			Class.forName("com.bmc.truesight.platform.etl.component.management.types.MyMenuComponent", false,
					MyMenuHelper.class.getClassLoader());
		} catch (final ClassNotFoundException e) {
			// MyMenuComponent is not present in ClassLoader, so it *really* is not present
			return false;
		}

		// Find MyMenuComponent instances and check whether at least one is ready
		return ComponentsDAO
				.getComponentsByTenantAndType("*", MyMenuComponent.COMPONENT_TYPE)
				.orElse(Collections.emptyList())
				.stream()
				.map(MyMenuComponent.class::cast).anyMatch(MyMenuComponent::isReady);
	}

}
