package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	public static WebDriver driver;
	  
	public static String prop(String key) throws IOException
	{
		String address = "./src/test/resources/config.properties";
		FileInputStream fis = new FileInputStream(address);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
	}
	
	@BeforeMethod
	
	public void setup() throws IOException
	{
		String browsername =  prop("browsername");
		if(browsername.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browsername.equals("edge"))
		{
			driver = new EdgeDriver();
			
		}
		driver.get(prop("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}
	
 
	
 
 
	
	@AfterMethod  
	public void teardown()
	{
		driver.manage().window().minimize();
		driver.quit();
	}

	 
}
