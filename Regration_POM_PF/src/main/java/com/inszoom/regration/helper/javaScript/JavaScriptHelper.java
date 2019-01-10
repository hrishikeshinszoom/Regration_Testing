package com.inszoom.regration.helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.inszoom.regration.helper.logger.LoggerHelper;

public class JavaScriptHelper {
	
	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(JavaScriptHelper.class);

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("JavaScriptHelper : " + this.driver.hashCode());
	}
}
