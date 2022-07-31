import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class FaceUserNamePassword {

    @Test
    void userNamePassword() throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.facebook.com/login/");

        driver.findElement(By.xpath("//input[contains(@name , 'email')]"));
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[contains(@name , 'pass')] [@type='password']"));
        Thread.sleep(4000);

        driver.findElement(By.xpath("//button[contains(@id, 'loginbutton')] ")).click();
        Thread.sleep(4000);

        TakesScreenshot ts = (TakesScreenshot) driver;

        File src = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src, new File(".//Test.png"));

    }
}
