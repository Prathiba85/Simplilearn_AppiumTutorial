package com.test.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Lib {

	public AndroidDriver startApplication() throws MalformedURLException {
		URL URL = new URL ("http://localhost:4723/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","11");
		capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
		capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
		
		AndroidDriver driver = new AndroidDriver(URL, capabilities);
		System.out.println("Session ID is " + driver.getSessionId());
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;

	}
	public void navigateToViews(AndroidDriver driver) {
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();

	}
	public void scrollTillView(AndroidDriver driver,String strview) {
		
	//ctrl+shift+O --To import all libraries
		List<WebElement> lstViews = driver.findElements(By.id("android:id/text1"));
		for (WebElement view : lstViews) {
			System.out.println(view.getAttribute("text"));
		}
		

		scrollUp(driver);
		//Print next set of elements in new view
		
		lstViews = driver.findElements(By.id("android:id/text1"));
		for (WebElement view : lstViews) {
			System.out.println(view.getAttribute("text"));
		}
		
	}
	public void scrollUp(AndroidDriver driver) {
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		
		int startX = (int) (0.5 * width);
		int startY = (int) (0.9 * height);
		
		int endX = startX;
		int endY = (int) (0.1 * height);
		
		TouchAction action = new TouchAction(driver);
		
		action
		.longPress(PointOption.point(startX, startY))
		.moveTo(PointOption.point(endX, endY))
		.release()
		.perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void findAndClickView(AndroidDriver driver,String viewName) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flgFound = false;
		while (!flgFound) {
			//To conver only the area under views ,we are getting the parent element (View)
			WebElement prntViews = driver.findElement(By.id("android:id/content"));
			List<WebElement> lstViews = prntViews.findElements(By.id("android:id/text1"));
			for (WebElement view : lstViews) {
				System.out.println(view.getAttribute("text"));
				if (view.getAttribute("text").equals(viewName)) {
					flgFound = true;
					view.click();
					break;
				}
			}
			if (!flgFound) {
				scrollUp(driver);
			}
		}
		
		System.out.println("\nFound the element");
}



}
