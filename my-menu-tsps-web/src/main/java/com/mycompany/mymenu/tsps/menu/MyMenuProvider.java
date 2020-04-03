package com.mycompany.mymenu.tsps.menu;

import java.util.Collections;
import java.util.List;

import com.bmc.truesight.platform.etl.component.management.types.MyMenuComponent;
import com.bmc.tsps.common.services.menu.Menu;
import com.bmc.tsps.common.services.menu.MenuProvider;

public class MyMenuProvider implements MenuProvider {

	@Override
	public List<Menu> getMenu() {

		final Menu rootMenu = new Menu("my-menu.name", "/my-menu",
				"",
				MyMenuComponent.COMPONENT_TYPE, 50);

		final Menu devicesMenu = new Menu("my-menu.devices", "/my-menu/devices", "",
				MyMenuComponent.COMPONENT_TYPE, 51);
		
		rootMenu.getMenus().add(devicesMenu);

		return Collections.singletonList(rootMenu);

	}

}
