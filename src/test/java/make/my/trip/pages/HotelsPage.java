package make.my.trip.pages;

import static make.my.trip.pageconstants.HotelsContants.Apply_Button;
import static make.my.trip.pageconstants.HotelsContants.City_Text;
import static make.my.trip.pageconstants.HotelsContants.Clear_Button;
import static make.my.trip.pageconstants.HotelsContants.Enter_City_Name;
import static make.my.trip.pageconstants.HotelsContants.Home_Text;
import static make.my.trip.pageconstants.HotelsContants.Hotels_Text;
import static make.my.trip.pageconstants.HotelsContants.Last_Popular_Filter_CheckBox;
import static make.my.trip.pageconstants.HotelsContants.Logout_Button;
import static make.my.trip.pageconstants.HotelsContants.Maximum_Price_Slider;
import static make.my.trip.pageconstants.HotelsContants.Minimum_Price_Slider;
import static make.my.trip.pageconstants.HotelsContants.My_Name_Text;
import static make.my.trip.pageconstants.HotelsContants.Number_Of_Guest;
import static make.my.trip.pageconstants.HotelsContants.Popular_Filter_View_Button;
import static make.my.trip.pageconstants.HotelsContants.Popular__Filter_Hide_Button;
import static make.my.trip.pageconstants.HotelsContants.Price_Range_Text;
import static make.my.trip.pageconstants.HotelsContants.Recommended_Hotels;
import static make.my.trip.pageconstants.HotelsContants.Search_Button;
import static make.my.trip.pageconstants.HotelsContants.Select_Adult_Guest;
import static make.my.trip.pageconstants.HotelsContants.Select_Age;
import static make.my.trip.pageconstants.HotelsContants.Select_Check_In_Date;
import static make.my.trip.pageconstants.HotelsContants.Select_Child_Guest;
import static make.my.trip.pageconstants.HotelsContants.Select_City;
import static make.my.trip.pageconstants.HotelsContants.Select_Hotel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import make.my.trip.utilities.CommonUtility;
import make.my.trip.utilities.SynchronisationUtils;

public class HotelsPage {
	
	protected WebDriver driver;
	
	public HotelsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = Hotels_Text)
	private WebElement hotelTxt;
	
	@FindBy(xpath = City_Text)
	private WebElement cityTxt;
	
	@FindBy(xpath = Enter_City_Name)
	private WebElement cityName;
	
	@FindBy(xpath = Select_City)
	private WebElement selectCity;
	
	@FindBy(xpath = Select_Check_In_Date)
	private WebElement checkInDate;
	
	@FindBy(xpath = Number_Of_Guest)
	private WebElement numOfGuest;
	
	@FindBy(xpath = Select_Adult_Guest)
	private WebElement adultGuest;
	
	@FindBy(xpath = Select_Child_Guest)
	private WebElement childGuest;
	
	@FindBy(xpath = Select_Age)
	private WebElement childage;
	
	@FindBy(xpath = Apply_Button)
	private WebElement applyBtn;
	
	@FindBy(xpath = Search_Button)
	private WebElement searchBtn;
	
	@FindBy(xpath = Minimum_Price_Slider)
	private WebElement minPrice;
	
	@FindBy(xpath = Maximum_Price_Slider)
	private WebElement maxPrice;
	
	@FindBy(xpath = Price_Range_Text)
	private WebElement priceRange;
	
	@FindBy(xpath = Recommended_Hotels)
	private WebElement recommendedHotels;
	
	@FindBy(xpath = Select_Hotel)
	private WebElement selectHotel;
	
	@FindBy(xpath = Home_Text)
	private WebElement homeTxt;
	
	@FindBy(xpath = Clear_Button)
	private WebElement clearBtn;
	
	@FindBy(xpath = Popular_Filter_View_Button)
	private WebElement viewMoreBtn;
	
	@FindBy(xpath = Popular__Filter_Hide_Button)
	private WebElement hideBtn;
	
	@FindBy(xpath = Last_Popular_Filter_CheckBox)
	private WebElement lastPopularFilter;
	
	@FindBy(xpath = My_Name_Text)
	private WebElement nameTxt;
	
	@FindBy(xpath = Logout_Button)
	private WebElement logoutBtn;
	
	
	public void clickHotels() {
		SynchronisationUtils.waitForElementToBeVisible(this.hotelTxt, driver);
		this.hotelTxt.click();
		SynchronisationUtils.staticWait(5);
		
	}
	public void enterCity(String cityName) {
		SynchronisationUtils.waitForElementToBeVisible(this.cityTxt, driver);
		this.cityTxt.click();
		SynchronisationUtils.waitForElementToBeVisible(this.cityName, driver);
		this.cityName.sendKeys(cityName);
		SynchronisationUtils.staticWait(2);
		SynchronisationUtils.waitForElementToBeVisible(this.selectCity, driver);
		this.selectCity.click();
	}
	
	public void clickCal() throws InterruptedException {
		int numberOfDays = 7;
	    DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
	    Calendar cal = Calendar.getInstance();
	    Calendar nextcal = Calendar.getInstance();
	    cal.add(Calendar.DATE, numberOfDays);
	    nextcal.add(Calendar.DATE, numberOfDays+1);
	    String selectedDate = dateFormat.format(cal.getTime());
	    String nextDate = dateFormat.format(nextcal.getTime());
		SynchronisationUtils.waitForElementToBeVisible(this.checkInDate, driver);
		CommonUtility.clickToElement(this.checkInDate, driver);
		Thread.sleep(10);
		String date = "//div[@class='DayPicker-Day' and contains(@aria-label,'" + selectedDate + "')]";
		WebElement selectDate = driver.findElement(By.xpath(date));
		String nextDay = "//div[@class='DayPicker-Day' and contains(@aria-label,'" + nextDate + "')]";
		WebElement selectNextDate = driver.findElement(By.xpath(nextDay));
		selectDate.click();
		SynchronisationUtils.waitForElementToBeVisible(selectNextDate, driver);
		selectNextDate.click();
	}
	
	public void selectGuest() {
		SynchronisationUtils.waitForElementToBeVisible(this.numOfGuest, driver);
		CommonUtility.clickToElement(this.numOfGuest, driver);
		SynchronisationUtils.waitForElementToBeVisible(this.adultGuest, driver);
		this.adultGuest.click();
		SynchronisationUtils.waitForElementToBeClickable(this.childGuest, driver);
		this.childGuest.click();
		SynchronisationUtils.waitForElementToBeClickable(this.childage, driver);
		this.childage.click();
		Select age = new Select(this.childage);
		age.selectByIndex(2);
		SynchronisationUtils.waitForElementToBeClickable(this.applyBtn, driver);
		this.applyBtn.click();
		SynchronisationUtils.waitForElementToBeClickable(this.searchBtn, driver);
		this.searchBtn.click();
		SynchronisationUtils.staticWait(7);
	}
	
	public void priceRange() throws InterruptedException {
		Actions action = new Actions(driver);
		action.clickAndHold(this.minPrice).moveByOffset(15, 0).release().perform();
		SynchronisationUtils.waitForElementToBeClickable(this.priceRange, driver);
		CommonUtility.moveToParticularElement(this.priceRange, driver);
		SynchronisationUtils.staticWait(5);
		action.clickAndHold(this.maxPrice).moveByOffset(-85, 0).release().perform();
		SynchronisationUtils.staticWait(5);
		CommonUtility.moveToParticularElement(this.recommendedHotels, driver);
		String parentWindow = driver.getWindowHandle();
		SynchronisationUtils.waitForElementToBeVisible(this.selectHotel, driver);
		this.selectHotel.click();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!parentWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				SynchronisationUtils.staticWait(5);
				SynchronisationUtils.waitForElementToBeVisible(this.homeTxt, driver);
				driver.close();
			}
	}
		driver.switchTo().window(parentWindow);
		SynchronisationUtils.staticWait(5);
	}
	
	public void selectFilter() {
		SynchronisationUtils.waitForElementToBeClickable(this.clearBtn, driver);
		this.clearBtn.click();
		SynchronisationUtils.staticWait(5);
		CommonUtility.clickToElement(this.viewMoreBtn, driver);
		SynchronisationUtils.staticWait(5);
		SynchronisationUtils.waitForElementToBeClickable(this.lastPopularFilter, driver);
		CommonUtility.moveToParticularElement(this.hideBtn, driver);
		this.lastPopularFilter.click();
		SynchronisationUtils.staticWait(5);
		CommonUtility.moveToParticularElement(this.recommendedHotels, driver);
		String parentWindow = driver.getWindowHandle();
		SynchronisationUtils.waitForElementToBeVisible(this.selectHotel, driver);
		this.selectHotel.click();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!parentWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				SynchronisationUtils.staticWait(5);
				SynchronisationUtils.waitForElementToBeVisible(this.homeTxt, driver);
				SynchronisationUtils.waitForElementToBeClickable(this.nameTxt, driver);
				this.nameTxt.click();
				SynchronisationUtils.waitForElementToBeClickable(this.logoutBtn, driver);
				this.logoutBtn.click();
				driver.close();
			}
	}
		driver.switchTo().window(parentWindow);
	}

}
