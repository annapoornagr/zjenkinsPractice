package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilites.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility{
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	//initialiazation
	public CreateNewContactPage (WebDriver driver) //its a constructorv
	{ 
	PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getLastNameEdt()	
	{
		return LastNameEdt;
	}
	
	public WebElement getSaved()
	{
	   return SaveBtn;
	}
	
	public WebElement getLeadSourceDropDown()
	{
		return leadSourceDropDown;
	}
	
	//Business library
	
	/**
	 * This method will create a new contact with mandatory fields
	 * @param lastname
	 */
	
	public void createNewContact(String lastname)//parameterised
	{
		LastNameEdt.sendKeys(lastname);	
		SaveBtn.click();
	}
	
	/**
	 * This method will create contact with lead source drop down
	 * @param lastname
	 * @param leadSourceValue
	 */
	
	public void createNewContact(String lastname,String leadSourceValue)//parameterised
	{
		LastNameEdt.sendKeys(lastname);
		handledropDown(leadSourceValue, leadSourceDropDown);
		SaveBtn.click();
		
	}
	
	
	
	
	
	

}
