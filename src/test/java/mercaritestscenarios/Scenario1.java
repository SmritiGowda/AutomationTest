package mercaritestscenarios;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scenario1 {
	
	// Declaring the web driver globally
	public WebDriver driver;
	
	// A method for launching the browser and navigating till the search filter page
	@BeforeTest
	public void setup() throws InterruptedException 
	{
			// Launching the Chrome browser
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Smriti Gowda\\Desktop\\Personal\\Jobs\\Mercari\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver(); 
			// Going to the Mercari site
			driver.get("https://jp.mercari.com/"); 
			// Maximizing the Chrome browser window
			driver.manage().window().maximize(); 
			// Deleting the browser cookies
			driver.manage().deleteAllCookies(); 
			// Waiting time for the entire page to load
			driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS); 
			// Waiting time between each consecutive test steps 
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
			Thread.sleep(10000);
			// Clicking on the search bar
			driver.findElement(By.xpath("//input[contains(@class,'searchInput__268d8f3d')]")).click(); 
			// Clicking on "Select by category" (カテゴリーからさがす)
			driver.findElement(By.xpath("//p[contains(@class,'merText body__5616e150 primary__5616e150')]")).click(); 
			// Selecting "Books, Music & Games" (本・音楽・ゲーム) as the Tier 1 category 
			driver.findElement(By.xpath("//a[contains(text(),'本・音楽・ゲーム')]")).click(); 
			// Selecting "Books" (本) as the Tier 2 category
			driver.findElement(By.xpath("//div[@class='content__884ec505']//a[contains(text(),'本')]")).click();
			// Selecting "Computers & Technology" (コンピュータ/IT) as the Tier 3 category 
			driver.findElement(By.xpath("//a[contains(text(),'コンピュータ/IT')]")).click();
		
	}
	
	// A test method to verify that Tier1 category search condition is set correctly on the left side bar
	@Test(priority=1)
	public void VerifyTier1Category() 
	{
			// Locating a Tier1 category element
			Select select=new Select(driver.findElement(By.xpath("(//select[contains(@class,'merInputNode select__da4764db medium__da4764db')])[1]")));
			// Fetching the selected value of the Tier1 category field and storing it in a variable
			WebElement Tier1 = select.getFirstSelectedOption(); 
			// Fetching the selected value's text and storing it in a variable
			String Tier1category = Tier1.getText(); 
			// Printing a text of the Tier1 Category's selected value
			System.out.println(Tier1category); 
			// Initializing the Tier1 Category to a variable 'ExpectedTier1'
			String Expectedtier1="本・音楽・ゲーム";
			// Initializing the drop down's selected value to a variable 'ActualTier1'
			String Actualtier1= Tier1category; 
			// Verifying that the selected value of a drop down is matching with the Tier1 Category(i.e comparing ActualTier1 with ExpectedTier1)
			Assert.assertEquals(Actualtier1,Expectedtier1); 
	}
	
	// A test method to verify that Tier2 category search condition is set correctly on the left side bar
	@Test(priority=2)
	public void VerifyTier2Category() 
	{
			// Locating a Tier2 category element
			Select select=new Select(driver.findElement(By.xpath("(//select[contains(@class,'merInputNode select__da4764db medium__da4764db')])[2]")));
			// Fetching the selected value of the Tier1 category field and storing it in a variable
			WebElement Tier2 = select.getFirstSelectedOption(); 
			// Fetching the selected value's text and storing it in a variable
			String Tier2category = Tier2.getText(); 
			// Printing a text of the Tier2 Category's selected value
			System.out.println(Tier2category); 
			 // Initializing the Tier2 Category to a variable 'ExpectedTier2'
			String Expectedtier2="本"; 
			// Initializing the drop down's selected value to a variable 'ActualTier2'
			String Actualtier2= Tier2category; 
			// Verifying that the selected value of a drop down is matching with the Tier2 Category(i.e comparing ActualTier2 with ExpectedTier2)
			Assert.assertEquals(Actualtier2,Expectedtier2); 		
	}
	
	// A test method to verify the Tier3 category search condition is set correctly on the left side bar
	@Test(priority=3)
	public void VerifyTier3Category()
	{
			// Finding a Tier3 Category element and storing it in a variable
			WebElement Element = driver.findElement(By.xpath("(//input[contains(@class,'mer-checkbox-input')])[8]")); 
			// Scrolling down the page to an element location
		    JavascriptExecutor js = (JavascriptExecutor) driver; 
		    js.executeScript("arguments[0].scrollIntoView(true);", Element);
		    // Storing a value to the variable and verifying is that value selected
		    Boolean Tier3category=Element.isSelected();
		    Assert.assertEquals(true, Tier3category); 
	}	
	
	// A method to close the browser after all the test execution
	@AfterTest
	public void teardown()
	{ 
		    driver.close();
	}
}
	
	