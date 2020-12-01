package mavenProject.googleLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestEnvironment {

	static WebDriver driver;

	@BeforeMethod
	@Parameters("option")
	public void testEnvironment(String option) {

		System.out.println(option);
		if (option.contentEquals("false") == true) {
			System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + "\\src\\resource\\java\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		if (option.contentEquals("true") == true) {

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-incognito");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\resource\\java\\chromedriver.exe");
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else {

			System.out.println("Invalid Input");

		}

	}

	@AfterMethod
	public void Endmethod() {

		driver.close();
		driver.quit();

	}

}
