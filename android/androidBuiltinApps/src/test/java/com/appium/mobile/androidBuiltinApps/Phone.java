package com.appium.mobile.androidBuiltinApps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Phone {
	
	@Test
	public void testDialNumber() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		// Device Details
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("deviceName", "CL Galaxy S6");
		
		// Phone App
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", "DialtactsActivity");

		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Extract Phone Number
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a phone number to dial:");
		long phoneNumber = input.nextLong();
		
		// Split phone number into separate digits
		LinkedList<Long> stack = new LinkedList<Long>();
		while (phoneNumber > 0) {
			
			stack.push(phoneNumber % 10);
			phoneNumber/=10;	
			
		}
		
		while (!stack.isEmpty()) {
			
			String digit = Long.toString(stack.pop());
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+digit+"\")").click();
			
		}
		
		driver.findElementById("com.android.contacts:id/dialButton").click();
		
	}

}
