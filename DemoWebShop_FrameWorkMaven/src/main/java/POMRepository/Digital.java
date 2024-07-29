package POMRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Digital {

@FindBy(xpath="//input[@value='Add to cart']")
private List<WebElement> CartButton;

@FindBy(xpath="//span[text()='Shopping cart']")
private WebElement Shopping;

@FindBy(xpath="//input[@name='removefromcart']")
private List<WebElement> checkbox;

@FindBy(xpath="//input[@name='updatecart']")
private WebElement updateCart;

@FindBy(xpath="//a[text()='Blue Jeans' and @class='product-name']/../..//input[contains(@class,'qty-input')]")
private WebElement QtyTextField;



public Digital(WebDriver driver)
{
	   PageFactory.initElements(driver, this);
}


public List<WebElement> getCartButton() {
	return CartButton;
}

public WebElement getShopping() {
	return Shopping;
}

public List<WebElement> getCheckbox() {
	return checkbox;
}

public WebElement getUpdateCart() {
	return updateCart;
}
public WebElement getQtyTextField() {
	return QtyTextField;
}

}
