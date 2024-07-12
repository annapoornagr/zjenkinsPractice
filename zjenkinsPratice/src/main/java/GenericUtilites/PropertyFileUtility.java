package GenericUtilites;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
	 * This class consist of generic methods related to Property file
	 * @author chand
	 */
	
public class PropertyFileUtility {
	
	/**
	 * This method will read data from property file and return the value to Caller
	 * @param key
	 * @return
	 * @throws IOException 
	 */

	public String readDatarompropertyFile(String key) throws IOException// Parameterised method
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();              //object creation of Propertyfile
		p.load(fis);
		String value = p.getProperty(key);           //when we call the method, should give "key" in property file
		return value;                                //return the value to the caller
		
	
		

	}

}
