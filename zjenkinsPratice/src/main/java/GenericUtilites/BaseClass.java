package GenericUtilites;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists of  basic configuration annotations of testing
 * @author chand
 */

public class BaseClass {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public WebDriver driver;
	
	//For Listeners
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("==== Db Connection Successful ====");
		
	}
	
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String URL = pUtil.readDatarompropertyFile("url");
		
//        driver = new EdgeDriver();//initializing the driver
		
		//For Cross Browser Execution, launching the edge and firefox browser
		//if(BROWSER.contains("edge"))
		//{
		//	driver=new EdgeDriver();
		//}
		//else if (BROWSER.equals("firefox")) 
		//{
			WebDriverManager.firefoxdriver().setup();
		    driver=new FirefoxDriver();
		//}
		//else 
		//{
		//driver=new EdgeDriver();
		//} 
		
		sUtil.maximizeWindow(driver);//maximize window
		sUtil.addimplicitWait(driver);//add implicit wait
		
		driver.get(URL);//add the Url
		
		//FOR Listeners
		sDriver=driver;
		
	System.out.println("==== Browser Launch Successful ====");
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDatarompropertyFile("username");
		String PASSWORD = pUtil.readDatarompropertyFile("password");
		
		
		LoginPage lp = new LoginPage(driver);//create an object of POM class
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("==== Login To App Successful ====");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
	    HomePage hp = new HomePage(driver);	
	    hp.logoutOfApp(driver);
	
	    System.out.println("==== Logout of App Successful ====");
	}
	 
	// @AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("==== Browser closure Successful ====");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("==== DP closure Successful ====");
	}
}
	
	
	

