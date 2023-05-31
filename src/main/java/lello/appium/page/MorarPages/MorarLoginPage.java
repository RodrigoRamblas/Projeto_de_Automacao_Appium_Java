package lello.appium.page.MorarPages;

import org.openqa.selenium.By;

import lello.appium.core.BasePage;

import static lello.appium.core.DriverFactory.getDriver;

public class MorarLoginPage extends BasePage {

	private String popUp = "//android.widget.Button[1]";
	private String localizacao = "//android.widget.Button[1]";
	private String cpfOuCnpj = "android.widget.EditText";
	private String senhaIg = "//android.widget.EditText[@text='Type your password']";
	private String senhaPt = "//android.widget.EditText[@text='Preencha sua senha']";

	public void fecharPopUp() {
		try {
			existeElementoPorXpath(popUp);
			clicar(By.xpath(popUp));
			clicar(By.xpath(localizacao));
		} catch(Exception ignored) {}
	}
	public void setCPFouCNPJ(String cpfOuCPNPJ) {
		existeElementoPorClassName(cpfOuCnpj);
		getDriver().findElement(By.className(cpfOuCnpj)).click();
		escreverCPFOuCNPJ(By.className(cpfOuCnpj), cpfOuCPNPJ);
	}
	public void setSenha(String senha) throws InterruptedException {
		try{
			Thread.sleep(2000);
			clicar(By.xpath(senhaPt));
			escreverSenha(By.xpath(senhaPt), senha);
		}catch (Exception ex){
			Thread.sleep(2000);
			clicar(By.xpath(senhaIg));
			escreverSenha(By.xpath(senhaIg),senha);
		}
	}
	public void entrar() throws InterruptedException {
		clicar(By.xpath("//android.widget.Button[2]"));
	}
	public void cliqueComodidades(){
		getDriver().findElementByName("Entrar");
	}
	public void clicarEntrar() throws InterruptedException {
		Thread.sleep(1000);
		clicar(By.xpath("//android.widget.Button[@index=2]"));
		Thread.sleep(3000);
	}
	public void clicarClose() throws InterruptedException {
		Thread.sleep(4000);
		clicar(By.xpath("//android.widget.Button[@index=5]"));
	}
	public void clicarForaDoPopUp() throws InterruptedException {
		Thread.sleep(1000);
		tap( 500, 500);
	}
}
