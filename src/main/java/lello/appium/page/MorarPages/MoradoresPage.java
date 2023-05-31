package lello.appium.page.MorarPages;

import lello.appium.core.BasePage;
import org.openqa.selenium.By;

public class MoradoresPage extends BasePage {

    public void adicionarUmNovoUsuario(){clicarContent("Adicionar novo usuário");}
    public void cadastrarUmNovoContato(){clicarContent("Cadastrar novo contato");}

    public void clicarNomeNovoMorador() throws InterruptedException {clicar(By.xpath("//android.widget.EditText[1]"));}
    public void escreverNomeMorador() throws InterruptedException {escrever(By.xpath("//android.widget.EditText[1]"), "RodrigoMoradorTeste");}
    public void clicarCPFNovoMorador() throws InterruptedException {clicar(By.xpath("//android.widget.EditText[2]"));}
    public void escreverCPFNovoMorador() throws InterruptedException {escrever(By.xpath("//android.widget.EditText[2]"), "33186367700");}
    public void clicarEmailNovoMorador() throws InterruptedException {clicar(By.xpath("//android.widget.EditText[3]"));}
    public void escreverEmailMorador() throws InterruptedException {escrever(By.xpath("//android.widget.EditText[3]"), "rodrigo.hamblas@lello.com.br");}

    public void clicarCelularNovoMoradorDDD() throws InterruptedException {clicar(By.xpath("//android.widget.EditText[4]"));}
    public void escreverCelularlMoradorDDD() throws InterruptedException {escrever(By.xpath("//android.widget.EditText[4]"), "11");}
    public void clicarCelularNovoMorador() throws InterruptedException {clicar(By.xpath("//android.widget.EditText[5]"));}
    public void escreverCelularlMorador() throws InterruptedException {escrever(By.xpath("//android.widget.EditText[5]"), "970216812");}
    public void clicarMenuDrop(){clicarContent("Escolha uma opção");}
    public void clicarMenuDropProprietario(){clicarContent("Proprietário");}
    public void clicarConcluir(){clicarContent("Concluir");}



}
