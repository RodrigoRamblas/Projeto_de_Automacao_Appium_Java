package lello.appium.page.MorarPages;

import org.openqa.selenium.By;

import lello.appium.core.BasePage;

import static lello.appium.core.DriverFactory.getDriver;

public class MorarLoginPage extends BasePage {

	public void setCPFouCNPJ (String cpfOuCPNPJ) {
		getDriver().findElement(By.className("android.widget.EditText")).click();
		escreverCPFOuCNPJ(By.className("android.widget.EditText"), cpfOuCPNPJ);
	}
	public void setSenha(String senha) {
		getDriver().findElement(By.xpath("//android.widget.EditText[@text='Preencha sua senha']")).click();
		escreverCPFOuCNPJ(By.xpath("//android.widget.EditText[@text='Preencha sua senha']"), senha);
	}
	public void entrar(){
		clicar(By.xpath("//android.widget.Button[2]"));
	}

	public void cliqueComodidades(){
		getDriver().findElementByName("Entrar");
	}
	public void clicarEntrar(){
	clicar(By.xpath("//android.widget.Button[@index=2]"));
	}

	public void clicarForaDoPopUp(){
		tap( 500, 500);
	}
}
