package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumActivity2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");
		System.out.println("Page title: " + driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		// driver.findElement(By.className("svelte-1pdjkmx")); // there are 5 matches with classname. Hence it wont perform the action
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		driver.quit();

	}
}
