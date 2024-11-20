package pages.login;

import element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final ElementActions elementActions;

    public LoginPage(WebDriver driver) {
        elementActions = new ElementActions(driver);
    }

    public void login(String userName, String password) {
        elementActions.typeText(By.name("username"), userName);
        elementActions.typeText(By.name("password"), password);
        elementActions.submit(By.xpath("//button[@type='submit']"));

    }
}
