package KeybordEvent;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TabsAndWindows {

	public static void main(String[] args) {
		ChromeOptions option;
		WebDriver driver;
		option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.setHeadless(false);//user interface browser mode on/of(false/true)
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(option);


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
				
		driver.get("https://www.opencart.com/");
		
		driver.switchTo().newWindow(WindowType.TAB); // OPENS NEW TAB
		//driver.switchTo().newWindow(WindowType.WINDOW); // OPENS IN ANOTHER WINDOW
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

}
