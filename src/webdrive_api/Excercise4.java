package webdrive_api;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise4 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// Exercise 1:
	// Step 1: Vào trang: http://the-internet.herokuapp.com/iframe
	// Step 2: Input giá trị “Ronaldo” vào khung TinyMCE
//////////////////////////////////////////////////////////////////////////////////////////////////
	// @Test
	public void TC01_Inputiframe() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/iframe");
		WebElement iframeLookingfor = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(iframeLookingfor);
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Ronaldo");
		driver.switchTo().defaultContent();
		String textIframe = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		Assert.assertEquals(textIframe, "An iFrame containing the TinyMCE WYSIWYG Editor");
	}

	// Exercise 2 : Step 1: Vào
	// trang:https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled
	// Step 2: Kiểm tra textbox Last name là disable
	// Step 3: Input giá trị “nguyen” vào textbox: First name
	// Step 4: Click button submit
	// Step 5: Kiểm tra message hiển thị là “fname=nguyen”

	// @Test
	public void TC02_Inputiframe() throws InterruptedException {
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		WebElement iframeLookingfor = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(iframeLookingfor);
		WebElement element = driver.findElement(By.xpath("//input[@name='lname']"));
		Assert.assertFalse(element.isEnabled());
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("nguyen");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		String textIframe = driver.findElement(By.xpath("//div[contains(text(),'fname=nguyen')]")).getText().trim();
		Assert.assertEquals(textIframe, "fname=nguyen");
	}

	// Exercise 4 Step 01 - Truy cập vào trang: http://www.hdfcbank.com/
	// Step 02 - Click Angri link -> Mở ra tab/window mới -> Switch qua tab mới =>
	// switchToWindowByTitle("HDFC Bank Kisan Dhan Vikas e-Kendra");
	// Step 03 - Click Account Details link -> Mở ra tab/window mới -> Switch qua
	// tab mới
	// Step 04- Click Privacy Policy link (nằm trong frame) -> Mở ra tab/window
	// mới-> Switch qua tab mới
	// Step 05- Click CSR link on Privacy Policy page=> ve 
	// Step 06- Back về Main window ( window ban
	// đầu)=>

	//@Test
	public void TC04_Inputiframe() throws InterruptedException {
		driver.get("http://www.hdfcbank.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Agri')]")).click();
		switchToWindowByTitle("HDFC Bank Kisan Dhan Vikas e-Kendra");
		driver.findElement(By.xpath("//p[contains(text(),'Account Details')]")).click();
		switchToWindowByTitle("Welcome to HDFC Bank NetBanking");
		WebElement iframeLookingfor = driver.findElement(By.xpath("//frame[@name='footer']"));
		driver.switchTo().frame(iframeLookingfor);
		driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")).click();
		switchToWindowByTitle(
				"HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
	
	}

	private void switchToWindowByTitle(String string) {
		// TODO Auto-generated method stub

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}