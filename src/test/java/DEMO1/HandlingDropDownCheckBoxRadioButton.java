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

public class HandlingDropDownCheckBoxRadioButton {
	// Drop Down -> 1. Static drop down 		2. Dynamic drop down -> Mouse & Keyboard???
		// 1. Static drop down -> select tagName -> Select class -> pass webElement in Select class constructor
				// to identify option -> a. visible txt		b. index	c. value
	ChromeOptions option;
	WebDriver driver;


	@BeforeMethod
	public void openBrowser() {
		option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.setHeadless(false);//user interface browser mode on/of(false/true)
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(option);
		driver.get("https://www.amazon.com");

		driver.manage().window().maximize();
	}
		// Handle drop down
	@Test
	public void droupdown() throws InterruptedException {


	WebElement allDropDown = driver.findElement(By.id("searchDropdownBox"));//amazo
	Select select = new Select(allDropDown);
		Thread.sleep(2000);
	select.selectByVisibleText("Amazon Fresh");

	Thread.sleep(3000);
	//select.selectByIndex(14); // Books
    //Thread.sleep(3000);
    // select.selectByValue("search-alias=amazon-pharmacy");
      //Thread.sleep(3000);

        //int allDropDownOptionTotal = 58;
    	//for(int i=0; i<=allDropDownOptionTotal; i++) {
			//select.selectByIndex(i);
     		//Thread.sleep(1000);}
       	}}
		
		// Handle check box
		//@Test
		//public void checkbox() throws InterruptedException {
//		driver.findElement(By.id("nav-link-accountList")).click();
//		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("continue")).click();
//		WebElement rememberMeCheckBox = driver.findElement(By.name("rememberMe"));
//		Thread.sleep(3000);
//		rememberMeCheckBox.click();
//		if(rememberMeCheckBox.isSelected()) {
//			System.out.println("Selected: Correct interaction");
//		}else {
//			System.out.println("Couldn't interact");
//		}
//		Thread.sleep(3000);
//		rememberMeCheckBox.click();
//		if(!rememberMeCheckBox.isSelected()) {
//			System.out.println("Deselected: Correct interaction");
//		}else {
//			System.out.println("Couldn't interact");
//		}
		
		// Handle Radio button
		/*driver.findElement(By.id("icp-nav-flyout")).click();
		WebElement englishRadioBtn = driver.findElement(By.xpath
				("//*[@id=\"icp-language-settings\"]/div[2]/div/label/input"));
		WebElement spanishRadioBtn = driver.findElement(By.xpath
				("//*[@id=\"icp-language-settings\"]/div[3]/div/label/i"));
		System.out.println("English Default select: "+englishRadioBtn.isSelected());
		System.out.println("Spanish Default select: "+spanishRadioBtn.isSelected());
		
		WebElement languageChangeHeader = driver.findElement(By.id("icp-language-heading"));
		System.out.println(languageChangeHeader.getText());
		Thread.sleep(3000);
		spanishRadioBtn.click();
		System.out.println(languageChangeHeader.getText());
		
		Thread.sleep(3000);
		driver.close();
	}*/
	
	// Assignment: Any application: Any feature -> any number test case -> automation all or whatever number can automation

