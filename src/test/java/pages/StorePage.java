package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class StorePage extends BasePage {

	public StorePage(WebDriver driver) {
		super(driver);

	}

	private final By searchFld = By.id("woocommerce-product-search-field-0");

	private final By searchBtn = By.cssSelector("button[value='Search']");

	private final By title = By.cssSelector("#main > div > header > h1");

	private final By viewCartLink = By.xpath("//a[@title='View cart']");

	private StorePage enterTextInSearchField(String txt) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);
		return this;
	}

	public StorePage search(String txt) {

		enterTextInSearchField(txt).clickSearchBtn();
		return this;
	}

	private StorePage clickSearchBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
		return this;
	}

	public String getTitle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
	}

	private By getAddToCartBtnElement(String productName) {
		return By.cssSelector("a[aria-label='Add \u201C" + productName + "\u201D to your cart']");

	}

	public StorePage clickOnAddToCartBtn(String productName) {
		By addToCartBtn = getAddToCartBtnElement(productName);
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
		return this;
	}

	public CartPage clickViewCart() {
		wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
		return new CartPage(driver);
	}

}
