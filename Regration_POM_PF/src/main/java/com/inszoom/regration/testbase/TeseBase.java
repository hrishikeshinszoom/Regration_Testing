package com.inszoom.regration.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class TeseBase {

	public WebDriver driver;
	public static Properties OR;
	public File f1;
	public FileInputStream file;

	public void loadPropertiesFile() throws IOException {

		OR = new Properties();
		f1 = new File(".//src//main//java//com//inszoom//regration//config//config.properties");
		file = new FileInputStream(f1);
		OR.load(file);

	}

	@BeforeTest
	// before test (load configuration file, launch browser,)
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
				// https://github.com/mozilla/geckodriver/releases
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", ".//drivers/chromedriver.exe");

				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("chrome")) {
				// https://chromedriver.storage.googleapis.com/index.html
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
