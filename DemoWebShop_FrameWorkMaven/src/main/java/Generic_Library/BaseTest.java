package Generic_Library;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POMRepository.HomePage;
import POMRepository.loginPage;

//to give pre n post condition so we r using base
//data utility used to extra value from external file like property n excel
//Java utility used to create random numbers like in string using the methods
//web utility used to reuseability of the code like action,select etc..
//Listeners used to monitor the prgm of TestNG in RunTime execution n it'll caputre the Screenshot

public class BaseTest {
	public DataUtility data_Utility=new DataUtility();
	public WebDriver driver;
	public static WebDriver listenersDriver;
	public HomePage home_Page;

	@BeforeClass(alwaysRun = true)
	public void lanuchTheBrowser() throws IOException {
		driver=new ChromeDriver();
		listenersDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(data_Utility.getDataFromProperties("url"));
	}

	@BeforeMethod(alwaysRun = true)
	public void performLogin() throws IOException {
		home_Page=new HomePage(driver);
		home_Page.getLoginLink().click();
		
		loginPage login_Page=new loginPage(driver);
		login_Page.getEmailTextField().sendKeys(data_Utility.getDataFromProperties("email"));
		login_Page.getPasswordTextField().sendKeys(data_Utility.getDataFromProperties("pwd"));
		login_Page.getLoginButton().click();

	}

	@AfterMethod(alwaysRun = true)
	public void performLogout() {
		home_Page.getLogoutLink().click();
	}

	@AfterClass(alwaysRun = true)
	public void closeTheBrowser() {
		driver.quit();
	}

}
