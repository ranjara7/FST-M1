package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumActivity5 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();	
		driver.get("https://training-support.net/webelements/dynamic-controls");
		WebElement cb= driver.findElement(By.id("checkbox"));
		System.out.println("Page title: " + driver.getTitle());
        System.out.println(cb.isDisplayed());
        driver.findElement(By.xpath("//button[contains(text(),'Toggle ')]")).click();
        System.out.println(cb.isDisplayed());
        driver.quit();
        
	}

}
