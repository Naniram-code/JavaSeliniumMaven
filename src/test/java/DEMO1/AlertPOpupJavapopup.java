package DEMO1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertPOpupJavapopup{

			// Alert/Pop-up/Java POpup:
			ChromeOptions option;
	        WebDriver driver;
			   @BeforeMethod
			   public void openBrowser() {
	            option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
				option.setHeadless(false);//user interface browser mode on/of(false/true)
				option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	            driver = new ChromeDriver(option);
				driver.get("http://the-internet.herokuapp.com");}

			@Test(priority =1)
			public void AlertPOpup() throws InterruptedException {
				option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
				option.setHeadless(false);//user interface browser mode on/of(false/true)
				option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				driver = new ChromeDriver(option);
				driver.get("http://the-internet.herokuapp.com");

				driver.findElement(By.linkText("JavaScript Alerts")).click();
				driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
				Thread.sleep(5000);

				//handling jsAlert alert
				String jsAlert = driver.switchTo().alert().getText();
				System.out.println(jsAlert);
				driver.switchTo().alert().accept();
				Thread.sleep(5000);

				//handling jsComfirm Alert
				driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
				Thread.sleep(5000);
				String JsComfirm = driver.switchTo().alert().getText();
				System.out.println(JsComfirm);
				driver.switchTo().alert().dismiss();
				Thread.sleep(5000);

				//handling jsPrompt Alert
				driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
				driver.switchTo().alert().sendKeys("JsPrompt");
				Thread.sleep(5000);
				String jsComfirm = driver.switchTo().alert().getText();
				System.out.println(jsComfirm);
				driver.switchTo().alert().accept();
				Thread.sleep(5000);
				driver.close();
			}
				@Test(priority =2)
				public void droupdown() throws InterruptedException {
					driver.findElement(By.linkText("Dropdown")).click();
					WebElement allDropDown = driver.findElement(By.id("dropdown"));//amazo
					Select select = new Select(allDropDown);
					Thread.sleep(2000);
					select.selectByVisibleText("Option 2");
			}
	}

