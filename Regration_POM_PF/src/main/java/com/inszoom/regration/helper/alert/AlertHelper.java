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

	public boolean isAlertPresent() {

		try {
			getAlert();
			return true;
		} catch (Exception e) {
			System.out.println("No alert present");
		}
		return false;
	}

	public void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		acceptAlert();

	}

	public void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		dismissAlert();

	}

}
