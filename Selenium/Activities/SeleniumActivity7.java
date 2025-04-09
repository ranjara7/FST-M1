package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumActivity7 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Page title: " + driver.getTitle());
		WebElement ta=driver.findElement(By.id("textInput"));
		System.out.println("text area is enabled? "+ta.isEnabled());
		driver.findElement(By.id("textInputButton")).click();
		System.out.println("text area is enabled? "+ta.isEnabled());
		driver.quit();

	}

}
