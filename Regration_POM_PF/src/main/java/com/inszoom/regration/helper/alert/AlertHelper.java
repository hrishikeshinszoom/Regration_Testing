package com.inszoom.regration.helper.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {

	private WebDriver driver;

	public AlertHelper(WebDriver driver) {
		this.driver = driver;

	}

	public Alert getAlert() {
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		getAlert().accept();
	}

	public void dismissAlert() {
		getAlert().dismiss();
	}
	
	public String setAlertText() {
		String text = getAlert().getText();
		return text;
	}
	
	public void isAlertPresent() {
		
	}
}	

