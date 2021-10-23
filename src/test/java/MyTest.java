import java.time.Duration;

import PageObjects.MainPage;
import PageObjects.Registration;
import PageObjects.Testresult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyTest {
    WebDriver driver;
    MainPage scenario;
    Testresult result;
    Registration enter;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.booking.com");
    }

    @Test(priority = 1)
    public void Homepage() {
        scenario = new MainPage(driver);

        try {
            Thread.sleep(2000);
            scenario.switchToEng();
            scenario.chooseCity("New York");
            scenario.setDates("2021-12-01", "2021-12-31");
            scenario.search();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void checkValues() {
        result = new Testresult(driver);
        assertTrue(result.getCities().stream().allMatch(s -> s.contains("New York")));
        assertTrue(result.getCheckinDate().contains("December 1, 2021"));
        assertTrue(result.getCheckoutDate().contains("December 31, 2021"));
    }

    @Test(priority = 3)
    public void RegistrationInSys() {
        enter = new Registration(driver);
        enter.registerButton();
        enter.skUser("glaeddyvcarme@gmail.com");
        enter.password("Dd1234567890");
    }
}