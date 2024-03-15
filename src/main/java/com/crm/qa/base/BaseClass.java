package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		 prop = new Properties();
		 try {
			 FileInputStream fip= new FileInputStream("E:\\Dev\\Speed400Journey\\FreeCRMTest\\"
			 		+ "FreeCRMTest2\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			 prop.load(fip);
		 }catch(FileNotFoundException e) {
			 e.printStackTrace();
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
		 
		 
	}
	
	public static void initialization() {
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FF")||browserName.equalsIgnoreCase("Firefox")) {
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get(prop.getProperty("url"));
	}

}
