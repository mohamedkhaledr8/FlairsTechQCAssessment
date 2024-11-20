package commonComponents;


import element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenu {

    private final ElementActions elementActions;

    public SideMenu(WebDriver driver) {
        elementActions = new ElementActions(driver);
    }

    public void navigateToAdminViewSystemUserPage() {
        elementActions.clickElement(By.xpath("//a[contains(@href,'viewAdminModule')]"));
    }
}
