package FirstCode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {
    public static void main(String[] args) throws InterruptedException{
        ChromeOptions Option =new ChromeOptions();
        Option.addArguments("--remote-allow-origins=*");
        //1) Launch browser
        ChromeDriver driver = new ChromeDriver(Option);


        //WebDriver driver=new ChromeDriver();

        //2) open url on the browser
        driver.get("https://app.vwo.com");

        driver.manage().window().maximize(); // maximize the page
        Thread.sleep(5000);
        driver.close();
    }
}