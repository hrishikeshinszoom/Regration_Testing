package com.inszoom.regration.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.inszoom.regration.helper.browserConfiguration.BrowserType;
import com.inszoom.regration.utility.ResourceHelper;

public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties OR;
	
	public PropertyReader() {
		String filepath = ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\config.properties");
		try {
			file = new FileInputStream(new File(filepath));
			OR = new Properties();
			OR.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int implicitwait() {
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int explicitwait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int pageLoagTime() {
		return Integer.parseInt(OR.getProperty("pageLoagTime"));
	}

	public BrowserType getbrowserType() {
		return BrowserType.valueOf(OR.getProperty("browserType"));

	}

}
