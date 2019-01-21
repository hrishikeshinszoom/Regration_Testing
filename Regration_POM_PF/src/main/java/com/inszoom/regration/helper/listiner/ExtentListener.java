/**
 * 
 */
package com.inszoom.regration.helper.listiner;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.inszoom.regration.helper.logger.LoggerHelper;

/**
 * @author insind5006
 *
 */
public class ExtentListener implements ITestListener {

	private Logger olog = LoggerHelper.getLogger(ExtentListener.class);

	public void onTestStart(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + "Test started...");
		olog.info(result.getMethod().getMethodName() + "Test started...");
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + "Test passed...");
		olog.info(result.getMethod().getMethodName() + "Test passed...");
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + "Test failed..." + result.getThrowable());
		olog.info(result.getMethod().getMethodName() + "Test failed..." + result.getThrowable());
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
