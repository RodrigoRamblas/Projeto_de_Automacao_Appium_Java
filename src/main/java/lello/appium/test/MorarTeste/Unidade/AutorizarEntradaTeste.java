package lello.appium.test.MorarTeste.Unidade;

import lello.appium.page.MorarPages.MorarLoginPage;
import lello.appium.page.MorarPages.MorarMenuPage;
import lello.appium.page.MorarPages.MorarSplashPage;
import lello.appium.page.MorarPages.AutorizarEntradaPage;
import org.junit.Before;
import org.junit.Test;

public class AutorizarEntradaTeste {

    private MorarSplashPage splash = new MorarSplashPage();
    private MorarLoginPage login = new MorarLoginPage();
    private MorarMenuPage menu = new MorarMenuPage();
    private AutorizarEntradaPage unidade = new AutorizarEntradaPage();

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
    public void cadastrarVisitanteInterforne() throws InterruptedException {
        menu.acessarUnidade();
        unidade.clicarAutorizarEntrada();
        unidade.clicarCadastrarNovoVisitante();
        unidade.clicarNomeVisitante();
        unidade.escreverNomeVisitante();
        Thread.sleep(4000);
        unidade.clicarCPFVisitante();
        Thread.sleep(4000);
        unidade.escreverCPFVisitante();
        unidade.clicarEmSalvar();
        unidade.clicarEmConcluir();
    }

    @Test
    public void cadastrarPrestadorInterfone(){
        menu.acessarUnidade();
        unidade.clicarAutorizarEntrada();
        unidade.clicarAbaPrestadores();
        unidade.clicarCadastrarNovoPrestador();
        unidade.clicarNomeNovoPrestador();
        unidade.escreverNomePrestador();
        unidade.clicarCPFNovoPrestador();
        unidade.escreverCPFNovoPrestador();
        unidade.clicarNomeNovaEmpresa();
        unidade.escreverCPFNovaEmpresa();
        unidade.clicarEmVoltar();
        unidade.clicarEmSalvarPrestador();
    }
}
