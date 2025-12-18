package rahulshettyacademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.OrdersPage;
import rahulshettyacademy.pageobject.ProductCatalogue;
import rahulshettyacademy.pageobject.ThankYouMsg;

public class SubmitOrderTest extends BaseTest{

	String productName = "ZARA COAT 3";
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {

		
		ProductCatalogue productCatalogue=landingPage.loginApplicaton(input.get("email"), input.get("password"));
		
		List<WebElement>products=productCatalogue.getProductList();
		System.out.println("Hi");
		productCatalogue.addProductToCart(input.get(productName));
		//since we used inheritance concept so child classes can also call parent class methos so calling abstract parent class method from child class
		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match=cartPage.VerifyProductDisplay(input.get(productName));
		Assert.assertTrue(match);
		CheckOutPage checkOut=cartPage.goToChekOut();
		checkOut.FillForm();
		ThankYouMsg tqMsg=checkOut.submitOrder();
	    String confirmMessage=tqMsg.checkMessage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest() {
		ProductCatalogue productCatalogue=landingPage.loginApplicaton("shakelliambica@gmail.com","Ambica123");
		OrdersPage ordersPage=productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
	

	@DataProvider
	public Object[][] getData() throws IOException {
         List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

	//extent reports
	
	
	
	
			        //two dimentional array for two data sets
					//object is generic one which acepts any data type
					//return new Object[][] {{"shakelliambica@gmail.com","Ambica123","ZARA COAT 3"},{"ambica@gmail.com","Ambica@24","ADIDAS ORIGINAL"}};
					//public void submitOrder(String email, String password, String productName) 
					//ProductCatalogue productCatalogue=landingPage.loginApplicaton("shakelliambica@gmail.com","Ambica123");
					//ProductCatalogue productCatalogue=landingPage.loginApplicaton(email, password);
	
						//HashMap<String,String> map=new HashMap<String,String>();
					//	map.put("email","shakelliambica@gmail.com");
					//	map.put("password", "Ambica123");
					//	map.put("productName", "ZARA COAT 3");
					//	
					//	HashMap<String,String> map1=new HashMap<String,String>();
					//	map1.put("email","ambica@gmail.com");
					//	map1.put("password", "Ambica@24");
					//	map1.put("productName", "ADIDAS ORIGINAL");
						//public void submitOrder(HashMap<String,String> input)
						//ProductCatalogue productCatalogue=landingPage.loginApplicaton(input.get("email"), input.get("password"));
						
}
