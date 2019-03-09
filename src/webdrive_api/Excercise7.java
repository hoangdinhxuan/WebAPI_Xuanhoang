package webdrive_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Excercise7 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// userPath.concat("/driver/chromedriver.exe"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	// Exercise 1:
	// Step 1: Vào trang: http://the-internet.herokuapp.com/dynamic_loading/1
	// Step 2: Click button Start
	// Step 3: Wait cho đến khi chữ Loading biến mất
	// Step 4: Verify label: “Hello World!” được hiển thị

	@Test
	public void TC01() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		WebElement username = driver.findElement(By.xpath("//div[@id='start']/button"));
		username.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
		String text = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
		Assert.assertEquals(text, "Hello World!");
	}

	// Exercise 3
	// Step 1: Vào trang: https://www.w3schools.com/howto/howto_js_countdown.asp
	// Step 2: Chờ fluentWait cho đến khi “25s” được hiển thị
	@Test
	public void TC03() throws InterruptedException {
		driver.get("https://www.w3schools.com/howto/howto_js_countdown.asp");
		WebElement coutDown = driver.findElement(By.xpath("//p[@id='countdown1']"));
		new FluentWait<WebElement>(coutDown).withTimeout(120, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.until(new Function<WebElement, Boolean>() {
					public Boolean apply(WebElement element) {
						boolean flag = element.getText().contains("25");
						return flag;
					}
				});
	}

	// Exercise 5:
	// Step 1: Vào trang:
	// https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html
	// Step 2: Click button Dowload
	// Step 3: Chờ đến khi load 100% và verify text là 100%
	@Test
	public void TC05() throws InterruptedException {
		driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
		driver.findElement(By.xpath("//button[@id='cricle-btn']")).click();
		waitForProgressBar("//div[text()='100%']");

		String textResult = driver.findElement(By.xpath("//div[@class='percenttext']")).getText();
		Assert.assertEquals(textResult, "100%");
	}

	public void waitForProgressBar(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(locator));
			}
		});
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}