package org.ecommerce;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class InukHome extends ReusableMethods {
	
	public static void main(String[] args) throws Throwable {
		
		browserLaunch();
		loadURL("https://inukhome.com/en/");
		driver.manage().window().maximize();
		
	    Actions acc = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement s= driver.findElement(By.id("sb-nav-close"));
		click(driver,s);
		
		driver.findElement(By.id("cookiesClose")).click();
		
		screenShot(driver, "Homewindow");
		
		driver.findElement(By.xpath("//a[@title='Login to your customer']")).click();
		
		WebElement username = driver.findElement(By.id("email"));
		sendKeys(driver,username,getData(1,1));
		
		WebElement password = driver.findElement(By.id("passwd"));
		sendKeys(driver,password,getData(1,3));
		screenShot(driver, "usercredentials");
		driver.findElement(By.xpath("//span[text()=' Sign in ']")).click();
		screenShot(driver, "myaccount");
		WebElement child = driver.findElement(By.xpath("(//a[@class='sf-with-ul'])[10]"));
        rightClick(child);
        
        Robot Rb = new Robot();
        Rb.keyPress(KeyEvent.VK_DOWN);
        Rb.keyRelease(KeyEvent.VK_DOWN);
        Rb.keyPress(KeyEvent.VK_ENTER);
        Rb.keyPress(KeyEvent.VK_ENTER);
        
        Thread.sleep(2000);
        
        String parent1 = driver.getWindowHandle();
        System.out.println(parent1);
        Set<String> allWindow = driver.getWindowHandles();
        System.out.println(allWindow);
           
        for (String x : allWindow) {
        	   if (!parent1.equals(x)) {
        		   driver.switchTo().window(x);
        	   }}
        
        driver.switchTo().window(parent1);
        screenShot(driver, "childwindow");
        WebElement mouseOver= driver.findElement(By.xpath("(//a[@title='Lighting'])[3]"));
	    mouseOver(mouseOver);
	        
	    driver.findElement(By.xpath("(//a[@title='Wall lamp'])")).click();
		
		WebElement lamp = driver.findElement(By.xpath("(//a[@title='Adri mint Lamp'])[2]"));
		scrollUp(driver,lamp);
		
		driver.findElement(By.xpath("(//li[@rel='tab4'])")).click();
		
		WebElement cart = driver.findElement(By.xpath("//span[text()='Add to cart']"));
		scrollUp(driver,cart);
		screenShot(driver, "cart");
	    driver.findElement(By.xpath("//body[@id='product']")).click();

		driver.findElement(By.id("search_query_top")).click();
		
		System.out.println("successfully finished the project");
		
		
		
        	
		
		}

	
	}

	
	
		
		
		
	


