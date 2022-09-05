package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BrowserManager;
import utils.Common;

public class HomePage {

    private WebElement viewAllCoursesBtn;


    public HomePage() {
        viewAllCoursesBtn = BrowserManager
                .findWebElementWait(By.xpath("//a[contains(.,'VIEW ALL COURSES')]"));
    }

    public void goToViewAllCoursesBtn() {
        Common.goToHiddenElement(viewAllCoursesBtn);
    }
}
