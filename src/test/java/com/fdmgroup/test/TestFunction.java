package com.fdmgroup.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.fdmgroup.util.DriverUtilities;

public class TestFunction {
	DriverUtilities driverUtilities;
	WebDriver driver;
	private final String bbc = "http://www.bbc.co.uk";
	private final String google = "http://www.google.co.uk";
	private String screenshotFilePath = "~\\Desktop\\SeleniumScreenshots\\screenshot.png";
	
	@Test
	public void testSomething() throws IOException {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
		
		driver.manage().window().maximize();
		
		System.out.println("Browser name: " + ((RemoteWebDriver)driver).getCapabilities().getBrowserName());
		System.out.println("Browser version: " + ((RemoteWebDriver)driver).getCapabilities().getVersion());
		
		driver.get(bbc); //first command to open a url
		driver.navigate().refresh();
		
		driver.navigate().to(google);
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //take a screen shot
		//System.out.println(srcFile);
		FileHandler.copy(srcFile, new File(screenshotFilePath));
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.quit();
	}

}
