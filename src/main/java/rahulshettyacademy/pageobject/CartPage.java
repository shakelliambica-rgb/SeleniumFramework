package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
WebDriver driver;
public CartPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(css=".cartSection h3")
List<WebElement> productTitles;

@FindBy(css=".totalRow button")
WebElement checkOutEle;

public Boolean VerifyProductDisplay(String productName) {
	// if you need web element then use filter, here we need to verify only so using
	// true or false anymatch will return it
	Boolean match = productTitles.stream()
			.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
	return match;
}

public CheckOutPage goToChekOut() {
	checkOutEle.click();
	CheckOutPage checkOut=new CheckOutPage(driver);
	return checkOut;
}

}
