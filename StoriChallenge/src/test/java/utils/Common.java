package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Common {
    private static ArrayList<String> tabs;

    public static void clickJS(WebElement element) {
        WebDriver driver = BrowserManager.getDriver();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


    public static void changeToNewTab() {
        waitSeconds(5);

        tabs = new ArrayList<>(BrowserManager.getDriver().getWindowHandles());
        BrowserManager.getDriver().switchTo().window(tabs.get(1));
    }

    public static void goBackToMainTab() {
        BrowserManager.getDriver().switchTo().window(tabs.get(0));
    }

    public static String getAlertText() {
        return BrowserManager.getDriver().switchTo().alert().getText();
    }

    public static void clickOnOkAlertButton() {
        BrowserManager.getDriver().switchTo().alert().accept();
    }

    public static void switchToIframe(WebElement iframe) {
        BrowserManager.getDriver().switchTo().frame(iframe);
    }

    public static void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void takeSnapShot(String nameFile) {
        TakesScreenshot scrShot = ((TakesScreenshot) BrowserManager.getDriver());

        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile = new File("./" + nameFile + ".png");

        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void goToHiddenElement(WebElement element) {
        Actions actions = new Actions(BrowserManager.getDriver());
        actions.moveToElement(element);
        actions.perform();
        sendKeyDown();
    }

    public static void sendKeyDown() {
        Actions actions = new Actions(BrowserManager.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
}
