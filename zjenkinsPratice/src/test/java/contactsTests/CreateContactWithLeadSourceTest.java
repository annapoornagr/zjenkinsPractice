package contactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilites.BaseClass;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;


public class CreateContactWithLeadSourceTest extends BaseClass{
	
	@Test(groups = "RegressionSuite")
	public void CreateContactWithLead() throws EncryptedDocumentException, IOException 
	{
       
		
		/* Read data from Excel file */
		String LASTNAME= eUtil.readDataFromExcelFile("Contacts", 4, 2);
		String LEADSOURCE = eUtil.readDataFromExcelFile("Contacts", 4, 3);
		
		//Step 3: Navigate to Contact Link
		HomePage hp = new HomePage(driver);//object creation of homepage
		hp.clickOnContactsLnk();//calling the method
				
		//Step 4: Click on Create Contact Lookup Page
		ContactsPage cp = new ContactsPage(driver);//object creation of contacts page
		cp.clickOnCreateContactLookUpImg();
		
		//Step 5: Create contact with Mandatory Information and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, LEADSOURCE);//Lastname is the maandatory field to create contact
						
		//Step 6: Validate for the Contact
		ContactInfoPage cip = new ContactInfoPage(driver);//object creation of contactinfo page
		String contactheader = cip.captureHeaderText();
		
		Assert.assertTrue(contactheader.contains(LASTNAME));//Hard Assert
		
		System.out.println(contactheader);	
		
		
}
}
