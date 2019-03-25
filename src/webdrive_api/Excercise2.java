package webdrive_api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise2 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void TC01_check() throws InterruptedException {
		driver.get("https://daominhdam.github.io/basic-form/");

		WebElement element = driver.findElement(By.xpath("//input[@id='password']"));
		Assert.assertFalse(element.isEnabled());
		Thread.sleep(2000);
		WebElement elementCharacter = driver.findElement(By.xpath("//input[@id='password']"));
		String textDisable = elementCharacter.getAttribute("placeholder");
		Assert.assertEquals("Textbox is disabled", textDisable);

	}

///////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void TC02_checkoption() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/radio.html");

		WebElement element = driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
		Assert.assertFalse(element.isSelected());
		if (element.isSelected() == false)
			element.click();
		Assert.assertTrue(element.isSelected());
		Thread.sleep(2000);
		WebElement radio = driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
		Assert.assertFalse(radio.isSelected());
		if (radio.isSelected() == false)
			radio.click();
		Assert.assertTrue(radio.isSelected());
		Thread.sleep(2000);

	}

	///////////////////////////////////////////////////////////////////////////////
		String selectyer = selectyear.getFirstSelectedOption().getText();
		Assert.assertEquals("2018", selectyer);

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}