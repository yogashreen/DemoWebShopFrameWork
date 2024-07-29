package Generic_Library;

import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {

	public static int getRandomNumber() {  //in other class we have to create object to call this method instead declare the method as static
		Random r=new Random();//it is used to print some random numbers
		return r.nextInt(5000);
	}
	
	public static String getTimeStamp() {
		LocalDateTime l= LocalDateTime.now();
		String date = l.toString().replace(":", "-");
		return date;
	}
}
