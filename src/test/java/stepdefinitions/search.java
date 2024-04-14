package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.searchResultsPage;

public class search {
	WebDriver driver;
	private HomePage homepage;
	private searchResultsPage serchResultsPage;
	//private DriverFactory DriverFactory;
	
	@Given("User opens the Application")
	public void user_opens_the_application() {
		//DriverFactory=new DriverFactory();
		driver= DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
		
		homepage=new HomePage(driver);
		homepage.enterProductIntosearchBox(validProductText);
	//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(validProductText);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
	 // driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		serchResultsPage=homepage.clickOnSearchButton();
	}

	@Then("User should get Valid Product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
	   //this method will be present in serachResultPage
		
		//searchResultsPage serchResultsPage=new searchResultsPage(driver);
		Assert.assertTrue(serchResultsPage.displayStatusOfValidProduct());
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
		
		homepage=new HomePage(driver);
		homepage.enterProductIntosearchBox(invalidProductText);
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(invalidProductText);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	//message coming on serachResults page
  //Assert.assertEquals("There is no product that matches the search criteria.",driver.findElement(By.xpath("//input[@id='button-search']//following-sibling::p")).getText());
		//serchResultsPage=new searchResultsPage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.",serchResultsPage.getMessageText());	
	
	
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
	  //intenatlonally kept blank  
		homepage=new HomePage(driver);
	}
}
