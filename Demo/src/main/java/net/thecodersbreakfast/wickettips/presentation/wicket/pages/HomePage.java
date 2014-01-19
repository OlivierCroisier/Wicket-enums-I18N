package net.thecodersbreakfast.wickettips.presentation.wicket.pages;

import java.util.Locale;

import net.thecodersbreakfast.wickettips.model.Season;
import net.thecodersbreakfast.wicket.enums.component.form.EnumDropDownChoice;
import net.thecodersbreakfast.wicket.enums.model.EnumModel;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;


/**
 * @author Olivier Croisier
 */
public class HomePage extends WebPage {

	private Season season = Season.SPRING;

	public HomePage() {
		add(newLocaleLink("EnglishLocaleLink", Locale.ENGLISH));
		add(newLocaleLink("FrenchLocaleLink", Locale.FRENCH));

		Form<Void> form = new Form<Void>("form");
		form.add(new EnumDropDownChoice<Season>("season", new PropertyModel<Season>(this, "season")));
		add(form);

		add(new Label("label", new EnumModel<Season>(new PropertyModel<Season>(this, "season"), this)));

	}

	private Link<Void> newLocaleLink(String id, final Locale locale) {
		return new Link<Void>(id) {
			@Override
			public void onClick() {
				getSession().setLocale(locale);
			}
		};
	}

}
