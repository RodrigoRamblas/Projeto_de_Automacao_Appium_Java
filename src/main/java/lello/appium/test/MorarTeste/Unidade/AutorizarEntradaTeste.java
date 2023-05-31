package lello.appium.test.MorarTeste.Unidade;

import lello.appium.core.ConvertJson;
import lello.appium.page.MorarPages.AutorizarEntradaPage;
import lello.appium.page.MorarPages.MorarLoginPage;
import lello.appium.page.MorarPages.MorarMenuPage;
import lello.appium.page.MorarPages.MorarSkipPage;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class AutorizarEntradaTeste extends ConvertJson {

    private MorarLoginPage login = new MorarLoginPage();
    private final MorarSkipPage skip = new MorarSkipPage();
    private MorarMenuPage menu = new MorarMenuPage();

    private final String jsonLogin = "src/main/java/lello/appium/data/login/login.json";
    private final String jsonAutorizar = "src/main/java/lello/appium/data/autorizar/autorizar.json";


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
    public void AutorizarEntradaInterfonePontual() throws Exception {
        List autorizarUP = Autorizar(jsonAutorizar);
        List tipoAcesso = (List) autorizarUP.get(3);
        menu.acessarAutorizar();
        menu.cadastroNovoVisitante(autorizarUP.get(0).toString(), tipoAcesso.get(0).toString());
        menu.validarMensagemDeSucessoAutorizar(autorizarUP.get(2).toString());
        menu.clicarEmConcluir();
    }

    @Test
    public void AutorizarEntradaAcessoDiretoRecorrente() throws Exception {
        List autorizarUP = Autorizar(jsonAutorizar);
        List tipoAcesso = (List) autorizarUP.get(3);
        menu.acessarAutorizar();
        menu.cadastroNovoVisitante(autorizarUP.get(1).toString(), tipoAcesso.get(1).toString());
        menu.validarMensagemDeSucessoAutorizar(autorizarUP.get(2).toString());
        menu.clicarEmConcluir();
    }
}
