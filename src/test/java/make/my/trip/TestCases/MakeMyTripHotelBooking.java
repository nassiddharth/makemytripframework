package make.my.trip.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import make.my.trip.pages.HotelsPage;
import make.my.trip.pages.LoginPage;
import make.my.trip.utilities.ConfigFileReader;

public class MakeMyTripHotelBooking{

	public WebDriver driver;
	public LoginPage loginPage;
	public HotelsPage hotelPage;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		System.setProperty(ConfigFileReader.readDataFromPropertiesFile("webdriverConfig"),
				ConfigFileReader.readDataFromPropertiesFile("chromeDriverPath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(ConfigFileReader.readDataFromPropertiesFile("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
	
	@Test
	public void login() throws IOException, InterruptedException{
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickLoginButton(ConfigFileReader.readDataFromPropertiesFile("email"),
				ConfigFileReader.readDataFromPropertiesFile("password"));
		hotelPage = PageFactory.initElements(driver, HotelsPage.class);
		hotelPage.clickHotels();
		hotelPage.enterCity(ConfigFileReader.readDataFromPropertiesFile("cityName"));
		hotelPage.clickCal();
		hotelPage.selectGuest();
		hotelPage.priceRange();
		hotelPage.selectFilter();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		
	}

}
