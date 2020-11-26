package mavenProject.googleLogin;

import java.util.ResourceBundle;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNG_2 {
	
	static BaseClass test;

	public void initialStep() {

		test = new BaseClass(true);

	}

	@Test(priority = 1, enabled = true)
	public void bothValid() {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		String u1 = getValue.getString("v_Username");
		String p1 = getValue.getString("v_Password");

		BaseClass.login.bothValid(BaseClass.driver, u1, p1);

	}

	@Test(priority = 2, enabled = true)
	public void invalidpassword() {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		BaseClass.login.invalidPassword(BaseClass.driver, getValue.getString("v1_Username"),
				getValue.getString("i_Password"));

	}

	@Test(priority = 3, enabled = true)
	public void invalidUsername() {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		BaseClass.login.invalidUsername(BaseClass.driver, getValue.getString("i_Username"));

	}

	@Test(priority = 4, enabled = true)
	public void bothInvalid() {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		BaseClass.login.bothInvalid(BaseClass.driver, getValue.getString("i2_Username"));

	}

	@Test(priority = 5, enabled = true)
	public void clickNextPassword() {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		BaseClass.login.clickNextWithoutPassword(BaseClass.driver, getValue.getString("v_Username"));

	}

	@Test(priority = 6, enabled = true)
	public void clickNextUsername() {

		BaseClass.login.clickNextWithoutUsername();

	}

	@AfterMethod(alwaysRun = true)
	public void finalmethod() {
		
	test.Endmethod();

	}
}
