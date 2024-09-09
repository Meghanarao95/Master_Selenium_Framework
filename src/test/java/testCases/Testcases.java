package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import objects.BillingAddress;
import objects.Product;
import objects.User;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.StorePage;
import utils.JacksonUtils;

public class Testcases extends BaseTest {

	@Test
	public void guestCheckoutUingDirectBanckTransfer() throws InterruptedException, IOException {

		String searchFor = "Blue";
     
	   // Parcing Json obect into Java Object and then using it in our testcase
		BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);		
		Product product = new Product(1215);	
		StorePage storepage = new HomePage(getDriver())
				.load()
				.navigateToStoreusingMenu()
				.search(searchFor);
		AssertJUnit.assertEquals(storepage.getTitle(), "Search results: “"+searchFor+"”");

		storepage.clickOnAddToCartBtn(product.getName());
	
		CartPage cartpage = storepage.clickViewCart();
		AssertJUnit.assertEquals(cartpage.getProductName(), product.getName());

		CheckOutPage checkoutpage = cartpage
				.checkout()
				.setBillingAddress(billingAddress)
				 .selectDirectBankTransfer()
				.clickPlaceOrder();
	
		AssertJUnit.assertEquals(checkoutpage.getNotice(), "Thank you. Your order has been received.");

	}

	@Test

	public void loginGuestCheckoutUingDirectBanckTransfer() throws InterruptedException, IOException {
		
		String searchFor = "Blue";
		  // Parcing Json obect into Java Object and then using it in our testcase
				BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);	
				Product product = new Product(1215);
     			User user = new User("Jhon", "Doe");
				
		StorePage storepage = new HomePage(getDriver())
				                  .load()
				                  .navigateToStoreusingMenu()
				                  .search(searchFor);
		AssertJUnit.assertEquals(storepage.getTitle(), "Search results: “"+searchFor+"”");

		storepage.clickOnAddToCartBtn(product.getName());	
		CartPage cartpage = storepage.clickViewCart();
		AssertJUnit.assertEquals(cartpage.getProductName(), product.getName());
			
		CheckOutPage checkoutpage = cartpage
				                 .checkout()
				                 .clickHereToLoginLink()
    	                         .login(user)
		                         .setBillingAddress(billingAddress)
		                         .selectDirectBankTransfer()
				                 .clickPlaceOrder();
		AssertJUnit.assertEquals(checkoutpage.getNotice(), "Thank you. Your order has been received.");

	}

}
