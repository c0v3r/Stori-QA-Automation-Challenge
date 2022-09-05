package pages;

import model.Course;
import model.Engineer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserManager;
import utils.Common;

import java.util.ArrayList;
import java.util.List;

public class PracticePage {
    private WebElement countryTxt;
    private WebElement countryDdn;
    private WebElement openWindowBtn;
    private WebElement openTabBtn;
    private WebElement alertTxt;
    private WebElement alertBtn;
    private WebElement confirmBtn;

    private List<WebElement> coursesWebTable;
    private List<WebElement> engineersWebTable;

    private WebElement iFrame;

    private WebElement iFrameTextHighlighted;


    public PracticePage() {
        countryTxt = BrowserManager.findWebElementWait(By.xpath("//*[@id='autocomplete']"));
        openWindowBtn = BrowserManager.findWebElementWait(By.xpath("//*[@id='openwindow']"));
        openTabBtn = BrowserManager.findWebElementWait(By.xpath("//*[@id='opentab']"));
        alertTxt = BrowserManager.findWebElementWait(By.xpath("//*[@id='name']"));
        alertBtn = BrowserManager.findWebElementWait(By.xpath("//*[@id='alertbtn']"));
        confirmBtn = BrowserManager.findWebElementWait(By.xpath("//*[@id='confirmbtn']"));
        coursesWebTable = BrowserManager.getDriver().findElements(By.xpath("//*[@id='product']/tbody/tr/th/../../tr"));
        engineersWebTable = BrowserManager.getDriver().findElements(By.xpath("//div/*[@id='product']/tbody/tr"));
        iFrame = BrowserManager.findWebElementWait(By.xpath("//*[@id='courses-iframe']"));
    }

    public WebElement getCountryTxt() {
        return countryTxt;
    }

    public void dinamicSearch(String txt) {
        countryDdn = BrowserManager
                .findWebElementWait(By.xpath(String.format("//li/div[contains(.,'%s')]", txt)));

        Common.waitSeconds(2);
        countryDdn.click();
        Common.waitSeconds(3);
    }

    public void selectDropdown(String option) {
        Select se = new Select(BrowserManager.findWebElementWait(By.xpath("//*[@id='dropdown-class-example']")));
        se.selectByVisibleText(option);
    }

    public WebElement getOpenWindowBtn() {
        return openWindowBtn;
    }

    public WebElement getOpenTabBtn() {
        return openTabBtn;
    }

    public WebElement getAlertTxt() {
        return alertTxt;
    }

    public WebElement getAlertBtn() {
        return alertBtn;
    }

    public WebElement getConfirmBtn() {
        return confirmBtn;
    }

    public List<Course> getCourses() {
        List<Course> courseList = new ArrayList<>();

        for (int i = 1; i < coursesWebTable.size(); i++) {

            Course course = new Course();
            course.setInstructor(coursesWebTable.get(i).findElement(By.xpath("td[1]")).getText());
            course.setCourse(coursesWebTable.get(i).findElement(By.xpath("td[2]")).getText());
            course.setPrice(Integer.parseInt(coursesWebTable.get(i).findElement(By.xpath("td[3]")).getText()));

            courseList.add(course);
        }

        return courseList;
    }

    public List<Engineer> getEngineers() {
        List<Engineer> engineerList = new ArrayList<>();

        for (int i = 0; i < engineersWebTable.size(); i++) {

            Engineer engineer = new Engineer();
            engineer.setName(engineersWebTable.get(i).findElement(By.xpath("td[1]")).getText());
            engineer.setPosition(engineersWebTable.get(i).findElement(By.xpath("td[2]")).getText());
            engineer.setCity(engineersWebTable.get(i).findElement(By.xpath("td[3]")).getText());
            engineer.setAmount(Integer.parseInt(engineersWebTable.get(i).findElement(By.xpath("td[4]")).getText()));

            engineerList.add(engineer);
        }

        return engineerList;
    }

    public WebElement getIframe() {
        return iFrame;
    }

    public WebElement getIFrameTextHighlighted() {
        iFrameTextHighlighted = BrowserManager.findWebElementWait(By.xpath("//div[@class='price-title']//div[2]//li[2]"));
        return iFrameTextHighlighted;
    }
}
