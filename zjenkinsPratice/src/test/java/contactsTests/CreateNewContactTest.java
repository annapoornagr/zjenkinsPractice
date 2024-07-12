package contactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilites.BaseClass;
import GenericUtilites.ExcelFileUtility;
import GenericUtilites.PropertyFileUtility;
import GenericUtilites.SeleniumUtility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

@Listeners(GenericUtilites.ListenersImplementation.class)
public class CreateNewContactTest extends BaseClass{
	
       @Test(groups = "SmokeSuite")
		public void CreateNewContactWithMandatoryfields() throws IOException, InterruptedException {
		
		
				/* Read data from Excel file */
				String LASTNAME= eUtil.readDataFromExcelFile("Contacts", 1, 2);
				
				//Step 3: Navigate to Contact Link
				HomePage hp = new HomePage(driver);//object creation of homepage
				hp.clickOnContactsLnk();//calling the method
						
				//Step 4: Click on Create Contact Lookup Page
				ContactsPage cp = new ContactsPage(driver);//object creation of contacts page
				cp.clickOnCreateContactLookUpImg();
				
				//Step 5: Create contact with Mandatory Information and save
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(LASTNAME);//Lastname is the maandatory field to create contact
				
				//Assert.fail();//intenstionally we added to fail the test Script
								
				//Step 6: Validate for the Contact
				ContactInfoPage cip = new ContactInfoPage(driver);//object creation of contactinfo page
				String contactheader = cip.captureHeaderText();
				
				//Assert.assertTrue(contactheader.contains(LASTNAME));//Hard Assert
				
				System.out.println(contactheader);	
				System.out.println("wait for one year, YOUR FINANCIAL PROBLEMS WILL GET RESOLVE SOON");
						
	}
   @Test
   public void sample()//Non Static method with void return type
   {
	   System.out.println("demo");
	  System.out.println("ANNAPOORNA SOON GET JOB IN AUTOMATIOn");
   }
}


		
  

    

		
		
		
		
		
		
		