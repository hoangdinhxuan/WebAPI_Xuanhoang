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
//	Exercise 2:
//		Step 1: Vào trang: https://www.24h.com.vn/
//		Step 2: Hover vào menu: Danh mục -> Tiếp tục hover menu bóng đá -> Tiếp tục hover -> Lịch thi đấu bóng đá
//		Step 3: Click vào menu Lịch thi đấu bóng đá
//		Step 4: Kiểm tra title của web hiện tại là: Lịch thi đấu Bóng Đá Anh, Ý TBN C1, Kết quả Tỉ lệ cược 24h
	@Test
	public void TC01_hover() throws InterruptedException {
		driver.get("https://www.24h.com.vn/");
		WebElement hoverdanhmuc = driver.findElement(By.xpath("//li[@class='sbLi sbLix']//a[@href='#']"));
		Actions action = new Actions(driver);
		action.moveToElement(hoverdanhmuc).perform();
	        Thread.sleep(2000);
		WebElement hoverbongda = driver.findElement(By.xpath("//li[@class='sbLi']//a[@title='Bóng đá']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(hoverbongda).perform();
		Thread.sleep(2000);
		WebElement hoverlichbongda = driver.findElement(By.xpath("//ul[@class='fly']//a[@title='Lịch thi đấu bóng đá']"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(hoverlichbongda).perform();
		Thread.sleep(2000);
		hoverlichbongda.click();
		Assert.assertEquals(driver.getTitle(), "Lịch thi đấu Bóng Đá Anh, Ý TBN C1, Kết quả Tỉ lệ cược 24h");
	}
//	Exercise 3: 
//
//		Step 1: Vào trang: http://jqueryui.com/resources/demos/selectable/display-grid.html
//		Step 2: Click and hold: từ số 1 đến 12
//		Step 3: Kiểm tra rằng đã chọn 12 element thành công( Getsize list element = 12)
        @Test
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
//	Exercise 4: 
//		Step 01 - Truy cập vào trang: http://swisnl.github.io/jQuery-contextMenu/demo.html
//		Step 02 - Right click vào element: right click me
//		Step 03 - Hover chuột vào element: Quit
//		Step 04 – Kiểm tra label Quit được hiển thị
        @Test
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
//	Exercise 5: 
//
//		Step 01 - Truy cập vào trang: http://www.seleniumlearn.com/double-click
//		Step 02 - Double click vào button: Double-Click Me!
        @Test
	public void TC05_doubleclick() throws InterruptedException {
		driver.get("http://www.seleniumlearn.com/double-click");
		WebElement btnDouble = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me!')]"));
		Actions action = new Actions(driver);
		action.doubleClick(btnDouble).perform();
	}
//	 Exercise 7:
//		 Step 01 - Truy cập vào trang: http://jqueryui.com/resources/demos/droppable/default.html
//		 Step 02 - Kéo hình chữ nhật: Drag me to my target vào hình Drop here
//		 Step 03 - Verify message đã thay đổi: Dropped!
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
