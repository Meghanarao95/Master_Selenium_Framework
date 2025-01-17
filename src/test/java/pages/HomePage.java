package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class HomePage extends BasePage{
	
	
	private  final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	
	public HomePage load() {
		load("/");
		return this;
	}
	
	
	
	public StorePage navigateToStoreusingMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(storeMenuLink)).click();	
		
		return  new StorePage(driver);
	}
	
	

}
