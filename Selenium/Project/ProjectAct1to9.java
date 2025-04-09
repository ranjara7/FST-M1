package projects;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectAct1to9 {
	
	WebDriver driver;
	Actions builder;
	WebElement sales;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
	}
	
	@Test(priority=1)
	public void pageTitle() {
		Assert.assertEquals(driver.getTitle(), "SuiteCRM");
	}
	
	@Test(priority=2)
	public void getImageUrl() {
	System.out.println("Suite CRM Header image Url: "+driver.findElement(By.xpath("//img[@alt='SuiteCRM']")).getAttribute("src"));
	}
	
	@Test(priority=3)
	public void getCopywriteText() {
	String copyWrite = driver.findElement(By.id("admin_options")).getText();
	System.out.println("Suite CRM Copywrite: "+copyWrite);
	Assert.assertEquals(copyWrite, "© Supercharged by SuiteCRM");
	}
	
	@Test(priority=4)
	public void login() {
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		Assert.assertEquals(driver.findElement(By.id("tab0")).getText(), "SUITECRM DASHBOARD");
	}
	
	@Test(dependsOnMethods = { "login" }, priority=5)
	public void getNavBarColor() {
		String color=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']")).getCssValue("color");
		String hexColor = Color.fromString(color).asHex();
		System.out.println(hexColor);
		Assert.assertEquals(hexColor, "#534d64");
	}
	
	@Test(dependsOnMethods = { "login" }, priority=5)
	public void verifyActivitiesMenu() {
		WebElement activities=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[@id='grouptab_3']"));
		activities.isDisplayed();
		Assert.assertEquals(activities.getText(), "ACTIVITIES");
		activities.click();
	}
	
	@Test(dependsOnMethods = { "login" }, priority=6)
	public void leadPhoneAndTableData() throws InterruptedException {
		sales = driver.findElement(By.xpath("//a[@id='grouptab_0']"));
		WebElement leads = driver.findElement(By.id("moduleTab_9_Leads"));
		builder = new Actions(driver);
		builder.moveToElement(sales).click(leads).build().perform();
		wait = new WebDriverWait (driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='adspan_77c0ebaa-448d-740d-a00f-605ae70266e9']"))).click();
	    System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']"))).getText());
	    for(int i=1; i<=10; i++) {
			System.out.println("Activities: " + driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+ i + "]/td[3]")).getText());
		}
	}
	
	@Test(dependsOnMethods= {"login"}, priority=7)
	public void printAccountsTable() {
		builder = new Actions(driver);
		sales = driver.findElement(By.xpath("//a[@id='grouptab_0']"));
		WebElement accounts = driver.findElement(By.id("moduleTab_9_Accounts"));
		builder.moveToElement(sales).click(accounts).build().perform();
		wait = new WebDriverWait (driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list view table-responsive']/tbody")));
		for(int i=1; i<10; i+=2) {
			System.out.println("Activities: " + driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+ i + "]")).getText());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
