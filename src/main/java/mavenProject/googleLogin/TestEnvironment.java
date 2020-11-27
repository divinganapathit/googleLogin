package mavenProject.googleLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class TestEnvironment extends BasePage {

	@BeforeSuite
	@Parameters("option")
	public void testEnvironment(String option) {

		if (option == "false") {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\resource\\java\\chromedriver.exe");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else {

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-incognito");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\resource\\java\\chromedriver.exe");
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

	}

}
