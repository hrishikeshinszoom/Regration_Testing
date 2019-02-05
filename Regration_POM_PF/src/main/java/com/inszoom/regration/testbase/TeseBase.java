package com.inszoom.regration.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.inszoom.regration.helper.browserConfiguration.BrowserType;
import com.inszoom.regration.helper.browserConfiguration.ChromeBrowser;
import com.inszoom.regration.helper.browserConfiguration.config.ObjectReader;
import com.inszoom.regration.helper.browserConfiguration.config.PropertyReader;
import com.inszoom.regration.helper.logger.LoggerHelper;
import com.inszoom.regration.helper.wait.WaitHelper;
import com.inszoom.regration.utility.ExtentManager;

public class TeseBase {

	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(TeseBase.class);

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.getInstance();
	}

	@BeforeTest
	public void beforeTest() {
		ObjectReader.reader = new PropertyReader();
		
	}
	
	
	/*
	 * @BeforeMethod public void beforeMethod(Method method) {
	 * test.log(Status.INFO, method.getName() + " test started");
	 * oLog.info("**************"+method.getName()+"Started***************"); }
	 */

	/*
	 * @AfterMethod public void afterMethod(ITestResult result) { if
	 * (result.getStatus() == ITestResult.FAILURE) { test.log(Status.FAIL,
	 * result.getThrowable()); } else if (result.getStatus() ==
	 * ITestResult.SUCCESS) { test.log(Status.PASS, result.getName() +
	 * "test passed"); } else if (result.getStatus() == ITestResult.SKIP) {
	 * test.log(Status.SKIP, result.getThrowable() + "test skipped"); }
	 * oLog.info("**************"+result.getName()+"Finished***************");
	 * extent.flush(); }
	 */

	public WebDriver getBrowserObject(BrowserType btype) throws Exception {

		try {
			switch (btype) {
			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);

			default:
				throw new Exception("Driver not found: " + btype.name());
			}
		} catch (Exception e) {
			oLog.info(e.getMessage());
			throw e;
		}
	}

	public void setUpDriver(BrowserType btype) throws Exception {
		driver = getBrowserObject(btype);
		oLog.info("initialize wedriver:" + driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.implicitwait(), TimeUnit.SECONDS);
		wait.setPageLoadTimeout(ObjectReader.reader.pageLoagTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

}
