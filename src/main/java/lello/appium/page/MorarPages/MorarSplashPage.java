package lello.appium.page.MorarPages;

import lello.appium.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lello.appium.core.BasePage;

import java.util.concurrent.TimeUnit;

public class MorarSplashPage extends BasePage {

	public boolean isTelaSplashVisivel(){
		return existeElementoPorTexto("Lello para Moradores");
	}
	
	public void aguardarSplashSumir(){
		//DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@content-desc='Lello para Moradores']")));
	}
}
