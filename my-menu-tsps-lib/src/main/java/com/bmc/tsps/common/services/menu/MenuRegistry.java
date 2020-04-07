package com.bmc.tsps.common.services.menu;

import java.util.ArrayList;
import java.util.List;


public class MenuRegistry {

	private static final MenuRegistry instance = new MenuRegistry();
	private final List<MenuProvider> menuProviders = new ArrayList<>();

	public static MenuRegistry getInstance() {
		return instance;
	}

	public void addProvider(final MenuProvider menuProvider) {
		this.menuProviders.add(menuProvider);
	}

	public void removeProvider(final MenuProvider menuProvider) {
		this.menuProviders.remove(menuProvider);
	}

}
