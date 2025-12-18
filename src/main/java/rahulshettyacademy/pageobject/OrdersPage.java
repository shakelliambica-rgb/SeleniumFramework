package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
WebDriver driver;
public OrdersPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(css="tr td:nth-child(3)")
List<WebElement> productNamesTable;

@FindBy(css=".totalRow button")
WebElement checkOutEle;

public Boolean VerifyOrderDisplay(String productName) {

	Boolean match = productNamesTable.stream()
			.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
	return match;
}


}
