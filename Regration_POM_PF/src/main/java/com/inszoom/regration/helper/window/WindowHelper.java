package com.inszoom.regration.helper.window;

import java.util.LinkedList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.inszoom.regration.helper.logger.LoggerHelper;

public class WindowHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(WindowHelper.class);

	public WindowHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("WindowHelper : " + this.driver.hashCode());
	}

	public void goBack() {
		driver.navigate().back();
		oLog.info("clicking on back button");
	}

	public void forward() {
		driver.navigate().forward();
		oLog.info("clicking on forward button");
	}

	public void refresh() {
		driver.navigate().refresh();
		oLog.info("clicking on refresh button");
	}

	public Set<String> windowHandles() {
		return driver.getWindowHandles();
	}

	public void switchToWindow(int index) {
		LinkedList<String> windowsID = new LinkedList<String>(windowHandles());
		if (index < 0 || index > windowsID.size()) {
		}
		driver.switchTo().window(windowsID.get(index));
		oLog.info("switching To window based on index");
	}

	public void switchToParentWindow() {
		// LinkedList<String> windowsID = new LinkedList<String>(windowHandles());
		// driver.switchTo().window(windowsID.get(0));
		driver.switchTo().defaultContent();
		oLog.info("switching To Parent Window");
	}

	public void switchToParentCloseChildWindow() {
		// LinkedList<String> windowsID = new LinkedList<String>(windowHandles());
		//
		// for (int i = 1; i <= windowsID.size(); i++) {
		// driver.switchTo().window(windowsID.get(i));
		// driver.close();
		// }

		Set<String> windows = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();
		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainWindow)) {
				driver.close();
			}
		}
		switchToParentWindow();
		oLog.info("switching To Parent Window and closing all child windows");
	}

	public void switchToFrame(String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}

}
