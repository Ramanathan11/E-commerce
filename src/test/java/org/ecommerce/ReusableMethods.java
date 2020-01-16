package org.ecommerce;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ReusableMethods {
	static WebDriver driver;
	public static void browserLaunch() {
	try {
		System.setProperty("webdriver.chrome.driver","E:\\eclipse oxy 32bit\\BaseClass\\Drivers\\chromedriver.exe");
	
		driver = new ChromeDriver();
		System.out.println("success");
	}
	catch (Exception e) {
		
		e.printStackTrace();
		System.out.println("not launched");
		
	}
		
		}
	public static void loadURL(String url){
	try {
		driver.get(url);
		System.out.println("launched");
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("not launched");
		
	}
	}
	public static void currentUrl() {
	driver.getCurrentUrl();
	}
	public static void getTitle() {
		driver.getTitle();
	}
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public static void closeBrowser() {
		driver.close();
	}
	public static void quitBrowser() {
		driver.quit();
	}
	public static void fill(WebElement ele,String value) {
		ele.sendKeys("value");
	}
		public static void btn(WebElement ele) {
			ele.click();
	}
		public static void dragAndDrop(WebElement ele1, WebElement ele2) {
			Actions acc = new Actions(driver);
			acc.dragAndDrop(ele1, ele2);
			
	}
		
		public static void mouseOver( WebElement e) {
			Actions acc = new Actions(driver);
			acc.moveToElement(e).perform();
		}
		public static void rightClick(WebElement e) {
			Actions acc = new Actions(driver);
			acc.contextClick(e).perform();
		}
		public static void screenShot(WebDriver driver,String name) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File s = ts.getScreenshotAs(OutputType.FILE);
			File d = new File ("E:\\eclipse oxy 32bit\\Ecommerce\\ScreenSchot\\"+name+".png");
			FileUtils.copyFile(s,d);
			
		}
		public static void acceptAlert() {
			driver.switchTo().alert().accept();
			
		}
		public static void dismissAlert() {
			Alert al = driver.switchTo().alert();
			al.dismiss();
		}
		public static void confirmAlert() {
			driver.switchTo().alert().getText();
		
		}
		public static void promptAlert(Alert al, String s) {
			driver.switchTo().alert();
			al.sendKeys(s);
			al.accept();
		}
		public static String getData(int a, int b) throws Throwable {
			String v = null;
			File F = new File("E:\\eclipse oxy 32bit\\Ecommerce\\Ecommerce Details\\ecommerce details.xlsx");
			FileInputStream fis= new FileInputStream(F);
			Workbook w = new XSSFWorkbook(fis);
			Sheet s = w.getSheet("Sheet2");
			Row r = s.getRow(a);
			Cell c = r.getCell(b);
			int ct = c.getCellType();
			if(ct==1) {
			v = c.getStringCellValue();
			}
			else if (ct==0) {
				if(DateUtil.isCellDateFormatted(c)) {
				Date dateCell = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat();
				v = sim.format(dateCell);
			}
			
			
			else if(ct==0) {
				double n = c.getNumericCellValue();
				long l = (long)n;
			v = String.valueOf(l);
				
			}
			}
			
			return v;
					
			
		}
		public static void sendKeys(WebDriver driver, WebElement e,String name) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Object obj = js.executeScript("arguments[0].setAttribute('value','"+name+"')", e);
			
		}
		public static void click(WebDriver driver, WebElement s) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",s);
		}
		public static void scrollUp(WebDriver driver,WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", ele);
			js.executeScript("arguments[0].click()", ele);	
}
		public static void scrollDown(WebDriver driver,WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", ele);
		js.executeScript("arguments[0].click()", ele);	
}
}
