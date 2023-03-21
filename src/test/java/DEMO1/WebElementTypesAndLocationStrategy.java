package DEMO1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElementTypesAndLocationStrategy {
	
	// Selenium Automation:
		// 1. Specifically Locate the element(WebElement/WebObject/GUI(Graphical user Interface)object or element)
		// 2. Perform action
		// 3. Validate action performed
	
	// WebElements or WebObjects or GUI (Graphical User Interface) objects or elements:
				// Types:
					// 1. Text Box/Field: user can input some characters
					// 2. Button/Tab: user input to click on it
					// 3. Radio Button: user input to click to select, "Round button"
					// 4. Check box: user input to click to select, "check mark"
					// 5. Links: click takes user to different page or application
					// 6. Text: to provide informations
					// 7. Drop Down: clicking on it more options are visible -> Static or Dynamic
					// 8. Menu/Menu link: high value feature/product/flow
					// 9. Pictures/Videos:
			
			// Strategy to locate webElement:
				// Types:
					// 1. Name: value pointed mostly are unique, most commonly used
					// 2. ID: value pointed mostly are unique, most commonly used
					// 3. linkText: text of the link itself
					// 4. partial linkText: unique portion of the link
					// 5. className: mostly not unique value, mostly not helpful to identify an element alone
					// 6. tagName: generic name, not able to identify an element, but helps to identify group of element in that category
					// 7. Xpath: can be used when nothing works, copy or customizable
					// 8. Css selector: can be used when nothing works, copy or customizable

//	<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" 
//			placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" 
//			aria-label="Search">
	
	
	// Understanding DOM:
	// <input type="text" name="userName" size="10" pb-role="username">
		// 1. tagName - input
		// 2. attribute - type/name/size/pb-role
		// 3. value - text/userName/10/username
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option;
		WebDriver driver;

		option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.setHeadless(false);//user interface browser mode on/of(false/true)
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(option);
		driver.manage().window().maximize(); // maximize window size to full size
		driver.get("https://www.amazon.com");
		
		String productForSearch = "samsung";
		
		// Handling text box/text field
		WebElement searchTxtField = driver.findElement(By.id("twotabsearchtextbox"));
		
		searchTxtField.sendKeys(productForSearch);
		
		// handling button/tab
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		// Creating verification
		String actualSearchResultPageTitle = driver.getTitle();
		
		// title verification
		if(actualSearchResultPageTitle.contains(productForSearch)) {
			System.out.println("Search functionality Test: Passed");
		}else {
			System.err.println("Search functionality Test: Failed");
			System.out.println("Actual title: "+actualSearchResultPageTitle);
			System.out.println("Product searched: "+productForSearch);
		}
		
		// url verification
		String actualSearchResultPageUrl = driver.getCurrentUrl();
		if(actualSearchResultPageUrl.contains(productForSearch)) {
			System.out.println("Search functionality Test: Passed");
		}else {
			System.err.println("Search functionality Test: Failed");
			System.out.println("Actual title: "+actualSearchResultPageUrl);
			System.out.println("Product searched: "+productForSearch);
		}
		
		// text in application verification
		// Handling text element
//		WebElement resultNumberTxtElement = driver.findElement(By.
//				className("a-color-state a-text-bold")); // exception -> NoSuchElementException
		WebElement resultNumberTxtElement = driver.findElement(By.
				xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]"));
		String resultNumberTxt = resultNumberTxtElement.getText();
		if(resultNumberTxt.contains(productForSearch)) {
			System.out.println("Search functionality Test: Passed");
		}else {
			System.err.println("Search functionality Test: Failed");
			System.out.println("Actual title: "+resultNumberTxt);
			System.out.println("Product searched: "+productForSearch);
		}
		
		// webElement verification
//		WebElement resultImageElement = driver.findElement(By.
//				cssSelector("#CardInstancexRAvRbQ71CqwGHoit8LQlA > div._bGlmZ_content_2rsXy > "
//						+ "div._bGlmZ_header_2PHEO > div > "
//						+ "div.a-section.a-spacing-none._bGlmZ_logo_3eW0R > a > div > img"));
		// copied xpath & css selector -> long | might not be sensitive -> need customization
//		#CardInstanceg4xJI6p_Z_Ms8EnWgqOHuQ > div._bGlmZ_content_2rsXy > 
//		div._bGlmZ_header_2PHEO > div > div.a-section.a-spacing-none._bGlmZ_logo_3eW0R > 
//		a > div > img
		WebElement resultImageElement = driver.findElement(By.
				cssSelector("div._bGlmZ_content_2rsXy > "
						+ "div._bGlmZ_header_2PHEO > div > "
						+ "div.a-section.a-spacing-none._bGlmZ_logo_3eW0R > a > div > img"));
		if(resultImageElement.isDisplayed()) {
			System.out.println("Search functionality Test: Passed");
		}else {
			System.err.println("Search functionality Test: Failed");
		}
		
		
		// Handling link/menu link
		String menuLink = "Best Sellers";
		WebElement link = driver.findElement(By.linkText(menuLink));
		link.click();
		String menuLinkPageTitle = driver.getTitle();
		if(menuLinkPageTitle.contains(menuLink)) {
			System.out.println("Menu link functionality Test: Passed");
		}else {
			System.err.println("Menu link functionality Test: Failed");
			System.out.println("Actual title: "+menuLinkPageTitle);
			System.out.println("Product searched: "+menuLink);
		}
		
		
		Thread.sleep(3000);
		driver.close();
	}
	
	// Assignment: Any application | Any 5 feature | Create automation script -> txtbox/link/button ->id/name/className/txt/partialTxt/copied xpath or Css selector -> verification
}
