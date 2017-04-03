package com.appium.safari;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class iosSafariDevice {
	
	@Test
	public void main() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3.2");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "CL-IDP2500");
		capabilities.setCapability("udid", "55ced2ce7327ebd44adfb6e4f5aa5f8e8e5f3e04");
//		capabilities.setCapability("xcodeOrgId", "<Team ID>");
//		capabilities.setCapability("xcodeSigningId", "iPhone Developer");
		capabilities.setCapability("updatedWDABundleId", "com.ihossain.WebDriverAgentRunner");
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/ismail/Library/Developer/Xcode/DerivedData/UIKitCatalog-gjuxzucwbjrprqagekpiqwgrolld/Build/Products/Debug-iphoneos/UIKitCatalog.app");
		capabilities.setCapability("bundleId", "com.example.apple-samplecode.ihossain");
		capabilities.setCapability("xcodeConfigFile", "/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/Config.xcconfig");

		
		IOSDriver driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		driver.quit();
		
	}
	
	
}
