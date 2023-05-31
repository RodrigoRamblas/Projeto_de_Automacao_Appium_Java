package lello.appium.core;

import com.github.curiousoddman.rgxgen.RgxGen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

	public BasePage() {
		DriverFactory.getDriver();
	}

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 50);

	//Clicar
	public void clicar(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
		DriverFactory.getDriver().findElement(by).click();
	}
	public void clicarEscrever(By by, String texto){
		wait.until(ExpectedConditions.elementToBeClickable(by));
		DriverFactory.getDriver().findElement(by).click();
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}
	public void clicarContent(String contentDesc){
		DriverFactory.getDriver().findElementByAccessibilityId(""+contentDesc+"").click();}
	public void clicarName(String name){ DriverFactory.getDriver().findElementByName(""+name+"").click();}
	public void clicarPorTexto(String texto) {clicar(By.xpath("//*[@text='"+texto+"']"));}
	public void clicarPorId(String id) {DriverFactory.getDriver().findElement(By.id(id)).click();}
	public void cliqueLongo(By by) {
		new TouchAction<>(DriverFactory.getDriver())
				.longPress(PointOption.point(DriverFactory.getDriver().findElement(by).getCenter()))
				.release()
				.perform();
	}

	//Escrever
	public void escrever(By by, String texto)  {
		wait.until(ExpectedConditions.elementToBeClickable(by));
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}
	public void escreverCPFOuCNPJ(By by, String cpfOuCPNPJ) { DriverFactory.getDriver().findElement(by).sendKeys(cpfOuCPNPJ); }
	public void escreverSenha(By by, String senha) { DriverFactory.getDriver().findElement(by).sendKeys(senha); }

	//Obter
	public String obterTexto(By by) { return DriverFactory.getDriver().findElement(by).getText(); }
	public String obterTextoPorContentDesc(String name) { return DriverFactory.getDriver().findElementByName(""+name+"").getText(); }

	//Recuperar
	public String recuperarMensagemXpath(String xpath){
		WebElement element  = DriverFactory.getDriver().findElement(By.xpath(xpath));
		return element.getAttribute("content-desc");
	}
	public String recuperaMensagemContentDesc(String contentDesc){ return String.valueOf(DriverFactory.getDriver().findElement(By.id(contentDesc))); }
	public String mensagemOcorrencia(String contentDesc){
		String texto = String.valueOf(DriverFactory.getDriver().findElement(By.name(contentDesc)));
		return texto;
	}
	public void fecharTeclado(){
		DriverFactory.getDriver().hideKeyboard();
	}
	public void selecionarCombo(By by, String valor)  { DriverFactory.getDriver().findElement(by).click();clicarPorTexto(valor); }
	public boolean isCheckMarcado(By by) { return DriverFactory.getDriver().findElement(by).getAttribute("checked").equals("true"); }

	//Validar carregamento
	public boolean existeElementoPorXpath(String xpath) {
		List<MobileElement> elementos = DriverFactory.getDriver().findElements(By.xpath(xpath)); return elementos.size() > 0;
	}
	public boolean existeElementoPorContentDesc(String contentDesc) {
		List<MobileElement> elementos = DriverFactory.getDriver().findElements(By.name(contentDesc)); return elementos.size() > 0;
	}
	public boolean existeElementoPorClassName(String className) { List<MobileElement> elementos = DriverFactory.getDriver().findElements(By.className(className)); return elementos.size() > 0;}
	public boolean existeElementoPorTexto(String texto) { List<MobileElement> elementos = DriverFactory.getDriver().findElements(By.xpath("//*[@text='"+texto+"']")); return elementos.size() > 0;}
	public String obterTituloAlerta(){
		return obterTexto(By.id("android:id/alertTitle"));
	}
	public String obterMensagemAlerta(){
		return obterTexto(By.id("android:id/message"));
	}
	public void voltar(){ DriverFactory.getDriver().navigate().back(); }
	public void tap(int x, int y) {new TouchAction<>(DriverFactory.getDriver()).tap(PointOption.point(new Point(x, y))).perform();	}
	public void scrollDown(){
		scroll(0.9, 0.1);
	}
	public void scrollUp(){
		scroll(0.1, 0.9);
	}
	public void swipeLeft(){
		swipe(0.1, 0.9);
	}
	public void swipeRight(){
		swipe(0.9, 0.1);
	}
	public void scroll(double inicio, double fim) {
		Dimension size = DriverFactory.getDriver().manage().window().getSize();
		
		int x = size.width / 2;
		
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		
		new TouchAction<>(DriverFactory.getDriver())
			.press(PointOption.point(new Point(x, start_y)))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(new Point(x, end_y)))
			.release()
			.perform();
	}
	
	public void swipe(double inicio, double fim) {
		Dimension size = DriverFactory.getDriver().manage().window().getSize();
		
		int y = size.height / 2;
		
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		new TouchAction<>(DriverFactory.getDriver())
			.press(PointOption.point(new Point(start_x, y)))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(new Point(end_x, y)))
			.release()
			.perform();
	}

	public void swipeElement(MobileElement element, double inicio, double fim) {
		int y = element.getLocation().y + (element.getSize().height / 2);
		
		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
		
		new TouchAction<>(DriverFactory.getDriver())
			.press(PointOption.point(new Point(start_x, y)))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(new Point(end_x, y)))
			.release()
			.perform();
	}
	public void usarTab(){
		String tab = "\t";
	}

	public String gerarPlaca() {
		RgxGen rgxGen = new RgxGen("[A-Z]{3}[0-9][A-Z][0-9]{2}");         // Create generator
		String s = rgxGen.generate();
		return s;
	}

	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] screenshot() {
		return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
	}


}
