package com.inszoom.regration.helper.browserConfiguration.config;

import com.inszoom.regration.helper.browserConfiguration.BrowserType;

public interface ConfigReader {

	public int implicitwait();

	public int explicitwait();

	public int pageLoagTime();

	public BrowserType getbrowserType();

}
