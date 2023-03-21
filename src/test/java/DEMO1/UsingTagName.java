package DEMO1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsingTagName {


		ChromeOptions option;
		WebDriver driver;
@BeforeMethod
		public void loadBrowser() {
			option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			option.setHeadless(false);//user interface browser mode on/of(false/true)
			option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.get("https://www.amazon.com");
		}
		// input -> txtBox/CheckBox/RadioBtn/Button/Tab 
		// a -> links/hyperlink
		// img -> images
		// table -> webTables -> tr-rows | td-columns
		// div
		// select -> static drop down
		// iframe -> frame
		
		// findElements() -> return list of webElements with the tagName
		@Test(priority = 1)
		public void listElementso1(){
	List<WebElement> inputElements = driver.findElements(By.tagName("input"));
		System.out.println("Number of input webElement: "+inputElements.size());
			driver.close();}
		//@Test(priority = 1)
				public void listElements(){
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		System.out.println("Number of links: "+linkElements.size());
		
		for(WebElement link: linkElements) {
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
			driver.close();
		}}
		@Test(priority = 2)
			public void listElements1(){
	        List<WebElement> imageElements = driver.findElements(By.tagName("img"));
		    System.out.println("Number of images: "+imageElements.size());
				driver.close();}
	@Test(priority = 3)
			public void listElements2(){
	List<WebElement> selectElements = driver.findElements(By.tagName("select"));
		System.out.println("Number of static dropdown: "+selectElements.size());
				driver.close();}
	@Test(priority = 4)
				public void listElements3(){
		List<WebElement> tableElements = driver.findElements(By.tagName("table"));
		System.out.println("Number of tables: "+tableElements.size());
				driver.close();}
	@Test(priority = 5)
			public void listElements4(){
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of iframes: "+iframeElements.size());



		driver.close();


}}
