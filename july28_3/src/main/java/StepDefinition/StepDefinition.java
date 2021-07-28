package StepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	WebDriver driver;

	@Given("^User is already on login page$")
	public void User_is_already_on_login_page() throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:/Program Files/Google/Chrome/Application/chrome/chrome.exe");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\Google\\Chrome\\Application\\chrome driver\\chromedriver.exe");
		// ooper waaale line me driver object ko assigned hua chrome driver ka path
		driver = new ChromeDriver(options);// driver looks for chrome through options opject

		driver.get("https://www.flipkart.com/");// chrome driver instance
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("^title of the page is Flipkart$")
	public void Title_of_the_page_is_Flipkart() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!",
				title);

	}

	@Then("^user enters username and password$")
	public void User_enters_username_and_password(DataTable credentials) 
	{
		for(Map<String,String> data:credentials.asMaps(String.class,String.class))
		{
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(data.get("username"));
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(data.get("password"));
		}
	}
	@Then("^user clicks on login button$")
	public void User_Clicks_on_Login_button() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();

	}

	@Then("^user is on Home page$")
	public void User_is_on_home_page() {
		String title2 = driver.getTitle();
		System.out.println("Home page title:" + title2);
		Assert.assertEquals(
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!",
				title2);

	}

	@Then("^user closes the browser$")
	public void User_closes_the_browser() {
		driver.quit();

	}

}
