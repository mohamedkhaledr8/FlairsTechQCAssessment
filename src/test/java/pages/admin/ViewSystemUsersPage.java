package pages.admin;

import element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewSystemUsersPage {

    private final ElementActions elementActions;

    public ViewSystemUsersPage(WebDriver driver) {
        elementActions = new ElementActions(driver);
    }

    public void clickAddButton() {
        elementActions.clickElement(By.xpath("//div[@class='orangehrm-header-container']/button"));

    }

    public String getRecordsNumber() {
        return elementActions.getElementText(By.xpath("//div[contains(@class,'orangehrm-horizontal')]/span"));
    }


    public void searchForUser(String userName) {
        elementActions.typeText(By.xpath("(//div[@class='oxd-form-row']/descendant::input)[1]"), userName);
        elementActions.submit(By.xpath("//div[contains(@class,'form-actions')]/button[@type='submit']"));
    }

    public void deleteUser(String userName) {
        elementActions.clickElement(By.xpath("//div[text()='" + userName + "']/../following-sibling::div[4]/div/button[1]"));
        elementActions.clickElement(By.xpath("//div[@role='document']/descendant::button[contains(@class, 'label-danger')]"));

    }

    public void resetFilter() {
        elementActions.clickElement(By.xpath("//div[contains(@class,'form-actions')]/button[1]"));

    }


}
