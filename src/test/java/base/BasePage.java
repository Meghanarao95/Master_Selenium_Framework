package base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void load(String endPoint) {
		driver.get("https://askomdch.com" + endPoint);

	}

	public void waitForOverlaysToDisapper(By overLay) {

		List<WebElement> overlays = driver.findElements(overLay);
		System.out.println("Over size " + overlays.size());
		if (overlays.size() > 0) {

			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAYS  INVISIBLE");
		} else {
			System.out.println("OVERLAYS NOT FOUND");

		}

	}

}
