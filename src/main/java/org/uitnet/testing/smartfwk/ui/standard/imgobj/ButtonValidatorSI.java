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
package org.uitnet.testing.smartfwk.ui.standard.imgobj;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.testng.Assert;
import org.uitnet.testing.smartfwk.ui.core.appdriver.SmartAppDriver;
import org.uitnet.testing.smartfwk.ui.core.commons.AreaCoordinates;
import org.uitnet.testing.smartfwk.ui.core.commons.ImageSection;
import org.uitnet.testing.smartfwk.ui.core.commons.UIObjectType;
import org.uitnet.testing.smartfwk.ui.core.objects.ImageObject;
import org.uitnet.testing.smartfwk.ui.core.objects.NewTextLocation;
import org.uitnet.testing.smartfwk.ui.core.objects.button.ButtonValidator;
import org.uitnet.testing.smartfwk.ui.core.objects.validator.mechanisms.TextMatchMechanism;
import org.uitnet.testing.smartfwk.ui.standard.imgobj.scrollbar.ScrollbarSI;

/**
 * 
 * @author Madhav Krishna
 *
 */
public class ButtonValidatorSI extends ButtonValidator {
	protected ButtonSI buttonObj;

	public ButtonValidatorSI(SmartAppDriver appDriver, ButtonSI uiObject, Region region) {
		super(appDriver, uiObject, region);
		this.buttonObj = uiObject;
	}

	@Override
	public ButtonValidatorSI validateName(String expectedName, TextMatchMechanism validationMechanism,
			int maxIterationsToLocateElements) {
		Match match = findElement(maxIterationsToLocateElements);
		validateTextValue(match.text(), expectedName, validationMechanism);
		return this;
	}

	@Override
	@Deprecated
	public ButtonValidatorSI validateDisabled(int maxIterationsToLocateElements) {
		Assert.fail("validateDisabled() API is not supported by ButtonSI.");
		return this;
	}

	@Override
	@Deprecated
	public ButtonValidatorSI validateEnabled(int maxIterationsToLocateElements) {
		Assert.fail("validateEnabled() API is not supported by ButtonSI.");
		return this;
	}

	@Override
	public boolean isPresent(int maxIterationsToLocateElements) {
		Match m = findElementNoException(maxIterationsToLocateElements);
		return (m != null);
	}
	
	@Override
	public boolean isNotPresent(int maxIterationsToLocateElements) {
		Match m = findElementNoException(maxIterationsToLocateElements);
		return (m == null);
	}

	@Override
	public boolean isVisible(int maxIterationsToLocateElements) {
		return isPresent(maxIterationsToLocateElements);
	}

	@Override
	public boolean isHidden(int maxIterationsToLocateElements) {
		return isHidden(maxIterationsToLocateElements);
	}

	@Override
	public ButtonValidatorSI click(int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			match.click();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse click on Button '" + buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}
	
	@Override
	public ButtonValidatorSI forceClick(int maxIterationsToLocateElements) {
		return click(maxIterationsToLocateElements);
	}
	
	public ButtonValidatorSI click(ImageSection imageSection, int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			getImageSection(match, imageSection).click();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse click on Button '" + buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}

	@Override
	public ButtonValidatorSI doubleClick(int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			match.doubleClick();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse double click on Button '" + buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}

	public ButtonValidatorSI doubleClick(ImageSection imageSection, int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			getImageSection(match, imageSection).doubleClick();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse double click on Button '" + buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}

	@Override
	public ButtonValidatorSI rightClick(int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			match.rightClick();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse right click on Button '" + buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}

	public ButtonValidatorSI rightClick(ImageSection imageSection, int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			getImageSection(match, imageSection).rightClick();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse right click on Button '" + buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}

	@Override
	public ButtonValidatorSI clickAndHold(int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			match.mouseDown(Button.LEFT);
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse clickAndHold on Button '" + buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}

	@Override
	public ButtonValidatorSI release(int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			match.mouseDown(Button.LEFT);
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse clickAndHold on Button '" + buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}
	
	@Override
	public ButtonValidatorSI mouseHoverOver(int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			match.mouseMove();
		} catch (Throwable th) {
			Assert.fail("Failed to perform mouse hoverover on Button '" + buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}

	@Override
	public ButtonValidatorSI performKeyDown(Keys keys, int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			match.click();
			match.keyDown(seleniumToSikuliKeyConverter(keys));
		} catch (Throwable th) {
			Assert.fail("Failed to perform keyDown on Button '" + buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}

	@Override
	public ButtonValidatorSI performKeyUp(Keys keys, int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			match.click();
			match.keyUp(seleniumToSikuliKeyConverter(keys));
		} catch (Throwable th) {
			Assert.fail("Failed to perform keyUp ('" + seleniumToSikuliKeyConverter(keys) + "') on Button '"
					+ buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}

	@Override
	public ButtonValidatorSI performKeyPressed(Keys keys, int maxIterationsToLocateElements) {
		try {
			Match match = findElement(maxIterationsToLocateElements);
			match.click();
			match.keyDown(seleniumToSikuliKeyConverter(keys));
			match.keyUp(seleniumToSikuliKeyConverter(keys));
		} catch (Throwable th) {
			Assert.fail("Failed to perform keyPressed ('" + seleniumToSikuliKeyConverter(keys) + "') on Button '"
					+ buttonObj.getDisplayName() + "'.", th);
		}
		return this;
	}

	@Override
	@Deprecated
	public ButtonValidatorSI typeText(String text, NewTextLocation location, int maxIterationsToLocateElements) {
		Assert.fail("typeText() API is not supported for Button element.");
		return this;
	}

	@Override
	public ButtonValidatorSI scrollElementOnViewport(ScrollbarSI scrollbar) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Match findElement(int maxIterationsToLocateElements) {
		Match match = null;
		for (int i = 0; i <= maxIterationsToLocateElements; i++) {
			try {
				Region region = buttonObj.getButtonImageLocation().getRegionOfImageObject(appDriver,
						buttonObj.getButtonImage(appDriver.getAppConfig().getTestPlatformType(),
								appDriver.getAppConfig().getAppType(), appDriver.getAppConfig().getAppWebBrowser()));
				Assert.assertNotNull(region, "Failed to find Button '" + buttonObj.getDisplayName() + "'.");
				match = new Match(region, 1);
				break;
			} catch (Throwable th) {
				if (i == maxIterationsToLocateElements) {
					Assert.fail("Unable to find Button '" + buttonObj.getDisplayName() + "'. Reason timeout(waited for "
							+ (maxIterationsToLocateElements * 2) + " seconds).", th);
					break;
				}
			}
			appDriver.waitForSeconds(2);
		}
		return match;
	}

	@Override
	public Match findElementNoException(int maxIterationsToLocateElements) {
		Match match = null;
		try {
			match = findElement(maxIterationsToLocateElements);
		} catch (Throwable th) {
			// Do nothing
		}
		return match;
	}

	@Override
	public List<Match> findElements(int maxIterationsToLocateElements) {
		Region r = buttonObj.getButtonImageLocation().getRegion(appDriver);

		return new ImageObject(UIObjectType.button, buttonObj.getDisplayName(),
				buttonObj.getButtonImage(appDriver.getAppConfig().getTestPlatformType(),
						appDriver.getAppConfig().getAppType(), appDriver.getAppConfig().getAppWebBrowser()))
								.getValidator(appDriver, r).findElements(maxIterationsToLocateElements);
	}

	public ButtonValidatorSI dragAndDrop(ImageObject target, Region targetRegion, int maxIterationsToLocateElements) {
		try {
			Match sourceElem = findElement(maxIterationsToLocateElements);
			Match targetElem = target.getValidator(appDriver, targetRegion).findElement(maxIterationsToLocateElements);

			Assert.assertNotNull(sourceElem, "Failed to find Button '" + buttonObj.getDisplayName() + "'.");
			Assert.assertNotNull(targetElem, "Failed to find element '" + target.getDisplayName() + "'.");

			sourceElem.drag(targetElem);
			sourceElem.dropAt(targetElem);
		} catch (Throwable th) {
			Assert.fail("Failed to perform dragAndDrop from source '" + buttonObj.getDisplayName() + "' to target '"
					+ target.getDisplayName() + "'.", th);
		}
		return this;
	}

	protected Location getImageSection(Match imageMatch, ImageSection imageSection) {
		switch (imageSection) {
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
	public boolean isDisabled(int maxIterationsToLocateElements) {
		Assert.fail("isDisabled() API is not supported by Button component.");
		return false;
	}
	
	@Override
	@Deprecated
	public boolean isEnabled(int maxIterationsToLocateElements) {
		Assert.fail("isEnabled() API is not supported by Button component.");
		return false;
	}

	@Override
	@Deprecated
	public Actions getNewSeleniumActions() {
		Assert.fail("getNewSeleniumActions() API is not supported by Button component.");
		return null;
	}

	@Override
	public ButtonValidatorSI validateElementPresentWithinArea(AreaCoordinates coordinates,
			int maxIterationsToLocateElements) {
		Match match = findElement(maxIterationsToLocateElements);
		if(!(match.x >= coordinates.getX1() && match.y >= coordinates.getY1() &&  
				(match.x + match.w) <= coordinates.getX2() && (match.y + match.h) <= coordinates.getY2())) {
			Assert.fail("Element '" + buttonObj.getDisplayName() + "' is not within the specified area [x1=" + coordinates.getX1() 
			+ ", y1=" + coordinates.getY1() + ", x2=" + coordinates.getX2() + ", y2=" + coordinates.getY2() + "]."
			+ " Actual Coordinates: [x1=" + match.x + ", y1=" + match.y + ", x2=" + (match.x  + match.w) 
			+ ", y2=" + (match.y + match.h) + "].");
		}
		return this;
	}

}
