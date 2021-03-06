package mavenProject.googleLogin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//input[@id='identifierId']")
	public WebElement input_Username;
	@FindBy(xpath = "//div[@class='Xb9hP']/input[@class='whsOnd zHQkBf' and @type='password']")
	public WebElement input_Password;
	@FindBy(xpath = "//div[contains(@class,'VfPpkd-RLmnJb')][1]")
	public WebElement username_Next;
	@FindBy(xpath = "(//div[@class='VfPpkd-RLmnJb'])[1]")
	public WebElement password_Next;
	@FindBy(xpath = "//span[contains(text(),'Wrong password. Try again or click Forgot password')]")
	public WebElement wrong_Password;
	@FindBy(xpath = "//span[contains(text(),'Enter a password')]")
	public WebElement enter_Password;
	@FindBy(xpath = "//div[contains(@class,'o6cuMc')]")
	public WebElement username_NotFound;
	@FindBy(xpath = "//img[contains(@class,'gb_Ha gbii'])")
	public WebElement logout_Option;
	@FindBy(xpath = "//a[@id='gb_71' and @class='gb_Hb gb_fg gb_ng gb_2e gb_7c']")
	public WebElement logout_button;

	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void bothValid( String username, String password) {

//		basePage.entersLoginPageURL();
		driver.navigate().to(getData("url"));
		Reporter.log("Go on to URL -\"https://accounts.google.com/\".\n");
		input_Username.sendKeys(username);
		Reporter.log("Enter a valid username that is stored in properties file.\n");
		username_Next.click();
		Reporter.log("Click on next.\n");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		delay(input_Password);
		Reporter.log("Enter a valid password that is stored in properties file.\n");
		input_Password.sendKeys(password);
		delay(password_Next);
		password_Next.click();
		Reporter.log("Click on next.\n");
		System.out.println("Logged into page sucessfully");
//		wait.until(ExpectedConditions.visibilityOf(logout_Option));
//		logout_Option.click();
//		logout_button.click();
		System.out.println("Successfully logged in and logged out of the account");

	}

	public void invalidPassword( String username, String password) throws IOException {

//		basePage.entersLoginPageURL();
		driver.navigate().to(getData("url"));
		Reporter.log("Go on to URL -\"https://accounts.google.com/\".\n");
		input_Username.sendKeys(username);
		Reporter.log("Enter a valid username that is stored in properties file.\n");
		username_Next.click();
		Reporter.log("Click on next.\n");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		delay(input_Password);
		Reporter.log("Enter an invalid password that is stored in properties file.\n");
		input_Password.sendKeys(password);
		delay(password_Next);
		password_Next.click();
		Reporter.log("Click on next.\n");
		System.out.println(wrong_Password.toString());
		System.out.println(wrong_Password);
//		basePage.delay(wrong_Password);
		Assert.assertEquals(getExcelData(0), wrong_Password.getText());
		System.out.println(wrong_Password.getText());
		System.out.println("Could not login because of invalid Password");

	}

	public void invalidUsername(String username) throws IOException {

//		basePage.entersLoginPageURL();
		driver.navigate().to(getData("url"));
		Reporter.log("Go on to URL -\"https://accounts.google.com/\".\n");
		input_Username.sendKeys(username);
		Reporter.log("Enter an invalid username that is stored in properties file.\n");
		username_Next.click();
		Reporter.log("Click on next.\n");
		WebDriverWait wait = new WebDriverWait(driver, 5);
//		delay(username_NotFound);
		Assert.assertEquals(getExcelData(1), username_NotFound.getText());
		System.out.println(username_NotFound.getText());
		System.out.println("Could not login beecause of invalid Username");

	}

	public void bothInvalid(String username) throws IOException {

//		basePage.entersLoginPageURL();
		driver.navigate().to(getData("url"));
		Reporter.log("Go on to URL -\"https://accounts.google.com/\".\n");
		input_Username.sendKeys(username);
		Reporter.log("Enter an invalid username that is stored in properties file.\n");
		username_Next.click();
		Reporter.log("Click on next.\n");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		delay(username_NotFound);
		Assert.assertEquals(getExcelData(2), username_NotFound.getText());
		System.out.println(username_NotFound.getText());
		System.out.println("Could not login beecause of invalid Username");
		System.out.println("Since the username itself was invalid it didnot move the password page");

	}

	public void clickNextWithoutEnteringPassword(String username) throws IOException {

//		basePage.entersLoginPageURL();
		driver.navigate().to(getData("url"));
		Reporter.log("Go on to URL -\"https://accounts.google.com/\".\n");
		input_Username.sendKeys(username);
		Reporter.log("Enter a valid username that is stored in properties file.\n");
		username_Next.click();
		Reporter.log("Click on next.\n");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		delay(input_Password);
		password_Next.click();
		Reporter.log("Click on next without entering password.\n");
		Assert.assertEquals("Enter a password", enter_Password.getText());
		softAssert.assertTrue(getExcelData(3) == enter_Password.getText());
		System.out.println("Could not login because password was not entered");

	}

	public void clickNextWithoutEnteringUsername() throws IOException {

//		basePage.entersLoginPageURL();
		driver.navigate().to(getData("url"));
		Reporter.log("Go on to URL -\"https://accounts.google.com/\".\n");
		username_Next.click();
		Reporter.log("Click on next without entering the username.\n");
		softAssert.assertEquals("Enter an email or phone number", username_NotFound.getText());
		softAssert.assertTrue(getExcelData(4) == username_NotFound.getText(), "true");
		System.out.println("Could not login because username was not entered");

	}

}
