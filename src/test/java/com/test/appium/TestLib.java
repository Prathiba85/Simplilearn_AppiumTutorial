package com.test.appium;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;


public class TestLib {
public static void main(String[] args) throws MalformedURLException {
	Lib lb = new Lib();
	//ctrl+ 2, L
	AndroidDriver driver = lb.startApplication();
	lb.navigateToViews(driver);
	//lb.scrollTillView(driver, "Lists");
	lb.findAndClickView(driver, "Tabs");
	
	
}
	
}
