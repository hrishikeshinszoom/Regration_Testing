package com.inszoom.regration.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.inszoom.regration.utility.ResourceHelper;

public class ChromeBrowser {

	public ChromeOptions getChromeOptions() {

		ChromeOptions option = new ChromeOptions();

		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");

		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);

		option.setCapability(ChromeOptions.CAPABILITY, chrome);

		if (System.getProperty("os.name").contains("Linux")) {
			option.addArguments("--headless", "window-size = 1024,768", "--no-sandbox");
		}

		return option;
	}

	public WebDriver getChromeDriver(ChromeOptions cap) {

		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath(""));
			return new ChromeDriver(cap);
		}

		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath(""));
			return new ChromeDriver(cap);
		}
		return null;
	}
	
	public static void main(String[] args) {
		ChromeBrowser obj = new ChromeBrowser();
		WebDriver driver = obj.getChromeDriver(obj.getChromeOptions());
		driver.get("https://ent64qafqk.guisystems.com/");
	}
}