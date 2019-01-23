package com.inszoom.regration.helper.listiner;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.inszoom.regration.helper.logger.LoggerHelper;

public class Retry implements IRetryAnalyzer {
	public int retryCount = 0;
	public int maxRetryCount = 3;

	private Logger olog = LoggerHelper.getLogger(Retry.class);

	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			olog.info("retrying test: " + result.getName() + "with status " + getResultStatusName(result.getStatus()) + "for the " + (retryCount + 1) + "times. ");
			retryCount++;
			return true;
		}
		return false;
	}

	public String getResultStatusName(int Status) {
		String resultName = null;
		if (Status == 1) {
			resultName = "SUCCESS";
		}

		if (Status == 2) {
			resultName = "FALIURE";
		}

		if (Status == 3) {
			resultName = "SKIP";
		}

		return resultName;
	}

	public void log(String data) {
		olog.info(data);
		Reporter.log(data);
	}
}
