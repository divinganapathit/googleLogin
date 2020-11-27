package mavenProject.googleLogin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//input[@id='identifierId']")
	public WebElement input_Username;

	@FindBy(xpath = "//div[@class='Xb9hP']/input[@class='whsOnd zHQkBf' and @type='password']")
	public WebElement input_Password;

	@FindBy(xpath = "//div[contains(@class,'VfPpkd-RLmnJb')][1]")
	public WebElement username_Next;

	@FindBy(xpath = "//div[contains(@class,'VfPpkd-RLmnJb')][1]")
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

		PageFactory.initElements(driver, this);

	}

	public void bothValid(WebDriver driver, String username, String password) {

//		basePage.entersLoginPageURL();
		input_Username.sendKeys(username);
		username_Next.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(input_Password));
		input_Password.sendKeys(password);
		password_Next.click();
		System.out.println("Logged into page sucessfully");
//		wait.until(ExpectedConditions.visibilityOf(logout_Option));
//		logout_Option.click();
//		logout_button.click();
		System.out.println("Successfully logged in and logged out of the account");

	}

	public void invalidPassword(WebDriver driver, String username, String password) throws IOException {

//		basePage.entersLoginPageURL();
		input_Username.sendKeys(username);
		username_Next.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(input_Password));
		input_Password.sendKeys(password);
		password_Next.click();
		wait.until(ExpectedConditions.visibilityOf(wrong_Password));
		Assert.assertEquals(getExcelData(0), wrong_Password.getText());
		System.out.println(wrong_Password.getText());
		System.out.println("Could not login because of invalid Password");

	}

	public void invalidUsername(WebDriver driver, String username) throws IOException {

//		basePage.entersLoginPageURL();
		input_Username.sendKeys(username);
		username_Next.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(username_NotFound));
		Assert.assertEquals(getExcelData(1), username_NotFound.getText());
		System.out.println(username_NotFound.getText());
		System.out.println("Could not login beecause of invalid Username");

	}

	public void bothInvalid(WebDriver driver, String username) throws IOException {

//		basePage.entersLoginPageURL();
		input_Username.sendKeys(username);
		username_Next.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(username_NotFound));
		Assert.assertEquals(getExcelData(2), username_NotFound.getText());
		System.out.println(username_NotFound.getText());
		System.out.println("Could not login beecause of invalid Username");
		System.out.println("Since the username itself was invalid it didnot move the password page");

	}

	public void clickNextWithoutEnteringPassword(WebDriver driver, String username) throws IOException {

//		basePage.entersLoginPageURL();
		input_Username.sendKeys(username);
		username_Next.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(input_Password));
		password_Next.click();
		Assert.assertEquals("Enter a password", enter_Password.getText());
		softAssert.assertTrue(getExcelData(3) == enter_Password.getText());
		System.out.println("Could not login because password was not entered");

	}

	public void clickNextWithoutEnteringUsername() throws IOException {

//		basePage.entersLoginPageURL();
		username_Next.click();
		softAssert.assertEquals("Enter an email or phone number", username_NotFound.getText());
		softAssert.assertTrue(getExcelData(4) == username_NotFound.getText(), "true");
		System.out.println("Could not login because username was not entered");

	}

}
