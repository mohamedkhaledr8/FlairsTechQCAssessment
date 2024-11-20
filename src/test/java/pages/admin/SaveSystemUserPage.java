package pages.admin;

import element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class SaveSystemUserPage {
    private final ElementActions elementActions;

    public SaveSystemUserPage(WebDriver driver) {
        elementActions = new ElementActions(driver);
    }

    public void selectUserRole(int role) {
        elementActions.clickElement(By.xpath("(//div[@class='oxd-select-wrapper'])[1]/div"));

        elementActions.clickElement(By.xpath("//div[@role='listbox']/div[@role='option'][" + role + "]"));
    }

    public void selectUserStatus(int status) {
        elementActions.clickElement(By.xpath("(//div[@class='oxd-select-wrapper'])[2]/div"));

        elementActions.clickElement(By.xpath("//div[@role='listbox']/div[@role='option'][" + status + "]"));
    }

    public void selectEmployeeName(String subName) {
        elementActions.typeText(By.xpath("//div[@class='oxd-autocomplete-wrapper']/descendant::input"), subName);
        var options = elementActions.getElements(By.xpath("//div[@role='listbox']/div[@role='option']/span"));
        int randomIndex = new Random().nextInt(options.size());
        String optionText = options.get(randomIndex).getText();
        elementActions.clickElement(By.xpath("//div[@role='listbox']/div[@role='option']/span[text()= '" + optionText + "']"));

    }

    public void typeUserName(String userName) {
        elementActions.typeText(By.xpath("(//input[@autocomplete='off'])[1]"), userName);
    }

    public void typePassword(String password) {
        elementActions.typeText(By.xpath("(//input[@autocomplete='off'])[2]"), password);
    }

    public void typeConfirmPassword(String confirmPassword) {
        elementActions.typeText(By.xpath("(//input[@autocomplete='off'])[3]"), confirmPassword);
    }

    public void clickSaveButton() {
        elementActions.submit(By.xpath("//button[@type='submit']"));
    }

}
