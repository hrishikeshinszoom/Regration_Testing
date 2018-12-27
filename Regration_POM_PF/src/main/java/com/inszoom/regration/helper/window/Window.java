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

	public void switchToParentWindow() {
		LinkedList<String> windowsID = new LinkedList<String>(windowHandles());
		driver.switchTo().window(windowsID.get(0));
	}

	public void switchToParentCloseChildWindow() {
		LinkedList<String> windowsID = new LinkedList<String>(windowHandles());

		for (int i = 1; i <= windowsID.size(); i++) {
			driver.switchTo().window(windowsID.get(i));
			driver.close();
		}
		switchToParentWindow();
	}

	public void switchToFrame(String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}

}
