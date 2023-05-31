package lello.appium.page.MorarPages;

import lello.appium.core.BasePage;
import org.openqa.selenium.By;

public class AutorizarEntradaPage extends BasePage {
    public void clicarAutorizarEntrada() throws InterruptedException {
        clicarContent("Autorizar Entrada");
        Thread.sleep(2000);
        clicarContent("Sair da apresentação");
        Thread.sleep(2000);
    }
    public void cadastrarNovoVisitante() throws InterruptedException {
        clicarContent("Cadastrar novo visitante");
        Thread.sleep(2000);
        clicarPorTexto("Escreva");
        Thread.sleep(2000);
        escrever(By.xpath("//*[@text='Escreva']"), "Geralda");
    }

    public void cadastrarCPFVisitante() throws InterruptedException {
        clicar(By.xpath("//*[@text='000.000.000-00']"));
        Thread.sleep(2000);
        escrever(By.xpath("//*[@text='000.000.000-00']"), "59001233406");
        Thread.sleep(2000);
    }

    public void clicarEmSalvar() throws InterruptedException {
        clicarContent("Salvar");
        Thread.sleep(2000);
    }
    public void clicarEmConcluir(){
        obterTextoPorContentDesc("Cadastro do visitante criado com sucesso");
        clicarContent("Concluir");
    }
    public void clicarAbaPrestadores(){clicarContent("PRESTADORES\n" +
            "Guia 2 de 2");}
    public void clicarCadastrarNovoPrestador(){clicarContent("Cadastrar novo prestador");}
    public void clicarNomeNovoPrestador() throws InterruptedException {clicar(By.xpath("//android.widget.EditText[1]"));}
    public void escreverNomePrestador() throws InterruptedException {escrever(By.xpath("//android.widget.EditText[1]"), "Marialurdesprestador");}
    public void clicarCPFNovoPrestador() throws InterruptedException {clicar(By.xpath("//android.widget.EditText[2]"));}
    public void escreverCPFNovoPrestador() throws InterruptedException {escrever(By.xpath("//android.widget.EditText[2]"), "33186367700");}
    public void clicarNomeNovaEmpresa() throws InterruptedException {clicar(By.xpath("//android.widget.EditText[3]"));}
    public void escreverCPFNovaEmpresa() throws InterruptedException {escrever(By.xpath("//android.widget.EditText[3]"), "Pizzaria Mogi");}
    public void clicarEmVoltar(){voltar();}
    public void clicarEmSalvarPrestador() {clicarContent("Salvar");

    }}
