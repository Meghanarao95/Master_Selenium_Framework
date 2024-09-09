package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

import base.BasePage;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
		
		
	}
	
	
	private final By productName = By.cssSelector("td[class='product-name'] a");

	private final By checkOutBtn= By.cssSelector(".checkout-button.button.alt.wc-forward");
	

	
	
	public String getProductName() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
		
		return driver.findElement(productName).getText();
	}
	
	

	
	public CheckOutPage checkout() {
		
		wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();

	
	return new CheckOutPage(driver);
	}
	
}
