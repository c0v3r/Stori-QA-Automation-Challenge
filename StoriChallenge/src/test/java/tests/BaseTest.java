package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserManager;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        try{
            BrowserManager.init();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        BrowserManager.quitDriver();
    }
}


