package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActivity8 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);

		driver.get("https://training-support.net/webelements/mouse-events");
		System.out.println("Page title: " + driver.getTitle());
		WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
        WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
        WebElement srcButton = driver.findElement(By.xpath("//h1[text()='src']"));
        WebElement targetButton = driver.findElement(By.xpath("//h1[text()='target']"));
        builder.click(cargoLock).moveToElement(cargoToml).click(cargoToml).build().perform();
        String actionMessage = driver.findElement(By.id("result")).getText();
        System.out.println(actionMessage);
        builder.doubleClick(srcButton).contextClick(targetButton).build().perform();
        actionMessage = driver.findElement(By.id("result")).getText();
        System.out.println(actionMessage);
        driver.quit();
        
	}

}
