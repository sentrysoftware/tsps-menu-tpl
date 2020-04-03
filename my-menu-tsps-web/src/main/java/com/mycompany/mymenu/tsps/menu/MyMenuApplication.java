package com.mycompany.mymenu.tsps.menu;

import com.bmc.tsps.common.services.i18n.I18nRegistry;
import com.bmc.tsps.common.services.menu.MenuRegistry;
import com.bmc.tsps.common.services.asset.AssetRegistry;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyMenuApplication implements ServletContextListener {
	
	private MyMenuProvider menuProvider;
	private MyMenuAssetProvider assetProvider;
	private MyMenuI18nProvider i18nProvider;

    @Override
    public void contextInitialized(final ServletContextEvent event) {	
		this.menuProvider = new MyMenuProvider();
	    this.assetProvider = new MyMenuAssetProvider();
		this.i18nProvider = new MyMenuI18nProvider();
				
		MenuRegistry.getInstance().addProvider(menuProvider);
	    AssetRegistry.getInstance().addProvider(assetProvider);
		I18nRegistry.getInstance().register(i18nProvider);
    }	
	
    @Override
    public void contextDestroyed(final ServletContextEvent event) {
		MenuRegistry.getInstance().removeProvider(menuProvider);
	    AssetRegistry.getInstance().removeProvider(assetProvider);
		I18nRegistry.getInstance().unregister(i18nProvider);
		
		this.menuProvider = null;
	    this.assetProvider = null;
		this.i18nProvider = null;
    }
}