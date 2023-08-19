package com.test.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;


public class ApiDemos {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		URL URL = new URL ("http://localhost:4723/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","11");
		capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
		capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
		
		AndroidDriver driver = new AndroidDriver(URL, capabilities);
		System.out.println("Session ID is " + driver.getSessionId());
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Controls']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='01. Light Theme']")).click();
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/edit")).sendKeys("prathiba");
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/edit2")).sendKeys("sankar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.CheckBox[@text='Checkbox 1']")).click();
		WebElement checkbox= driver.findElement(By.xpath("//android.widget.CheckBox[@text='Checkbox 1']"));
		
		System.out.println(checkbox.getAttribute("checked"));
		
		
		driver.findElement(By.xpath("//android.widget.CheckBox[@text='Checkbox 1']")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@text='Checkbox 2']")).click();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='RadioButton 2']")).click();
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/star")).click();
		
	}

}
