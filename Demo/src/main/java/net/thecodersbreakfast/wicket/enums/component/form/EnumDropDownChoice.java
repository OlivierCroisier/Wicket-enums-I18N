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

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;

import java.util.Arrays;
import java.util.List;

/**
 * Custom DropDownChoice working automagically with Enums, showing localized
 * values of all the model's enum values. Best if used with a {@link
 * EnumChoiceRenderer} (the default if no other ChoiceRenderer is provided) See
 * {@link EnumChoiceRenderer} for the localization details.
 *
 * @author Olivier Croisier
 */
public class EnumDropDownChoice<T extends Enum<T>> extends DropDownChoice<T> {

    public EnumDropDownChoice(String id, IModel<T> model) {
        super(id);
        setModel(model);
        setChoiceRenderer(new EnumChoiceRenderer<T>(this));
    }

    public EnumDropDownChoice(String id, IModel<T> model, EnumChoiceRenderer<T> choiceRenderer) {
        super(id);
        setModel(model);
        setChoiceRenderer(choiceRenderer);
    }

    @Override
    public List<? extends T> getChoices() {
        return Arrays.asList(getModelObject().getDeclaringClass().getEnumConstants());
    }
}
