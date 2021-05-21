/*
 * SmartTestAutoFwk
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
package smartfwk.testing.ui.core.objects.tab;

import org.sikuli.script.Region;

import smartfwk.testing.ui.core.commons.ItemSet;
import smartfwk.testing.ui.core.config.webbrowser.WebBrowser;
import smartfwk.testing.ui.core.objects.UIObjectValidator;
import smartfwk.testing.ui.core.objects.webpage.WebPage;

/**
 * 
 * @author Madhav Krishna
 *
 */
public abstract class TabSheetValidator extends UIObjectValidator {
	private TabSheet tabSheet;
	
	public TabSheetValidator(WebBrowser browser, TabSheet locator, Region region) {
		super(browser, locator, region);
		this.tabSheet = locator;
	}

	@Override
	public TabSheet getUIObject() {
		return this.tabSheet;
	}

	public void setComponent(TabSheet component) {
		this.tabSheet = component;
	}

	public abstract void selectTab(String tabName, int numRetries);
	
	public abstract void validateSelectedTab(WebPage webPage,
			String expectedSelectedTabName, int numRetries);

	public abstract void validateTabsPresent(WebPage webPage,
			ItemSet<String> allTabNames, int numRetries);

	public abstract void validateDisabledTabs(WebPage webPage,
			ItemSet<String> disabledTabNames, int numRetries);

	public abstract void validateEnabledTabsOnTabSheet(WebPage webPage, int numRetries);
}
