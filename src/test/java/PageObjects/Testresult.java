package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class Testresult {
    By propc = By.xpath("//span[@data-testid='address']");
    By checkin = By.xpath("//div[@data-placeholder='Check-in Date']");
    By checkout = By.xpath("//div[@data-placeholder='Check-out Date']");
    private final WebDriver driver;


    public Testresult(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public List<String> getCities() {
        List<WebElement> webElements = driver.findElements(propc);
        List<String> listValues = webElements.stream().map(webElement -> webElement.getText()).toList();
        return listValues;
    }

    public String getCheckinDate() {
        String checkindate = driver.findElement(checkin).getText();
        return checkindate;
    }

    public String getCheckoutDate() {
        String checkoutdate = driver.findElement(checkout).getText();
        return checkoutdate;
    }

}