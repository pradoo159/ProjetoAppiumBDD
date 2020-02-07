package br.com.rsinet.hub_bdd.appium.manager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.rsinet.hub_bdd.appium.dataProviders.ReadProperties;
import io.appium.java_client.android.AndroidDriver;

public class AppManager {
	
	private String URL = "http://127.0.0.1:4723/wd/hub";
	private AndroidDriver driver;
	
	private static Logger logger = Logger.getLogger("ReadProperties.class");
	
	public AndroidDriver getDriver() {
		if(driver == null)
			driver = createDriver();
		return driver;
	}

	private AndroidDriver createDriver() {

		ReadProperties prop = new ReadProperties("mobile");
		Properties props = prop.getProperty();
		String deviceName = props.getProperty("deviceName");
		String platformVersion = props.getProperty("platformVersion");
		String platformName = props.getProperty("platformName");
		String appPackage = props.getProperty("appPackage");
		String appActivity = props.getProperty("appActivity");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", deviceName);
		caps.setCapability("platformName", platformName);
		caps.setCapability("appPackage", appPackage);
		caps.setCapability("appActivity", appActivity);
		try {
			driver = new AndroidDriver(new URL(URL), caps);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}catch (MalformedURLException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return driver;
	}
	
	public void closeDriver() {
		driver.closeApp();
	}

}
