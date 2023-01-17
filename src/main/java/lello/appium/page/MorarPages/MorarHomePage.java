package lello.appium.page.MorarPages;

import org.openqa.selenium.By;

import lello.appium.core.BasePage;

public class MorarHomePage extends BasePage {

	public String clicarEmNotificações (String conta) {
		return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
	}
}
