package iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class IframeDemo {

	public static void main(String[] args) {
		ChromeOptions option;
		WebDriver driver;
		option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.setHeadless(false);//user interface browser mode on/of(false/true)
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(option);

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("mce_0_ifr");
		
		driver.findElement(By.id("tinymce")).clear(); // clears box
		driver.findElement(By.id("tinymce")).sendKeys("Welcome to automation");
		
		driver.findElement(By.id("tinymce")).sendKeys(Keys.CONTROL+"A"); //select text
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[@title='Bold']")).click();//bold text
		

	}

}
