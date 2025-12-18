package rahulshettyacademy.AbstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	WebDriverWait wait;
	
public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

//write reusable code here which is used across all pages or classes
@FindBy(css="[routerlink='/dashboard/cart']")
WebElement cartHeader;

@FindBy(css="[routerlink*='myorders']")
WebElement ordersHeader;


public void waitForElementsToAppear(List<WebElement> products) {
	wait.until(ExpectedConditions.visibilityOfAllElements(products));
}

public void waitForElementToAppear(By findBy) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
}


public void waitForWebElementToAppear(WebElement findBy) {
	wait.until(ExpectedConditions.visibilityOf(findBy));
}

public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
	Thread.sleep(5000);
	//wait.until(ExpectedConditions.invisibilityOf(ele));
}

public CartPage goToCartPage() {
	cartHeader.click();
	CartPage cartPage=new CartPage(driver);
	return cartPage;
}


public OrdersPage goToOrdersPage() {
	ordersHeader.click();
	OrdersPage ordersPage=new OrdersPage(driver);
	return ordersPage;
}
}
