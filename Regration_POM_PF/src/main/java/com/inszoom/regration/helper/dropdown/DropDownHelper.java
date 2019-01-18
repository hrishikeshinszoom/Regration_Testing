package com.inszoom.regration.helper.dropdown;

import java.util.LinkedList;
import java.util.List;

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
	private static final Logger oLog = LoggerHelper.getLogger(DropDownHelper.class);

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("DropDownHelper : " + this.driver.hashCode());
	}

	public void SelectUsingVisibleValue(WebElement element, String visibleValue) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
		oLog.info("Locator : " + element + " Value : " + visibleValue);
	}

	public String getSelectedValue(WebElement element) {
		String value = new Select(element).getFirstSelectedOption().getText();
		oLog.info("WebElment :" + element + " value " + value);
		return value;
	}

	public void selectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		oLog.info("locator: " + element + "value:" + index);
	}

	public void selectUsingVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		oLog.info("locator: " + element + "value:" + text);
	}

	public LinkedList<String> getAllDropDownList(WebElement locator) {
		Select select = new Select(locator);
		List<WebElement> elementList = select.getOptions();
		LinkedList<String> valueList = new LinkedList<String>();

		for (WebElement element : elementList) {
			oLog.info(element.getText());
			valueList.add(element.getText());
		}
		return valueList;
	}
}
