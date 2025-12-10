package listeners;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("extent-reports/ExecutionReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result) {
        Object[] params = result.getParameters();
        String dynamicName = result.getMethod().getMethodName();

        if (params != null && params.length > 0) {
            dynamicName += " - " + params[0].toString();
        }

        ExtentTest extentTest = extent.createTest(dynamicName);
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().log(Status.FAIL, "Test Failed");
        test.get().log(Status.FAIL, result.getThrowable());

        // Obtener driver desde BaseTest
        WebDriver driver = (WebDriver) result.getAttribute("driver");

        if (driver != null) {
            try {
                // Crear carpeta si no existe
                File screenshotsFolder = new File("screenshots");
                if (!screenshotsFolder.exists()) {
                    screenshotsFolder.mkdir();
                }

                // Nombre del archivo
                String screenshotPath = "screenshots/" + result.getName() + ".png";

                // Tomar screenshot
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.copy(src.toPath(), new File(screenshotPath).toPath());

                // Adjuntar al reporte
                test.get().addScreenCaptureFromPath(screenshotPath);

            } catch (IOException e) {
                test.get().log(Status.WARNING, "No se pudo guardar el screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
