package tendablePom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestDemoPage {
	public WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Request A Demo')]")private WebElement requestDemoButton;
	@FindBy(xpath = "//h1[text()='Request a Demo']")private WebElement requestDemoFormTitle;
	
	public RequestDemoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean requestDemoFormTitleIsDisplayed() {
		boolean demoFormTitleIsDisplayed= requestDemoFormTitle.isDisplayed();
		 return demoFormTitleIsDisplayed;
	}
}
