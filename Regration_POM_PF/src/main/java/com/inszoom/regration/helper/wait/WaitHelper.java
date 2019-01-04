package com.inszoom.regration.helper.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WaitHelper {

	private WebDriver driver;

	public void setImplicitWait(long timeout, TimeUnit unit) {

		driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}

}
