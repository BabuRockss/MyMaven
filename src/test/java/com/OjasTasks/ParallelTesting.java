package com.OjasTasks;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParallelTesting extends GenericsMethods {

	@BeforeTest
	public static void openbrowser() throws IOException {
		invoke();
		Reporter.log("Browser has been invoked");
	}

	@Test
	public static void writingdatatoexcel() throws Exception {
		ArrayList<String> urls = GenericsMethods.arraylist(GenericsMethods.propertyfile("FlipKarturl"),
				GenericsMethods.propertyfile("JavaTpointurl"), GenericsMethods.propertyfile("schoolsurl"));
		// int sizeurls = urls.size();
		ArrayList<String> titles = new ArrayList<String>();
		System.out.println(titles);

		for (int i = 0; i < urls.size(); i++) {
			driver.get(urls.get(i));
			String title = driver.getTitle();
			titles.add(title);

		}

		for (int j = 0; j < titles.size(); j++) {
			excelsheetdata(j, 0, titles.get(j));
		}
		screenshot();
		Reporter.log("Title has been stored in xl");
	}

	public static void sendkeysOnWenElement() throws IOException {
 
		// GenericsMethods.sendkeysOnWenElement((WebElement)
		// POM_Locating_WebElements.username,GenericsMethods.propertyfile("username"));
		// GenericsMethods.sendkeysOnWenElement((WebElement)
		// POM_Locating_WebElements.password,GenericsMethods.propertyfile("password"));

	}

	@AfterTest
	public static void closebrowser() throws IOException {
		teardown();

	}
}