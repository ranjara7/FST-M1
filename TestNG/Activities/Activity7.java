package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/login-form");
	}

	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		return new Object[][] { { "admin", "password" }, 
			                    { "adminwrong", "password" } };
	}

	@Test(dataProvider = "Authentication")
	public void loginTestCase(String username, String password) {
		driver.navigate().refresh();
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals(loginMessage, "Welcome Back, admin");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
