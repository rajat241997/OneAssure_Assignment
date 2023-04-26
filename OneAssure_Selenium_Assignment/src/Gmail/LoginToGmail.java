package Gmail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToGmail {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // Launching Chrome
		driver.get("https://www.google.com/gmail/about/"); // Get URL
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// CLick on Sign in button
		WebElement signIn_Button = driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
		signIn_Button.click();
		// Enter email
		WebElement email = driver.findElement(By.id("identifierId"));
		email.sendKeys("rajatpardhi97@gmail.com");

		// Click on Next button
		WebElement nextButton = driver.findElement(By.xpath("(//span[@class=\"VfPpkd-vQzf8d\"])[2]"));
		nextButton.click();

		// Apply java wait
		Thread.sleep(5000);
		// Taking Screen
		// Take a screenshot of the current page
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Save the screenshot to a file
		FileUtils.copyFile(screenshot,
				new File("C:\\Users\\rajat\\Desktop\\OneAssure_Assignment\\Screenshot\\Couldn’t sign you in.jpg"));
		/*
		 * Couldn’t sign you in This browser or app may not be secure. Learn more Try
		 * using a different browser. If you’re already using a supported browser, you
		 * can try again to sign in.
		 */
		FileUtils.copyFile(screenshot, new File(".//screenshot/Couldn’t sign you in.jpg"));

	}

}
