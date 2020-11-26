package mavenProject.googleLogin;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJava {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Com\\eclipse-workspace\\googleLogin\\src\\resource\\java\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.navigate().to("https://accounts.google.com/");

		driver.manage().window().maximize();

		ResourceBundle getValue = ResourceBundle.getBundle("inputData");

		GoogleLogin login = new GoogleLogin(driver);

		try {

			String u1 = getValue.getString("v_Username");
			String p1 = getValue.getString("v_Password");
			
			login.bothValid(driver, u1, p1);

//			login.invalidPassword(driver, getValue.getString("v1_Username"), getValue.getString("i_Password"));
			
//			login.invalidUsername(driver, getValue.getString("i_Username"));
			
//			login.bothInvalid(driver, getValue.getString("i2_Username"));
			
//			login.clickNextWithoutPassword(driver, u1);
			
//			login.clickNextWithoutUsername();
			

		} catch (Exception e) {

			System.out.println(e);

		} finally {

			driver.close();
			driver.quit();

		}
	}

}