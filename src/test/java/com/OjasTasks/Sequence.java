package com.OjasTasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sequence {

	public  WebDriver driver;
	@Test
	public void openbrowser() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		System.out.println("PageTitle"+driver.getTitle());
		driver.quit();
		
	}
	
	@Test
	//public static WebDriver driver;
	public void secondBrowser()
{
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver=new ChromeDriver();
		driver.get("https://ojasit.darwinbox.com/");
		System.out.println("PageTitle"+driver.getTitle());
		driver.quit();
		
		}
	public void ThirdBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/");
		System.out.println("PageTitle"+driver.getTitle());
		driver.quit();
	}
}
