package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BrowserManager {
    private static WebDriver driver;
    private static String browser;;
    private static String propertyFilePath = "./src/test/resources/Configuration.properties";
    private static WebDriverWait wait;


    private BrowserManager() {
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void init() {
        if (driver == null) {
            browser = System.getProperty("browser");
            openBrowser();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            init();
        }
        return driver;
    }

    public static WebElement findWebElementWait(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return driver.findElement(by);
    }

    public static void openBrowser() {
        String browserType = browser.toUpperCase();
        Properties properties = loadProperties();

        switch (browserType) {
            case "CH":
                configureChrome(properties.getProperty("PATHCHROMEDRIVER"));
                break;
            case "FF":
                configureFireFox(properties.getProperty("PATHFFDRIVER"));
                break;
            default:
                System.out.println("browser : " + browserType + " is invalid, Launching Chrome as browser of choice.");
                configureChrome(properties.getProperty("PATHCHROMEDRIVER"));
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30, 200);
        driver.get(properties.getProperty("URL"));
    }

    private static void configureChrome(String pathBin) {
        System.setProperty("webdriver.chrome.driver", pathBin);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
    }

    private static void configureFireFox(String pathBin) {
        System.setProperty("webdriver.gecko.driver", pathBin);
        driver = new FirefoxDriver();
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("File not found.");
        }
        return properties;
    }
}