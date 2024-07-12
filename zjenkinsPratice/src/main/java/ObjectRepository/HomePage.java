package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilites.SeleniumUtility;

public class HomePage extends SeleniumUtility{
	
	//Declaration - webelements - dropdown,windows, frames,mousehovering
	
	@FindBy(linkText = "Contacts")//identified 3 elements
	private WebElement contactsLnk;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlnk;
	
	//Initialization - 
	public HomePage(WebDriver driver)//Constructor
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getContactsLnk()//get method of encapsulation
	{
		return contactsLnk;
	}
	
	public WebElement getAdministratorImg()
	{
		return administratorImg; 
	}
	
	public WebElement getSignoutLnk()
	{
		return signoutlnk; 
	}
	
	//Business Labrary
	
	/**
	 * This method will click on contact link
	 */
	
	public void clickOnContactsLnk()
	{
		contactsLnk.click();
	}
	
	/**
	 * This method will logout of application
	 * @param driver
	 * @throws InterruptedException
	 */
	
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(1000);
		signoutlnk.click();
	}
	
	
	
	
	
	

}
