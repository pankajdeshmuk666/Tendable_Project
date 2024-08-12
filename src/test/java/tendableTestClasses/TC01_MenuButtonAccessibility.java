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
import utilityClasses.Utility;

public class TC01_MenuButtonAccessibility {

	public static WebDriver driver;
	public HomePage home;
	String tcid;

	@BeforeClass
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver", Configuration.buildpath);
		driver = new ChromeDriver();
		home = new HomePage(driver);
		driver.manage().window().maximize();
		driver.get(Configuration.urlTandable);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	}

	@BeforeMethod
	public void waitBeforePageLoad() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	}

	@Test
	public void verifyAccessibilityOfHomeButton() {
		tcid="101";
		Reporter.log("----Verifying accessibility of home button ----",true);
		home.clickHomeMenuButton();
		String ExpectedResult = Configuration.urlTandable;
		System.out.println("Expected Result=" + ExpectedResult);
		String ActualResult = driver.getCurrentUrl();
		System.out.println("Actual Result=" + ActualResult);
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test
	public void verifyAccessibilityOfOurStoryButton() {
		tcid="102";
		Reporter.log("----Verifying accessibility of our story button ----",true);
		home.clickOurStoryMenuButton();
		String ActualResult = driver.getTitle();
		System.out.println("Actual Result=" + ActualResult);
		String ExpectedResult = "Our Story | Quality Improvement Solution | Tendable | Tendable";
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test
	public void verifyAccessibilityOfOurStoryButtonByStatus() {
		tcid="103";
		Reporter.log("----Verifying accessibility of our Story button ----",true);
		home.clickOurStoryMenuButtonStaus();
		System.out.println(home.clickOurStoryMenuButtonStaus());
		Assert.assertTrue(home.clickOurStoryMenuButtonStaus());
	}

	@Test
	public void verifyAccessibilityOfOurSolutionButton() {
		tcid="104";
		Reporter.log("----Verifying accessibility of our solution button ----",true);
		home.clickOurSolutionMenuButton();
		String ActualResult = driver.getTitle();
		System.out.println("Actual Result=" + ActualResult);
		String ExpectedResult = "Quality Improvement App | Health and Social Care | Tendable";
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test
	public void verifyAccessibilityOfOurSolutionButtonByStatus() {
		tcid="105";
		Reporter.log("----Verifying accessibility of our solution button ----",true);
		home.clickOurSolutionMenuButtonStaus();
		System.out.println(home.clickOurSolutionMenuButtonStaus());
		Assert.assertTrue(home.clickOurSolutionMenuButtonStaus());
	}

	@Test
	public void verifyAccessibilityOfWhyTendableButton() {
		tcid="106";
		Reporter.log("----Verifying accessibility of why Tendable button ----",true);
		home.clickwhyTendableMenuButton();
		String ActualResult = driver.getTitle();
		System.out.println("Actual Result=" + ActualResult);
		String ExpectedResult = "Why Tendable? Quality Improvement Solution | Tendable | Tendable";
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test
	public void verifyAccessibilityOfWhyTendableButtonByStatus() {
		tcid="107";
		Reporter.log("----Verifying accessibility of why Tendable Button ----",true);
		home.clickwhyTendableMenuButton();
		System.out.println(home.clickwhyTendableMenuButtonStaus());
		Assert.assertTrue(home.clickwhyTendableMenuButtonStaus());
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
