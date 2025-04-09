package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/target-practice");
	}

	@Test
	public void pageTitle() {
		Assert.assertEquals(driver.getTitle(), "Target Practice");
	}

	@Test
	public void blackButton() {
		Assert.assertEquals(driver.findElement(By.xpath("//button[text()='Black']")).getText(), "black");
	}

	@Test(enabled = false)
	public void testCase3() {
		String subHeading = driver.findElement(By.className("sub")).getText();
		Assert.assertTrue(subHeading.contains("Practice"));
	}

	@Test
	public void testCase4() {
		throw new SkipException("Skipping test case");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
