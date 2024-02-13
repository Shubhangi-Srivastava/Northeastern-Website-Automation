package example;		
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

//import org.apache.bcel.generic.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.itextpdf.html2pdf.HtmlConverter;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
 


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
 

public class NewTest {
 
	Properties p = new Properties();
	public static WebDriver d;
	public static Navigation n;
	//loading the properties file
	@BeforeClass
	public void loadProperties() {
		try {
				p.load(new FileInputStream("C:\\Users\\Yurya\\Downloads\\Data\\config.properties"));
			} catch (FileNotFoundException f) {
				f.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
		
	
	
	
	@Test(priority = 1)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Login to MyNeu")
	@Feature("Feature3: Login to Univ portal")
	@Story("Story: Valid login")
	@Step("Verify Login to MyNeu")
	
	public void testLoginNE() throws Exception {
		// Setting the driver properties
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Yurya\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		// navigating to nu login page
		
		WebDriverWait wait = new WebDriverWait(d, 300);
		d.get("https://me.northeastern.edu/");
		Thread.sleep(3000);
 
		this.takeSnapShot(d, "C:\\Users\\Yurya\\Downloads\\Data\\Scenario1/page.png");
		// Login
		d.findElement(By.xpath("//*[@id=\"i0116\"]")).click();
		
		d.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys(p.getProperty("username"));
		
		Thread.sleep(3000);
		
		this.takeSnapShot(d, "C:\\Users\\Yurya\\Downloads\\Data\\\\Scenario1/login.png");
		String path = "C:\\Users\\Yurya\\Downloads\\Data/login.png";
		Reporter.log("<img width='400' height='240' src = '" + path + "'/><br/>");
		d.findElement(By.xpath("//*[@id='idSIButton9']")).click();
 
		// Update the XPath for the password field
	 	d.findElement(By.xpath("//*[@id='i0118']")).sendKeys(p.getProperty("password"));
	 	Thread.sleep(9000);
	 	
		d.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		Thread.sleep(3000);
		
		//Duo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Yes, this is my device']")));
		d.findElement(By.xpath("//button[text()='Yes, this is my device']")).click();	
		
		// Remember Me
		Thread.sleep(10000);

		d.findElement(By.xpath("//*[@id='idSIButton9']")).click();
 
		

		Thread.sleep(5000);
		this.takeSnapShot(d, "C:\\Users\\Yurya\\Downloads\\Data\\\\Scenario1/success.png");
		Thread.sleep(5000);
		this.takeSnapShot(d, "C:\\Users\\Yurya\\Downloads\\Data\\\\Scenario1/logged.png");
		
		Thread.sleep(10000);
		//Let's Go button
		d.findElement(By.xpath("//*[@id='id__82']")).click();
		Thread.sleep(5000);
		
		//Resources
		d.findElement(By.xpath("//*[@id=\"spSiteHeader\"]/div/div[2]/div/div[3]/div/div/div/div/span[4]/a/span")).click();
		Thread.sleep(5000);
		d.findElement(By.xpath("//*[@id=\"vpc_WebPart.ResourcesWebPartWebPart.external.7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div[1]/div[2]/div/div[1]/div/p")).click();
		Thread.sleep(5000);
 
		d.findElement(By.xpath("//*[@id=\"vpc_WebPart.ResourcesWebPartWebPart.external.7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div[2]/div/div/div[1]/div/div[21]/div/div/a")).click();
 
		Thread.sleep(5000);
		// Get handles of all open tabs
		Set<String> handles = d.getWindowHandles();
 
		// Switch to the new tab
		for (String handle : handles) {
		    d.switchTo().window(handle);
		}
		
		System.out.println("Before waiting for username input");
		WebDriverWait waitUsername = new WebDriverWait(d, 50);
		WebElement usernameInput = waitUsername.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
		System.out.println("After waiting for username input");
		usernameInput.click();
		usernameInput.sendKeys(p.getProperty("uname"));
 
	
		d.findElement(By.xpath("//*[@id='password']")).click();
		
		d.findElement(By.xpath("//*[@id='password']")).sendKeys(p.getProperty("password"));
		
		Thread.sleep(3000);
 
		d.findElement(By.xpath("/html/body/section/div/div[2]/div/form/div[3]/button")).click();
 
		
		Thread.sleep(10000);
	    // Initialize the Select class with your dropdown WebElement
		// Assuming the second option is "Graduate"
		WebElement dropdownElement = d.findElement(By.xpath("//*[@id='levl_id']"));
		Select dropdown = new Select(dropdownElement);
 
		// Select by index (index starts from 0, so 1 corresponds to the second option)
		dropdown.selectByIndex(1);
 
	  
	    Thread.sleep(3000);
	    d.findElement(By.xpath("/html/body/div[3]/form/input")).click();
	    
	    Thread.sleep(5000);
		this.takeSnapShot(d, "C:\\Users\\Yurya\\Downloads\\Data\\\\Scenario1/transcript.png");

 

		//To Save PDF
		try {
			String html = d.getPageSource();
            String pdfFilePath = "C:\\\\\\\\Users\\\\\\\\Yurya\\\\\\\\Downloads\\\\\\\\Data\\myTranscript.pdf";
 
            try (FileOutputStream outputStream = new FileOutputStream(new File(pdfFilePath))) {
                HtmlConverter.convertToPdf(html, outputStream);
                System.out.println("PDF created successfully at: " + pdfFilePath);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		String actualUrl = d.getCurrentUrl();
		System.out.print("This is actutal URL" +actualUrl);
		String expectedUrl = "https://bnrordsp.neu.edu/ssb-prod/bwskotrn.P_ViewTran";
		
		
		
		Thread.sleep(8000);
		Assert.assertEquals(true, actualUrl.contains(expectedUrl));
		Reporter.log("testLoginNE: ");
		Reporter.log("Expected: " + expectedUrl);
		Reporter.log("Actual: " + actualUrl);
 
		Reporter.log("Fail/Pass: ");
		if (actualUrl.contains(expectedUrl))
			Reporter.log("Pass");
		else
			Reporter.log("Fail");
		
	    d.quit();
 
	}
	
	
	
	
	
	@Test(priority = 2)
	@Severity(SeverityLevel.BLOCKER)
	@Description("To do list")
	@Feature("Login to Canvas")
	@Story("Story: Valid login")
	@Step("Verify Login to MyNeu")
	public void test2() throws Exception {
		// Setting the driver properties
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Yurya\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(d, 300);

		// navigating to nu login page
		d.get("https://canvas.northeastern.edu/");
		Thread.sleep(5000);
		this.takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario2//page.png");
		
		// Login
		d.findElement(By.xpath(
				"//*[@id=\"post-2224\"]/div/div[1]/div/div/div/div/div/div/div/div/div/a"))
				.click();
		Thread.sleep(8000);
		
		d.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys(p.getProperty("username"));
		d.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		
		Thread.sleep(10000);
		
		d.findElement(By.xpath("//*[@id='i0118']")).sendKeys(p.getProperty("password"));
	 	Thread.sleep(3000);

 
	 	this.takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario2/Password.png");
		d.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		Thread.sleep(8000);
		
		//Duo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Yes, this is my device']")));
		d.findElement(By.xpath("//button[text()='Yes, this is my device']")).click();	
		
		
		// Remember Me
//		d.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		Thread.sleep(10000);
		d.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		
		// Click Calendar
		d.findElement(By.xpath("//*[@id='global_nav_calendar_link\']")).click();
		Thread.sleep(1000);
		this.takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario2//calender.png");
		readDataAndFillForm(d);
		this.takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario2//Form.png");
		d.quit();
		
	}
	
	private static void readDataAndFillForm(WebDriver driver) {
        try (FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\Yurya\\Downloads\\Data/scenario2.xlsx"));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            // Assuming your Excel sheet is the first one (index 0)
            Sheet sheet = workbook.getSheetAt(0);

           // Iterate through rows in the Excel sheet
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip the header row

            while (rowIterator.hasNext()) {
            	d.findElement(By.xpath("//*[@id=\"create_new_event_link\"]")).click();
            	d.findElement(By.className("edit_planner_note_option")).click();
        		//Thread.sleep(1000);
                Row row = rowIterator.next();

                // Read data from each cell
                String title = getStringValue(row.getCell(0));
                String date = getStringValue(row.getCell(1));
                String time = getStringValue(row.getCell(2));
                String details = getStringValue(row.getCell(3));

                // Fill in the form on the web page
                fillForm(driver, title, date, time, details);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private static String getStringValue(Cell cell) {
	    if (cell == null) {
	        return ""; // Return an empty string for null cells
	    }

	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue();
	        case NUMERIC:
	            // Check if the numeric value is a date
	            if (DateUtil.isCellDateFormatted(cell)) {
	                return cell.getDateCellValue().toString();
	            } else {
	                return String.valueOf(cell.getNumericCellValue());
	            }
	        default:
	            return ""; // Handle other cell types as needed
	    }
	}

	private static void fillForm(WebDriver driver, String title, String date, String time, String details) {
		 try {
	          Thread.sleep(20000); // Adjust the sleep duration as needed
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        // Locate form elements and fill in the data
			 driver.findElement(By.xpath("//*[@id=\"planner_note_title\"]")).sendKeys(title);
	
			WebElement calendarElem = driver.findElement(By.xpath("//*[@id=\"edit_planner_note_form_holder\"]/form/div[1]/table/tbody/tr[2]/td[2]/div/div[1]/button"));
			calendarElem.click();
			driver.findElement(By.xpath(date)).click();
			
			driver.findElement(By.xpath("//*[@id=\"planner_note_time\"]")).sendKeys(time);
			
			driver.findElement(By.xpath("//*[@id=\"details_textarea\"]")).sendKeys(details);
			
	        // Submit the form or perform other actions as needed
	        driver.findElement(By.xpath("//*[@id=\"edit_planner_note_form_holder\"]/form/div[2]/button")).click();

	        // Wait for success message or perform other verifications
	        try {
	            // Add a sleep to wait for the success message or other elements
	            Thread.sleep(10000); // Adjust the sleep duration as needed
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	   
	    }


	
	
	
	@Test(priority = 3)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Download classroom guide")
	@Feature("Feature1: Login")
	@Story("Story:Valid Login")
	@Step("Verify Login")
	
	public void test3() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Yurya\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		
	       ChromeOptions chromeOptions = new ChromeOptions();
	       WebDriver driver = new ChromeDriver(chromeOptions);
	       Actions action = new Actions(driver);
		       WebDriverWait wait = new WebDriverWait(driver, 20);


		    	        try {
		    	            driver.get("https://service.northeastern.edu/tech?id=classrooms");
		    	            this.takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario3/Classrooms.png");
		    	            Thread.sleep(2000);
		    	           

		    	            WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ng-binding[href*='classroom_details']")));
		    	            linkElement.click();

		    	            WebElement pdfLinkElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ng-binding[href*='Hybrid_Nuflex_Classroom.pdf']")));
		    	            String pdfUrl = pdfLinkElement.getAttribute("href");
		    	            Thread.sleep(2000);
		    	            this.takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario3/PDF.png");

		    	            downloadPdf(pdfUrl, "C:\\Users\\Yurya\\Downloads\\Data/Hybrid_Nuflex_Classroom.pdf");
		    	        } finally {
		    	            System.out.println("Scenario Three Ends");
		    	            driver.quit();
		    	        }
		    	        driver.quit();
		    	        d.quit();
		    	    }

		    	    private static void downloadPdf(String pdfUrl, String destinationPath) {
		    	        try {
		    	            URL url = new URL(pdfUrl);
		    	            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		    	            int responseCode = httpURLConnection.getResponseCode();

		    	            if (responseCode == HttpURLConnection.HTTP_OK) {
		    	                try (InputStream inputStream = httpURLConnection.getInputStream();
		    	                     OutputStream outputStream = new FileOutputStream(destinationPath)) {

		    	                    byte[] buffer = new byte[4096];
		    	                    int bytesRead;

		    	                    while ((bytesRead = inputStream.read(buffer)) != -1) {
		    	                        outputStream.write(buffer, 0, bytesRead);
		    	                    }
		    	                }
		    	                System.out.println("PDF downloaded successfully to: " + destinationPath);
		    	            } else {
		    	                System.err.println("Failed to download PDF. HTTP response code: " + responseCode);
		    	            }
		    	        } catch (IOException e) {
		    	            e.printStackTrace();
		    	        }
		    	        
		    	    }
	
		    

	@Test(priority = 4)
	@Severity(SeverityLevel.MINOR)
	@Description("Download dataset")
	@Feature("Download file")
    @Story("Story: bookmark")
	@Step("Download")
		    		
public void test4() throws Exception {
	 
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Yurya\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();

	       // initial set up:
	       ChromeOptions chromeOptions = new ChromeOptions();
//		    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	       WebDriver driver = new ChromeDriver(chromeOptions);
	       Actions action = new Actions(driver);
	 
	       WebDriverWait wait = new WebDriverWait(driver, 10);

	      // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increase the wait time
	 
	       try {
	           // Maximize the browser window
	           driver.manage().window().maximize();
	 
	           // Navigate to the desired URL
	           driver.get("https://onesearch.library.northeastern.edu/discovery/search?vid=01NEU_INST:NU&lang=en");
	            this.takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario4/content.png");

	           WebElement menuItem=driver.findElement(By.xpath("//span[contains(text(),'digital repository service')]"));
	           action.moveToElement(menuItem);
	           wait.until(ExpectedConditions.visibilityOf(menuItem));
	           action.click();
	           action.perform();
	           Thread.sleep(4000);

	           //get Dataset
	           System.out.println(driver.getCurrentUrl());
	 
	           String currentHandle= driver.getWindowHandle();
	           Set<String> handles=driver.getWindowHandles();
	           for(String actual: handles) {
	 
	               if (!actual.equalsIgnoreCase(currentHandle)) {
	                   //switching to the opened tab
	                   driver.switchTo().window(actual);
	 
	                   String dataset=driver.getTitle();
	                   System.out.println(dataset);
	                   WebElement data=driver.findElement(By.xpath("//a[@class='btn btn-clear btn-block' and @href='/datasets']"));
	                   action.moveToElement(data);
	                   wait.until(ExpectedConditions.visibilityOf(data));
	                   action.click();
	                   action.perform();
	                   Thread.sleep(4000);
	 
	               }
	           }
	          driver.findElement(By.xpath("//input[@id='searchFieldHeader' and @placeholder='Search this featured content']")).sendKeys("csv");
	           driver.findElement(By.xpath("(//*[@id='search-submit-header'])[2]")).click();
	            this.takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario4/file.png");

	           Thread.sleep(10000);
	 

	           //click on search result 1st element
	 
	           WebElement serachItem=driver.findElement(By.xpath("//a[contains(@href, '/files/neu:m0472768f')]"));
	           action.moveToElement(serachItem);
	           action.click();
	           action.perform();

	           Thread.sleep(4000);

	           //------------------download file-------------------
	 
	           WebElement dowload=driver.findElement(By.xpath("//a[contains(text(),'Zip File')]"));
	           action.moveToElement(dowload);
	           action.click();
	           action.perform();
	           Thread.sleep(4000);
	 
	 
	       } catch (InterruptedException e) {
	           throw new RuntimeException(e);
	       } finally {
	           driver.quit();
	           System.out.println("Test completed successfully.");
	       }
	       
	       d.quit();
	   }
			    	    

	
	
	
	
	@Test(priority = 5)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Check Academic calender")
	@Feature("Feature3: Login to Student Hub portal")
	@Story("Story: Validate login")
	@Step("Login to MyNeu")
	
	public void test5() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Yurya\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		d= new ChromeDriver();
		d.manage().window().maximize();
    	loadProperties();
		WebDriverWait wait = new WebDriverWait(d, 300);

        // Set the path to your chrome driver executable

 
        // Initialize WebDriver
        d.get("https://northeastern.sharepoint.com/sites/studenthub/SitePages/Student-Resources.aspx#/resources");
      
		Thread.sleep(5000);
        this.takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario5/Canvas.png");

		
		d.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys(p.getProperty("username"));
		d.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		
		Thread.sleep(5000);
		
		d.findElement(By.xpath("//*[@id='i0118']")).sendKeys(p.getProperty("password"));
	 	Thread.sleep(8000);
 
        this.takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario5/Login.png");

	 	d.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		Thread.sleep(3000);
		//Duo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Yes, this is my device']")));
		d.findElement(By.xpath("//button[text()='Yes, this is my device']")).click();	
		
		
		// Remember Me
		Thread.sleep(5000);

		d.findElement(By.xpath("//*[@id='idSIButton9']")).click();
 
       //Launch the application


       //Perform the scenario

       executeScenario();

       //Close the browser

        d.quit();

    }
 
    private static void executeScenario() throws Exception {

        // Add your login code here if needed (username and password fields)
 
        // Navigate to Academics Classes & Registration
    	
    	Thread.sleep(8000);

        clickElement(By.cssSelector("[data-gtm-sh-resources-group='Academics, Classes & Registration']"));
        
        takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario5/Academics.png");

        Thread.sleep(8000);
        // Click on the Academic Calendar
        
        String mainWindowHandle = d.getWindowHandle();
        // Click on Academic Calendar under Northeastern University Registrar
        clickElement(By.cssSelector("[data-gtm-sh-resources-link='Academic Calendar']"));
        takeSnapShot(d, "C:\\\\Users\\\\Yurya\\\\Downloads\\\\Data/scenario5/calender.png");


	     // Get all window handles
	     Set<String> allWindowHandles = d.getWindowHandles();
	
	     // Iterate through all handles
	     for (String windowHandle : allWindowHandles) {
	         // Switch to the new tab
	         if (!windowHandle.equals(mainWindowHandle)) {
	             d.switchTo().window(windowHandle);
	             clickElement(By.xpath("//*[@id=\"tax-academic-calendars\"]/div/a[1]"));
	             
	             Thread.sleep(5000);

	             scrollDown();
	             
	             Thread.sleep(5000);
	             
	             d.switchTo().frame("trumba.spud.6.iframe");
	             d.findElement(By.xpath("//*[@id='mixItem0']")).click();
	             Thread.sleep(5000);
	            
	             scrollDown();
	             scrollDown();
	             d.switchTo().defaultContent();
	             
	            
	             JavascriptExecutor jsExec = (JavascriptExecutor) d;
	             WebElement scrollToButton = d.findElement(By.id("nu-global-footer"));
	             jsExec.executeScript("arguments[0].scrollIntoView(true);", scrollToButton);
	                Thread.sleep(2000);
	                // Verify if button is displayed
	                Assert.assertTrue(scrollToButton.isDisplayed());
	                jsExec.executeScript("alert('Add to My Calendar button is present');");
	         }
	     }
        
    }
 
    private static void clickElement(By by) {
        WebElement element = d.findElement(by);
        element.click();
    }
 
    private static void scrollDown() {

        d.findElement(By.tagName("body")).sendKeys(org.openqa.selenium.Keys.PAGE_DOWN);

    }
    
	
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
}