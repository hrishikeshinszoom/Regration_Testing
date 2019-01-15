/**
 * 
 */
package com.inszoom.regration.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.inszoom.regration.helper.logger.LoggerHelper;

/**
 * @author insind5006
 *
 */
public class FrameHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(FrameHelper.class);

	public FrameHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("SwitchHelper : " + this.driver.hashCode());
	}
	
	/**
	 * this method will switch to frame based on frame Index
	 * @param frameIndex
	 */
	public void switchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
		oLog.info("switched to: " + frameIndex + "frame");
	}
	
	/**
	 * this method will switch to frame based on frame Name
	 * @param frameIndex
	 */
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
		oLog.info("switched to:" + frameName + "");
	}
	
	/**
	 * this method will switch to frame based on frame webelement
	 * @param frameIndex
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		oLog.info("switched to:" + element.toString());
	}
}
