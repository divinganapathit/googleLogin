package mavenProject.googleLogin;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass {

	static GoogleLogin login;
	static WebDriver driver;
	public static ResourceBundle getvalue = ResourceBundle.getBundle("inputData");

	public BaseClass(boolean option) {
		if (option == false) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\resource\\java\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(getvalue.getString("url"));
			login = new GoogleLogin(driver);

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
			driver.navigate().to(getvalue.getString("url"));
			login = new GoogleLogin(driver);

		}

	}

	public static String getData(String key) {

		return getvalue.getString(key);

	}

	public void Endmethod() {

		driver.close();
		driver.quit();

	}

}
