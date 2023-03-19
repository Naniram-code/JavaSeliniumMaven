package DEMO1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {
    ChromeOptions option;
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.setHeadless(false);//user interface browser mode on/of(false/true)
        option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(option);
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test
    public void webTableElements() {

        WebElement table = driver.findElement(By.xpath("//table[contains(@id,\"customers\")]"));//Table path
        List<WebElement> rows = table.findElements(By.xpath("//table[contains(@id,\"customers\")]/tbody/tr"));//Row
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.xpath("//table[contains(@id,\"customers\")]/tbody/tr[2]/td")); //Column path
            for (WebElement col : cols) {
                System.out.println(col.getText());
            }
        }
    }

}
