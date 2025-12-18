package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
//create a local driver variable
	WebDriver driver;
	//create a constructor
	//constructor will execute first 
	public LandingPage(WebDriver driver) {
		//our child classes have knowledge about driver life and now use super keyword 
		super(driver);
		//initialization of driver using this keyword
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory design pattern reduce syntax of creating web element by using @FindBy annotation
	//keep all locators into webelements and use page factory 
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	//it will construct like below at run time,
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
//now write action methods to perform login 
	public ProductCatalogue loginApplicaton(String email, String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		//we know this will go to nextpage Product Catalogue then create its object here itself
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
	}
	
public String getErrorMsg() {
	waitForWebElementToAppear(errorMessage);
	return errorMessage.getText();
}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
}
