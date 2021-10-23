package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MainPage {
    By langbutton = By.cssSelector("Button.bui-button.bui-button--light.bui-button--large div");
    By engbutton = By.cssSelector(".bui-group__item:nth-child(1) > .bui-group:nth-child(1) .bui-grid__column:nth-child(3) .bui-inline-container__main:nth-child(2)");
    By calendar = By.cssSelector(".sb-date-field__icon.sb-date-field__icon-btn.bk-svg-wrapper.calendar-restructure-sb");
    By next = By.cssSelector(".bui-calendar__control.bui-calendar__control--next");
    By search = By.cssSelector(".sb-searchbox__button");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void switchToEng() {
        driver.findElement(langbutton).click();
        driver.findElement(engbutton).click();
    }

    public void chooseCity(String city) {
        driver.findElement(By.xpath("//input[@name='ss']")).sendKeys(city);
    }

    public void setDates(String date1, String date2) {
        driver.findElement(calendar).click();
        driver.findElement(next).click();
        driver.findElement(By.xpath("//td[@data-date='" + date1 + "']")).click();
        driver.findElement(By.xpath("//td[@data-date='" + date2 + "']")).click();
    }

    public void search() {
        driver.findElement(search).click();
    }


}
