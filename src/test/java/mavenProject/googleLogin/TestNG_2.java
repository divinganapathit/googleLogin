package mavenProject.googleLogin;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNG_2 extends BasePage {

	@Test(priority = 1, enabled = true)
	public void bothValid() {

		login.bothValid(TestEnvironment.driver, getData("v_Username"), getData("v_Password"));

	}

	@Test(priority = 2, enabled = true)
	public void invalidpassword() throws IOException {

		login.invalidPassword(driver, getData("v1_Username"), getData("i_Password"));

	}

	@Test(priority = 3, enabled = true)
	public void invalidUsername() throws IOException {

		login.invalidUsername(driver, getData("v1_Username"));

	}

	@Test(priority = 4, enabled = true)
	public void bothInvalid() throws IOException {

		login.bothInvalid(driver, getData("i2_Username"));

	}

	@Test(priority = 5, enabled = true)
	public void clickNextPassword() throws IOException {

		login.clickNextWithoutEnteringPassword(driver, getData("v_Username"));

	}

	@Test(priority = 6, enabled = true)
	public void clickNextUsername() throws IOException {

		login.clickNextWithoutEnteringUsername();

	}
	
	@AfterMethod
	public void Endmethod() {

		driver.close();
		driver.quit();

	}
}
