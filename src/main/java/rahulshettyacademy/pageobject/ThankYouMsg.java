package rahulshettyacademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouMsg {
	WebDriver driver;
	
public ThankYouMsg(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(css="h1.hero-primary")
WebElement textMsg;

public String checkMessage() {
	String confirmMessage=textMsg.getText();
	return confirmMessage;
}
}
