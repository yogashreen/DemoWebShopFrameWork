package TestScriptAddToCart;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Library.BaseTest;
import POMRepository.Digital;

import java.util.List;
@Listeners(Generic_Library.ListenersImplementation.class)

public class AddToCartTestCase extends BaseTest {
@Test
public void Verify_User_Is_Able_To_Add_Product_To_AddToCart() throws InterruptedException {
	home_Page.getDigitalDownloadsLink().click();
	
	//validate
	
		if(	driver.getTitle().equals("Demo Web Shop. Digital downloads"))
		{
		System.out.println("Navigated to Digital Downloads Page Successfully");
		}
		else
		System.out.println("Navigated to Digital Downloads Page Fail");

		 //products added to cart
		Digital digital_downloads = new Digital(driver);
		List<WebElement> addtocartall = digital_downloads.getCartButton();
		 int expectedresult = addtocartall.size();
		 for (WebElement addtocartallpdt : addtocartall) 
		 {
			addtocartallpdt.click();
			Thread.sleep(2000);	
		}

		 //Navigate shopping cart
		 home_Page.getShoppingCartLink().click();
		 
		 Assert.assertEquals(driver.getTitle(), "Demo Web Shop.12345");
		
		/* if(driver.getTitle().equals("Demo Web Shop. Shopping Cart"))
		 {
			 
			 System.out.println("Shopping Cart Page displayed");
		 }
		 else
		 {
			 System.out.println("Shopping Cart Page is not displayed");
		 }*/
			
		 //removing the product
	
				 digital_downloads.getCheckbox();
				 digital_downloads.getUpdateCart();
		 //validation
		 if(driver.findElement(By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]")).isDisplayed())
		 {
			System.out.println("Products are removed from Cart Successfylly");
		  }
		  else
			System.out.println("Products are removed from Cart Fail");
		 
		 
		 driver.close();

}
}
