/*
 * SmartTestAutoFramework
 * Copyright 2021 and beyond
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package smartfwk.testing.ui.core.objects.datetime;

import org.sikuli.script.Region;

import smartfwk.testing.ui.core.config.webbrowser.WebBrowser;
import smartfwk.testing.ui.core.objects.UIObjectValidator;
import smartfwk.testing.ui.core.objects.validator.mechanisms.TextValidationMechanism;

/**
 * 
 * @author Madhav Krishna
 *
 */
public abstract class DateTimeItemValidator extends UIObjectValidator {
	private DateTimeItem dateTimeItem;

	public DateTimeItemValidator(WebBrowser browser, DateTimeItem uiObject, Region region) {
		super(browser, uiObject, region);
		this.dateTimeItem = uiObject;
	}

	@Override
	public DateTimeItem getUIObject() {
		return this.dateTimeItem;
	}

	public abstract void validateDisabled(int numRetries);

	public abstract void validateEnabled(int numRetries);

	public abstract void typeDateTime(String date, String time, int numRetries);

	public abstract void selectDateTimeUsingDateTimePicker(String date, String time, int numRetries);

	public abstract void validateDateTime(String date, String time, TextValidationMechanism dateValidationMechanism, TextValidationMechanism timeValidationMechanism, int numRetries);
}