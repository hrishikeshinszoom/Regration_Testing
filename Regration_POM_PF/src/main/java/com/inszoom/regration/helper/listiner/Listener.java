package com.inszoom.regration.helper.listiner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.inszoom.regration.helper.logger.LoggerHelper;

public class Listener implements ITestListener {

	private Logger olog = LoggerHelper.getLogger(Listener.class);

	public void onTestStart(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + "Test started...");
		olog.info(result.getMethod().getMethodName() + "Test started...");
	}

	public void onTestSuccess(ITestResult result) {

		Reporter.log(result.getMethod().getMethodName() + "Test Successed...");
		olog.info(result.getMethod().getMethodName() + "Test Successed...");
	}

	@SuppressWarnings("unused")
	public void onTestFailure(ITestResult result) {

		if (!result.isSuccess()) {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

			String methodName = result.getName();

			// File scrFile = ((TakesScreenshot)
			// driver).getScreenshotAs(OutputType.FILE);
			File destFile;
			// try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/test_reports/";
			destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_"
					+ formater.format(calendar.getTime()) + ".png");

			// FileUtils.copyFile(scrFile, destFile);
			// } catch (IOException e) {

			// e.printStackTrace();
			// }
		}

		Reporter.log(result.getMethod().getMethodName() + "Test Failed...");
		olog.info(result.getMethod().getMethodName() + "Test Failed...");

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
