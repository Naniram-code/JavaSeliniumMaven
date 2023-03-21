package DEMO1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseAndKeyboardInteractionConcept {
	//Mouse & Keyboard operation: -> Actions class
		// 1. create instance/object of Actions class - pass driver instance
		// 2. define webElement if required
		// 3. define action/s
		// 4. build & perform action/s

	ChromeOptions option;
	WebDriver driver;
	//Actions action = new Actions(driver);

	@BeforeMethod
	public void openBrowser() {
		option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.setHeadless(false);//user interface browser mode on/of(false/true)
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(option);
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
	}

		@Test(priority = 1)
		public void MouseKeywords() throws InterruptedException {
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
			System.out.println("Page title: " + driver.getTitle());

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
			action.sendKeys("amazon").keyUp(Keys.SHIFT).build().perform();//upper case shift keys
			Thread.sleep(3000);
			action.sendKeys(Keys.BACK_SPACE).build().perform();
			Thread.sleep(3000);

		driver.findElement(By.xpath("//i[@aria-label='Amazon']")).click();//page up page Down
		
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
