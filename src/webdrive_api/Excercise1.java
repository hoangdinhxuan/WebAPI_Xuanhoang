package webdrive_api;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.commonFunction;

public class Excercise1 extends commonFunction {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.get("http://live.guru99.com/");
		openUrl(driver, "http://live.guru99.com/");

	}

	@Test
	public void TC01_LoginEmpty() throws InterruptedException {
//		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
		click(driver, "//div[@class='footer']//a[contains(text(),'My Account')]");
//		driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']")).sendKeys("");
		input(driver, "//input[@class='input-text required-entry validate-email']", "");
//		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']")).sendKeys("");
		input(driver, "//input[@class ='input-text required-entry validate-password']", "");
////		WebElement loginbtn = driver.findElement(By.xpath("//button[@id='send2']"));
//		loginbtn.click();
		click(driver, "//button[@id='send2']");
//		String WarningEmail = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();

		Assert.assertEquals("This is a required field.", getText(driver, "//div[@id='advice-required-entry-email']"));
		Thread.sleep(2000);
	}

	@Test
	public void TC02_InvalidEmail() throws InterruptedException {

		forwardToPage(driver, "http://live.guru99.com/index.php/customer/account/");

//		driver.navigate().to("http://live.guru99.com/index.php/customer/account/");

		input(driver, "//input[@class ='input-text required-entry validate-email']", "123434234@12312.123123");
//		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-email']"))
//				.sendKeys("123434234@12312.123123");
		Thread.sleep(2000);
		input(driver, "//input[@class ='input-text required-entry validate-password']", "");
//		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']")).sendKeys("");
//		WebElement Loginbtn = driver.findElement(By.xpath("//button[@class='button']"));
//
//		Loginbtn.click();
		click(driver, "//button[@class='button']");

//		String InvalidEmailWarning = driver.findElement(By.xpath("//div[@class ='validation-advice']")).getText();
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.",
				getText(driver, "//div[@class ='validation-advice']"));
	}

	@Test
	public void TC03_Passincorrect() throws InterruptedException {

//		driver.navigate().to("http://live.guru99.com/index.php/customer/account/");
		forwardToPage(driver, "http://live.guru99.com/index.php/customer/account/");

//		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-email']"))
//				.sendKeys("automation@gmail.com");
		input(driver, "//input[@class ='input-text required-entry validate-email']", "automation@gmail.com");

//		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']")).sendKeys("123");
		input(driver, "//input[@class ='input-text required-entry validate-password']", "123");

//		WebElement Loginbtn = driver.findElement(By.xpath("//button[@class='button']"));
//		Loginbtn.click();
		click(driver, "//button[@id='send2']");

//		String errormessagelWarning = driver.findElement(By.xpath("//div[@class ='validation-advice']")).getText();

		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.",
				getText(driver, "//div[@class ='validation-advice']"));
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

//		driver.navigate().to("http://live.guru99.com/index.php/customer/account/");
		forwardToPage(driver, "http://live.guru99.com/index.php/customer/account/");
//		WebElement creatacount = driver.findElement(By.xpath("//span[text()='Create an Account']"));
////		creatacount.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", creatacount);
		clickByJs(driver, "//span[text()='Create an Account']");

//		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Hoang");
		input(driver, "//input[@id='firstname']", "Hoang");
//		driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Dinh");
		input(driver, "//input[@id='middlename']", "Dinh");
//		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Xuan");
		input(driver, "//input[@id='lastname']", "Xuan");
//		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(EmailAddress);
		input(driver, "//input[@id='email_address']", EmailAddress);

		System.out.println("email = " + EmailAddress);
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		input(driver, "//input[@id='password']", "123456");
//		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		input(driver, "//input[@id='confirmation']", "123456");

//		WebElement sub = driver.findElement(By.xpath("//input[@id='is_subscribed']"));
//		// sub.click();
//		js.executeScript("arguments[0].click();", sub);
		clickByJs(driver, "//input[@id='is_subscribed']");

//		WebElement register = driver.findElement(By.xpath("//button[@title='Register']"));
//		// register.click();
//		js.executeScript("arguments[0].click();", register);
		clickByJs(driver, "//button[@title='Register']");
		Thread.sleep(2000);
//		String urlLoginPage = driver.getCurrentUrl();
//		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/index/", urlLoginPage);

		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/index/", getCurrentUrl(driver));
//		WebElement account = driver.findElement(By.xpath("//span[text()='Account']"));
//		// account.click();
//		js.executeScript("arguments[0].click();", account);
		clickByJs(driver, "//span[text()='Account']");
//		WebElement logout = driver.findElement(By.xpath("//a[text()='Log Out']"));
//		 logout.click();
		clickByJs(driver, "//a[text()='Log Out']");
//		js.executeScript("arguments[0].click();", logout);
//		WebElement acount = driver.findElement(By.xpath("//span[text()='Account']"));// acount.click();
		clickByJs(driver, "//span[text()='Account']");
//		js.executeScript("arguments[0].click();", acount);
//		WebElement login = driver.findElement(By.xpath("//a[@title='Log In']"));// login.click();
		clickByJs(driver, "//a[@title='Log In']");
//		js.executeScript("arguments[0].click();", login);
//		driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']"))
//				.sendKeys(EmailAddress);
		input(driver, "//input[@class='input-text required-entry validate-email']", EmailAddress);
//		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
		input(driver, "//input[@id='pass']", "123456");
//		WebElement logintext = driver.findElement(By.xpath("//span[text()='Login']"));// logintext.click();
//		js.executeScript("arguments[0].click();", logintext);
		clickByJs(driver, "//span[text()='Login']");
		Thread.sleep(2000);
		Assert.assertEquals("http://live.guru99.com/index.php/customer/account/", getCurrentUrl(driver));
//		WebElement aucounttext = driver.findElement(By.xpath("//span[text()='Account']"));// aucounttext.click();
//		js.executeScript("arguments[0].click();", aucounttext);
		clickByJs(driver, "//span[text()='Account']");

//		WebElement logtext = driver.findElement(By.xpath("//a[text()='Log Out']"));// logtext.click();
//
//		js.executeScript("arguments[0].click();", logtext);
		Thread.sleep(2000);
		clickByJs(driver, "//a[text()='Log Out']");

	}

	@Test
//Login hệ thống với tài khoản vừa tạo
	public void TC05_LogInsystem() {

//		driver.navigate().to("http://live.guru99.com/index.php/customer/account/");
		forwardToPage(driver, "http://live.guru99.com/index.php/customer/account/");
//		driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']")).clear();
		clear(driver, "//input[@class='input-text required-entry validate-email']");
//		driver.findElement(By.xpath("//input[@name='login[password]']")).clear();
		clear(driver, "//input[@name='login[password]']");
//
//		driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']"))
//				.sendKeys(EmailAddress);
		input(driver, "//input[@class='input-text required-entry validate-email']", EmailAddress);
//		driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys(" 123");
		input(driver, "//input[@name='login[password]']", " 123");
//		WebElement LogInbtn = driver.findElement(By.xpath("//button[@id='send2']"));
//		LogInbtn.click();
		click(driver, "//button[@id='send2']");

		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.",
				getText(driver, "//div[@id='advice-validate-password-pass']"));
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}