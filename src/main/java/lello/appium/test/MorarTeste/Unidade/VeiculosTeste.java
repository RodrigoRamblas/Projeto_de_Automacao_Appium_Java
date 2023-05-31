package lello.appium.test.MorarTeste.Unidade;

import lello.appium.core.BasePage;
import lello.appium.core.ConvertJson;
import lello.appium.page.MorarPages.MorarLoginPage;
import lello.appium.page.MorarPages.MorarMenuPage;
import lello.appium.page.MorarPages.MorarSkipPage;
import lello.appium.page.MorarPages.MorarSplashPage;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
//import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class VeiculosTeste extends  ConvertJson{

    private final MorarSplashPage splash = new MorarSplashPage();
    private final MorarLoginPage login = new MorarLoginPage();
    private final MorarSkipPage skip = new MorarSkipPage();
    private final MorarMenuPage menu = new MorarMenuPage();
    private final BasePage base = new BasePage();

    private final String jsonLogin = "src/main/java/lello/appium/data/login/login.json";
    private final String jsonVeiculos = "src/main/java/lello/appium/data/veiculos/veiculos.json";

    @Before
    public void setup() throws InterruptedException, IOException, ParseException, ParseException {
        List loginUP = Login(jsonLogin);
        skip.clicarEmProximo();
        menu.singUp();
        login.fecharPopUp();
        login.setCPFouCNPJ(loginUP.get(0).toString());
        login.setSenha(loginUP.get(1).toString());
        login.clicarEntrar();
        login.clicarClose();
        login.clicarForaDoPopUp();
    }

    @Test
    public void VeiculosTesteFlagVeiculosTipoSim () throws IOException, ParseException, InterruptedException {
        List veiculoUP = Veiculo(jsonVeiculos);
        menu.acessarUnidade();
        menu.acessarVeiculos();
        menu.adicionarNovoVeiculo(veiculoUP.get(1).toString(), base.gerarPlaca());
        menu.validarMensagemDeSucessoVeiculo(veiculoUP.get(2).toString());
        menu.clicarEmConcluir();
    }

    @Test
    public void VeiculosTesteFlagVeiculosTipoNao () throws IOException, ParseException, InterruptedException {
        List veiculoUP = Veiculo(jsonVeiculos);
        menu.acessarUnidade();
        menu.acessarVeiculos();
        menu.adicionarNovoVeiculo(veiculoUP.get(0).toString(), base.gerarPlaca());
        menu.validarMensagemDeSucessoVeiculo(veiculoUP.get(2).toString());
        menu.clicarEmConcluir();
    }
}
