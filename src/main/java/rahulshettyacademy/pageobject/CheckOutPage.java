package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//form/div/div[2]/child::div[2]/child::input")
WebElement cvvNum;

@FindBy(xpath="//div[text()='Name on Card ']/following-sibling::input")
WebElement userName;

@FindBy(xpath="//input[@placeholder='Select Country']")
WebElement selectCountry;

@FindBy(xpath="//section/button")
List<WebElement> results;

By submit=By.xpath("(//a[normalize-space()='Place Order'])[1]");


public void FillForm() 
{
	cvvNum.sendKeys("980");
	userName.sendKeys("Ambica");
	selectCountry.sendKeys("ind");
	waitForElementsToAppear(results);
	for(WebElement result:results) 
	{
		if(result.getText().equalsIgnoreCase("India")){
			result.click();
			break;
		}
	}	
}
 
public ThankYouMsg submitOrder() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	waitForElementToAppear(submit);
	driver.findElement(submit).click();
	ThankYouMsg tqMsg=new ThankYouMsg(driver);
	return tqMsg;
}
}
