package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 {
	WebDriver driver;
	String title;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/");
	}

	@Test(priority=1)
	public void pageTitleTest() {
	    title = driver.getTitle();
		Assert.assertEquals(title,"Training Support");
	}

	@Test(priority=2)
	public void aboutUsTest() {
		driver.findElement(By.linkText("About Us")).click();
	    title = driver.getTitle();
		Assert.assertEquals(title, "About Training Support");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();	
	}

}
