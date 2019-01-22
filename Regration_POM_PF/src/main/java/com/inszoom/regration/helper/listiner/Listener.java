/**
 * 
 */
package com.inszoom.regration.helper.listiner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.inszoom.regration.helper.logger.LoggerHelper;
import com.inszoom.regration.testbase.TeseBase;

/**
 * @author insind5006
 *
 */
public class Listener extends TeseBase implements ITestListener {

	private Logger olog = LoggerHelper.getLogger(Listener.class);

	public void onTestStart(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + "Test started...");
		olog.info(result.getMethod().getMethodName() + "Test started...");
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + "Test passed...");
		olog.info(result.getMethod().getMethodName() + "Test passed...");
	}

	public void onTestFailure(ITestResult result) {

		if (!result.isSuccess()) {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

			String methodName = result.getName();

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile;
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "";
				destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_"
						+ formater.format(calendar.getTime()) + ".png");

				FileUtils.copyFile(scrFile, destFile);
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + "Test skipped..." + result.getThrowable());
		olog.info(result.getMethod().getMethodName() + "Test skipped..." + result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		Reporter.log(context.getCurrentXmlTest().getName() + "Class Started...");
		olog.info(context.getCurrentXmlTest().getName() + "Class Started....");
	}

	public void onFinish(ITestContext context) {
		Reporter.log(context.getName() + "Test finished...");
		olog.info(context.getName() + "Test finished....");

	}

}
