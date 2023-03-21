package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAndKeyboardInteractionConcept {
	//Mouse & Keyboard operation: -> Actions class
		// 1. create instance/object of Actions class - pass driver instance
		// 2. define webElement if required
		// 3. define action/s
		// 4. build & perform action/s

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		Actions action = new Actions(driver);
		WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
		Thread.sleep(3000);
		// one action at a time
		action.moveToElement(accountList).build().perform();
		Thread.sleep(3000);
//		action.moveToElement(driver.findElement(By.linkText("Create a List"))).build().perform();
//		Thread.sleep(3000);
//		action.click().build().perform();
		// series of actions
		action.moveToElement(driver.findElement(By.linkText("Start here."))).click()
		.build().perform();
		System.out.println("Page title: "+driver.getTitle());
		
		WebElement cusName = driver.findElement(By.id("ap_customer_name"));
		Thread.sleep(3000);
		
		// Keyboard interaction
		action.moveToElement(cusName).click().sendKeys("test").build().perform();
		Thread.sleep(3000);
		action.doubleClick().build().perform();
		Thread.sleep(3000);
		action.click().build().perform();
		Thread.sleep(3000);
		action.doubleClick().build().perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.DELETE).build().perform();
		Thread.sleep(3000);
		action.sendKeys("amazon").build().perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		
		driver.findElement(By.xpath("//i[@aria-label='Amazon']")).click();
		
		for(int i=1; i<=20; i++) {
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(2000);
		}
		for(int i=1; i<=20; i++) {
			action.sendKeys(Keys.PAGE_UP).build().perform();
			Thread.sleep(2000);
		}
		
		Thread.sleep(3000);
		driver.close();
	}

}
