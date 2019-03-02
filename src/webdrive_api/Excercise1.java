package webdrive_api;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise1 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://live.guru99.com/");
	}

	@Test
	public void TC01_LoginEmpty() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']")).sendKeys("");
		WebElement loginbtn = driver.findElement(By.xpath("//button[@id='send2']"));
		loginbtn.click();
		String WarningEmail = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
		Assert.assertEquals("This is a required field.", WarningEmail);
		Thread.sleep(2000);
	}

	@Test
	public void TC02_InvalidEmail() throws InterruptedException {

		driver.navigate().to("http://live.guru99.com/index.php/customer/account/");

		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-email']"))
				.sendKeys("123434234@12312.123123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']")).sendKeys("");
		WebElement Loginbtn = driver.findElement(By.xpath("//button[@class='button']"));

		Loginbtn.click();
		String InvalidEmailWarning = driver.findElement(By.xpath("//div[@class ='validation-advice']")).getText();
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", InvalidEmailWarning);
	}

	@Test
	public void TC03_Passincorrect() throws InterruptedException {

		driver.navigate().to("http://live.guru99.com/index.php/customer/account/");

		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-email']"))
				.sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']")).sendKeys("123");
		WebElement Loginbtn = driver.findElement(By.xpath("//button[@class='button']"));
		Loginbtn.click();
		String errormessagelWarning = driver.findElement(By.xpath("//div[@class ='validation-advice']")).getText();
		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.",
				errormessagelWarning);
		Thread.sleep(2000);
	}

	public int RandomEmail() {
		Random rd = new Random();
		int em = rd.nextInt(1000000);
		return em;
	}

	public String EmailAddress = "hoangxuan94" + RandomEmail() + "@gmail.com";

	@Test
	public void TC04_creatacount() throws InterruptedException {

		driver.navigate().to("http://live.guru99.com/index.php/customer/account/");
		WebElement creatacount = driver.findElement(By.xpath("//span[text()='Create an Account']"));
		creatacount.click();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Hoang");
		driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Dinh");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Xuan");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(EmailAddress);
		System.out.println("email = " + EmailAddress);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='is_subscribed']")).click();
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Thread.sleep(2000);
		String urlLoginPage = driver.getCurrentUrl();
		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/index/", urlLoginPage);
		driver.findElement(By.xpath("//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		driver.findElement(By.xpath("//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[@title='Log In']")).click();
		driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']"))
				.sendKeys(EmailAddress);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(2000);
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/", currentURL);
		driver.findElement(By.xpath("//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();

	}

	@Test
//Login hệ thống với tài khoản vừa tạo
	public void LogInsystem() {

		driver.navigate().to("http://live.guru99.com/index.php/customer/account/");
		driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']")).clear();

		driver.findElement(By.xpath("//input[@name='login[password]']")).clear();

		driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']"))
				.sendKeys(EmailAddress);

		driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys(" 123");
		WebElement LogInbtn = driver.findElement(By.xpath("//button[@id='send2']"));
		LogInbtn.click();

		String InvalidPasswordWarning = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']"))
				.getText();
		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.",
				InvalidPasswordWarning);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}