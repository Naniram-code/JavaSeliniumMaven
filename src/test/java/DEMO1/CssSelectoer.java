package DEMO1;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssSelectoer {
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
        //1.css with tag & id
        WebElement email = driver.findElement(By.cssSelector("input#login-username"));
        email.sendKeys("b0@esiix.ccom");
        WebElement password = driver.findElement(By.cssSelector("input#login-password"));
        password.sendKeys("ify@1tt23");

        WebElement text = driver.findElement(By.cssSelector("[data-qa='qewoqoleka']"));
        Assert.assertEquals(text.getText(), "Don't have an account? Start a free trial");

        WebElement test1= driver.findElement(By.cssSelector("[id='js-sign-in-heading']"));
        Assert.assertEquals(test1.getText(), "SIGN IN TO VWO PLATFORM");

        driver.findElement(By.id("js-login-btn")).click();
        String loginpageTitle = driver.getTitle();
        Assert.assertEquals(loginpageTitle, "Login - VWO");
        Thread.sleep(2000);
        driver.close();
    }
    @Test(priority = 1)
    public void loginPositiveTest() throws InterruptedException {
        //2.Unique Attribute and key [k='v']
        WebElement email = driver.findElement(By.cssSelector("[data-qa='hocewoqisi']"));
        email.sendKeys("vwouser@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("[data-qa='jobodapuxe']"));
        password.sendKeys("!@#$%^&*()Abc");

        driver.findElement(By.id("js-login-btn")).click();
        String loginpageTitle = driver.getTitle();
        Assert.assertEquals(loginpageTitle, "Login - VWO");
        Thread.sleep(2000);
        driver.quit();}
    @AfterTest
    public void tearDown() {

        driver.quit();
}}
