package tendablePom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	@FindBy(xpath = "//h2[text()='What is Tendable?']")
	private WebElement whatIsTendableText;
	@FindBy(xpath = "//img[@alt='Tendable Logo']")
	private WebElement tendableLogoHomePageButton;
	@FindBy(xpath = "(//a[@href=\"https://www.tendable.com/book-a-demo\"])[2]")
	private WebElement requestDemoButton;
	
	@FindBy(xpath = "//a[text()='Our Story ']")private WebElement ourStoryButton;
	@FindBy(xpath = "//a[text()='Our Solution ']")private WebElement ourSolutionButton;
	@FindBy(xpath = "//a[text()='Why Tendable? ']")private WebElement whyTendableButton; 
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	

	public void clickHomeMenuButton() {
		tendableLogoHomePageButton.click();
	}

	public void clickOurStoryMenuButton() {
		ourStoryButton.click();
	}
	
	public boolean clickOurStoryMenuButtonStaus() {
		ourStoryButton.click();
		boolean ourStoryButtonStatus = ourStoryButton.isEnabled();
		return ourStoryButtonStatus;
	}
	
	public void clickOurSolutionMenuButton() {
		ourSolutionButton.click();
	}
	
	public boolean clickOurSolutionMenuButtonStaus() {
		ourSolutionButton.click();
		boolean ourSolutionButtonStatus = ourSolutionButton.isEnabled();
		return ourSolutionButtonStatus;
	}
	
	public void clickwhyTendableMenuButton() {
		whyTendableButton.click();
	}
	
	public boolean clickwhyTendableMenuButtonStaus() {
		whyTendableButton.click();
		boolean whyTendableButtonStatus = whyTendableButton.isEnabled();
		return whyTendableButtonStatus;
	}
	public boolean requestDemoButtonStatus() {
		boolean demoButtonStatus = requestDemoButton.isDisplayed();
		return demoButtonStatus;
	}
	
	public void clickRequestDemoButton() {
		requestDemoButton.click();
	}
}
