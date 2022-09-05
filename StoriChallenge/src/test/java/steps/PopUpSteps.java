package steps;

import io.qameta.allure.Step;
import pages.PopUpPage;
import utils.BrowserManager;

import java.util.Iterator;
import java.util.Set;


public class PopUpSteps {
    private static final String PAGE_NAME = "Pop Up: ";
    private PopUpPage page;

    public PopUpSteps() {
        this.page = new PopUpPage();
    }

    @Step(PAGE_NAME + "El usuario selecciona")
    public String get30DayMoneyBackMessage() {
        String parentWindowHandler = BrowserManager.getDriver().getWindowHandle();
        goToPopUp();

        String message = page.get30DayMoneyBackMessage().getText();

        backToPracticePage(parentWindowHandler);
        return message;
    }

    private void backToPracticePage(String parentWindowHandler) {
        BrowserManager.getDriver().switchTo().window(parentWindowHandler);
    }

    public void goToPopUp() {

        String subWindowHandler = null;

        Set<String> handles = BrowserManager.getDriver().getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        BrowserManager.getDriver().switchTo().window(subWindowHandler); // switch to popup window
    }
}
