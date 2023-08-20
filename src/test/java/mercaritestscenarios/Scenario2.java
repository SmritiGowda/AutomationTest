package mercaritestscenarios;

import org.testng.annotations.Test;

import java.awt.RenderingHints.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Scenario2 extends Scenario1{
	
	// A method for launching the browser and creating two browsing histories
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
		
			// Creating the first Browsing History
		
			// Clicking on the search bar
			driver.findElement(By.xpath("//input[contains(@class,'searchInput__268d8f3d')]")).click(); 
			// Clicking on "Select by category" (カテゴリーからさがす)
			driver.findElement(By.xpath("//p[contains(@class,'merText body__5616e150 primary__5616e150')]")).click(); 
			// Selecting Women (レディース) category
			driver.findElement(By.xpath("//a[contains(text(),'レディース')]")).click(); 
			// Selecting the all (すべて) category
			driver.findElement(By.xpath("//a[contains(text(),'すべて')]")).click(); 
			Thread.sleep(8000);
		
		
			// Creating the second Browsing history which is the latest
		
			// Clicking on the search bar
			driver.findElement(By.xpath("//input[contains(@class,'searchInput__268d8f3d')]")).click(); 
			Thread.sleep(8000);
			// Clicking on "Select by category" (カテゴリーからさがす)
			driver.findElement(By.xpath("//p[contains(@class,'merText body__5616e150 primary__5616e150')]")).click(); 
			// Selecting "Books, Music & Games" (本・音楽・ゲーム) as the Tier 1 category 
			driver.findElement(By.xpath("//a[contains(text(),'本・音楽・ゲーム')]")).click(); 
			// Selecting "Books" (本) as the Tier 2 category
			driver.findElement(By.xpath("//div[@class='content__884ec505']//a[contains(text(),'本')]")).click();
			// Selecting "Computers & Technology" (コンピュータ/IT) as the Tier 3 category
			driver.findElement(By.xpath("//a[contains(text(),'コンピュータ/IT')]")).click();
			// Clicking on the search bar	
			driver.findElement(By.xpath("//input[contains(@class,'searchInput__268d8f3d')]")).click(); 	
	}
	
	// A test method to verify there are two browsing histories
	@Test(priority=4)
	public void Verify2BrowsingHistory() 
	{
			// Finding the browsing history elements 
			List <WebElement> history2 = driver.findElements(By.xpath("//div[contains(@class,'merList border__17a1e07b separator__17a1e07b')]//p")); 
			// Printing the size of browsing histories
			System.out.println("The size is " + (history2.size())); 
			// Verifying the history size equals to 2
			Assert.assertEquals(history2.size(), 2);
	}
	
	// A test method to verify the latest browsing history is コンピュータ/IT
	@Test(priority=5)
	public void VerifyLatestHistory1() throws InterruptedException 
	{
			Thread.sleep(10000);
			// Fetching the text of a latest browsing history
			String latest= driver.findElement(By.xpath("(//div[contains(@class,'content__884ec505')])[3]")).getText();
			// Initializing the expected latest browsing history to a variable 'ExpectedLatestFromHistory3'
			String ExpectedLatestFromHistory2="コンピュータ/IT";
			// Verifying that the latest browsing history is matching with expected latest browsing history
			Assert.assertEquals(latest, ExpectedLatestFromHistory2);	
	}
	
	// A test method to verify the search conditions are set correctly on the left side bar. So calling the Scenario1 class methods
	@Test(priority=6)
	public void VerifySearchConditions() throws InterruptedException
	{
			// Clicking on the latest browser history i.e "Computers & Technology/ コンピュータ/IT"
			driver.findElement(By.xpath("(//div[contains(@class,'content__884ec505')])[3]")).click();
			Thread.sleep(8000);	
			// With the help of super, calling Scenario1 class methods to execute this test
			super.VerifyTier1Category();
			super.VerifyTier2Category();
			super.VerifyTier3Category();	
	}	
	
	// A test method to verify there are three browsing histories and the latest browsing history is javascript, コンピュータ/IT
	@Test(priority=7)
	public void Verify3BrowsingHistory() throws InterruptedException 
	{
			// Clicking on the search bar
			driver.findElement(By.xpath("//input[contains(@class,'searchInput__268d8f3d')]")).click(); 
			// Giving an input as javascript in the search bar
			driver.findElement(By.xpath("//input[contains(@class,'searchInput__268d8f3d')]")).sendKeys("javascript"); 
			// Clicking on the enter button 
			driver.findElement(By.xpath("//input[contains(@class,'searchInput__268d8f3d')]")).sendKeys(Keys.ENTER);
			Thread.sleep(8000);
		
			// Going to the Mercari site
			driver.get("https://jp.mercari.com/");
			Thread.sleep(8000);
			// Finding the browsing history elements
			List <WebElement> history3 = driver.findElements(By.xpath("//div[contains(@class,'merList border__17a1e07b separator__17a1e07b')]//p"));
			// Printing the size of browsing histories
			System.out.println("The size is :" + (history3.size())); 
			// Verifying the history size equals to 3
			Assert.assertEquals(history3.size(), 3);
		
			//Clicking on the search bar
			driver.findElement(By.xpath("//input[contains(@class,'searchInput__268d8f3d')]")).click(); 
			Thread.sleep(8000);
			// Fetching the text of a latest browsing history
			String latest2= driver.findElement(By.xpath("(//div[contains(@class,'content__884ec505')])[3]")).getText();
			// Printing the text of a latest browsing history
			System.out.println("Latest text is: " + latest2);
			// Initializing the expected latest browsing history to a variable 'ExpectedLatestFromHistory3'
			String ExpectedLatestFromHistory3="javascript, コンピュータ/IT";
			// Verifying that the latest browsing history is matching with expected latest browsing history
			Assert.assertEquals(latest2, ExpectedLatestFromHistory3); 
	} 
	
	// A method to close the browser after all the test execution
	@AfterTest
	public void teardown()
	{ 
			driver.close();
	}
}
	

