package lt.basepage.framework.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("http://192.168.0.37/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearsDown() {
            driver.quit();
    }
}
