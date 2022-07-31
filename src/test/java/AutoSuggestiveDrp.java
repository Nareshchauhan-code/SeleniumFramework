import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestiveDrp {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));

        for (WebElement ele : elements) {

            if (ele.getText().equalsIgnoreCase("Selenium")) {

                ele.click();
                break;
            }
        }

    }
}
