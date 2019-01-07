package com.inszoom.regration.helper.logger;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import com.inszoom.regration.utils.ResourceHelper;

/**
 * @author hrishikesh basak
 */
@SuppressWarnings("rawtypes")
public class LoggerHelper {

	private static boolean root = false;

	public static Logger getLogger(Class clas) {
		if (root) {
			return Logger.getLogger(clas);
		}
		// String log4jLOcation =
		// System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
		PropertyConfigurator
				.configure(ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
	}
}