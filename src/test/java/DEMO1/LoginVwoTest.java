package DEMO1;

import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    @Test(priority = 2)
    public void loginNegetiveTest() throws InterruptedException {
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("b0@esiix.ccom");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("ify@1tt23");

        driver.findElement(By.id("js-login-btn")).click();
        WebElement errorMsg = driver.findElement(By.id("js-notification-box-msg"));
        Assert.assertEquals(errorMsg.getText(), "Your email, password, IP address or location did not match");
        Thread.sleep(2000);
        driver.close();}
    @Test(priority = 1)
    public void loginPositiveTest() throws InterruptedException {
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("vwouser@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("!@#$%^&*()Abc");
        driver.findElement(By.id("js-login-btn")).click();
        String loginpageTitle = driver.getTitle();
        Assert.assertEquals(loginpageTitle, "Login - VWO");
        Thread.sleep(2000);
        driver.quit();}}
