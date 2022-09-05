package steps;


import io.qameta.allure.Step;
import model.Course;
import model.Engineer;
import pages.PracticePage;
import utils.Common;

import java.util.List;
import java.util.stream.Collectors;

public class PracticePageSteps {
    private static final String PAGE_NAME = "Practice Page: ";
    private PracticePage page;
    private String alertText;

    public PracticePageSteps() {
        this.page = new PracticePage();
    }

    @Step(PAGE_NAME + "User types: {texto}")
    public PracticePageSteps setTxt(String texto) {
        page.getCountryTxt().sendKeys(texto);
        return this;
    }


    @Step(PAGE_NAME + "User types: {text}")
    public PracticePageSteps autoSearch(String text) {
        page.dinamicSearch(text);
        return this;
    }

    @Step(PAGE_NAME + "User selects: {option}")
    public void selectOption(String option) {
        page.selectDropdown(option);
        Common.waitSeconds(5);
    }

    @Step(PAGE_NAME + "User clicks on Open Window Button")
    public void clickOpenWindowButton() {
        page.getOpenWindowBtn().click();
    }

    @Step(PAGE_NAME + "User clicks on Open Tab Button")
    public void clickOpenTabButton() {
        page.getOpenTabBtn().click();
        Common.changeToNewTab();
    }

    @Step(PAGE_NAME + "User types on Alert textbox: {text}")
    public void setAlertText(String text) {
        page.getAlertTxt().sendKeys(text);
    }

    @Step(PAGE_NAME + "User clicks on Alert button")
    public void clickOnAlertButton() {
        page.getAlertBtn().click();
        alertText = Common.getAlertText();
    }

    @Step(PAGE_NAME + "User clicks on Confirm button")
    public void clickOnConfirmButton() {
        page.getConfirmBtn().click();
        alertText = Common.getAlertText();
    }

    public String getAlertText() {
        return alertText;
    }

    @Step(PAGE_NAME + "User gets courses")
    public List<Course> getCourses(int price) {

        return page.getCourses()
                .stream()
                .filter(c -> c.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Step(PAGE_NAME + "User gets engineers")
    public List<Engineer> getEngineers() {
        return page.getEngineers();
    }

    @Step(PAGE_NAME + "User gets the Text Highlighted")
    public String getTextIframe() {
        Common.switchToIframe(page.getIframe());
        Common.goToHiddenElement(page.getIFrameTextHighlighted());
        return page.getIFrameTextHighlighted().getText();
    }
}
