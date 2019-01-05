package com.qa.guru.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.guru.Utility.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
		prop=new Properties();
		
			FileInputStream ip=new FileInputStream(System.getProperty("C:\\Users\\user\\eclipse-workspace\\GuruECommerceTest\\src\\main\\java\\com\\qa\\guru"
					+ "\\config\\config.properties"));
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
			}
}
	
	public static void intilization() {
		String browserName=System.getProperty("browser");
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\GuruECommerceTest\\Executables\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\eclipse-workspace\\GuruECommerceTest\\Executables\\chromedriver.exe");
				driver=new FirefoxDriver();
		}			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
	}

