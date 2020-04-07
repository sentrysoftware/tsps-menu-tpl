package com.mycompany.mymenu.tsps.menu;

import com.bmc.tsps.common.services.asset.AssetProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyMenuAssetProvider implements AssetProvider {

	@Override
	public List<String> getModules() {

		return MyMenuHelper.isComponentPresent() ? Collections.singletonList("myMenuTspsApp") : Collections.emptyList();

	}

	@Override
	public List<String> getJavascripts() {

		return MyMenuHelper.isComponentPresent()
				? Arrays.asList("/my-menu-tsps-web/js/tsps-route.js",
						"/my-menu-tsps-web/components/my-menu-devices-tsps/my-menu-devices-tsps.js")
				: Collections.emptyList();

	}

	@Override
	public List<String> getCss() {

		return MyMenuHelper.isComponentPresent()
				? Collections.singletonList("/my-menu-tsps-web/css/my-menu-tsps.css")
				: Collections.emptyList();

	}

}