package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class commonFunction1 {

   //private int timeouts = 20

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	// driver.navigate().to("http://live.guru99.com/index.php/customer/account/");
	public void forwardToPage(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void click(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	// clickByJavaScript
	public void clickByJs(WebDriver driver, String locator) {
		WebElement account = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", account);
	}

	public String getText(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();

	}

	public void clear(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}

	public void input(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void selectCombobox(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));

		select.selectByVisibleText(value);

	}

	public String getTextComboboxSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();

	}

	public String getAtribute(WebDriver driver, String locator, String attribute) {

		WebElement element = driver.findElement(By.xpath(locator));

		return element.getAttribute(attribute);
	}

	public String getText(String locator) {

	}

	public int getSizeList(String locator) {

	}

	public boolean isDisplayed(String locator) {

	}

	public boolean isSelected(String locator) {

	}

	public boolean isEnabled(String locator) {

	}

	public void acceptAlert() {

	}

	public void cancelAlert() {

	}

	public String getTextAlert() {

	}

	public void inputAlert(String value) {

	}

	public void switchWindowByTitle(String title) {

	}

	public String getWindow() {

	}

	public void switchToIframe(String locator) {

	}

	public void switchToDefaultContent() {

	}

	public void hover(String locator) {

	}

	public void doubleClick(String locator) {

	}

	public void rightClick(String locator) {

	}

	public void dragAndDrop(String locatorFrom, String locatorTarget) {

	}

	public void clickAndHold(String locator, int itemFrom, int itemTarget) {

	}

	public void inputKeys(String locator, Keys key) {

	}

	public void uploadBySendKeys(String locator, String value) {

	}

	public void uploadByRobot(String locator, String value) {

	}

	public Object executeScriptBrowser(String javaScript) {

	}

	public Object executeScript(String locator) {

	}

	public Object scrollToBottomPage() {

	}

	public Object scroll(String locator) {

	}

	public void highlight(String locator) {

	}

	public Object removeAttribute(String locator, String attribute) {

	}

	public void waitPresence(String locator) {

	}

	public void waitVisible(String locator) {

	}

	public void waitAlertPresence() {

	}

}
