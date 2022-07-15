package steps;


import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import static steps.DriverFactory.getDriver;


public class Hooks {
	public static Scenario scenario;
	public static String url ;
	
	WebDriver driver = getDriver();
	
	
	@After
	public void finaliza(Scenario scenario){
		captureScreenshot(driver, scenario);
		DriverFactory.killDriver();
	
	}
	

	 public void captureScreenshot(WebDriver driver, Scenario scenario) {
		    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		    File arquivo = takesScreenshot.getScreenshotAs(OutputType.FILE);
		    try {
				FileUtils.copyFile(arquivo, new File(
						"ScreenShot" + File.separator +  scenario.getName().replace("\"", " ") + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
