package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonUtils;
import util.ElementUtils;


public class searchResultsPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public searchResultsPage(WebDriver driver)  //constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//input[@id='button-search']//following-sibling::p")
	private WebElement messageText;

	public boolean displayStatusOfValidProduct() {
		//return validHPProduct.isDisplayed();
		return elementUtils.displayStatusOfElement(validHPProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getMessageText() {
		return elementUtils.getTextFromElement(messageText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return messageText.getText();
	}
}
