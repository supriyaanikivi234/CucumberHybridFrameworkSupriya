package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;
import Factory.DriverFactory;
public class MyHooks {

	WebDriver driver;
	private ConfigReader ConfigReader;
	//private DriverFactory DriverFactory;
	
	@Before
	public void setup()
	{
		ConfigReader=new ConfigReader();
		Properties prop=ConfigReader.intializeProperties();
		
		
		
		//DriverFactory.intializeBrowser("chrome");  //driver=new ChromeDriver(); instead of this stmt write like this
		//DriverFactory=new DriverFactory();
		driver=DriverFactory.intializeBrowser(prop.getProperty("browser"));
		 driver.get(prop.getProperty("url"));
		//driver.manage().deleteAllCookies();----> moved to driverfactory class
		//driver.manage().window().maximize();----> moved to driverfactory class
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));----> moved to driverfactory class
		//driver.get("https://tutorialsninja.com/demo/");  //removing the hardcoding and fecthing data from propertiwes file

		
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		String scenarioName=scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed())
		{
			byte[] srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		driver.quit();
	}
}
