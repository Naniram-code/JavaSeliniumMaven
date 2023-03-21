package KeybordEvent;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException   {

		ChromeOptions option;
		WebDriver driver;
		option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.setHeadless(false);//user interface browser mode on/of(false/true)
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(option);


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		//1) scroll down page by pixel
		//js.executeScript("window.scrollBy(0,3000)", "");
		//System.out.println(js.executeScript("return window.pageYOffset;"));  //3000		
				
		//2) scroll down the page till the element is present
		//WebElement flag=driver.findElement(By.xpath("//img[@alt='Flag of India']"));
		
		//js.executeScript("arguments[0].scrollIntoView();", flag);
		//System.out.println(js.executeScript("return window.pageYOffset;"));  //5077.40234375	
		
		//3) scroll down till end of the page/document
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(3000);
		
		// go back to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
	}

}
