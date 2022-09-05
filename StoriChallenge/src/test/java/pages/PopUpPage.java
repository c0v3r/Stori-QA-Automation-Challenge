package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BrowserManager;
import utils.Common;

public class PopUpPage {

    public WebElement get30DayMoneyBackMessage() {
        Common.waitSeconds(2);
        Actions action = new Actions(BrowserManager.getDriver());
        action.sendKeys(Keys.ESCAPE).perform();

        return BrowserManager.
                findWebElementWait(By.xpath("//*[@id='welcome']//h3[contains(.,'30 day Money Back Guarantee')]"));
    }
}
