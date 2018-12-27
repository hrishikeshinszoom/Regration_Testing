package com.inszoom.regration.helper.window;

import org.openqa.selenium.WebDriver;

public class Window {

	private WebDriver driver;

	public Window(WebDriver driver) {
		this.driver = driver;
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void forward() {
		driver.navigate().forward();
	}

	public void refresh() {
		driver.navigate().refresh();
	}
	
	
}
