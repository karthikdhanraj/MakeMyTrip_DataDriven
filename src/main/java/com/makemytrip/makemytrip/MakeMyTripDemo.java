package com.makemytrip.makemytrip;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripDemo {
	
	public static String month ="November 2022";
	public static int date = 30;
	public static String classType;
	
	
	
	
	
	public static void main(String[] args) throws Throwable {
		
		
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	
	Actions act = new Actions(driver);
    classType = DataDriven.particularData("class", 2, 0);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	WebElement flights = driver.findElement(By.className("menu_Flights"));
	js.executeScript("arguments[0].click();", flights);
	
	WebElement from = driver.findElement(By.id("fromCity"));
	from.sendKeys("chennai");
	Thread.sleep(1000);	

	List<WebElement> fromoptions = driver.findElements(By.xpath("//ul[@role='listbox']/child::li"));
	int fromsize = fromoptions.size();
	
	for (WebElement webElement : fromoptions) {
		String text = webElement.getText();
		
	}
	
	for (int i = 1; i < fromsize; i++) {
		
		WebElement list1 = driver.findElement(By.xpath("//ul[@role='listbox']/child::li["+ i +"]"));

		js.executeScript("arguments[0].click();", list1);
		break;
		}
	
	Thread.sleep(1000);
	
	WebElement to = driver.findElement(By.id("toCity"));
	to.sendKeys("Delhi");
	Thread.sleep(1000);
	
	List<WebElement> tooptions = driver.findElements(By.xpath("//ul[@role='listbox']/child::li"));
	int tosize = tooptions.size();
	
	for (WebElement webElement : tooptions) {
		
		String text = webElement.getText();
		
	}
	
	for (int i = 1; i < fromsize; i++) {
		
		WebElement list1 = driver.findElement(By.xpath("//ul[@role='listbox']/child::li["+ i +"]"));
		
		js.executeScript("arguments[0].click();", list1);
		break;
		}
	
	WebElement depature = driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
	js.executeScript("arguments[0].click();", depature);
	
	while (true) {
		
		String calenderMonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		
		
		if (calenderMonth.equalsIgnoreCase(month)) {
			break;
			
		}
		else {
			WebElement next = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
			js.executeScript("arguments[0].click();", next);
		}
		
		
		}
	
	List<WebElement> dates = driver.findElements(By.xpath(" (//div[@class='DayPicker-Body'])[1]/descendant::div[@class='dateInnerCell']/child::p[1]"));
	
	for (WebElement webElement : dates) {
		
		String date = webElement.getText();
		int parseInt = Integer.parseInt(date);
		
		if (parseInt==MakeMyTripDemo.date) {
			
			js.executeScript("arguments[0].click();", webElement);
			break;
		}
		else {
			continue;
		}
		
	}
	
	WebElement travelClassPassengers = driver.findElement(By.xpath("//span[text()='Travellers & CLASS']"));
	js.executeScript("arguments[0].click();", travelClassPassengers);
	
	List<WebElement> classTypeList = driver.findElements(By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/child::li"));
	
	for (WebElement webElement : classTypeList) {
		
		String classtypelist = webElement.getText();
		
		
		if (classType.equalsIgnoreCase(classtypelist)) {
			
			js.executeScript("arguments[0].click();", webElement);
			break;
			
			}
		else {
			continue;
		}
	}
	
	List<WebElement> adultPassengerNumber = driver.findElements(By.xpath("//p[@data-cy='adultRange']/following-sibling::ul/child::li"));
	int adultCount = adultPassengerNumber.size();

	String adultNoString = DataDriven.particularData("Passengers", 1, 0);
	int noOfAdult = Integer.parseInt(adultNoString);
	
	
	for (int i = noOfAdult ; i < adultCount ; i++) {
		
        WebElement adult = driver.findElement(By.xpath("//p[@data-cy='adultRange']/following-sibling::ul/child::li["+i+"]"));
		js.executeScript("arguments[0].click();", adult);
		break;
		
		
	}
	
	
	List<WebElement> childNumber = driver.findElements(By.xpath("//p[@data-cy='childrenRange']/following-sibling::ul/child::li"));
	int childCount = childNumber.size();

	String childNoString = DataDriven.particularData("Passengers", 1, 1);
	int noOfChild = Integer.parseInt(childNoString);
	
	
	for (int i =noOfChild+1 ; i < childCount ; i++) {
		
        WebElement child = driver.findElement(By.xpath("//p[@data-cy='childrenRange']/following-sibling::ul/child::li["+i+"]"));
		js.executeScript("arguments[0].click();", child);
		break;
		
		
	}
	
	
	List<WebElement> infantNumber = driver.findElements(By.xpath("//p[@data-cy='infantRange']/following-sibling::ul/child::li"));
	int infantCount = infantNumber.size();

	String infantNoString = DataDriven.particularData("Passengers", 1, 2);
	
	int noOfinfant = Integer.parseInt(infantNoString);
	
	
	for (int i =noOfinfant+1 ; i < infantCount ; i++) {
		
        WebElement infant = driver.findElement(By.xpath("//p[@data-cy='infantRange']/following-sibling::ul/child::li["+i+"]"));
		js.executeScript("arguments[0].click();", infant);
		break;
		
		
	}
	
	WebElement apply = driver.findElement(By.xpath("//button[text()='APPLY']"));
	js.executeScript("arguments[0].click();", apply);
	
	
	WebElement search = driver.findElement(By.xpath("//a[text()='Search']"));
	js.executeScript("arguments[0].click();", search);


    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OKAY, GOT IT!']")));
	WebElement close = driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']"));
	js.executeScript("arguments[0].click();", close);
	
	List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='priceSection']/descendant::button"));
	int totalFlight = priceList.size();
	
	for (int i = 1; i < totalFlight; i++) {
		
		WebElement flight = driver.findElement(By.xpath("//div[@class='priceSection']/descendant::button["+i+"]"));
		js.executeScript("arguments[0].click();", flight);
		break;
	}
	
	WebElement book = driver.findElement(By.xpath("(//div[@class='viewFareBtnCol '])[1]/child::button"));
	js.executeScript("arguments[0].click();", book);
	
	
	Set<String> windowHandles = driver.getWindowHandles();
	
	for (String page : windowHandles) {
		
		String title = driver.switchTo().window(page).getTitle();
		
		
	}
	Thread.sleep(5000);
	
	//OPTIONAL
	WebElement secure = driver.findElement(By.xpath("//span[normalize-space()='Yes, Secure my trip.']/preceding-sibling::span"));
	js.executeScript("arguments[0].click();", secure);
	//
	
	
	
	
    WebElement adultEntry = driver.findElement(By.xpath("//font[text()='ADULT (12 yrs+)']"));
	act.moveToElement(adultEntry).build().perform();
	
	
	

	
	//adult

	for (int i = 1; i <= noOfAdult; i++) {
		
		WebElement addAdult = driver.findElement(By.xpath("//button[text()='+ ADD NEW ADULT']"));
		js.executeScript("arguments[0].click();", addAdult);
		
		String adultData = DataDriven.particularData("adult", i, 0);
		String[] split = adultData.split(" ");
		
		WebElement adultFirstName = driver.findElement(By.xpath("(//input[@placeholder='First & Middle Name'])["+i+"]"));
		adultFirstName.sendKeys(split[0]);
		
		WebElement adultLastname = driver.findElement(By.xpath("(//input[@placeholder='Last Name'])["+i+"]"));
		adultLastname.sendKeys(split[1]);
		
		String passengerSexDatadriven = DataDriven.particularData("adult", i, 1);
		
		List<WebElement> PassengerSex = driver.findElements(By.xpath("//div[@class='adultDetailsForm']/descendant::div[3]/following-sibling::div[2]//label"));
		int size = PassengerSex.size();
		
		for (WebElement a : PassengerSex) {
			String text = a.getText();
			if (text.equalsIgnoreCase(passengerSexDatadriven)) {
				
					WebElement male = driver.findElement(By.xpath("(//div[@class='adultListWrapper']/child::div/following-sibling::div["+i+"]//span[@class='selectTabText'])[1]"));
					js.executeScript("arguments[0].click();", male);
					Thread.sleep(2000);
					break;
					}
			    
			else {
				
				WebElement female = driver.findElement(By.xpath("(//div[@class='adultListWrapper']/child::div/following-sibling::div["+i+"]//span[@class='selectTabText'])[2]"));
				js.executeScript("arguments[0].click();", female);
				Thread.sleep(2000);
				break;
				}
			
			                              } 
		
		}
	//child
	if (noOfChild >0) {
		
	
	
	for (int i = 1; i <= noOfChild; i++) {
		
		WebElement addchild = driver.findElement(By.xpath("//button[text()='+ ADD NEW CHILD']"));
		js.executeScript("arguments[0].click();", addchild);
		
		String childData = DataDriven.particularData("child", i, 0);
		String[] split = childData.split(" ");
		
	    WebElement childFirstName = driver.findElement(By.xpath("(//div[@id='wrapper_CHILD']/child::div[2]/child::div/following-sibling::div[1]/descendant::input[@placeholder='First & Middle Name'])["+i+"]"));
		childFirstName.sendKeys(split[0]);
		
		WebElement chlidLastname = driver.findElement(By.xpath("(//div[@id='wrapper_CHILD']/child::div[2]/child::div/following-sibling::div[1]/descendant::input[@placeholder='Last Name'])["+i+"]"));
		chlidLastname.sendKeys(split[1]);
		
		String passengerSexDatadriven = DataDriven.particularData("child", i, 1);
		
		
		List<WebElement> PassengerSex = driver.findElements(By.xpath("//div[@id='wrapper_CHILD']/descendant::div[13]/child::div[3]/descendant::label"));
		int size = PassengerSex.size();
		
		for (WebElement a : PassengerSex) {
			String text = a.getText();
			if (text.equalsIgnoreCase(passengerSexDatadriven)) {
				
					WebElement male = driver.findElement(By.xpath("(//div[@id='wrapper_CHILD']/child::div/following-sibling::div/child::div/following-sibling::div["+i+"]//span[@class='selectTabText'])[1]"));
					js.executeScript("arguments[0].click();", male);
					Thread.sleep(2000);
					break;
					}
					
			else {
				
				WebElement female = driver.findElement(By.xpath("(//div[@id='wrapper_CHILD']/child::div/following-sibling::div/child::div/following-sibling::div["+i+"]//span[@class='selectTabText'])[2]"));
				js.executeScript("arguments[0].click();", female);
				Thread.sleep(2000);
				break;
				}
			
			                               }
		        }
	            }
	
	
	
	//infant
	if (noOfinfant>0) {
		
	
	for (int i = 1; i <= noOfinfant; i++) {
		
		WebElement addinfant = driver.findElement(By.xpath("//button[text()='+ ADD NEW INFANT']"));
		js.executeScript("arguments[0].click();", addinfant);
		
		String infantData = DataDriven.particularData("infant", i, 0);
		String[] split = infantData.split(" ");
		
		WebElement childFirstName = driver.findElement(By.xpath("(//div[@id='wrapper_INFANT']/child::div[2]/child::div/following-sibling::div[1]/descendant::input[@placeholder='First & Middle Name'])["+i+"]"));
		childFirstName.sendKeys(split[0]);
		
		WebElement chlidLastname = driver.findElement(By.xpath("(//div[@id='wrapper_INFANT']/child::div[2]/child::div/following-sibling::div[1]/descendant::input[@placeholder='Last Name'])["+i+"]"));
		chlidLastname.sendKeys(split[1]);
		
        String passengerSexDatadriven = DataDriven.particularData("infant", i, 1);
		
		List<WebElement> PassengerSex = driver.findElements(By.xpath("//div[@id='wrapper_INFANT']/descendant::div[13]/following-sibling::div[2]/descendant::label"));
		int size = PassengerSex.size();
		
		
		
		
		for (WebElement a : PassengerSex) {
			String text = a.getText();
			if (text.equalsIgnoreCase(passengerSexDatadriven)) {
				
					WebElement male = driver.findElement(By.xpath("(//div[@id='wrapper_INFANT']/child::div/following-sibling::div/child::div/following-sibling::div["+i+"]//span[@class='selectTabText'])[1]"));
					js.executeScript("arguments[0].click();", male);
					Thread.sleep(2000);
					break;
					}
			    
			else {
				
				WebElement female = driver.findElement(By.xpath("(//div[@id='wrapper_INFANT']/child::div/following-sibling::div/child::div/following-sibling::div["+i+"]//span[@class='selectTabText'])[2]"));
				js.executeScript("arguments[0].click();", female);
				Thread.sleep(2000);
				break;
				}
			
			}
	                                        }
	                  }
		

	
	WebElement countryCode = driver.findElement(By.xpath("//div[@id='Country Code']/descendant::div[3]"));
	act.moveToElement(countryCode).click().build().perform();
	
	WebElement mobile = driver.findElement(By.xpath("//input[@placeholder='Mobile No']"));
	mobile.sendKeys("9600070503");
	
	WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
	email.sendKeys("karthikdhanraj12@gmail.com");
	
	

	WebElement clickbutton = driver.findElement(By.xpath("//button[text()='Continue']"));
	act.doubleClick(clickbutton).build().perform();
	
	Thread.sleep(3000);
	
	
	WebElement confirm = driver.findElement(By.xpath("//button[text()='CONFIRM']"));
	js.executeScript("arguments[0].click();", confirm);
	
	WebElement yesPlease = driver.findElement(By.xpath("//button[text()='Yes, Please']"));
	js.executeScript("arguments[0].click();", yesPlease);
	
	//optional
	WebElement skip = driver.findElement(By.xpath("//span[text()='Skip to add-ons']"));
	js.executeScript("arguments[0].click();", skip);
	
	//WebElement clickContinue = driver.findElement(By.xpath("//button[text()='Continue']"));
	//js.executeScript("arguments[0].click();", clickContinue);
	
	WebElement proceedToPay = driver.findElement(By.xpath("//button[text()='Proceed to pay']"));
	js.executeScript("arguments[0].click();", proceedToPay);
	
	Thread.sleep(5000);
	
	WebElement card = driver.findElement(By.xpath("//span[text()='Credit/Debit/ATM Card']"));
	js.executeScript("arguments[0].click();", card);
	
	
	TakesScreenshot sc= (TakesScreenshot) driver;
	File src = sc.getScreenshotAs(OutputType.FILE);
	File dest = new File((System.getProperty("user.dir") + "/Image/mkt.png"));
	FileUtils.copyFile(src, dest);
	
    
    driver.quit();

}
	
}
