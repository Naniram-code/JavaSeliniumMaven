package VWO_Project;

import org.example.Main;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class VwoWeb_Test {
    ChromeOptions option;
    WebDriver driver;


    @BeforeMethod
    public void openBrowser() {
        option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.setHeadless(false);//user interface browser mode on/of(false/true)
        option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(option);
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
    }
    @Test(priority =1,enabled =true)
    public void NewRegistration() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.findElement(By.linkText("Start a free trial")).click();
        WebElement emailadd=driver.findElement(By.tagName("input"));
        //emailadd.sendKeys("Abc4321@gmail.com");//(1st user created)
        //emailadd.sendKeys("Abcd4321@gmail.com");//(2nd user created)
        emailadd.sendKeys("ARbcd34321@gmail.com");//(3nd user created)
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(5000);
       WebElement name=driver.findElement(By.xpath("//*[@id='page-v1-fname']"));
        Thread.sleep(5000);
        actions.sendKeys(name,"Jacksion").build().perform();
        WebElement Lastname=driver.findElement(By.xpath("//*[@id='page-v1-lname']"));
        actions.sendKeys(Lastname,"Zazz").build().perform();

        WebElement Clist=driver.findElement(By.className("iti__flag-container"));
        actions.moveToElement(Clist).click().build().perform();
        Thread.sleep(5000);
        WebElement Ncountry=driver.findElement(By.xpath("//*[@class='iti__country-list']/li[2]/span[1]"));
        actions.moveToElement(Ncountry).click().build().perform();

        WebElement PhoneNum=driver.findElement(By.xpath("//*[@id='page-v1-pnumber']"));
        actions.sendKeys(PhoneNum,"234576946").build().perform();
        WebElement Psw=driver.findElement(By.xpath("//*[@id='page-v1-pwd']"));
        actions.sendKeys(Psw,"abcedrg@#$$$65").build().perform();
        WebElement clickbutton=driver.findElement(By.tagName("button"));
        actions.moveToElement(clickbutton).doubleClick();
        String ActualTitle=driver.getTitle();
        System.out.println(ActualTitle);
        String ExpectedTitle="Get Started with Free Trial | VWO";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
        Thread.sleep(6000);
        driver.close();

    }

    @Test(priority = 2)
    public void loginNegetiveTest() throws InterruptedException {
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("bb0@esiix.ccom");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("ify@1tt23");

        driver.findElement(By.id("js-login-btn")).click();
      WebElement element=new WebDriverWait(driver, Duration.ofSeconds(5)) //Explicit Wait
               .until(ExpectedConditions.presenceOfElementLocated(By.id("js-notification-box-msg")));
               // .until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));

        String ActualErrorMsgg =element.getText();
        System.out.println(ActualErrorMsgg);
        String ExpectedErroeMsg="Your email, password, IP address or location did not match";
        Assert.assertEquals(ActualErrorMsgg,ExpectedErroeMsg);

        driver.close();}

    @Test(priority = 3)
    public void loginPositiveTest() throws InterruptedException {
        WebElement email = driver.findElement(By.id("login-username"));
        //email.sendKeys("vwouser@gmail.com");//(User 1)
        email.sendKeys("Abc4321@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        //password.sendKeys("!@#$%^&*()Abc");(psw user 1)
        password.sendKeys("abcedrg@#$$$6");
        driver.findElement(By.id("js-login-btn")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)//
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {//Fluent Wait:
            @Override
            public WebElement apply(WebDriver webDriver) {
                return  driver.findElement(By.id("js-login-btn"));
            }
        });
        driver.findElement(By.id("js-login-btn")).click();
        String ActualloginpageTitle = driver.getTitle();
        String ExpectedloginpageTitle="Login - VWO";
        Assert.assertEquals(ActualloginpageTitle,ExpectedloginpageTitle);
        driver.close();}
    @Test(priority = 3)
    public void VwoAssignment() throws InterruptedException {
        Actions actions= new Actions(driver);
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("vwouser@gmail.com");//(User 1)
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("!@#$%^&*()Abc");//(psw user 1)


        WebElement checkbox=driver.findElement(By.xpath("//*[@class='checked-login-icon text--highlight']"));
              actions.moveToElement(checkbox).click().build().perform();
        Thread.sleep(5000);

        WebElement element=driver.findElement(By.id("js-login-btn"));
        actions.moveToElement(element).click().build().perform();
        Thread.sleep(5000);

        WebElement text=driver.findElement(By.xpath("//p[@class='page-sub-title']"));
        String ActuallDashbordPageText = text.getText();
        System.out.println(ActuallDashbordPageText);
        String ExpectedlDashbordPageText="Hi vwo1 bwo2, here's an overview of your experience optimization journey";
        Assert.assertEquals(ActuallDashbordPageText,ExpectedlDashbordPageText);
        Thread.sleep(5000);
       WebElement ss=driver.findElement(By.xpath("//*[@class='icon-button'][1]"));
        actions.moveToElement(ss).doubleClick().build().perform();

       WebElement sss=driver.findElement(By.xpath("//*[@class='menu-dropdown-list Miw(100px)']/li"));
        actions.moveToElement(sss).doubleClick().build().perform();

        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        driver.close();}
    @AfterTest
    public void tearDown() {

        driver.quit();
}}
