package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonUtils;
import util.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver)  //constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginOption;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerOption;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
		
	public void clickOnMyAccount()
	{
		//myAccountDropMenu.click();
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public LoginPage SelectLoginOption()
	{
		elementUtils.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//loginOption.click();
		return new LoginPage(driver);
	}

	public RegisterPage SelectRegisterOption() {
		//registerOption.click();
		elementUtils.clickOnElement(registerOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
	public void enterProductIntosearchBox(String productText) {
		//searchBoxField.sendKeys(productText);
		elementUtils.typeTextIntoElement(searchBoxField, productText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public searchResultsPage clickOnSearchButton()
	{
		//searchButton.click();
		elementUtils.clickOnElement(searchButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new searchResultsPage(driver);
	}


}
