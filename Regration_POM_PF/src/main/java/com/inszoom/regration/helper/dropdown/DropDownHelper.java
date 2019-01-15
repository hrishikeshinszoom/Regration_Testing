package com.inszoom.regration.helper.dropdown;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.inszoom.regration.helper.logger.LoggerHelper;

/**
 * @author insind5006
 * 
 */
public class DropDownHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(DropDownHelper.class);

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("DropDownHelper : " + this.driver.hashCode());
	}

	public void SelectUsingVisibleValue(WebElement element, String visibleValue) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
		oLog.info("Locator : " + element + " Value : " + visibleValue);
	}

}
