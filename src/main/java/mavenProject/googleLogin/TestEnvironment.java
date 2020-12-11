package mavenProject.googleLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestEnvironment {
	static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest extentTest;
	public ExtentHtmlReporter htmlReport;

	@BeforeSuite(alwaysRun = true)
	@Parameters({"option"})
	public void testEnvironment(String option) {
		System.out.println(option);
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resource\\java\\chromedriver.exe");
		if (option.contentEquals("false")) {
			driver = new ChromeDriver();
			Reporter.log("Open Chrome Browser.\n");
			driver.manage().window().maximize();
			Reporter.log("Maximize the browser window.\n");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("test-type");
			options.addArguments("--disable-notifications");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			Reporter.log("Open Chrome Browser in Incognito mode.\n");
			driver.manage().window().maximize();
			Reporter.log("Maximize the browser window.\n");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	@AfterSuite(alwaysRun = true)
	public void Endmethod() {
		Reporter.log("Close the browser window and end all browser related tasks.");
		driver.quit();
	}
	
	@BeforeTest
	public void setExtent() {

		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		htmlReport.config().setDocumentTitle("Automation testing");
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setReportName("Google Login Testing");
		htmlReport.config().setTheme(Theme.DARK);
		
		extent =new ExtentReports();
		extent.attachReporter(htmlReport);
	}
	
	
	@AfterTest
	public void endReport() {
		
		extent.flush();
	}

}
