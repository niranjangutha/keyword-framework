package qa.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	public  WebDriver driver;
	public Properties prop;
	
	public WebDriver  init_driver(String browserName){
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "h:\\drivers\\chromedriver.exe");
		if(prop.getProperty("headless").equals("yes")) 
		{
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--headless");
			driver=new ChromeDriver(opt);
		}
		else
		{
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		}
	return driver;
	}
	
	public Properties init_properties() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("H:\\Seleniumconcets\\KeyWordDrivenFrameWork\\"
					+ "src\\main\\java\\qa\\keyword\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
				
	}
	
}
							