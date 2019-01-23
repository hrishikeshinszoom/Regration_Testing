package com.inszoom.regration.helper.logger;

import org.apache.log4j.PropertyConfigurator;

import com.inszoom.regration.utility.ResourceHelper;

import org.apache.log4j.Logger;

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
		
		PropertyConfigurator
				.configure(ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
	}
}
