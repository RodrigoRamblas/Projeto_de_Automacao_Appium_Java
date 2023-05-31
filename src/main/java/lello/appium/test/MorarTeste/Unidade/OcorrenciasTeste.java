package lello.appium.test.MorarTeste.Unidade;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lello.appium.core.ConvertJson;
import lello.appium.page.MorarPages.MorarLoginPage;
import lello.appium.page.MorarPages.MorarMenuPage;
import lello.appium.page.MorarPages.MorarSkipPage;
import lello.appium.page.MorarPages.MorarSplashPage;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class OcorrenciasTeste extends ConvertJson {

    private final MorarSplashPage splash = new MorarSplashPage();
    private final MorarLoginPage login = new MorarLoginPage();
    private final MorarMenuPage menu = new MorarMenuPage();
    private final MorarSkipPage skip = new MorarSkipPage();

    private final String jsonLogin = "src/main/java/lello/appium/data/login/login.json";
    private final String jsonOcorrencias = "src/main/java/lello/appium/data/ocorrencias/ocorrencias.json";

    @Before
    public void setup() throws InterruptedException, IOException, org.json.simple.parser.ParseException {
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
    @Severity(SeverityLevel.NORMAL)
    @Description("Registrar Uma ocorrência com a função Occorência pública NÃO e Sem Anexo")
    public void OcorrenciasFlagOcorrenciaPublicaTipoNaoSemAnexo () throws IOException, ParseException, InterruptedException {
        List ocorrenciaUP = Ocorrencia(jsonOcorrencias);
        List assunto = (List) ocorrenciaUP.get(4);
        menu.acessarUnidade();
        menu.acessarOcorrencias();
        menu.registrarNovaOcorrenciaSemAnexo(ocorrenciaUP.get(0).toString(), ocorrenciaUP.get(1).toString(), assunto.get(0).toString());
        menu.enviarOcorrencia();
        menu.validarMensagemDeSucessoOcorrencia(ocorrenciaUP.get(3).toString());
        menu.clicarEmConcluir();
        menu.minhasOcorrencias();
        menu.clicarNovaOcorrencia();
    }

    @Test
    public void OcorrenciasFlagOcorrenciaPublicaTipoSimSemAnexo() throws IOException, ParseException, InterruptedException {
        List ocorrenciaUP = Ocorrencia(jsonOcorrencias);
        List assunto = (List) ocorrenciaUP.get(4);
        menu.acessarUnidade();
        menu.acessarOcorrencias();
        menu.registrarNovaOcorrenciaSemAnexo(ocorrenciaUP.get(0).toString(), ocorrenciaUP.get(2).toString(), assunto.get(0).toString());
        menu.enviarOcorrencia();
        menu.validarMensagemDeSucessoOcorrencia(ocorrenciaUP.get(3).toString());
        menu.clicarEmConcluir();
        menu.minhasOcorrencias();
        menu.clicarNovaOcorrencia();
    }
}


