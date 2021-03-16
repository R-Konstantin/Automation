import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GUITests {

    @Test
    public void openGooglePage() {

        DriverManagerType driverManagerType = DriverManagerType.CHROME;
        WebDriverManager.getInstance(driverManagerType).setup();

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.quit();


    }
}
