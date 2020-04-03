package com.mycompany.mymenu.tsps.menu;

import com.bmc.tsps.common.services.i18n.I18nFile;
import com.bmc.tsps.common.services.i18n.I18nProvider;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

public class MyMenuI18nProvider implements I18nProvider {

	@Override
	public Collection<I18nFile> getResources() {

		if (MyMenuHelper.isComponentPresent()) {
			final I18nFile resourceEn = new I18nFile(Locale.ENGLISH, this.getClass().getResource("/en.json"));
			return Arrays.asList(resourceEn);
		}

		return Collections.emptyList();
	}

}
