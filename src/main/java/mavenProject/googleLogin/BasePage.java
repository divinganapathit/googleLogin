package mavenProject.googleLogin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import mavenProject.utilities.ExcelData;

public class BasePage {

	WebDriver driver;
	ResourceBundle getvalue = ResourceBundle.getBundle("inputData");
	SoftAssert softAssert = new SoftAssert();

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getExcelData(int index) throws IOException {
		ExcelData expectedData = new ExcelData();
		List<String> excelValue = new ArrayList<String>();
		excelValue = expectedData.readData();
		return excelValue.get(index);

	}

	public String getData(String key) {
		return getvalue.getString(key);
	}

	public boolean delay(WebElement xPath) {
		String uneditedLocator = xPath.toString();
		String locatorInfoUnedited = uneditedLocator.substring(80);
		System.out.println(locatorInfoUnedited);
		int n = locatorInfoUnedited.length();
		String locatorInfo = locatorInfoUnedited.substring(0, n - 1);
		System.out.println(locatorInfo);
		long startTime = System.currentTimeMillis();
		List<WebElement> findElement = driver.findElements(By.xpath(locatorInfo));
		boolean status = findElement.size() > 0;
		long waitTime = 0;

		while (!(status) && (waitTime < 120000)) {
			findElement = driver.findElements(By.xpath(locatorInfo));
			status = findElement.size() > 0;
			waitTime = System.currentTimeMillis() - startTime;
			System.out.println(waitTime);
		}
		if (status == false) {
			System.out.println("Element not Found!!");
		}

		return status;
	}

	public void getScreenShot() throws IOException {

		Date currentDate = new Date();
		String screenshotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenshotFolder = new File(".//screenshot//" + screenshotFileName + ".png");
		FileUtils.copyFile(screenshotFile, screenshotFolder);
		Reporter.log("<br><img src='" + screenshotFolder + "' alt='error screenshot' height='400' width='400'/><br>");
	}

	public String capture() throws IOException {
		Date currentDate = new Date();
		String screenshotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = ".//screenshot//" + screenshotFileName + ".png";
		File screenshotFolder = new File(destination);
		FileUtils.copyFile(screenshotFile, screenshotFolder);

		return destination;
	}

}
