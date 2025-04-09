package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumActivity4 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
		System.out.println("Page title: " + driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'#3')]")).getText());
	    System.out.println(driver.findElement(By.xpath("//h5[text()='Heading #5']")).getCssValue("color"));
	    System.out.println(driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class"));
	    System.out.println(driver.findElement(By.xpath("//button[text()='Slate']")).getText());
	    driver.quit();
	}
}
