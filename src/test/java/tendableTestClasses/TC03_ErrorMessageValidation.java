package tendableTestClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import configuration.Configuration;
import tendablePom.ContactUsPage;
import utilityClasses.Utility;

public class TC03_ErrorMessageValidation {

	public static WebDriver driver;
	public ContactUsPage cont;
	String tcid;
	
	@BeforeClass
	public void launchApplication() throws IOException {
		System.setProperty("webdriver.chrome.driver", Configuration.buildpath);
		driver = new ChromeDriver();
		cont = new ContactUsPage(driver);
		driver.manage().window().maximize();
		driver.get(Configuration.urlTandable);
	}
	
	@BeforeMethod
	public void waitBeforePageAndElementLoad() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	}
	
	@Test
	public void validatingErroMessageForContactUsMarkatingFormPage() throws IOException {
		tcid="301";
		Reporter.log("-------Verifing error message contact us marketing form page",true);
		
		cont.clickOnContactUsMenuButton();
		cont.clickOnMarketPlaceConnectButton();
		cont.clickOnMarketPlaceConnectButton();
		cont.enterFirstName(Utility.readPropertyFileData("firstName"));
		cont.enterOrganisationName(Utility.readPropertyFileData("organizationName"));
		cont.enterPhoneNumber(Utility.readPropertyFileData("phoneNumber"));
		cont.enterEmail(Utility.readPropertyFileData("email"));
		cont.selectJobRoleFromDropdown();
		cont.clickOnIAgreeRadioButton();
		cont.submitForm();
		
		Assert.assertTrue(cont.erroMessageIsDisplayedStatus());
	}
	
	@AfterMethod
	public void getStatusOfFailTest(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus()) {
			Thread.sleep(5000);
			Utility.captureScreenshot(driver, tcid);
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
