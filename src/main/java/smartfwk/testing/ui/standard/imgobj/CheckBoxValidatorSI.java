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

import java.util.List;

import org.openqa.selenium.Keys;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.testng.Assert;

import smartfwk.testing.ui.core.commons.ImageSection;
import smartfwk.testing.ui.core.commons.UIObjectType;
import smartfwk.testing.ui.core.config.webbrowser.WebBrowser;
import smartfwk.testing.ui.core.objects.ImageObject;
import smartfwk.testing.ui.core.objects.NewTextLocation;
import smartfwk.testing.ui.core.objects.checkbox.CheckBoxValidator;
import smartfwk.testing.ui.core.objects.scrollbar.Scrollbar;

/**
 * 
 * @author Madhav Krishna
 *
 */
public class CheckBoxValidatorSI extends CheckBoxValidator {
	protected CheckBoxSI cbObject;

	public CheckBoxValidatorSI(WebBrowser browser, CheckBoxSI uiObject, Region region) {
		super(browser, uiObject, region);
		this.cbObject = uiObject;		
	}

	@Override
	public boolean isPresent(int numRetries) {
		Match m = findElementNoException(numRetries);
		return (m != null);
	}

	@Override
	public boolean isVisible(int numRetries) {
		return isPresent(numRetries);
	}

	@Override
	public void click(int numRetries) {
		try {
			Match match = findElement(numRetries);
			match.click();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse click on CheckBox '" + cbObject.getDisplayName() + "'.", th);
		}
	}
	
	public void click(ImageSection imageSection, int numRetries) {
		try {
			Match match = findElement(numRetries);
			getImageSection(match, imageSection).click();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse click on CheckBox '" + cbObject.getDisplayName() + "'.", th);
		}
	}

	@Override
	public void doubleClick(int numRetries) {
		try {
			Match match = findElement(numRetries);
			match.doubleClick();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse double click on CheckBox '" + cbObject.getDisplayName() + "'.", th);
		}
	}
	
	public void doubleClick(ImageSection imageSection, int numRetries) {
		try {
			Match match = findElement(numRetries);
			getImageSection(match, imageSection).doubleClick();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse double click on CheckBox '" + cbObject.getDisplayName() + "'.", th);
		}
	}

	@Override
	public void rightClick(int numRetries) {
		try {
			Match match = findElement(numRetries);
			match.rightClick();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse right click on CheckBox '" + cbObject.getDisplayName() + "'.", th);
		}
	}
	
	public void rightClick(ImageSection imageSection, int numRetries) {
		try {
			Match match = findElement(numRetries);
			getImageSection(match, imageSection).rightClick();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse right click on CheckBox '" + cbObject.getDisplayName() + "'.", th);
		}
	}

	@Override
	public void clickAndHold(int numRetries) {
		try {
			Match match = findElement(numRetries);
			match.mouseDown(Button.LEFT);
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse clickAndHold on CheckBox '" + cbObject.getDisplayName() + "'.", th);
		}
	}

	@Override
	public void release(int numRetries) {
		try {
			Match match = findElement(numRetries);
			match.mouseDown(Button.LEFT);
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse clickAndHold on CheckBox '" + cbObject.getDisplayName() + "'.", th);
		}
	}

	@Override
	public void performKeyDown(Keys keys, int numRetries) {
		try {
			Match match = findElement(numRetries);
			match.click();
			match.keyDown(seleniumToSikuliKeyConverter(keys));
		} catch (Throwable th) {
			Assert.fail("Failed to perform keyDown on CheckBox '" + cbObject.getDisplayName() + "'.", th);
		}

	}

	@Override
	public void performKeyUp(Keys keys, int numRetries) {
		try {
			Match match = findElement(numRetries);
			match.click();
			match.keyUp(seleniumToSikuliKeyConverter(keys));
		} catch (Throwable th) {
			Assert.fail("Failed to perform keyUp ('" + seleniumToSikuliKeyConverter(keys) + "') on CheckBox '" + cbObject.getDisplayName() + "'.", th);
		}
	}

	@Override
	public void performKeyPressed(Keys keys, int numRetries) {
		try {
			Match match = findElement(numRetries);
			match.click();
			match.keyDown(seleniumToSikuliKeyConverter(keys));
			match.keyUp(seleniumToSikuliKeyConverter(keys));
		} catch (Throwable th) {
			Assert.fail("Failed to perform keyPressed ('" + seleniumToSikuliKeyConverter(keys) + "') on CheckBox '" + cbObject.getDisplayName() + "'.", th);
		}
	}

	@Override
	@Deprecated
	public void typeText(String text, NewTextLocation location, int numRetries) {
		Assert.fail("typeText() API is not supported for CheckBox element."); 

	}

	@Override
	public CheckBoxValidatorSI scrollElementOnViewport(Scrollbar scrollbar) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Match findElement(int numRetries) {
		Match match = null;
		for (int i = 0; i <= numRetries; i++) {
			try {
				Region region = cbObject.getCheckBoxImageLocation().getRegionOfImageObject(browser,
						cbObject.getCheckBoxImage());
				Assert.assertNotNull(region, "Failed to find CheckBox '" + cbObject.getDisplayName() + "'.");
				match = new Match(region, 1);
				break;
			} catch (Throwable th) {
				if (i == numRetries) {
					Assert.fail("Unable to find CheckBox '" + cbObject.getDisplayName() + "'. Reason timeout(waited for "
							+ (numRetries * 2) + " seconds).", th);
					break;
				}
			}
			browser.waitForSeconds(2);
		}
		return match;
	}

	@Override
	public Match findElementNoException(int numRetries) {
		Match match = null;
		try {
			match = findElement(numRetries);
		} catch (Throwable th) {
			// Do nothing
		}
		return match;
	}

	@Override
	public List<Match> findElements(int numRetries) {
		Region r = cbObject.getCheckBoxImageLocation().getRegion(browser);

		return new ImageObject(UIObjectType.checkBox, cbObject.getDisplayName(), cbObject.getCheckBoxImage())
				.getValidator(browser, r).findElements(numRetries);
	}
	
	public void dragAndDrop(ImageObject target, Region targetRegion, int numRetries) {
		try {
			Match sourceElem = findElement(numRetries);
			Match targetElem = target.getValidator(browser, targetRegion).findElement(numRetries);

			Assert.assertNotNull(sourceElem, "Failed to find CheckBox '" + cbObject.getDisplayName() + "'.");
			Assert.assertNotNull(targetElem, "Failed to find element '" + target.getDisplayName() + "'.");
			
			sourceElem.drag(targetElem);
			sourceElem.dropAt(targetElem);
		} catch (Throwable th) {
			Assert.fail("Failed to perform dragAndDrop from source '" + cbObject.getDisplayName() + "' to target '"
					+ target.getDisplayName() + "'.", th);
		}
	}
	
	protected Location getImageSection(Match imageMatch, ImageSection imageSection) {
		switch(imageSection) {
		case topLeft:
			return imageMatch.getTopLeft();
		case topRight:
			return imageMatch.getTopRight();
		case bottomLeft:
			return imageMatch.getBottomLeft();
		case bottomRight:
			return imageMatch.getBottomRight();
		case center:
			return imageMatch.getCenter();
		}
		return null;
	}

	@Override
	@Deprecated
	public boolean isCheckBoxChecked(int numRetries) {
		Assert.fail("isCheckBoxChecked() is not supported for image components.");
		return false;
	}

	@Override
	@Deprecated
	public void validateCheckBoxChecked(int numRetries) {
		Assert.fail("validateCheckBoxChecked() is not supported for CheckBox component.");
	}

	@Override
	@Deprecated
	public void validateCheckBoxUnchecked(int numRetries) {
		Assert.fail("validateCheckBoxUnchecked() is not supported for CheckBox component.");
	}

	@Override
	@Deprecated
	public void checkAndValidateChecked(int numRetries) {
		Assert.fail("checkAndValidateChecked() is not supported for CheckBox component.");
	}

	@Override
	@Deprecated
	public void uncheckAndValidateUnchecked(int numRetries) {
		Assert.fail("uncheckAndValidateUnchecked() is not supported for CheckBox component.");
	}

}
