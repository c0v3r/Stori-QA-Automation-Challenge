package utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.logging.Logger;


public class StepReporterEventListener implements StepLifecycleListener {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(StepReporterEventListener.class));

    @Override
    public void beforeStepStart(StepResult result) {
        LOGGER.info("Step to be Completed: " + result.getName());
    }

    @Override
    public void afterStepUpdate(StepResult result) {
        LOGGER.info("Step Completed: " + result.getName());
        this.takeScreenShot();
    }

    @Attachment("Captura de pantalla")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot) BrowserManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}