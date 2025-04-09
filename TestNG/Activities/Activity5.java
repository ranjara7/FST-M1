package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

	WebDriver driver;

	@BeforeClass(alwaysRun=true)
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/target-practice/");

	}
	
	@Test (groups = {"HeaderTests", "ButtonTests"})
	public void pageTitleTest() {
		System.out.println(driver.getTitle());
	}

	@Test(groups = {"HeaderTests"})
	public void header3Test() {
		Assert.assertEquals(driver.findElement(By.id("third-header")).getText(), "Third header");
	}

	@Test(groups = {"HeaderTests"})
	public void header5Test() {
		Assert.assertEquals(driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color"),
				"rgb(33, 186, 69)");
	}

	@Test(groups = {"ButtonTests"})
	public void ButtonTest1() {
		WebElement button1 = driver.findElement(By.cssSelector("button.olive"));
		Assert.assertEquals(button1.getText(), "Olive");
	}

	@Test(groups = {"ButtonTests"})
	public void ButtonTest2() {
		WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
		Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
