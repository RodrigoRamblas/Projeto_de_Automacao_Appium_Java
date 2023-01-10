package lello.appium.test.MorarTeste.Notificacoes;

import lello.appium.core.BaseTest;
import lello.appium.page.MorarPages.MorarLoginPage;
import lello.appium.page.MorarPages.MorarMenuPage;
import lello.appium.page.MorarPages.MorarSplashPage;
import org.junit.Before;
import org.junit.Test;

public class NotificacoesTeste extends BaseTest {

    private MorarSplashPage splash = new MorarSplashPage();
    private MorarLoginPage login = new MorarLoginPage();
    private MorarMenuPage menu = new MorarMenuPage();

    @Before
    public void setup() throws InterruptedException {
        splash.aguardarSplashSumir();
        Thread.sleep(1000);
        menu.pular();
        Thread.sleep(1000);
        login.setCPFouCNPJ("39604838806");
        Thread.sleep(1000);
        login.setSenha("12345");
        Thread.sleep(3000);
        login.clicarEntrar();
        Thread.sleep(3000);
        login.clicarForaDoPopUp();
        Thread.sleep(4000);
    }

    @Test
    public void acessarNotificaçõesDaPaginaInicial () throws InterruptedException {
        menu.acessarNotificacoes();
        Thread.sleep(4000);
    }
}
