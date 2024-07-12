package GenericUtilites;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists fo generic methods related to selenium webdriver
 * @author chand
 * @param <TakesScreenshot>
 * 
 */
public class SeleniumUtility {
	
	/**
	 * This method  will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * Thsis method will add 10 seconds of implicitly wait
	 * @param driver
	 */
    public void addimplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait 10 seconds for a element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method  will handle drop down by index
	 * @param element
	 * @param index
	 */
	
	public void handledropDown(WebElement element, int index)
	{
		Select sel=new Select(element);//object creation of select class
		sel.selectByIndex(index);
	}
	
	/**
	 * This method  will handle drop down by value
	 * @param element
	 * @param index
	 */
	public void handledropDown(WebElement element, String value)
	{
		Select sel=new Select(element);//object creation of select class
		sel.selectByValue(value);
	}
	
	/**
	 * This method  will handle drop down by VisibleText
	 * @param text
	 * @param element
	 */
	public void handledropDown(String text,WebElement element)
	{
		Select sel=new Select(element);//object creation of select class
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method  will perform mouse hovering action on web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method  will perform double click action on web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method  will perform right click action on web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method  will perform drag and drop action on web element
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	
	/**
	 * This method will scroll until a particular web element 
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElementAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	/**
	 * This method will scroll down by 500 untis
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500);","");
	}
	
	/**
	 * This method will handle frame By Index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver,int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**This method will handle frame By name of ID
	 * 
	 * @param driver
	 * @param frameNameorID
	 */
	public void handleFrame(WebDriver driver, String frameNameorID)
	{
		driver.switchTo().frame(frameNameorID);
	}
	
	/**
	 * This method will handle frame By Frame Element
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will accept alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
	driver.switchTo().alert().accept();	
	}
	
	/**
	 * This method will dismiss alert pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
	driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will send text to alert pop up
	 * @param driver
	 * @param text
	 */
	public void sendTextAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will capture  text from alert pop up
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
	 TakesScreenshot ts = (TakesScreenshot)driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  File dst = new File(".\\Screenshots\\"+screenshotName+".png");
	  
	  Files.copy(src, dst);
	  
	  
	  return dst.getAbsolutePath();//used in expert reports	  
	}
	
	
}
	 
	
