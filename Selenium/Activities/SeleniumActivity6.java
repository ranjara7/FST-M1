package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumActivity6 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		WebElement cb= driver.findElement(By.id("checkbox"));
		System.out.println("Page title: " +driver.getTitle());
		System.out.println("checkbox is selected? "+cb.isSelected());
		cb.click();
		System.out.println("checkbox is selected? "+cb.isSelected());
		driver.quit();
	}

}
