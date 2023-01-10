package lello.appium.page.MorarPages;

import lello.appium.core.BasePage;
import org.openqa.selenium.By;

public class AutorizarEntradaPage extends BasePage {
    public void clicarAutorizarEntrada(){ clicarContent("Autorizar Entrada");}
    public void clicarCadastrarNovoVisitante(){ clicarContent("Cadastrar novo visitante");}
    public void clicarNomeVisitante(){clicarPorTexto("Escreva");}
    public void escreverNomeVisitante(){escrever(By.xpath("//*[@text='Escreva']"), "Geralda");}
    public void clicarCPFVisitante(){clicar(By.xpath("//*[@text='000.000.000-00']"));}
    public void escreverCPFVisitante(){escrever(By.xpath("//*[@text='000.000.000-00']"), "59001233406");}
    public void clicarEmSalvar() {clicarContent("Salvar");}
    public void clicarEmConcluir(){clicarContent("Cadastro do visitante criado com sucesso");}
    public void clicarAbaPrestadores(){clicarContent("PRESTADORES\n" +
            "Guia 2 de 2");}
    public void clicarCadastrarNovoPrestador(){clicarContent("Cadastrar novo prestador");}
    public void clicarNomeNovoPrestador(){clicar(By.xpath("//android.widget.EditText[1]"));}
    public void escreverNomePrestador(){escrever(By.xpath("//android.widget.EditText[1]"), "Marialurdesprestador");}
    public void clicarCPFNovoPrestador(){clicar(By.xpath("//android.widget.EditText[2]"));}
    public void escreverCPFNovoPrestador(){escrever(By.xpath("//android.widget.EditText[2]"), "33186367700");}
    public void clicarNomeNovaEmpresa(){clicar(By.xpath("//android.widget.EditText[3]"));}
    public void escreverCPFNovaEmpresa(){escrever(By.xpath("//android.widget.EditText[3]"), "Pizzaria Mogi");}
    public void clicarEmVoltar(){voltar();}
    public void clicarEmSalvarPrestador() {clicarContent("Salvar");

    }}
