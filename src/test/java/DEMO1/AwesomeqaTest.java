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

import java.util.List;

public class AwesomeqaTest {
    ChromeOptions option;
    WebDriver driver;
    //Actions action = new Actions(driver);
    @BeforeMethod
    public void openBrowser() {
        option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.setHeadless(false);//user interface browser mode on/of(false/true)
        option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(option);

        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");

        driver.manage().window().maximize();
    }
         @Test(enabled = false)
        public void Registration() throws InterruptedException {

            // Find all form-control elements on the page
            // find form-control elements
            List<WebElement> formControlElements=driver.findElements(By.className("form-control"));
            formControlElements.get(1).sendKeys("Johnn"); // enter first name
            formControlElements.get(2).sendKeys("Doe"); // enter last name
            formControlElements.get(3).sendKeys("johndo637e@example.com"); // enter email
            formControlElements.get(4).sendKeys("12342567"); //enter  phone number
            formControlElements.get(5).sendKeys("jdshfjhdjsh%$%$%123"); // password
            formControlElements.get(6).sendKeys("jdshfjhdjsh%$%$%123"); // confirm password

            driver.findElement(By.xpath("//input[@name='agree']")).click();

            driver.findElement(By.xpath("//input[@type='submit']")).click();

            String expectedTitle="Your Account Has Been Created!";
            String ActualTitle=driver.getTitle();
            System.out.println(ActualTitle);
             Assert.assertEquals(ActualTitle,expectedTitle);
            driver.close();
            Thread.sleep(2000);}
            @Test(priority = 2)
             public void loginPositiveTest() throws InterruptedException {
                driver.findElement(By.xpath("//a[text()='login page']")).click();
                 WebElement email = driver.findElement(By.id("input-email"));
                 email.sendKeys("johndo637e@example.com");
                 WebElement password = driver.findElement(By.id("input-password"));
                 password.sendKeys("jdshfjhdjsh%$%$%123");

                 driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
                String expectedTitle="My Account";
                String ActualTitle=driver.getTitle();
                System.out.println(ActualTitle);
               Assert.assertEquals(ActualTitle,expectedTitle);
                driver.close();
                Thread.sleep(2000);}


             @Test(priority = 1)
             public void loginNegativeTest() throws InterruptedException {
                 driver.findElement(By.xpath("//a[text()='login page']")).click();
                 WebElement email = driver.findElement(By.id("input-email"));
                 email.sendKeys("johndohhje@example.com");
                 WebElement password = driver.findElement(By.id("input-password"));
                 password.sendKeys("jdshfjhdjkksh%$%$%123");

                 driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

                 String ExpectedWarningText="Warning: No match for E-Mail Address and/or Password.";
                WebElement ss=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
                 String ActualwarningText=ss.getText();
                 System.out.println(ActualwarningText);
                 Assert.assertEquals(ActualwarningText,ExpectedWarningText);
                 driver.close();
                 Thread.sleep(2000);}
    @AfterTest
    public void tearDown() {

        driver.quit();
        }}

