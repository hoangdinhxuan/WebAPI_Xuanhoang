package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class groups {
	WebDriver driver;

	@BeforeClass(groups = "LoginInvalidInfor")
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeMethod(groups = "LoginInvalidInfor")
	public void BeforeMethod() {
		driver.get("http://live.guru99.com/");
		WebElement acc = driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]"));
		acc.click();
	}

	@Parameters({ "username1", "password1" })
	@Test(groups = "LoginInvalidInfor")
	public void TC01_LoginEmpty(String username1, String password1) throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']")).sendKeys(username1);
		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']"))
				.sendKeys(password1);
		WebElement loginbtn = driver.findElement(By.xpath("//button[@id='send2']"));
		loginbtn.click();
		String WarningEmail = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
		Assert.assertEquals("This is a required field.", WarningEmail);
		Thread.sleep(2000);
	}

	@Parameters({ "username2", "password2" })
	@Test(groups = "LoginInvalidInfor")
	public void TC02_InvalidEmail(String username2, String password2) throws InterruptedException {

		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-email']")).sendKeys(username2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']"))
				.sendKeys(password2);
		WebElement Loginbtn = driver.findElement(By.xpath("//button[@class='button']"));

		Loginbtn.click();
		String InvalidEmailWarning = driver.findElement(By.xpath("//div[@class ='validation-advice']")).getText();
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", InvalidEmailWarning);
	}

	@Parameters({ "username3", "password3" })
	@Test
	public void TC03_Passincorrect(String username3, String password3) throws InterruptedException {

		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-email']")).sendKeys(username3);
		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']")).sendKeys(password3);
		WebElement Loginbtn = driver.findElement(By.xpath("//button[@class='button']"));
		Loginbtn.click();
		String errormessagelWarning = driver.findElement(By.xpath("//div[@class ='validation-advice']")).getText();
		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.",
				errormessagelWarning);
		Thread.sleep(2000);
	}

	@AfterClass(groups = "LoginInvalidInfor")
	public void afterClass() {
		driver.close();
	}
}