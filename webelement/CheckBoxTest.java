package webelement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTest {
	static WebDriver driver;
	public static void main(String[] args) {
		setUp();
		testCheckBoxExist();
		testCheckBox2Selected();
		testCheckBoxSelectedAndDeselected();

//		driver.close();
	}
	public static void setUp() {


	// step1: formulate a test domain url & driver path
			String siteUrl = "file:///C:/Users/PC/eclipse-workspace/DemoOnSelenium/static/web-application.html";
			String driverPath = "drivers/windows/chromedriver.exe";

			// step2: set system properties for selenium dirver
			System.setProperty("webdriver.chrome.driver", driverPath);

			// step3: instantiate selenium webdriver
			driver = new ChromeDriver();

			// step4: add implicit wait (Unconditional Delay)
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			
			// step5: launch browser
			driver.get(siteUrl);
		}
	public static void testCheckBoxExist() {
		WebElement vehicle1 =driver.findElement(By.id("vehicle1"));
		WebElement vehicle2 =driver.findElement(By.id("vehicle2"));
		WebElement vehicle3 =driver.findElement(By.id("vehicle3"));
		
		if(vehicle1.isDisplayed() && vehicle2.isDisplayed() && vehicle3.isDisplayed()) {
			System.out.println("Test is passed !");
		}else {
			System.out.println("Test is Failed !");
		}
	}
	
	public static void testCheckBox2Selected() {
		WebElement vehicle2 =driver.findElement(By.id("vehicle2"));

		
		if(vehicle2.isSelected()) {
				System.out.println("Test selected 2 is passed !");
			}else {
				System.out.println("Test selected 2 is Failed !");
			}
		
	}
	public static void testCheckBoxSelectedAndDeselected() {
		WebElement vehicle1 =driver.findElement(By.id("vehicle1"));
		WebElement vehicle2 =driver.findElement(By.id("vehicle2"));
		WebElement vehicle3 =driver.findElement(By.id("vehicle3"));

		//select radio button
		vehicle1.click();//selected
		vehicle2.click();//de selected
		vehicle3.click();//selected
		
		if(vehicle3.isSelected()) {
				System.out.println("Test selected 1,3 is selected and vehicle 2 is deselected passed !");
			}else {
				System.out.println("Test selected 3 is Failed !");
			}
		
	}
}
