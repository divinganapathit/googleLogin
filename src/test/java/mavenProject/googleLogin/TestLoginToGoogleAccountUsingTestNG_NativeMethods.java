package mavenProject.googleLogin;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginToGoogleAccountUsingTestNG_NativeMethods {

	WebDriver driver;

	@BeforeMethod
	public void initialMethod() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Com\\eclipse-workspace\\googleLogin\\src\\resource\\java\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		driver.navigate().to(getValue.getString("url"));

		driver.manage().window().maximize();

	}

	@Test(priority = 1, enabled = true)
	public void bothValid() {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		String u1 = getValue.getString("v_Username");
		String p1 = getValue.getString("v_Password");

		LoginPage login = new LoginPage(driver);

		login.bothValid(u1, p1);

	}

	@Test(priority = 2, enabled = true)
	public void invalidpassword() throws IOException {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		LoginPage login = new LoginPage(driver);

		login.invalidPassword(getValue.getString("v1_Username"), getValue.getString("i_Password"));

	}

	@Test(priority = 3, enabled = true)
	public void invalidUsername() throws IOException {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		LoginPage login = new LoginPage(driver);

		login.invalidUsername(getValue.getString("i_Username"));

	}

	@Test(priority = 4, enabled = true)
	public void bothInvalid() throws IOException {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		LoginPage login = new LoginPage(driver);

		login.bothInvalid(getValue.getString("i2_Username"));

	}

	@Test(priority = 5, enabled = true)
	public void clickNextPassword() throws IOException {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		LoginPage login = new LoginPage(driver);

		login.clickNextWithoutEnteringPassword(getValue.getString("v_Username"));

	}

	@Test(priority = 6, enabled = true)
	public void clickNextUsername() throws IOException {

		LoginPage login = new LoginPage(driver);

		login.clickNextWithoutEnteringUsername();

	}

	@AfterMethod(alwaysRun = true)
	public void finalmethod() {

		driver.close();
		driver.quit();

	}

}
