package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonUtils;
import util.ElementUtils;


import util.ElementUtils;

public class AccountPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver)  //constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformation;
	
	public boolean displayStatusOfEditYourAccountInformationOption()
	{
		return elementUtils.displayStatusOfElement(editYourAccountInformation, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return editYourAccountInformation.isDisplayed();
	}
	
	
}
