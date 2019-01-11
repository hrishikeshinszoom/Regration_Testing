package com.inszoom.regration.helper.listiner;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.inszoom.regration.helper.logger.LoggerHelper;

public class ListinerHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(ListinerHelper.class);

	public ListinerHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("ListinerHelper : " + this.driver.hashCode());
	}
}
