package lello.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;


public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;
	private static String path = "src\\main\\java\\lello\\appium\\apk\\android.apk";
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			createDriver();
//			createTestObjectDriver();
		}
		return driver;
	}

	public static AndroidDriver<MobileElement> validarCarregamento(By by) throws InterruptedException {
		driver.findElements(by).wait();
		return null;
	}
    
    private static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "nada");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
//        desiredCapabilities.setCapability("noReset", true);
		//C:\Users\rodrigo.ramblas\Documents\Appium\Projeto_de_Automacao_Appium_Java\src\main\java\lello\appium\apk\android.apk
		//desiredCapabilities.setCapability(MobileCapabilityType.APP,path);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\rodrigo.ramblas\\Documents\\Appium\\Projeto_de_Automacao_Appium_Java\\src\\main\\java\\lello\\appium\\apk\\android.apk");
//        desiredCapabilities.setCapability("appWaitPackage", "com.google.android.permissioncontroller");
//        desiredCapabilities.setCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
        try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
//        driver.findElement(By.xpath("//*[@text='OK']")).click();
    }
    

    
    public static void killDriver() {
    	if(driver != null) {
    		driver.quit();
    		driver = null;
    	}
    }
}
