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
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

/**
 * @param <T> Type of the Enum
 * @author Olivier Croisier
 */
public class EnumModel<T extends Enum<T>> extends AbstractReadOnlyModel<String> {

    private IModel<T> model;
    private Component component;

    public EnumModel(IModel<T> model, Component component) {
        this.model = model;
        this.component = component;
    }

    @Override
    public String getObject() {
        String key = EnumMessageKeyProvider.getMessageKey(model.getObject());
        return component.getString(key);
    }

}
