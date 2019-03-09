package webdrive_api;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise3 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// @Test
	public void TC01_hover() throws InterruptedException {
		driver.get("https://www.24h.com.vn/");
		WebElement hoverElement = driver.findElement(By.xpath("//a[@title='Bóng đá']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(hoverElement).perform();

		WebElement hoverbongda = driver.findElement(By.xpath("//a[@class='tit']"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(hoverbongda).perform();

		WebElement hoverlichbongda = driver
				.findElement(By.xpath("//div[@id='div_menu_c2_header_48']//a[@title='Lịch thi đấu bóng đá']"));
		Actions action3 = new Actions(driver);
		action3.moveToElement(hoverlichbongda).perform();
		driver.findElement(By.xpath("//div[@id='div_menu_c2_header_48']//a[@title='Lịch thi đấu bóng đá']")).click();
		Assert.assertEquals(driver.getTitle(), "Lịch thi đấu Bóng Đá Anh, Ý TBN C1, Kết quả Tỉ lệ cược 24h");
	}

	// @Test
	public void TC02_clickhover() throws InterruptedException {
		driver.get("https://www.24h.com.vn/");

		WebElement hoverElement = driver.findElement(By.xpath("//a[@class='sbA']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(hoverElement).perform();

		WebElement hoverbongda = driver.findElement(By.xpath("//a[@class='tit']"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(hoverbongda).perform();

		WebElement hoverlichbongda = driver
				.findElement(By.xpath("//div[@id='div_menu_c2_header_48']//a[@title='Lịch thi đấu bóng đá']"));
		Actions action3 = new Actions(driver);
		action3.moveToElement(hoverlichbongda).perform();
		driver.findElement(By.xpath("//div[@id='div_menu_c2_header_48']//a[@title='Lịch thi đấu bóng đá']")).click();
		Assert.assertEquals(driver.getTitle(), "Lịch thi đấu Bóng Đá Anh, Ý TBN C1, Kết quả Tỉ lệ cược 24h");
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// @Test
	public void TC03_clickandhover() throws InterruptedException {
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		List<WebElement> listItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		Actions action = new Actions(driver);
		action.clickAndHold(listItems.get(0)).clickAndHold(listItems.get(11)).click().perform();
		action.release();
		List<WebElement> listSelected = driver
				.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
		Assert.assertEquals(listSelected.size(), 12);
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// @Test
	public void TC04_rightclickme() throws InterruptedException {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightBtn = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		Actions action = new Actions(driver).contextClick(rightBtn);
		action.build().perform();
		WebElement hoverElement = driver.findElement(By.xpath("//span[text()='Quit']"));
		Actions hoverright = new Actions(driver);
		hoverright.moveToElement(hoverElement).perform();
		Assert.assertEquals(hoverElement.getText(), "Quit");
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// @Test
	public void TC05_doubleclick() throws InterruptedException {
		driver.get("http://www.seleniumlearn.com/double-click");
		WebElement btnDouble = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me!')]"));
		Actions action = new Actions(driver);
		action.doubleClick(btnDouble).perform();
	}

	/////////////////////////////////////////////////////////////
	@Test
	public void TC07_drap() throws InterruptedException {
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		WebElement dragFrom = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(dragFrom).moveToElement(target).release(target).build();
		dragAndDrop.perform();
		String gettext = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
		Assert.assertEquals("Dropped!",gettext);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}