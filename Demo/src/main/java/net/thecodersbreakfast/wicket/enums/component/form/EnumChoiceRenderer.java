/*
* Copyright 2013 Olivier Croisier (thecodersbreakfast.net)
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package net.thecodersbreakfast.wicket.enums.component.form;

import net.thecodersbreakfast.wicket.enums.EnumMessageKeyProvider;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.IChoiceRenderer;


/**
 * Custom {@link ChoiceRenderer} displaying localized Enum values. <br/> <br/>
 * The provided Component is used as the root of the I18N properties file search
 * process.
 *
 * @author Olivier Croisier
 */
public class EnumChoiceRenderer<T extends Enum<T>> implements IChoiceRenderer<T> {

    /** The Component used a the root of the I18N search process */
    private final Component resourceProvider;

    /**
     * Constructor
     *
     * @param resourceProvider The component to use as the root of the I18N
     * search process
     */
    public EnumChoiceRenderer(final Component resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    @Override
    public Object getDisplayValue(final T value) {
        final String key = EnumMessageKeyProvider.getMessageKey(value);
        return resourceProvider.getString(key);
    }

    @Override
    public String getIdValue(final T object, final int index) {
        final Enum<?> enumValue = object;
        return enumValue.name();
    }

}
