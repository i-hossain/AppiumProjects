package com.appium.mobile.androidBuiltinApps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Alarm {
	
	@Test
	public void testAlarm() throws MalformedURLException {
		
DesiredCapabilities capabilities = new DesiredCapabilities();
		
		// Device Details
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("deviceName", "CL Galaxy S6");
		
		// Phone App
		capabilities.setCapability("appPackage", "com.sec.android.app.clockpackage");
		capabilities.setCapability("appActivity", "ClockPackage");

		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		new TouchAction(driver).longPress((WebElement) driver.findElementsByClassName("android.widget.NumberPicker").get(0)).release().perform();
		
	}

}
