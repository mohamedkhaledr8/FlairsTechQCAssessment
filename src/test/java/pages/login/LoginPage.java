package pages.login;

import gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final ElementActions elementActions;

    public LoginPage(WebDriver driver) {
        elementActions = new ElementActions(driver);
    }

    public void login(String userName, String password) {
        elementActions.type(By.name("username"), userName);
        elementActions.type(By.name("password"), password);
        elementActions.click(By.xpath("//button[@type='submit']"));

    }
}
