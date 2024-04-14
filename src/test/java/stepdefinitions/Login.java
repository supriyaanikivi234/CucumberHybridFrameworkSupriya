package stepdefinitions;

import java.util.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.AccountPage;
import util.CommonUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;

public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private CommonUtils commonUtils;
	private AccountPage accountPage;
	//private DriverFactory DriverFactory;
	
	@Given("User has navigated to login page")
	public void User_has_navigated_to_login_page()
	{
	//DriverFactory=new DriverFactory();
	driver= Factory.DriverFactory.getDriver();
	
	HomePage homepage=new HomePage(driver);
	
	//driver.findElement(By.xpath("//a[text()='Login']")).click();-->removing hardcoding and updated using page factory below
	homepage.clickOnMyAccount();
	
	//driver.findElement(By.xpath("//span[text()='My Account']")).click();-->removing hardcoding and updated using page factory below
	loginPage=homepage.SelectLoginOption();
	
	}
	

	
	//@When("User enteres valid email address {string} into email field")
	  @When("^User enteres valid email address (.+) into email field$")
	public void user_enteres_valid_email_address_into_email_field(String validEmailText) {
		
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(validEmailText);
		//login= new LoginPage(driver);
		loginPage.enterEmailAddress(validEmailText);
		
	}

	//@And("User has entered valid password {string} into password field")
	  @And("^User has entered valid password (.+) into password field$")
	public void user_has_entered_valid_password_into_password_field(String validPasswordText) {
	    
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(validPasswordText);
		loginPage.enterPassword(validPasswordText);
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
	  
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		accountPage=loginPage.ClickOnloginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());  //this message will display on account page 
		//AccountPage accountPage=new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}

	/* @When("User enteres invalid email address {string} into email field")
	public void user_enteres_invalid_email_address_into_email_field(String invalidEmailText) {
	  
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(invalidEmailText);
	}
	*/
	
	@When("User enteres invalid email address into email field")
	public void user_enteres_invalid_email_address_into_email_field() {
	  
		//loginPage= new LoginPage(driver);
	
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(getEmailWithTimeStamp());
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		
		
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(invalidPasswordText);
		loginPage.enterPassword(invalidPasswordText);
	   	}

	@Then("User should get a proper warning message about credentails mismatch")
	public void user_should_get_a_proper_warning_message_about_credentails_mismatch() {
		//this message will come one login page
	//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
      Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	
	}

	@When("User do not enter email address into email field")
	public void user_do_not_enter_email_address_into_email_field() {
	   
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("");
		//loginPage= new LoginPage(driver);
		loginPage.enterEmailAddress("");
		
	}

	@And("User do not enter password into password field")
	public void user_do_not_enter_password_into_passwrd_field() {
		
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
		loginPage.enterPassword("");
	}
	
	
	
	
	
	
}
