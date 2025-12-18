package rahulshettyacademy.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.TestComponent.Retry;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalogue;
import rahulshettyacademy.pageobject.ThankYouMsg;

public class ErrorValidationTest extends BaseTest{

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void loginErrorMessage() throws IOException, InterruptedException {

		landingPage.loginApplicaton("shakelliambic@gmail.com", "Ambic123");
		AssertJUnit.assertEquals("Incorrect email password.",landingPage.getErrorMsg());
	}
	
	@Test
	public void productErrorValidation() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue=landingPage.loginApplicaton("shakelliambica@gmail.com", "Ambica123");
		
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		//since we used inheritance concept so child classes can also call parent class methos so calling abstract parent class method from child class
		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match=cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}

}
