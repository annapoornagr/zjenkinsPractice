package GenericUtilites;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Thus method consists of generic methods related to java
 * @author chand
 */

public class JavaUtility {
	
	/**
	 * This method will generate system date in a given format
	 * @return
	 */
	public String getDate()//No argument with String return type
	{
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");//to rename the screenshot
		String date = f.format(d);
		return date;
	}

}
