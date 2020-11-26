package mavenProject.googleLogin;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {

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

		GoogleLogin login = new GoogleLogin(driver);

		login.bothValid(driver, u1, p1);

	}

	@Test(priority = 2, enabled = true)
	public void invalidpassword() {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		GoogleLogin login = new GoogleLogin(driver);

		login.invalidPassword(driver, getValue.getString("v1_Username"), getValue.getString("i_Password"));

	}

	@Test(priority = 3, enabled = true)
	public void invalidUsername() {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		GoogleLogin login = new GoogleLogin(driver);

		login.invalidUsername(driver, getValue.getString("i_Username"));

	}

	@Test(priority = 4, enabled = true)
	public void bothInvalid() {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		GoogleLogin login = new GoogleLogin(driver);

		login.bothInvalid(driver, getValue.getString("i2_Username"));

	}

	@Test(priority = 5, enabled = true)
	public void clickNextPassword() {

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		GoogleLogin login = new GoogleLogin(driver);

		login.clickNextWithoutPassword(driver, getValue.getString("v_Username"));

	}

	@Test(priority = 6, enabled = true)
	public void clickNextUsername() {

		GoogleLogin login = new GoogleLogin(driver);

		login.clickNextWithoutUsername();

	}

	@AfterMethod(alwaysRun = true)
	public void finalmethod() {

		driver.close();
		driver.quit();

	}

}
