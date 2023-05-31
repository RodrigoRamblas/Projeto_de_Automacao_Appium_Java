package lello.appium.test.MorarTeste.Unidade;

import lello.appium.core.BaseTest;
import lello.appium.page.MorarPages.MoradoresPage;
import lello.appium.page.MorarPages.MorarLoginPage;
import lello.appium.page.MorarPages.MorarMenuPage;
import lello.appium.page.MorarPages.MorarSplashPage;
import org.junit.Before;
import org.junit.Test;

public class MoradoresTeste extends BaseTest {

    private MorarMenuPage menu = new MorarMenuPage();
    private MorarSplashPage splash = new MorarSplashPage();
    private MorarLoginPage login = new MorarLoginPage();
    private MoradoresPage moradores = new MoradoresPage();

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
    public void adicionarNovoUsuário() throws InterruptedException {
        menu.acessarUnidade();
        menu.acessarMoradores();
        moradores.adicionarUmNovoUsuario();
        menu.voltar();
        moradores.cadastrarUmNovoContato();
        moradores.clicarNomeNovoMorador();
        moradores.escreverNomeMorador();
        moradores.clicarCPFNovoMorador();
        moradores.escreverCPFNovoMorador();
        moradores.clicarEmailNovoMorador();
        moradores.escreverEmailMorador();
        moradores.clicarCelularNovoMoradorDDD();
        moradores.escreverCelularlMoradorDDD();
        moradores.clicarCelularNovoMorador();
        moradores.escreverCelularlMorador();
        moradores.clicarMenuDrop();
        moradores.clicarMenuDropProprietario();
        moradores.clicarConcluir();
    }
}
