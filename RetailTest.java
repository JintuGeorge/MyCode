
import LoadTeastData.TestData;
import ObjectRepo.MyObjectRepo;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RetailTest {

	public static void main(String[] args) {
	  
       
		Properties prop1= TestData.Test();
		Properties prop2=MyObjectRepo.WebElements();
        WebDriver driver=new ChromeDriver();
        
        //Test 1 - Login Flipkart URL Check
        
        driver.get(prop1.getProperty("loginurl"));
        String test=driver.getCurrentUrl();
       
        if(test.contentEquals("https://www.flipkart.com/account/login"))
        {
         System.out.println("Test1 : Pass\n");
        }
        else
        {
        	System.out.println("Test 1 :Fail\n");
        }
        
        //Test 2 - Login using Existing Account
        
    	   driver.findElement(By.xpath(prop2.getProperty("UserNameFeild"))).sendKeys(prop1.getProperty("username"));
    	   driver.findElement(By.xpath(prop2.getProperty("PasswordFeild"))).sendKeys(prop1.getProperty("password"));
    	   driver.findElement(By.xpath(prop2.getProperty("LoginButton"))).click();
    	   //WebDriverWait wait = new WebDriverWait(driver, 30);
    	   //wait.until(ExpectedConditions.urlMatches("https://www.flipkart.com/"));
    	   String test1=driver.getCurrentUrl();
    	   System.out.println("\n"+test1);
           if(test1.contentEquals("https://www.flipkart.com/"))
           {
            System.out.println("Test2 : Pass\n");
           }
           else
           {
           	System.out.println("Test 2 :Fail\n");
           }
        
        /*Test 3 - Find all the links in homepage
        if(driver.getCurrentUrl()=="https://www.flipkart.com/") 	
        {
        	
        }*/
    	   
        driver.close();
	}
}
      