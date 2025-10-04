package pages.admin;

import gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewSystemUsersPage {

    private final ElementActions elementActions;

    public ViewSystemUsersPage(WebDriver driver) {
        elementActions = new ElementActions(driver);
    }

    public void clickAddButton() {
        elementActions.click(By.xpath("//div[@class='orangehrm-header-container']/button"));

    }

    public String getRecordsNumber() {
        return elementActions.getText(By.xpath("//div[contains(@class,'orangehrm-horizontal')]/span"));
    }


    public void searchForUser(String userName) {
        elementActions.type(By.xpath("(//div[@class='oxd-form-row']/descendant::input)[1]"), userName);
        elementActions.click(By.xpath("//div[contains(@class,'form-actions')]/button[@type='submit']"));
    }

    public void deleteUser(String userName) {
        elementActions.click(By.xpath("//div[text()='" + userName + "']/../following-sibling::div[4]/div/button[1]"));
        elementActions.click(By.xpath("//div[@role='document']/descendant::button[contains(@class, 'label-danger')]"));

    }

    public void resetFilter() {
        elementActions.click(By.xpath("//div[contains(@class,'form-actions')]/button[1]"));

    }


}
