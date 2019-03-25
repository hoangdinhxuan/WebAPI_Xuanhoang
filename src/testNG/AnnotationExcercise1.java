package testNG;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AnnotationExcercise1 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void BeforeMethod() {
		driver.get("http://live.guru99.com/");
		WebElement acc = driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]"));
		acc.click();
	}

	@DataProvider(name = "account")
	public static Object[][] userandpass(Method method) {
		Object[][] result = null;
		if (method.getName().equals("TC01_LoginEmpty")) {
			result = new Object[][] { { "", "" } };
		} else if (method.getName().equals("TC02_InvalidEmail")) {
			result = new Object[][] { { "123434234@12312.123123", "" }};
		} else {
			result = new Object[][] { { "automation@gmail.com", "123" }};
		}
		return result;
	}

	@Test(dataProvider = "account")
	public void TC01_LoginEmpty(String ab, String cd) throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']")).sendKeys(ab);
		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']")).sendKeys(cd);
		WebElement loginbtn = driver.findElement(By.xpath("//button[@id='send2']"));
		loginbtn.click();
		String WarningEmail = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
		Assert.assertEquals("This is a required field.", WarningEmail);
		Thread.sleep(2000);
	}

	@Test(dataProvider = "account")
	public void TC02_InvalidEmail(String ab, String cd) throws InterruptedException {

		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-email']"))
				.sendKeys(ab);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']")).sendKeys(cd);
		WebElement Loginbtn = driver.findElement(By.xpath("//button[@class='button']"));

		Loginbtn.click();
		String InvalidEmailWarning = driver.findElement(By.xpath("//div[@class ='validation-advice']")).getText();
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", InvalidEmailWarning);
	}

	@Test(dataProvider = "account")
	public void TC03_Passincorrect(String ab, String cd) throws InterruptedException {

		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-email']"))
				.sendKeys(ab);
		driver.findElement(By.xpath("//input[@class ='input-text required-entry validate-password']")).sendKeys(cd);
		WebElement Loginbtn = driver.findElement(By.xpath("//button[@class='button']"));
		Loginbtn.click();
		String errormessagelWarning = driver.findElement(By.xpath("//div[@class ='validation-advice']")).getText();
		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.",
				errormessagelWarning);
		Thread.sleep(2000);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}