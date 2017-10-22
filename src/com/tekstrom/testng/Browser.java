package com.tekstrom.testng;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {
	public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
		return new RemoteWebDriver(new URL("http://10.0.0.2:4444/wd/hub"),getBrowserCapabilities(browser));
	
	}

	private static Capabilities getBrowserCapabilities(String browser) {
		// TODO Auto-generated method stub
		switch (browser) {
        case "firefox":
            System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
            System.out.println("Opening firefox driver");


            return DesiredCapabilities.firefox();
        case "chrome":
        	System.setProperty("webdriver.chromedriver", "/usr/local/bin/chromedriver");
            System.out.println("Opening chrome driver");
            return DesiredCapabilities.chrome();
        default:
            System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
            return DesiredCapabilities.firefox();
    }
	}
}
