package POMRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class loginPage {

	   @FindBy(id="Email")
	   private WebElement emailTextField;
	   
	   @FindBy(xpath="//input[@name='Password']")
	   private WebElement passwordTextField;
	   
	   @FindBy(xpath="//input[@value='Log in']")
	   private WebElement loginButton;
	   
	   public loginPage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	   
	   
	}


