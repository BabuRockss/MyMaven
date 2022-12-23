package com.OjasTasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericsMethods {
	public static Properties prop = new Properties();
	public static WebDriver driver;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;

	public static void invoke() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get(GenericsMethods.propertyfile(""));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	public static String propertyfile(String str) throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\bp20293\\eclipse-workspace\\Myproject\\config.properties");
		prop.load(file);
		String strproperty = prop.getProperty(str);
		return strproperty;
	}

	public static void excelsheetdata(int row, int coloum, String name) throws IOException {
		File file = new File("C:\\Users\\bp20293\\Desktop\\Book1.xlsx");
		FileInputStream finput = new FileInputStream(file);
		book = new XSSFWorkbook(finput);
		sheet = book.getSheetAt(0);
		sheet.createRow(row).createCell(coloum).setCellValue(name);
		FileOutputStream fos = new FileOutputStream(file);
		book.write(fos);
		book.close();
	}

	public static ArrayList<String> arraylist(String url1, String Url2, String Url3) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(url1);
		list.add(Url2);
		list.add(Url3);
		return list;
	}

	public static void ClickingButton(WebElement element, long waitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
		WebElement ele = null;
		ele = wait.until(ExpectedConditions.elementToBeClickable(element));
		ele.click();

	}

	public static void sendkeysOnWenElement(WebElement element, String text) {
		// waitForElement(20,element);
		element.click();
		element.clear();
		element.sendKeys(text);

	}

	// TODO Auto-generated method stub

	public static void selectDropdown(WebElement element, String text, String value, int num) {
		Select dropdown = new Select(element);
		dropdown.deselectByVisibleText(text);
		dropdown.deselectByValue(text);
		dropdown.deselectByIndex(num);
	}

	public static void performonActions(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}

	public static void GettingText(WebElement element, String url, String text) {

		element.getText();
		element.getAttribute(text);
	}

	public static void ListofElements(List<WebElement> list) {

		int size = list.size();
		System.out.println(size);
		for (WebElement Link : list) {
			System.out.println(Link.getText() + " " + Link.getAttribute("href"));
			Link.click();
		}
	}

	public static void screenshot() throws Exception {
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Destination = new File("C:\\Users\\bp20293\\eclipse-workspace\\Myproject\\Snapshots\\4.png");
		FileUtils.copyFile(screen, Destination);
//	     String filepath = Destination.toString();
//	     String path = "<br><img src='\"+filepath+\"' height='1000' width='1000'/><br>";

		Reporter.log("\"<a href=" + Destination.getAbsolutePath() + "> <img src=" + Destination.getAbsolutePath()
				+ " height='100' width='100'/> </a>\"");
	}

	public static void teardown() throws IOException {
		driver.close();
	}
}
