package KeybordEvent;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class InteractwithElementsUsingJS {

	public static void main(String[] args) {

		ChromeOptions option;
		WebDriver driver;
		option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.setHeadless(false);//user interface browser mode on/of(false/true)
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(option);


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//JavascriptExecutor js=driver;
		
		
		//First name - inputbox
		WebElement inputbox=driver.findElement(By.id("RESULT_TextField-1"));
		js.executeScript("arguments[0].setAttribute('value','john')", inputbox);
		
		//Radio button
		WebElement male_Rd=driver.findElement(By.id("RESULT_RadioButton-7_0"));
		//male_Rd.click();  //ClickInterceptedException
		js.executeScript("arguments[0].click();",male_Rd);
		
		
		//Checkbox
		WebElement chkbox=driver.findElement(By.id("RESULT_CheckBox-8_0"));
		js.executeScript("arguments[0].click();",chkbox);
		
		
		//button
		WebElement button=driver.findElement(By.id("FSsubmit"));
		js.executeScript("arguments[0].click();",button);
		
	}

}
