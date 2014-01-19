package net.thecodersbreakfast.wickettips.presentation.wicket;


import net.thecodersbreakfast.wickettips.presentation.wicket.pages.HomePage;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;


public class WicketTipsApplication extends WebApplication {

	@Override
	protected void init() {
		// EnumMessageKeyProvider.setDefault(new TestEnumResourceKeyProvider());
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}
}
