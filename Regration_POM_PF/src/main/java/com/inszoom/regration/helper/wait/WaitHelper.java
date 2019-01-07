package com.inszoom.regration.helper.wait;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.inszoom.regration.helper.logger.LoggerHelper;

public class WaitHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("AlertHelper : " + this.driver.hashCode());
	}

	public void setImplicitWait(long timeout, TimeUnit unit) {

		driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}

}
