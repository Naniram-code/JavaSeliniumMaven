package DEMO1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class HandlingAlert {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option;
		WebDriver driver;

			option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			option.setHeadless(false);//user interface browser mode on/of(false/true)
			option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(option);
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		WebElement customerIDtxtBx = driver.findElement(By.name("cusid"));
		customerIDtxtBx.sendKeys("test12");
		driver.findElement(By.name("submit")).click();
		
		// without handling alert -> UnhandledAlertException: unexpected alert open: {Alert text : Do you really want to delete this Customer?}
//		driver.findElement(By.name("res")).click();
		
		String expectedAlertMsgTxt1 = "Do you really want to delete this Customer";
		String expectedAlertMsgTxt2 = "Customer Successfully Delete!";
		// Handle alert -> 1. get text	2. accept	3. dismiss
		String actualAlertMsgTxt1 = driver.switchTo().alert().getText();
		if(actualAlertMsgTxt1.equals(expectedAlertMsgTxt1)) {
			System.out.println("Correct alert message 1: Test Passed");
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			String actualAlertMsgTxt2 = driver.switchTo().alert().getText();
			if(actualAlertMsgTxt2.equals(expectedAlertMsgTxt2)) {
				System.out.println("Correct alert message 2: Test Passed");
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
			}else
				System.out.println("Incorrect alert message 2: Test Failed");
		}else {
			System.err.println("Incorrect alert message 1: Test Failed");
			driver.switchTo().alert().dismiss();
		}
		
		Thread.sleep(2000);
		driver.findElement(By.name("cusid")).sendKeys("test123");
		// after handling alert
		Thread.sleep(2000);
		driver.findElement(By.name("res")).click();
		
		Thread.sleep(2000);
		driver.close();
	}
	
	// Assignment: handling Web-table(build logic from scratch)/Calendar(build logic from scratch)/Alert

}
