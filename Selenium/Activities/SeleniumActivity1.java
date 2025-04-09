package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumActivity1 {
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net");
		System.out.println("Page title: "+driver.getTitle());
		driver.findElement(By.linkText("About Us")).click();
		System.out.println("New page title: "+driver.getTitle());
		driver.quit();
		
	}

}
