package HeatMap;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HeatMapclick2 {


    ChromeOptions option;
    WebDriver driver;

    @BeforeMethod
        public void openBrowser() throws InterruptedException {
            option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
            option.setHeadless(false);//user interface browser mode on/of(false/true)
            option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(option);
            driver.manage().window().maximize();
            driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/" +
                    "1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1" +
                    "lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXB" +
                    "lIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNz" +
                    "BiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsI" +
                    "mZybiI6ZmFsc2V9&isHttpsOnly=1");
            driver.manage().window().maximize();}
        @Test(priority =1)
        public void TextVarify() throws InterruptedException {
            WebElement element=new WebDriverWait(driver, Duration.ofSeconds(5))//Explicit Wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='view--campaign ng-scope']//li[2]")));
            Actions action = new Actions(driver);
            action.moveToElement(element).click().build().perform();
            Set<String> handles = driver.getWindowHandles();
            System.out.println("Number of windows opened: "+handles.size());

            Iterator<String> it = handles.iterator();//Iterator
            String parentWindowHanlde = it.next();//parent
            String childWindowHanlde = it.next();//child
            driver.switchTo().window(childWindowHanlde);//switch child1
            WebElement frm1=driver.findElement(By.id("heatmap-iframe"));//iframe
            driver.switchTo().frame(frm1);//switch to iframe
            WebElement CLICKMAP=new WebDriverWait(driver, Duration.ofSeconds(5))//Explicit Wait
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='option-tab vwo_player-option']/span")));
            action.moveToElement(CLICKMAP).doubleClick().build().perform();
            System.out.println(" CLICKMAP Text:"+CLICKMAP.getText());

            driver.switchTo().parentFrame();// back(switch) to Parentframe

           WebElement TextVerification=new WebDriverWait(driver, Duration.ofSeconds(5))//Explicit Wait
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='vwo-widget-1671204638150']/div/p[2]")));

            boolean BooleanResult=driver.findElement(By.xpath("//*[@id='vwo-widget-1671204638150']/div/p[2]")).isDisplayed();
            Assert.assertEquals(true,BooleanResult);
            String ExpectedText="Massive Exclusive Bonuses Expiring on 25th December";
            String ActualText= TextVerification.getText();
            System.out.println(ActualText);
            Assert.assertEquals(ExpectedText,ActualText);
            driver.close();}

        @AfterTest
        public void tearDown() {

            driver.quit();
        }}






