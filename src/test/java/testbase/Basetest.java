package testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Basetest {
	
	public WebDriver driver;
	public Properties p;
	
	@BeforeClass
	@Parameters({"browser","os"})
	public void setup(String br,String os) throws IOException
	{
		FileInputStream fi=new FileInputStream("./src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(fi);
		
		//Running remotely through grid environment
		if(p.getProperty("execution_env").equals("remote"))
		{
			DesiredCapabilities capability=new DesiredCapabilities();
			
			if(os.equals("windows"))
			{
				capability.setPlatform(Platform.WIN11);
			}
			if(br.equals("edge"))
			{
				capability.setBrowserName("MicrosoftEdge");
			}
			driver=new RemoteWebDriver(new URL("http://192.168.1.9:4444/wd/hub"),capability);
		}
		
		//running locally
		if(p.getProperty("execution_env").equals("local"))
		{
			switch(br)
			{
			case "edge": driver=new EdgeDriver();
			break;
			case "chrome": driver=new ChromeDriver();
			break;
			case "firefox": driver=new FirefoxDriver();
			break;
			default :System.out.println("No browser");
			return;
			}
			
		}
		
		driver.get(p.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
