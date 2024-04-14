package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonUtils;
import util.ElementUtils;

public class LoginPage {

WebDriver driver;
private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver)  //constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordFiled;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	
	@FindBy(xpath="//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailText)
	{
		//emailField.sendKeys(emailText);
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String passwordText)
	{
		//passwordFiled.sendKeys(passwordText);
		elementUtils.typeTextIntoElement(passwordFiled, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountPage ClickOnloginButton()
	{
		//loginButton.click();
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	public String getWarningMessageText()
	{
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return warningMessage.getText();
	}
}
