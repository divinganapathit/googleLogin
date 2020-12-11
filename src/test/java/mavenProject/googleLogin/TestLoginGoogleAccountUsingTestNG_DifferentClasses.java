package mavenProject.googleLogin;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import mavenProject.googleLogin.BasePage;
import mavenProject.googleLogin.LoginPage;

/*
 *Author 
 *Date
 *Info - This class is automated version of the test case for logging into Google account
 * 
 * */
public class TestLoginGoogleAccountUsingTestNG_DifferentClasses extends TestEnvironment {

	/*
	 * Method that test when both username and password are valid
	 * 
	 */
	@Test(priority = 1, enabled = true)
	public void bothValid() throws Exception {
		extentTest=extent.createTest("bothValid");
		BasePage basePage = new BasePage(driver);
		LoginPage login = new LoginPage(driver);
		login.bothValid(basePage.getData("v_Username"), basePage.getData("v_Password"));
	}

	/*
	 * Method to test when username is valid and password is invalid
	 * 
	 */
	@Test(priority = 2, enabled = true)
	public void invalidpassword() throws Exception {
		extentTest=extent.createTest("invalidpassword");
		BasePage basePage = new BasePage(driver);
		LoginPage login = new LoginPage(driver);
		login.invalidPassword(basePage.getData("v1_Username"), basePage.getData("i_Password"));
	}

	/*
	 * Method to test when username is invalid and password is valid
	 * 
	 */

	@Test(priority = 3, enabled = true)
	public void invalidUsername() throws Exception {
		extentTest=extent.createTest("invalidUsername");
		BasePage basePage = new BasePage(driver);
		LoginPage login = new LoginPage(driver);
		login.invalidUsername(basePage.getData("v1_Username"));
	}

	/*
	 * Method to test when both username and password is invalid
	 * 
	 */

	@Test(priority = 4, enabled = true)
	public void bothInvalid() throws Exception {
		extentTest=extent.createTest("bothInvalid");
		BasePage basePage = new BasePage(driver);
		LoginPage login = new LoginPage(driver);
		login.bothInvalid(basePage.getData("i2_Username"));
	}

	/*
	 * Method to test when username is valid but click on next without entering the
	 * password
	 * 
	 */

	@Test(priority = 5, enabled = true)
	public void clickNextPassword() throws Exception {
		extentTest=extent.createTest("clickNextPassword");
		BasePage basePage = new BasePage(driver);
		LoginPage login = new LoginPage(driver);
		login.clickNextWithoutEnteringPassword(basePage.getData("v_Username"));

	}

	/*
	 *  Click on next without entering
	 * 
	 * 
	 */

	@Test(priority = 6, enabled = true)
	public void clickNextUsername() throws Exception {
		extentTest=extent.createTest("clickNextUsername");
		LoginPage login = new LoginPage(driver);
		login.clickNextWithoutEnteringUsername();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		BasePage objBasePage = new BasePage(driver);

		if (result.getStatus() == ITestResult.FAILURE) {

			String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			extentTest.fail("<details>" + "<summary>" + "<b>" + "<font color =\'red\'>"
					+ "Exception Occured: Click to see" + "</font>" + "</b>" + "</summary>"
					+ exceptionMessage.replaceAll(",", "<br>") + "</details" + "\n");
			String failLog = "TEST CASE FAILED";
			String screenShotPath = objBasePage.capture();
			extentTest.log(Status.FAIL, "Snapshot below: " + extentTest.addScreenCaptureFromPath(screenShotPath));
			Markup m = MarkupHelper.createLabel(failLog, ExtentColor.RED);
			extentTest.log(Status.FAIL, m);

		} else if (result.getStatus() == ITestResult.SKIP) {

			String methodName = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE:" + methodName.toUpperCase() + "  SKIPPED" + "</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.CYAN);

			extentTest.skip(m);

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			String methodName = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE:" + methodName.toUpperCase() + "  PASSED" + "</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			extentTest.pass(m);

		}

	}
}
