package mavenProject.googleLogin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

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
		BasePage basePage = new BasePage(driver);
		LoginPage login = new LoginPage(driver);
		login.clickNextWithoutEnteringPassword(basePage.getData("v_Username"));

	}

	/*
	 * /* Click on next without entering
	 * 
	 * 
	 */

	@Test(priority = 6, enabled = true)
	public void clickNextUsername() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.clickNextWithoutEnteringUsername();
	}
}
