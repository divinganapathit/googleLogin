package mavenProject.googleLogin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestLoginGoogleAccountUsingTestNG_DifferentClasses extends TestEnvironment {

	BasePage basePage = new BasePage();
	WebDriver driver = basePage.driverMethod();
	LoginPage login = new LoginPage(driver);

	@Test(priority = 1, enabled = true)
	public void bothValid() {

		login.bothValid(driver, BasePage.getData("v_Username"), BasePage.getData("v_Password"));

	}

	@Test(priority = 2, enabled = true)
	public void invalidpassword() throws IOException {

		login.invalidPassword(driver, BasePage.getData("v1_Username"), BasePage.getData("i_Password"));

	}

	@Test(priority = 3, enabled = true)
	public void invalidUsername() throws IOException {

		login.invalidUsername(driver, BasePage.getData("v1_Username"));

	}

	@Test(priority = 4, enabled = true)
	public void bothInvalid() throws IOException {

		login.bothInvalid(driver, BasePage.getData("i2_Username"));

	}

	@Test(priority = 5, enabled = true)
	public void clickNextPassword() throws IOException {

		login.clickNextWithoutEnteringPassword(driver, BasePage.getData("v_Username"));

	}

	@Test(priority = 6, enabled = true)
	public void clickNextUsername() throws IOException {

		login.clickNextWithoutEnteringUsername();

	}

}
