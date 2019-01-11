package com.inszoom.regration.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.inszoom.regration.helper.logger.LoggerHelper;

public class AssertionHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(AssertionHelper.class);

	public AssertionHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("AssertionHelper : " + this.driver.hashCode());
	}

}
