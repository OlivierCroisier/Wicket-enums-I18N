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

package net.thecodersbreakfast.wicket.enums;

/**
 * This class is used to determine the I18N key of an enum. Different strategies
 * can be chosen, but only one is active a a given time. This architecture is
 * required to avoid serialization when used from inside Wicket components.
 *
 * @author Olivier Croisier
 */
public abstract class EnumMessageKeyProvider {

    /** The current key generation strategy. */
    private static EnumMessageKeyProvider provider = new DefaultEnumResourceKeyProvider();

    /**
     * Encapsulates the I18N key generation algorithm (strategy)
     *
     * @param <T> The enum type
     * @param enumValue The enum value
     * @return a String defining the I18N key for the provided enum
     */
    public abstract <T extends Enum<T>> String computeMessageKey(T enumValue);

    /** Static accessor to the I18N key generation algorithm */
    public static <T extends Enum<T>> String getMessageKey(T enumValue) {
        return EnumMessageKeyProvider.provider.computeMessageKey(enumValue);
    }

    public static EnumMessageKeyProvider getDefault() {
        return EnumMessageKeyProvider.provider;
    }

    public static void setDefault(EnumMessageKeyProvider provider) {
        EnumMessageKeyProvider.provider = provider;
    }

}
