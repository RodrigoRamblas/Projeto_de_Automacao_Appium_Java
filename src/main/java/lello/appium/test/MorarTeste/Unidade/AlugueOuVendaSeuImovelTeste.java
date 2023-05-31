package lello.appium.test.MorarTeste.Unidade;

import lello.appium.core.ConvertJson;
import lello.appium.page.MorarPages.MorarLoginPage;
import lello.appium.page.MorarPages.MorarMenuPage;
import lello.appium.page.MorarPages.MorarSkipPage;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class AlugueOuVendaSeuImovelTeste extends ConvertJson {

    private final  MorarLoginPage login = new MorarLoginPage();
    private final MorarMenuPage menu = new MorarMenuPage();
    private final MorarSkipPage skip = new MorarSkipPage();
    private final String jsonLogin = "src/main/java/lello/appium/data/login/login.json";
    private final String jsonAluguel = "src/main/java/lello/appium/data/aluguel/aluguel.json";

    @Before
    public void setup() throws InterruptedException, IOException, ParseException {
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
    public void alugarOuVenderSaibaMais () throws IOException, ParseException {
        List aluguelUP = Aluguel(jsonAluguel);
        menu.acessarUnidade();
        menu.acessarAlugueOuVendaSeuImovel();
        menu.popUpAluguel(aluguelUP.get(0).toString());
        menu.validarMensagemCadastroAluguel(aluguelUP.get(2).toString());
    }
    @Test
    public void alugarOuVenderMaisTarde () throws IOException, ParseException {
        List aluguelUP = Aluguel(jsonAluguel);
        menu.acessarUnidade();
        menu.acessarAlugueOuVendaSeuImovel();
        menu.popUpAluguel(aluguelUP.get(1).toString());
    }
}
