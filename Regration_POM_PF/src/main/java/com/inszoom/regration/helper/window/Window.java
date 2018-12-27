package com.inszoom.regration.helper.window;

import java.util.LinkedList;
import java.util.Set;

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

	public Set<String> windowHandles() {
		return driver.getWindowHandles();
	}

	public void switchToWindow(int index) {
		LinkedList<String> windowsID = new LinkedList<String>(windowHandles());
		if (index < 0 || index > windowsID.size()) {
		}
		driver.switchTo().window(windowsID.get(index));
	}

	public void switchToParentCloseChildWindow() {
		
	}

}
