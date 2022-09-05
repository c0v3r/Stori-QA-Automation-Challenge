package tests;

import model.Course;
import model.Engineer;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.HomeSteps;
import steps.PopUpSteps;
import steps.PracticePageSteps;

import java.util.List;

public class StoriQAAutomationChallengeTest extends BaseTest {
    public static final String STORI_CARD = "Stori Card";
    PracticePageSteps practicePageSteps;
    PopUpSteps popUpSteps;
    HomeSteps homeSteps;

    @Test()
    public void suggestionClassExampleTest() {
        practicePageSteps = new PracticePageSteps();
        practicePageSteps.setTxt("Me");
        practicePageSteps.autoSearch("Mexico");
    }


    @Test()
    public void drodownExampleTest() {
        practicePageSteps = new PracticePageSteps();
        practicePageSteps.selectOption("Option2");
        practicePageSteps.selectOption("Option3");
    }


    @Test()
    public void switchWindowExampleTest() {
        practicePageSteps = new PracticePageSteps();
        practicePageSteps.clickOpenWindowButton();

        popUpSteps = new PopUpSteps();
        Assert.assertEquals(popUpSteps.get30DayMoneyBackMessage(),
                "30 DAY MONEY BACK GUARANTEE", "Texts are not equal");
    }


    @Test()
    public void switchTabExampleTest() {
        practicePageSteps = new PracticePageSteps();
        practicePageSteps.clickOpenTabButton();

        homeSteps = new HomeSteps();
        homeSteps.goToViewAllCoursesButton();
    }


    @Test()
    public void switchToAlertExampleTest() {
        practicePageSteps = new PracticePageSteps();
        practicePageSteps.setAlertText(STORI_CARD);
        practicePageSteps.clickOnAlertButton();
        System.out.println(practicePageSteps.getAlertText());

        practicePageSteps.setAlertText(STORI_CARD);
        practicePageSteps.clickOnConfirmButton();
        Assert.assertEquals(practicePageSteps.getAlertText(),
                "Hello Stori Card, Are you sure you want to confirm?" ,
                "Texts are not equal");
    }


    @Test()
    public void webTableExampleTest() {
        practicePageSteps = new PracticePageSteps();
        List<Course> courseList = practicePageSteps.getCourses(25);
        System.out.println("Number of courses that are $25: " + courseList.size());

        for (Course course : courseList) {
            System.out.println("Course Name: " + course.getCourse());
        }
    }


    @Test()
    public void webTableFixedHeaderTest() {
        practicePageSteps = new PracticePageSteps();
        List<Engineer> engineerList = practicePageSteps.getEngineers();

        for (Engineer engineer : engineerList) {
            System.out.println("Name of the engineer: " + engineer.getName());
        }
    }


    @Test()
    public void iFrameExampleTest() {
        practicePageSteps = new PracticePageSteps();
        System.out.println("Iframe: " + practicePageSteps.getTextIframe());
    }
}

