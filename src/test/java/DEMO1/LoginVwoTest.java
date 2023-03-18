package DEMO1;

import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LoginVwoTest {
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
    @Test(priority =1,enabled =false)
    public void NewRegistration() throws InterruptedException {
        driver.findElement(By.linkText("Start a free trial")).click();
        WebElement emailadd=driver.findElement(By.tagName("input"));
        //emailadd.sendKeys("Abc4321@gmail.com");//(1st user created)
        //emailadd.sendKeys("Abcd4321@gmail.com");//(2nd user created)
        emailadd.sendKeys("Abcd34321@gmail.com");//(3nd user created)
        driver.findElement(By.tagName("button")).click();
       WebElement name=driver.findElement(By.xpath("//*[@id='page-v1-fname']"));
       Actions actions = new Actions(driver);
        Thread.sleep(5000);
        actions.sendKeys(name,"Jacksion").build().perform();
        WebElement Lastname=driver.findElement(By.xpath("//*[@id='page-v1-lname']"));
        actions.sendKeys(Lastname,"Zazz").build().perform();
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
        Thread.sleep(5000);
        driver.close();

    }

    @Test(priority = 2)
    public void loginNegetiveTest() throws InterruptedException {
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("b0@esiix.ccom");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("ify@1tt23");

        driver.findElement(By.id("js-login-btn")).click();
        String ActualErrorMsg = driver.findElement(By.id("js-notification-box-msg")).getText();
        String ExpectedErroeMsg="Your email, password, IP address or location did not match";
        Assert.assertEquals(ActualErrorMsg,ExpectedErroeMsg);
        Thread.sleep(2000);
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
        String ActualloginpageTitle = driver.getTitle();
        String ExpectedloginpageTitle="Login - VWO";
        Assert.assertEquals(ActualloginpageTitle,ExpectedloginpageTitle);
        Thread.sleep(2000);
        driver.close();}
    @AfterTest
    public void tearDown() {

        driver.quit();
}}
