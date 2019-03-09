package webdrive_api;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise5 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// Exercise 7:
	// Step 1: Vào trang: http://demo.guru99.com/v4/
	// Step 2: Ấn phím Tab ở textbox UserID để chuyển xuống textbox: Password
	// Step 3: Input “123456” ở textbox Password
	// Step 4: Ấn tổ hợp phím Shift + Tab ở textbox Password để chuyển lên textbox:
	// UserID
	// Step 5: Input text bất kỳ “Ronaldo” vào textbox: UserID
	// Step 6: Ấn tổ hợp phím Ctrl + N ở textbox: UserID để mở window mới
	// Step 7: Vào trang https://www.google.com/
	// Step 8: Verify title hiện tại là: Google
	@Test
	public void TC01() throws InterruptedException {
		driver.get("http://demo.guru99.com/v4/");
		WebElement username = driver.findElement(By.xpath("//input[@name='uid']"));
		username.sendKeys(Keys.TAB);
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("123456");
		password.sendKeys(Keys.chord(Keys.SHIFT, "tab"));
		username.sendKeys("Ronaldo");
		username.sendKeys(Keys.chord(Keys.CONTROL, "n"));
		driver.get("https://www.google.com/");
		Assert.assertEquals("Google", driver.getTitle());
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}