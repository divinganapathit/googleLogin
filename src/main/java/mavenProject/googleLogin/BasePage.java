package mavenProject.googleLogin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import mavenProject.utilities.ExcelData;

public class BasePage {

	static LoginPage login;
	static WebDriver driver =new ChromeDriver();
	public static ResourceBundle getvalue = ResourceBundle.getBundle("inputData");
	public static BasePage basePage = new BasePage();
	public static SoftAssert softAssert = new SoftAssert();

	public static String getExcelData(int index) throws IOException {

		ExcelData expectedData = new ExcelData();
		List<String> excelValue = new ArrayList<String>();
		excelValue = expectedData.readData();
		return excelValue.get(index);

	}

	@BeforeMethod
	public void entersLoginPageURL() {

		driver.navigate().to(getData("url"));
		login = new LoginPage(driver);

	}

	public static String getData(String key) {

		return getvalue.getString(key);

	}

	public void delay(WebElement xPath) {

		String uneditedLocator = xPath.toString();
		String locatorInfo = uneditedLocator.substring(80);
		System.out.println(locatorInfo);
		double startTime = System.currentTimeMillis();
		List<WebElement> findElement = driver.findElements(By.xpath(locatorInfo));

		boolean status = false;
		int i = 0;
		double waitTime = 0;
		while (i == 0 && waitTime < 180000) {

			findElement = driver.findElements(By.xpath(locatorInfo));
			i = findElement.size();
			if (i > 0) {
				status = true;
				break;
			}
			double endTime = System.currentTimeMillis();
			waitTime = endTime - startTime;

		}
		if (status == false) {

			System.out.println("Element not Found!!");

		}
	}

}
