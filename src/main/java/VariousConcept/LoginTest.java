package VariousConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LoginTest {
	
	
	WebDriver driver;
	@BeforeMethod
	public void init() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println(driver.getTitle());
		
		
		By userNameLocator = By.xpath("//input[@id='username']");
		By passwordLocator = By.xpath("//*[@id=\"password\"]");
		By signInButtonLocator = By.xpath("/html/body/div/div/div/form/div[3]/button");
		
		driver.findElement(userNameLocator).sendKeys("demo@techfios.com");
		driver.findElement(passwordLocator).sendKeys("abc123");
		driver.findElement(signInButtonLocator).click();
}
	@AfterMethod
	public void teardown() {
		
		driver.close();
		driver.quit();
	}
}