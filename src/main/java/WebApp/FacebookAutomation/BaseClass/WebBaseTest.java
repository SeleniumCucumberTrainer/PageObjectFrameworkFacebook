package WebApp.FacebookAutomation.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;





public class WebBaseTest {
	
	//driver, excel, logger..
	
	public WebDriver driver;
	
	
	public Logger log;
	
	public Properties config = new Properties();
	
	@BeforeMethod
	public void init() throws IOException{
		
		/*excel = new Xls_Reader("");*/
		log = Logger.getLogger("devpinoyLogger");
		
		File file = new File("C:\\Users\\Administrator\\workspace\\FacebookAutomation\\Config\\env.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		config.load(fis);
		
		//System.out.println(config.getProperty("browser"));
		
		if(config.getProperty("browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\workspace\\FacebookAutomation\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chome browser opened");
		}
		else if(config.getProperty("browser").equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.geckodriver.driver", "C:\\Users\\Administrator\\workspace\\FacebookAutomation\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Firefox browser opened");
		}
		else if(config.getProperty("browser").equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Administrator\\workspace\\FacebookAutomation\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.info("IE browser opened");
		}
		
		driver.manage().window().maximize();
		log.info("Browser window maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(config.getProperty("url"));
		log.info(config.getProperty("url")+ " app opened");
		
		
		
	}

}
