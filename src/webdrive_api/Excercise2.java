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
//	Exercise 1: 
//		Step 1: Vào trang: https://daominhdam.github.io/basic-form/
//			Step 2: Kiểm tra textbox Password bị disable bằng lệnh assertFalse()
//			Step 3: Kiểm tra place holder có phải là giá trị: “Textbox is disabled” hay không?
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

//	Exercise 2: 
//		Step 1: Vào trang: http://demo.guru99.com/test/radio.html
//		Step 2: Kiểm tra Radio Option1 có được chọn hay chưa? 
//		Nếu chưa được chọn -> thực hiện click để chọn
//		Sau đó kiểm tra Option1 đã được chọn( lệnh assertTrue(element. isSelected());
//		Step 3: Kiểm tra Checkbox Checkbox3 có được chọn hay chưa? 
//		Nếu chưa được chọn -> thực hiện click để chọn
//		Sau đó kiểm tra Checkbox3 đã được chọn( lệnh assertTrue(element. isSelected());
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

//	Exercise 3:
//		Step 1: Vào trang: https://www.facebook.com/
//		Step 2: Select giá trị của các combobox tương ứng:
//		Ngày: 14
//		Tháng: Tháng 2
//		Năm: 2018
//	Step 3: Kiểm tra các giá trị vừa chọn ở các combobox vừa chọn bằng lệnh: select.getFirstSelectedOption().getText() với các giá trị tương ứng:
//		Ngày: 14
//		Tháng: Tháng 2
//		Năm: 2018
	@Test
	public void TC03_Select() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		Select selectday = new Select(driver.findElement(By.xpath("//*[@id='day']")));
		selectday.selectByVisibleText("14");
		String selectdate = selectday.getFirstSelectedOption().getText();
		Assert.assertEquals("14", selectdate);
		Thread.sleep(2000);
		Select selectmonth = new Select(driver.findElement(By.xpath("//*[@id='month']")));
		selectmonth.selectByVisibleText("Tháng 2");
		Thread.sleep(2000);
		String selectmont = selectmonth.getFirstSelectedOption().getText();
		Assert.assertEquals("Tháng 2", selectmont);
		Select selectyear = new Select(driver.findElement(By.xpath("//*[@id='year']")));
		selectyear.selectByVisibleText("2018");
		Thread.sleep(2000);
		String selectyer = selectyear.getFirstSelectedOption().getText();
		Assert.assertEquals("2018", selectyer);
	

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
