package DEMO1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestingAcademy {
    public static void main(String[] args) throws InterruptedException{

        ChromeOptions Option =new ChromeOptions();
        Option.addArguments("--remote-allow-origin=*");
        //1) Launch browser
        ChromeDriver driver = new ChromeDriver(Option);
        //WebDriver driver=new ChromeDriver();

        //2) open url on the browser
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize(); // maximize the page
        Thread.sleep(2000);
        //driver.close();//window not to be closed,New session can be started by used  same referance
        driver.quit();//Session ID is null and close all browser,Session ID=null
        //Window will be closed we have to call again the session creation and window open
    }

}
