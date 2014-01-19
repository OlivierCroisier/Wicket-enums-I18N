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

package net.thecodersbreakfast.wicket.enums.model;


import net.thecodersbreakfast.wicket.enums.EnumMessageKeyProvider;
import org.apache.wicket.Component;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.lang.PropertyResolver;


/**
 * PropertyModel that operates on an Enum and provides its internationalized
 * representation.
 *
 * @param <T> The model type
 * @author Olivier Croisier
 */
public class EnumPropertyModel<T extends Enum<T>> extends PropertyModel<String> {

    private Component component;

    public EnumPropertyModel(Object modelObject, String expression, Component resourceProvider) {
        super(modelObject, expression);
        this.component = resourceProvider;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String getObject() {
        final String expression = propertyExpression();
        final Object target = getTarget();
        if (target != null) {
            T enumValue = (T) PropertyResolver.getValue(expression, target);
            String key = EnumMessageKeyProvider.getMessageKey(enumValue);
            return component.getString(key);
        }
        return null;
    }

}
