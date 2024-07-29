package Generic_Library;

import java.io.File;
import java.io.IOException;

import 	org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
public void captureScreeshot(WebDriver driver , String name) {
	
	String modName=name+" "+JavaUtility.getTimeStamp();
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File trg = new File("./ScreenShot/"+modName+".png");
	
	try {
		FileHandler.copy(src, trg); //the reason we r using try&catch,if we use throws in method declaration will get another execption so handle this we go for try&catch
	} catch (IOException e) {
		e.printStackTrace();
	}
}
 
public void acceptAlert(WebDriver driver)
{
	  driver.switchTo().alert().accept();
}
public void dismissAlert(WebDriver driver)
{
	  driver.switchTo().alert().dismiss();
}
public void switchToFrame(WebDriver driver, int indexNum)
{
	  driver.switchTo().frame(indexNum);
}
public void switchToFrame(WebDriver driver, String idorName)
{
	  driver.switchTo().frame(idorName);
	  
}
public void switchToFrame(WebDriver driver, WebElement frameElement)
{
	  driver.switchTo().frame(frameElement);
	  
}
public void selectOptionByIndex(WebElement dropdown,int indexNum)
{
	  Select s=new Select(dropdown);
	  s.selectByIndex(indexNum);
}
public void selectOptionByValue(WebElement dropdown,String value)
{
	  Select s=new Select(dropdown);
	  s.selectByValue(value);
}
public void selectOptionByVisibleText(WebElement dropdown,String visibleText)
{
	  Select s=new Select(dropdown);
	  s.selectByVisibleText(visibleText);
}
public void mouseOveronElement(WebDriver driver, WebElement element)
{
	  Actions act=new Actions(driver);
	  act.moveToElement(element).perform();
}
public void clickUsingActions(WebDriver driver, WebElement element)
{
	  Actions act=new Actions(driver);
	  act.moveToElement(element).click().perform();
}
public void scrollTillElementUsingActions(WebDriver driver, WebElement element)
{
	  Actions act=new Actions(driver);
	  act.scrollToElement(element).perform();
}
}
