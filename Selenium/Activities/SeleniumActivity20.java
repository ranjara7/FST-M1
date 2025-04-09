package activities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumActivity20 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/alerts");
        System.out.println("Page title: " + driver.getTitle());

        driver.findElement(By.id("prompt")).click();

        Alert promtAlert = driver.switchTo().alert();
        String alertText = promtAlert.getText();
        System.out.println("Text in alert: " + alertText);
        promtAlert.sendKeys("Awesome!");
        Thread.sleep(5000);

        promtAlert.accept();
        System.out.println(driver.findElement(By.id("result")).getText());
        driver.quit();
    }
}
