package seleniumBasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.linkText("Click Here")).click();
		
		driver.findElement(By.linkText("Click Here")).click();
		
		driver.findElement(By.linkText("Click Here")).click();

		// without handling new window
//		Thread.sleep(3000);
		// close() Vs quit()
//		driver.close(); // closing window where driver instance is focused at
//		driver.quit(); // close all windows opened by that driver instance
//		Thread.sleep(3000);
//		driver.findElement(By.linkText("Click Here")).click(); // NoSuchWindowException: no such window: target window already closed
	
		// Handling windows -> switchTo() new window by using window handle -> getWindowHandle() Vs getWindowHandles()
			// getWindownHandle() -> return window handle of window on focus
			// getWindowHandles() -> return all window handles of windows opened by driver instance
		// if only one window left at the end -> still requires switching to the last window present
		
//		String parentWindowHandle = driver.getWindowHandle();
//		System.out.println("Parent window handle: "+parentWindowHandle);
		
		Set<String> handles = driver.getWindowHandles();
		System.out.println("Number of windows opened: "+handles.size());
		
//		for(String handle: handles) {
//			System.out.println(handle);
//			driver.switchTo().window(handle);
//			Thread.sleep(2000);
//			System.out.println(driver.getTitle());
//			System.out.println(driver.getCurrentUrl());
//			driver.close();
//		}
		
		Iterator<String> it = handles.iterator();
		String parentWindowHanlde = it.next();
		String child1WindowHanlde = it.next();
		String child2WindowHanlde = it.next();
		String child3WindowHanlde = it.next();
		
		driver.switchTo().window(child2WindowHanlde);
		boolean result = child2WindowHanlde.equals(driver.getWindowHandle());
		System.out.println("Checking child 2 window: "+result);
		String newWindowHeader = driver.findElement(By.xpath("//div/h3")).getText();
		System.out.println(newWindowHeader);
		System.out.println(newWindowHeader.equals("New Window"));
		driver.close();
		
		driver.switchTo().window(child1WindowHanlde);
		result = child1WindowHanlde.equals(driver.getWindowHandle());
		System.out.println("Checking child 1 window: "+result);
		driver.close();
		
		driver.switchTo().window(child3WindowHanlde);
		result = child3WindowHanlde.equals(driver.getWindowHandle());
		System.out.println("Checking child 3 window: "+result);
		driver.close();
		
		driver.switchTo().window(parentWindowHanlde);
		result = parentWindowHanlde.equals(driver.getWindowHandle());
		System.out.println("Checking parent window: "+result);
		String parentWindowHeader = driver.findElement(By.cssSelector(".example>h3")).getText();
		System.out.println(parentWindowHeader);
		System.out.println(parentWindowHeader.equals("Opening a new window"));
		driver.close();
		
		
//		driver.quit();
	}

}
