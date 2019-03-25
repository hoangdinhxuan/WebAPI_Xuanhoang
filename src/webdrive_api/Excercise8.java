package webdrive_api;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise8 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// userPath.concat("/driver/chromedriver.exe"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

//	Bonus Exercise:
//		Step 1: Vào trang: https://www.tjvantoll.com/demos/2012-08-05/initial
//		Step 2: Bỏ trống Name, Comments
//		Step 3: Click button Submit
//		Step 4: Verify message:' Please fill out this field." ở textbox Name
//		Step 5: Input giá trị "abc" vào textbox: Name
//		Step 6: Click button Submit
//		Step 7: Verify message: "Please fill out this field." ở textbox Comments

	@Test
	public void TC01() throws InterruptedException {
		driver.get("https://www.tjvantoll.com/demos/2012-08-05/initial");
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		name.sendKeys("");
		WebElement coment = driver.findElement(By.xpath("//textarea[@id='comments']"));
		coment.sendKeys("");
		WebElement button = driver.findElement(By.xpath("//div[@class='buttons']/button"));
		button.click();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String text = jsExecutor.executeScript("return arguments[0].validationMessage;", name).toString();
		Assert.assertEquals(text, "Please fill out this field.");
		name.sendKeys("abc");
		button.click();
		String textcmt = jsExecutor.executeScript("return arguments[0].validationMessage;", coment).toString();
		Assert.assertEquals(textcmt, "Please fill out this field.");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}