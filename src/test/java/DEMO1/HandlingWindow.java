package DEMO1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingWindow {
	ChromeOptions option;
	WebDriver driver;
	Select select;

	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.setHeadless(false);//user interface browser mode on/of(false/true)
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Click Here")).click();
		
		driver.findElement(By.linkText("Click Here")).click();
		
		driver.findElement(By.linkText("Click Here")).click();}

		@Test(priority = 1)
		public void HandleWind() throws InterruptedException {
			// without handling new window
	      Thread.sleep(3000);
			// close() Vs quit()
	     //driver.close(); // closing window where driver instance is focused at
	     //driver.quit(); // close all windows opened by that driver instance

	     driver.findElement(By.linkText("Click Here")).click(); // NoSuchWindowException: no such window: target window already closed

			//Handling windows -> switchTo() new window by using window handle -> getWindowHandle() Vs getWindowHandles()
			//getWindownHandle() -> return window handle of window on focus
			// getWindowHandles() -> return all window handles of windows opened by driver instance
			// if only one window left at the end -> still requires switching to the last window present

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent window handle: "+parentWindowHandle);
			Thread.sleep(2000);
		}

		@Test(priority = 2)
		public void windowHandles() throws InterruptedException {
		Set<String> handles = driver.getWindowHandles();
		System.out.println("Number of windows opened: "+handles.size());
		
	    for(String handle: handles) {
			System.out.println(handle);
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
		driver.close();
	                        }}
			@Test(priority = 3)
			public void HandleWindIterator() throws InterruptedException {

				Thread.sleep(2000);
				Set<String> handles = driver.getWindowHandles();
				System.out.println("Number of windows opened: "+handles.size());

				Iterator<String> it = handles.iterator();
				String parentWindowHanlde = it.next();//parent
				String child1WindowHanlde = it.next();//c1
				String child2WindowHanlde = it.next();//c2
				String child3WindowHanlde = it.next();//c3

				driver.switchTo().window(child2WindowHanlde);//switch child2
				boolean result = child2WindowHanlde.equals(driver.getWindowHandle());
				System.out.println("Checking child 2 window: " + result);
				String newWindowHeader = driver.findElement(By.xpath("//div/h3")).getText();
				System.out.println(newWindowHeader);
				System.out.println(newWindowHeader.equals("New Window"));
				driver.close();

				driver.switchTo().window(child1WindowHanlde);//switch child1
				result = child1WindowHanlde.equals(driver.getWindowHandle());
				System.out.println("Checking child 1 window: " + result);
				driver.close();

				driver.switchTo().window(child3WindowHanlde);//switch child3
				result = child3WindowHanlde.equals(driver.getWindowHandle());
				System.out.println("Checking child 3 window: " + result);
				driver.close();

				driver.switchTo().window(parentWindowHanlde);// switch to parent
				result = parentWindowHanlde.equals(driver.getWindowHandle());
				System.out.println("Checking parent window: " + result);
				String parentWindowHeader = driver.findElement(By.cssSelector(".example>h3")).getText();
				System.out.println(parentWindowHeader);
				System.out.println(parentWindowHeader.equals("Opening a new window"));
				driver.close();
				Thread.sleep(2000);
			}
		
//		driver.quit();
	}


