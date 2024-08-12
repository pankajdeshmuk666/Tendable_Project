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

import configuration.Configuration;
import tendablePom.HomePage;
import tendablePom.RequestDemoPage;
import utilityClasses.Utility;

public class TC02_RequestDemoButton {

	public static WebDriver driver;
	public HomePage home;
	public RequestDemoPage demo;
	String tcid;
	
	@BeforeClass
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver", Configuration.buildpath);
		driver = new ChromeDriver();
		home = new HomePage(driver);
		demo=new RequestDemoPage(driver);
		driver.manage().window().maximize();
		driver.get(Configuration.urlTandable);
	}
	
	@BeforeMethod
	public void waitBeforePageLoad() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	}
	
	@Test
	public void VerifyDemoButtonStatusOnHomePage() {
		tcid="201";
		Reporter.log("----Verifying Request Demo Button is presend on home Page ----",true);
		home.clickHomeMenuButton();
		Assert.assertTrue(home.requestDemoButtonStatus());
	}
	
	@Test
	public void VerifyDemoButtonStatusOnOurStoryPage() {
		tcid="202";
		Reporter.log("----Verifying Request Demo Button is presend on our story Page ----",true);
		home.clickOurStoryMenuButton();
		Assert.assertTrue(home.requestDemoButtonStatus());
	}
	
	@Test
	public void VerifyDemoButtonStatusOnOurSolutionPage() {
		tcid="203";
		Reporter.log("----Verifying Request Demo Button is presend on our solution Page ----",true);
		home.clickOurSolutionMenuButton();
		Assert.assertTrue(home.requestDemoButtonStatus());
	}
	
	@Test
	public void VerifyDemoButtonStatusOnWhyTendablePage() {
		tcid="204";
		Reporter.log("----Verifying Request Demo Button is presend on why Tendable Page ----",true);
		home.clickwhyTendableMenuButton();
		Assert.assertTrue(home.requestDemoButtonStatus());
	}
	
	@Test
	public void VerifyDemoButtonIsActiveOnHomePage() {
		tcid="205";
		Reporter.log("----Verify domo button is active on the home page----", true);
		home.clickHomeMenuButton();
		home.clickRequestDemoButton();
		Assert.assertTrue(demo.requestDemoFormTitleIsDisplayed());
	}
	
	@Test
	public void VerifyDemoButtonIsActiveOnOurStoryPage() {
		tcid="206";
		Reporter.log("----Verify domo button is active on the our story page----", true);
		home.clickOurStoryMenuButton();
		home.clickRequestDemoButton();
		Assert.assertTrue(demo.requestDemoFormTitleIsDisplayed());
	}
	
	@Test
	public void VerifyDemoButtonIsActiveOnOurSolutionPage() {
		tcid="207";
		Reporter.log("----Verify domo button is active on the our solution page----", true);
		home.clickOurSolutionMenuButton();
		home.clickRequestDemoButton();
		Assert.assertTrue(demo.requestDemoFormTitleIsDisplayed());
	}
	
	@Test
	public void VerifyDemoButtonIsActiveOnWhyTendablePage() {
		tcid="208";
		Reporter.log("----Verify domo button is active on the why tendable page----", true);		
		home.clickwhyTendableMenuButton();
		home.clickRequestDemoButton();
		Assert.assertTrue(demo.requestDemoFormTitleIsDisplayed());
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
