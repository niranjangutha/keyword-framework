package qa.keyword.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.bytebuddy.description.annotation.AnnotationDescription.Loadable;
import qa.keyword.base.Base;

public class keyWordEngine {
	public  Base base;
	public WebDriver driver;
	public Properties prop;
	public Workbook book;
	public Sheet sheet;
	public WebElement element;
	
	public final String SENARIO_SHEET_PATH="H:\\Seleniumconcets\\KeyWordDrivenFrameWork"
			+ "\\src\\main\\java\\qa\\keyword\\scenarios\\amazon-keyword.xlsx";
	
	public void startExecution(String sheetName)
	{
		String Locatorname=null;
		String LocatorValue=null;
		FileInputStream file=null;
		String outputurl=null;
		try {
			file=new FileInputStream(SENARIO_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		int k=0;
		for(int i=0;i<sheet.getLastRowNum();i++) {
			try {
				/*String LocatorColVal = sheet.getRow(i+1).getCell(k+1).toString().trim();//id=username
			
				 * if(!LocatorColVal.equalsIgnoreCase("na")){
				 * Locatorname=LocatorColVal.split("=")[0].trim();//id
				 * LocatorValue=LocatorColVal.split("=")[1].trim();///username }
				 */
				 Locatorname=sheet.getRow(i+1).getCell(k+1).toString().trim();
				 LocatorValue=sheet.getRow(i+1).getCell(k+2).toString().trim();
				String action=sheet.getRow(i+1).getCell(k+3).toString().trim();
				String value=sheet.getRow(i+1).getCell(k+4).toString().trim();
			
			switch (action) {
			case "open browser":
				base=new Base();
				prop= base.init_properties();
				if(value.isEmpty()||value.equals("NA")) {
					driver=base.init_driver(prop.getProperty("browser"));
				}
				else {
					driver=base.init_driver(value);
				}	
				break;
			case "enter url":
				if(value.isEmpty()||value.equals("NA")) {
					driver.get(prop.getProperty("url"));
				}
				else {
					driver.get(value);
				}
				break;
			case "geturl":
				String currenturl=driver.getCurrentUrl();
				System.out.println(currenturl);
				break;
			case "quit":
				driver.quit();
				break;
			default:
				break;
			}
			
			
			
			
			switch (Locatorname) {
			case "id":
				element=driver.findElement(By.id(LocatorValue));
				if(action.equalsIgnoreCase("sendkeys")) {
				element.clear();
				element.sendKeys(value);
				}
				else if(action.equalsIgnoreCase("click")){
					element.click();
				}
				else if(action.equalsIgnoreCase("isDisplayed")) {
					boolean dispaly=element.isDisplayed();
					System.out.println(dispaly);
				}
				Locatorname=null;
				break;
			case "Name":
				element=driver.findElement(By.id(LocatorValue));
				if(action.equalsIgnoreCase("sendkeys")) {
				element.clear();
				element.sendKeys(value);
				}
				else if(action.equalsIgnoreCase("click")){
					element.click();
				}
				else if(action.equalsIgnoreCase("isDisplayed")) {
					boolean dispaly=element.isDisplayed();
					System.out.println(dispaly);
				}
				Locatorname=null;
				break;
			case "className":
				element=driver.findElement(By.id(LocatorValue));
				if(action.equalsIgnoreCase("sendkeys")) {
				element.clear();
				element.sendKeys(value);
				}
				else if(action.equalsIgnoreCase("click")){
					element.click();
				}
				else if(action.equalsIgnoreCase("isDisplayed")) {
					boolean dispaly=element.isDisplayed();
					System.out.println(dispaly);
				}
				Locatorname=null;
				break;
			case "cssSelector":
				element=driver.findElement(By.id(LocatorValue));
				if(action.equalsIgnoreCase("sendkeys")) {
				element.clear();
				element.sendKeys(value);
				}
				else if(action.equalsIgnoreCase("click")){
					element.click();
				}
				else if(action.equalsIgnoreCase("isDisplayed")) {
					boolean dispaly=element.isDisplayed();
					System.out.println(dispaly);
				}
				Locatorname=null;
				break;
			case "partialLinkText":
				element=driver.findElement(By.id(LocatorValue));
				if(action.equalsIgnoreCase("sendkeys")) {
				element.clear();
				element.sendKeys(value);
				}
				else if(action.equalsIgnoreCase("click")){
					element.click();
				}
				else if(action.equalsIgnoreCase("isDisplayed")) {
					boolean dispaly=element.isDisplayed();
					System.out.println(dispaly);
				}
				Locatorname=null;
				break;
			case "xpath":
				element=driver.findElement(By.id(LocatorValue));
				if(action.equalsIgnoreCase("sendkeys")) {
				element.clear();
				element.sendKeys(value);
				}
				else if(action.equalsIgnoreCase("click")){
					element.click();
				}
				else if(action.equalsIgnoreCase("isDisplayed")) {
					boolean dispaly=element.isDisplayed();
					System.out.println(dispaly);
				}
				Locatorname=null;
				break;
			case "LinkText":
				element=driver.findElement(By.id(LocatorValue));
				if(action.equalsIgnoreCase("sendkeys")) {
				element.clear();
				element.sendKeys(value);
				}
				else if(action.equalsIgnoreCase("click")){
					element.click();
				}
				else if(action.equalsIgnoreCase("isDisplayed")) {
					boolean dispaly=element.isDisplayed();
					System.out.println(dispaly);
				}
				Locatorname=null;
				break;

			default:
				break;
			}
				
			}
		catch(Exception e)
		{
			
		}
		
	}		
	}
}
