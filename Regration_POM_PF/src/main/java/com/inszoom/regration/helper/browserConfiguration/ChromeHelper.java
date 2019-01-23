package com.inszoom.regration.helper.browserConfiguration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeHelper {

	public ChromeOptions getChromeOptions() {

		ChromeOptions option = new ChromeOptions();

		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");

		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		
		
		
		return null;

	}
}
