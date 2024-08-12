package tendablePom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	@FindBy(xpath ="//a[text()='Contact Us']")private WebElement contactUsButton;
	@FindBy(xpath ="(//button[text()='Contact'])[1]")private WebElement markatingConnectButton;
	@FindBy(xpath ="(//input[@id='form-input-fullName'])[1]")private WebElement firstNameInputField;
	@FindBy(xpath ="(//input[@id='form-input-organisationName'])[1]")private WebElement organisationNameInputField;
	@FindBy(xpath ="(//input[@id='form-input-cellPhone'])[1]")private WebElement phoneNumberInputField;
	@FindBy(xpath ="(//input[@id='form-input-email'])[1]")private WebElement emailInputField;
	@FindBy(xpath ="(//select[@id='form-input-jobRole'])[1]")private WebElement jobRoleDropdown;
	@FindBy(xpath ="(//select[@id='form-input-jobRole'])[1]//option[text()='Management']")private WebElement jobRoleDropdownOption;
	@FindBy(xpath ="(//textarea[@id='form-input-message'])[1]")private WebElement messageInputField;
	@FindBy(xpath ="(//input[@id='form-input-consentAgreed-0'])[1]")private WebElement iAgreeRadioButton ;
	@FindBy(xpath ="(//button[text()='Submit'])[1]")private WebElement submitButton;
	@FindBy(xpath ="//p[text()='Sorry, there was an error submitting the form. Please try again.']")private WebElement errorMessage;
	
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}
	
	public void clickOnContactUsMenuButton() {
		contactUsButton.click();
	}
	
	public void clickOnMarketPlaceConnectButton() {
		markatingConnectButton.click();
	}
	
	public void enterFirstName(String firstName) {
		firstNameInputField.sendKeys(firstName);
	}
	
	public void enterOrganisationName(String organisationName) {
		organisationNameInputField.sendKeys(organisationName);
	}
	
	public void enterPhoneNumber(String phoneNumber) {
		phoneNumberInputField.sendKeys(phoneNumber);
	}
	
	public void enterEmail(String email) {
		emailInputField.sendKeys(email);
	}
	
	public void selectJobRoleFromDropdown() {
		jobRoleDropdown.click();
		jobRoleDropdownOption.click();
	}
	
	public void clickOnIAgreeRadioButton() {
		iAgreeRadioButton.click();
	}
	
	public void submitForm() {
		submitButton.click();
	}
	
	public boolean erroMessageIsDisplayedStatus() {
		boolean errorMessageStatus = errorMessage.isDisplayed();
		return errorMessageStatus;
	}
}
