package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import objects.BillingAddress;
import objects.User;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);

	}

	private final By firstNameFld = By.cssSelector("#billing_first_name");

	private final By lastNameFld = By.cssSelector("#billing_last_name");

	private final By alternateCountryDropdown = By.id("select2-billing_country-container");

	private final By countryOptionDropdown = By.xpath(" //li[text()= 'United States (US)']");

	private final By addressLineOneFld = By.cssSelector("#billing_address_1");

	private final By billingCityFld = By.xpath("//input[@id='billing_city']");

	private final By alternateStateDropdown = By.id("select2-billing_state-container");

	private final By stateOptionDropdown = By.xpath(" //li[text()= 'California']");

	private final By billingPostCodeFld = By.cssSelector("#billing_postcode");

	private final By billingEmailFld = By.cssSelector("#billing_email");

	private final By placeOrderBtn = By.id("place_order");

	private final By successNotice = By
			.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");

	private final By overLay = By.cssSelector(".blockUI.blockOverlay");

	private final By directBankTransferRadioBtn = By.id("payment_method_bacs");

	// TestCase 2

	private final By clickHereToLogin = By.xpath("//a[normalize-space()='Click here to login']");
	private final By usernameFld = By.id("username");
	private final By passwordFld = By.id("password");
	private final By loginBtn = By.name("login");

	public CheckOutPage enterFirstName(String firstName) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFld));
		element.clear();
		element.sendKeys(firstName);
		return this;
	}

	public CheckOutPage enterLastName(String lastName) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFld));
		element.clear();
		element.sendKeys(lastName);
		return this;
	}

	public CheckOutPage selectCountry(String countryName) {

		wait.until(ExpectedConditions.elementToBeClickable(alternateCountryDropdown)).click();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(countryOptionDropdown));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		return this;
	}

	public CheckOutPage enterAddressLineOne(String addressLineOne) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(addressLineOneFld));
		element.clear();
		element.sendKeys(addressLineOne);

		return this;
	}

	public CheckOutPage enterCity(String city) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityFld));
		element.sendKeys(city);
		return this;
	}

	public CheckOutPage selectState(String stateName) {

		wait.until(ExpectedConditions.elementToBeClickable(alternateStateDropdown)).click();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(stateOptionDropdown));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		return this;
	}

	public CheckOutPage enterPostalCode(String postalCode) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingPostCodeFld));
		element.clear();
		element.sendKeys(postalCode);
		return this;
	}

	public CheckOutPage enterEmailAddress(String emailAddress) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld));
		element.clear();
		element.sendKeys(emailAddress);
		return this;
	}

	public CheckOutPage setBillingAddress(BillingAddress billingAddress) {
		return enterFirstName(billingAddress.getFirstName())
				.enterLastName(billingAddress.getLastName())
				.selectCountry(billingAddress.getCountry())
				.enterAddressLineOne(billingAddress.getAddressLineOne())
				.enterCity(billingAddress.getCity())
				.selectState(billingAddress.getState())
				.enterPostalCode(billingAddress.getPostalCode())
				.enterEmailAddress(billingAddress.getEmail());

	}

	public CheckOutPage clickPlaceOrder() {
		waitForOverlaysToDisapper(overLay);
		wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
		return this;
	}

	public String getNotice() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();

	}

	// TestCase 2

	public CheckOutPage clickHereToLoginLink() {
		wait.until(ExpectedConditions.elementToBeClickable(clickHereToLogin)).click();
		return this;
	}

	public CheckOutPage enterUserName(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFld)).sendKeys(username);
		return this;
	}

	public CheckOutPage enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).sendKeys(password);
		return this;
	}

	public CheckOutPage clickLoginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		return this;
	}

	public CheckOutPage login(User user) {

		return enterUserName(user.getUsername())
			  .enterPassword(user.getPassword())
			  .clickLoginBtn();

	}
	
	
	
	public CheckOutPage selectDirectBankTransfer() {
		
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
		if(!element.isSelected()) {
			element.click();
		}
		
		return this;
	}


}
