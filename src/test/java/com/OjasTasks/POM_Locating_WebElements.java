package com.OjasTasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test

public class POM_Locating_WebElements extends GenericsMethods {
	// static By username=By.xpath("//input[@name='username']");
	// static By password=By.xpath("//input[@id='password']");
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement login;

	public POM_Locating_WebElements() {
		PageFactory.initElements(driver, this);

	}

	public void Loginaction() {
		sendkeysOnWenElement(username, prop.getProperty("Username"));
		sendkeysOnWenElement(password, prop.getProperty("Password"));
		ClickingButton(login, 20);

	}

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span/i")
	private WebElement mouseover;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
	private WebElement locatePIMLink;
	@FindBy(xpath = "//a[text()='Employee List']")
	private WebElement addemployee;
	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	private WebElement EmpoyeeName;
	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[2]")
	private WebElement Employeeid;

	public void mouseAction() {
		performonActions(locatePIMLink);
		sendkeysOnWenElement(addemployee, prop.getProperty("EmployeeName"));
		sendkeysOnWenElement(EmpoyeeName, prop.getProperty("EmployeeId"));
		// sendkeysOnWenElement(Employeeid,prop.getProperty(null));

	}
}
