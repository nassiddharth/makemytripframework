package make.my.trip.pageconstants;

public class HotelsContants {

	public static final String Hotels_Text = "//span[text()='Hotels']";

	public static final String City_Text = "//input[@id='city']";

	public static final String Enter_City_Name = "//input[@placeholder='Enter city/ Hotel/ Area/ Building']";

	public static final String Select_City = "//p[contains(text(),'Bengaluru, Karnataka, India')]";

	public static final String Select_Check_In_Date = "//span[contains(text(),'CHECK-IN')]";

	public static final String Number_Of_Guest = "//span[contains(text(),'ROOMS')]";

	public static final String Select_Adult_Guest = "//span[contains(text(),'ADULT')]/following::li[text()='2'][1]";

	public static final String Select_Child_Guest = "//span[contains(text(),'ADULT')]/following::li[text()='1'][2]";

	public static final String Apply_Button = "//button[contains(text(),'APPLY')]";

	public static final String Select_Age = "//select[@id='0']";

	public static final String Search_Button = "//button[@id='hsw_search_button']";

	public static final String Minimum_Price_Slider = "(//div[@class='rangeSliderWrap directionLtr']/child::div[@class='input-range']//div)[3]";

	public static final String Maximum_Price_Slider = "(//div[@class='rangeSliderWrap directionLtr']/child::div[@class='input-range']//div)[4]";

	public static final String Price_Range_Text = "//div[contains(text(),'Price Per Night')]";

	public static final String Recommended_Hotels = "//p[contains(text(),'Recommended for You')]";

	public static final String Select_Hotel = "//div[@id='Listing_hotel_0']";

	public static final String Home_Text = "//a[contains(text(),'Home')]";

	public static final String Clear_Button = "//a[contains(text(),'Clear')]";

	public static final String Popular_Filter_View_Button = "(//span[contains(text(),'View More')])[1]";

	public static final String Popular__Filter_Hide_Button = "(//span[contains(text(),'Hide')])[1]";

	public static final String Last_Popular_Filter_CheckBox = "(//div[@id='POPULAR']//div[contains(text(),'Popular Filters')]/following-sibling::ul//span/input[@type='checkbox']/../label)[last()]";
	
	public static final String My_Name_Text = "//span[contains(text(),'Hey')]";
	
	public static final String Logout_Button = "//p[contains(text(),'Logout')]";

}
