package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Registration {
    By registerbutton = By.cssSelector(".bui-button.bui-button--secondary.js-header-login-link");
    By username = By.xpath("//input[@name='username']");
    By cont = By.xpath("//button[@type='submit']");
    By newpassword = By.id("password");
    By button = By.xpath("//button[@type='submit']");

    private final WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void registerButton() {
        driver.findElement(registerbutton).click();
    }

    public void skUser(String mail) {
        driver.findElement(username).sendKeys(mail);
        driver.findElement(cont).click();
    }

    public void password(String pass) {
        driver.findElement(newpassword).sendKeys(pass);
        driver.findElement(button).click();
    }
}



