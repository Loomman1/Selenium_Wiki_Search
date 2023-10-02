import com.google.common.util.concurrent.Service;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args)
    {
//        Logger logger = Logger.getLogger("");
//        logger.setLevel(Level.FINE);
//        Arrays.stream(logger.getHandlers()).forEach(handler -> {handler.setLevel(Level.FINE);});
        File f = new File("E:/Programs/ChromeDriver_for_selenium_webdriver/chromedriver-win64/chromedriver.exe");
        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(f).build();

        WebDriver driver = new ChromeDriver(service);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        String title = driver.getTitle();
        System.out.println("Hello, I am "+title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement searchField = driver.findElement(By.name("search"));
        WebElement searchButton = driver.findElement(By.cssSelector(".cdx-search-input__end-button"));
        searchField.sendKeys("Selenium (software)");
        searchButton.click();
    }
}
