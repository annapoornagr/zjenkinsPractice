package ObjectRepository;

import org.openqa.selenium.WebDriver;

//POM CLASS - followed rules of POM class
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1: create a separate pom class for every web page
	
	//Rule 2: identify the web elements using @FindBy
	@FindBy(name="user_name")//name is the locator
	private WebElement usernameEdt;//here webelement is like a datatype,usernameEdt - variable reference
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule 3: create a constructor to initialise
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Rule 4: provide getters to access
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//business library - generic method
	
	/**
	 * This method will login to application
	 * @param username
	 * @param password
	 */
	
	public void loginToApp(String username,String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
		
	}
	
	
	

}
