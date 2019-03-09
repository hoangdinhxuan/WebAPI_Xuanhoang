package webdrive_api;

import org.openqa.selenium.Alert;
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
	// @Test
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

	// Exercise 01:
	// Step 01 - Truy cập vào
	// trang:http://the-internet.herokuapp.com/javascript_alerts
	// Step 02 - Click vào button: Click for JS Alert
	// Step 03 - Verify message hiển thị trong alert là: I am a JS Alert
	// Step 04 - Accept alert và verify message hiển thị tại Result là: You clicked
	// an alert successfully

	//@Test
	public void Excercise_Alerts() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		WebElement clickbutton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		clickbutton.click();
		Alert alert = driver.switchTo().alert();
		String textaAlert = alert.getText();
		Assert.assertEquals("I am a JS Alert", textaAlert);
		alert.accept();
		String textResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals("You successfuly clicked an alert", textResult);

	}
	//Exercise 02: Step 01 - Truy cập vào trang: http://the-internet.herokuapp.com/javascript_alerts
		//Step 02 - Click vào button: Click for JS Confirm
		//Step 03 - Verify message hiển thị trong alert là: I am a JS Confirm
		//Step 04 - Cancel alert và verify message hiển thị tại Result là:  You clicked: Cancel
	//@Test
	public void Excercise2() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		WebElement clickbutton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		clickbutton.click();
		Alert alert = driver.switchTo().alert();
		String textaAlert = alert.getText();
		Assert.assertEquals("I am a JS Confirm", textaAlert);
		alert.dismiss();
		String textResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals("You clicked: Cancel", textResult);
	}
	//Exercise 03:Step 01 - Truy cập vào trang: http://the-internet.herokuapp.com/javascript_alerts
		//Step 02 - Click vào button: Click for JS Prompt
		//Step 03 - Verify message hiển thị trong alert là: I am a JS prompt
		//Step 04 - Nhập vào text “VuNguyen”và verify message hiển thị tại Result là:  You entered: VuNguyen	
	@Test
	public void Excercise3() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		WebElement clickbutton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		clickbutton.click();
		Alert alert = driver.switchTo().alert();
		String textaAlert = alert.getText();
		Assert.assertEquals("I am a JS prompt", textaAlert);
		alert.sendKeys("VuNguyen");
		alert.accept();
		String textResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals("You entered: VuNguyen", textResult);
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}