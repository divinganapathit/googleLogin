package mavenProject.googleLogin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/*
 *Author 
 *Date
 *Info - This class is automated version of the test case for logging into Google account
 * 
 * */
public class TestLoginGoogleAccountUsingTestNG_DifferentClasses extends TestEnvironment {

	BasePage basePage = new BasePage(driver);
	LoginPage login = new LoginPage(driver);

	
	/*
	 * Method that test when both username and password are valid
	 * 
	 * */
	@Test(priority = 1, enabled = true)
	public void bothValid() {

		login.bothValid(basePage.getData("v_Username"), basePage.getData("v_Password"));

	}

	/*
	 * Method to test when username is valid and password is invalid
	 * 
	 * */
	@Test(priority = 2, enabled = true)
	public void invalidpassword() throws IOException {

		login.invalidPassword( basePage.getData("v1_Username"), basePage.getData("i_Password"));

	}

	/*
	 * Method to test when username is invalid and password is valid
	 * 
	 * */
	
	@Test(priority = 3, enabled = true)
	public void invalidUsername() throws IOException {

		login.invalidUsername(basePage.getData("v1_Username"));

	}

	/*
	 * Method to test when both username and password is invalid
	 * 
	 * */
	
	@Test(priority = 4, enabled = true)
	public void bothInvalid() throws IOException {

		login.bothInvalid(basePage.getData("i2_Username"));

	}

	/*
	 * Method to test when username is valid but click on next without entering the password
	 * 
	 * */
	
	@Test(priority = 5, enabled = true)
	public void clickNextPassword() throws IOException {

		login.clickNextWithoutEnteringPassword(basePage.getData("v_Username"));

	}

	/*
	 /* Click on next without entering 
	 * 
	 * 
	 * */
	
	@Test(priority = 6, enabled = true)
	public void clickNextUsername() throws IOException {

		login.clickNextWithoutEnteringUsername();

	}

}
