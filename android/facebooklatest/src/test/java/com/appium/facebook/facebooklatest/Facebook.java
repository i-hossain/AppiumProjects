package com.appium.facebook.facebooklatest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Facebook {
	
	@Test
	public void Login() throws InterruptedException, IOException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("deviceName", "CL-Galaxy S6");
		capabilities.setCapability("app","/Users/ismail/Guild/AppiumTutorial(Udemy)/com.facebook.katana_v110.0.0.15.69-49078465_Android-4.0.3.apk");
		capabilities.setCapability("appPackage", "com.facebook.katana");
		capabilities.setCapability("appActivity", "LoginActivity");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		login(driver);
		
		postStatus(driver);
		
		deleteStatus(driver);		
		
		logout(driver);


	}
	public void login(AndroidDriver driver) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("/Users/ismail/Documents/workspace/facebooklatest/credentials.config"));
		String username = br.readLine();
		String password = br.readLine();
		
		WebElement loginUsername = driver.findElementById("com.facebook.katana:id/login_username");
		loginUsername.sendKeys(username);
		
		WebElement loginPassword = driver.findElementById("com.facebook.katana:id/login_password");
		loginPassword.click();
		loginPassword.sendKeys(password);
		
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.facebook.katana:id/login_login\")").click();
		
	}
	
	public void postStatus(AndroidDriver driver) {
		
		WebElement status = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Status\")");
		status.click();
		
		WebElement statusBox = driver.findElementById("com.facebook.katana:id/composer_status_text");
		statusBox.click();
		statusBox.sendKeys("Appium Test on Android!");
		
		WebElement post = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"POST\")");
		post.click();
		
	}
	
	public void deleteStatus(AndroidDriver driver) throws InterruptedException {
		
		// TODO: Wait until element is clickable
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Story Menu\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Delete\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Delete\")").click();
		
	}
	
	public void logout(AndroidDriver driver) throws InterruptedException {
		
		driver.findElementById("com.facebook.katana:id/bookmarks_tab").click();
		// TODO: Clean scrolling
		
		TouchAction scroll = new TouchAction(driver);
		Thread.sleep(5000);
		scroll.press((WebElement) driver.findElements(By.className("com.facebook.fbui.widget.contentview.ContentView")).get(8)).moveTo((WebElement) driver.findElements(By.className("com.facebook.fbui.widget.contentview.ContentView")).get(0)).release().perform();
		scroll.press((WebElement) driver.findElements(By.className("com.facebook.fbui.widget.contentview.ContentView")).get(8)).moveTo((WebElement) driver.findElements(By.className("com.facebook.fbui.widget.contentview.ContentView")).get(0)).release().perform();
		scroll.press((WebElement) driver.findElements(By.className("com.facebook.fbui.widget.contentview.ContentView")).get(8)).moveTo((WebElement) driver.findElements(By.className("com.facebook.fbui.widget.contentview.ContentView")).get(0)).release().perform();
		scroll.press((WebElement) driver.findElements(By.className("com.facebook.fbui.widget.contentview.ContentView")).get(8)).moveTo((WebElement) driver.findElements(By.className("com.facebook.fbui.widget.contentview.ContentView")).get(0)).release().perform();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Log Out\")").click();
		
//		driver.performTouchAction(scrollDown);
		
	}
	
}
