package lello.appium.page.MorarPages;

import lello.appium.core.BasePage;
import org.openqa.selenium.By;
public class MorarSkipPage  extends BasePage {

    private String proximo = "//android.widget.Button[@content-desc='PRÓXIMO']";

    public boolean isTelaSplashVisivel(){
        return existeElementoPorTexto("skip");
    }

    public void clicarEmProximo() throws InterruptedException {
        try {
            existeElementoPorXpath(proximo);
            screenshot();
            clicar(By.xpath(proximo));
            screenshot();
            clicar(By.xpath(proximo));
            screenshot();
            clicar(By.xpath(proximo));
            screenshot();
        } catch (Exception ex) {
            Thread.sleep(4000);
            screenshot();
            clicar(By.xpath(proximo));
            screenshot();
            clicar(By.xpath(proximo));
            screenshot();
            clicar(By.xpath(proximo));
            screenshot();
        }
    }
}
