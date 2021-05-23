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
package smartfwk.testing.ui.standard.imgobj;

import org.sikuli.script.Region;

import smartfwk.testing.ui.core.commons.LocatorType;
import smartfwk.testing.ui.core.config.webbrowser.WebBrowser;
import smartfwk.testing.ui.core.objects.ObjectLocation;
import smartfwk.testing.ui.core.objects.PullDownMenuInfo;
import smartfwk.testing.ui.core.objects.combobox.ComboBox;

/**
 * 
 * @author Madhav Krishna
 *
 */
public class ComboBoxSI extends ComboBox {
	protected String leftSideImg;
	protected String rightSideImg;
	protected ObjectLocation location;
	protected PullDownMenuInfo pullDownMenuInfo;
	protected boolean readOnly;
	protected boolean disabled;

	public ComboBoxSI(String displayName, String leftSideImg, String rightSideImg, ObjectLocation location,
			PullDownMenuInfo pullDownMenuInfo) {
		super(LocatorType.IMAGE, displayName);
		this.leftSideImg = leftSideImg;
		this.rightSideImg = rightSideImg;
		this.location = location;
		this.pullDownMenuInfo = pullDownMenuInfo;
		this.readOnly = true;
		this.disabled = false;
	}

	public String getLeftSideImage() {
		return leftSideImg;
	}

	public String getRightSideImage() {
		return rightSideImg;
	}

	public ObjectLocation getLocation() {
		return location;
	}

	public PullDownMenuInfo getPullDownMenuInfo() {
		return pullDownMenuInfo;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public ComboBoxValidatorSI getValidator(WebBrowser browser, Region region) {
		return new ComboBoxValidatorSI(browser, this, region);
	}

	@Override
	public ComboBoxSI clone() {
		return new ComboBoxSI(displayName, leftSideImg, rightSideImg, location, pullDownMenuInfo);
	}

	@Override
	@Deprecated
	public ComboBoxSI updateLocatorParameterWithValue(String paramName, String value) {
		return this;
	}

}
