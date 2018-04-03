package com.gmail.update;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpadtedGmail {

	
	public	WebDriver driver;
	//************* This method will help you to mark as unread to read****************************** 
  

	@BeforeClass
	public void makeitread() throws Exception {
	
		System.setProperty("webdriver.gecko.driver", "D:\\Automation\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		
	
    	
		driver=new FirefoxDriver();
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    	
    	driver.navigate().to("https://gmail.com");
    	
    	driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("bharathkumar0732");
    	
    	driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
    	
    
    	Thread.sleep(2000);
    	
    	driver.findElement(By.name("password")).sendKeys("bharath0732");
    	
    	
    	driver.findElement(By.xpath(".//*[@id='passwordNext']/content")).click();
    	
    	Thread.sleep(5000);	 
    	
    	
    }
	
       @Test (enabled=true)   	
    	public void run() throws Exception {
    	for(int i=0;i<i+1;i++) {
    		
         driver.navigate().refresh();
    	
         Thread.sleep(5000);
         
    	 WebElement inbox=driver.findElement(By.xpath(".//*[@href='https://mail.google.com/mail/u/0/#inbox']"));
    	 WebElement checkbox=driver.findElement(By.xpath(".//div[@role='presentation' and @class='T-Jo-auh']"));
    	
    	System.out.println("in loop");
    	System.out.println(inbox.getAttribute("title"));
    	System.out.println(inbox.getAttribute("innerhtml"));
    	
   	if(inbox.getAttribute("title").trim().equalsIgnoreCase("Inbox")) {
   		
        System.out.println(inbox.getAttribute("title"));
        System.out.println(inbox.getAttribute("innerhtml"));
    	break;
   	
    	}
   	else {   
       	Thread.sleep(5000);
       	checkbox.click();
       	driver.findElement(By.xpath("//*[@class='T-I J-J5-Ji ar7 nf T-I-ax7 L3' or @role=button]")).click();
       	
       	Thread.sleep(5000);
       	driver.findElement(By.xpath(".//*[contains(text(),'Mark as read')]")).click();
       	
       	System.out.println("good");
       	Thread.sleep(10000);
        }
         
    	} 

        }
    	@AfterClass(enabled=true)
       public void quit() throws Exception {
	
        	
        
        	driver.findElement(By.xpath(".//*[@class='gb_db gbii']")).click();
 		   
            
            Thread.sleep(5000);
            
            WebElement signout=driver.findElement(By.id("gb_71"));
            
            signout.click();
    
            Thread.sleep(5000);
            
            driver.quit();
            
    	
    	}
    }


