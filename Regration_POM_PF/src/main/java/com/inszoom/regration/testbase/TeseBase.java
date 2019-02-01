package com.inszoom.regration.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.inszoom.regration.utility.ExtentManager;

import net.bytebuddy.jar.asm.commons.Method;

public class TeseBase {

	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	public static Properties OR;
	public File f1;
	public FileInputStream file;

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.getInstance();
	}

	@AfterSuite
	public void afterClass() {
		test = extent.createTest(getClass().getName());
	}

	@BeforeMethod
	public void afterMethod(Method method) {
		test.log(Status.INFO, method.getName() + " test started");
	}

	@AfterMethod
	public void beforeMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getTestName() + "test passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable() + "test skipped");
		}

	}

	public void loadPropertiesFile() throws IOException {

		OR = new Properties();
		f1 = new File(".//src//main//java//com//inszoom//regration//config//config.properties");
		file = new FileInputStream(f1);
		OR.load(file);

	}

	@BeforeTest
	public void BeforeTest_LaunchBrowser(String browser, String url) {
		try {
			loadPropertiesFile();
		} catch (Exception e) {
			System.out.println(e);
		}
		openBrowser(browser);
		getUrl(url);

	}

	public void openBrowser(String browser) {

		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equalsIgnoreCase("firefox")) {

				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", ".//drivers/chromedriver.exe");

				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");

				driver = new ChromeDriver();
			}
		} else if (System.getProperty("os.name").contains("Mac")) {
			System.out.println(System.getProperty("os.name"));
			if (browser.equalsIgnoreCase("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", ".//drivers/chromedriver.exe");

				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");

				driver = new ChromeDriver();
			}

		}
	}

	public void getUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();

	}

	public static void main(String[] args) throws Exception {
		TeseBase test = new TeseBase();
		test.loadPropertiesFile();

	}
}
