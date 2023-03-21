package KeybordEvent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {

	public static void main(String[] args) {
		ChromeOptions option;
		WebDriver driver;
		option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.setHeadless(false);//user interface browser mode on/of(false/true)
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(option);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://text-compare.com/");
		
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("WELCOME TO AUTOMATION");
		
		Actions act=new Actions(driver);
		
		
		//ctrl +a
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		
		//ctrl +c
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		
		//tab
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		//act.sendKeys(Keys.TAB).perform(); // only if want to press single key then prefer this
		
		//ctrl+v
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
	}

}
