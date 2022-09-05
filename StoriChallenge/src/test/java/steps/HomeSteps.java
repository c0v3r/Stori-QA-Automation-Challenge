package steps;

import io.qameta.allure.Step;
import pages.HomePage;
import utils.Common;

public class HomeSteps {
    private static final String PAGE_NAME = "Home Page: ";
    private HomePage page;

    public HomeSteps() {
        this.page = new HomePage();
    }


    @Step(PAGE_NAME + "User goes to View All Courses Button")
    public HomeSteps goToViewAllCoursesButton() {
        page.goToViewAllCoursesBtn();
        Common.takeSnapShot("switchTabExampleTest");
        return this;
    }
}
