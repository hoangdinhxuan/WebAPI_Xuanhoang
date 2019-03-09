package webdrive_api;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise6 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// @Test
	public void TC01() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/upload/");
		WebElement username = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		username.sendKeys("C:\\ronaldo.jpg");
		WebElement check = driver.findElement(By.xpath("//input[@id='terms']"));
		check.click();
		WebElement button = driver.findElement(By.xpath("//button[@id='submitbutton']"));
		button.click();
		Thread.sleep(3000);
		String textResult = driver.findElement(By.xpath("//h3[@id='res']")).getText();
		Assert.assertTrue(textResult.contains("successfully uploaded."));

	}

	@Test
	public void TC02() throws InterruptedException, Exception {
		driver.get("http://demo.guru99.com/test/upload/");
		StringSelection select = new StringSelection("C:\\ronaldo.jpg");
		WebElement btnBrowse = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		btnBrowse.click();
		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement check = driver.findElement(By.xpath("//input[@id='terms']"));
		check.click();
		WebElement button = driver.findElement(By.xpath("//button[@id='submitbutton']"));
		button.click();
		Thread.sleep(3000);
		String textResult = driver.findElement(By.xpath("//h3[@id='res']")).getText();
		Assert.assertTrue(textResult.contains("successfully uploaded."));

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}