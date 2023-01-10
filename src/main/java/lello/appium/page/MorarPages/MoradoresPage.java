package lello.appium.page.MorarPages;

import lello.appium.core.BasePage;
import org.openqa.selenium.By;

public class MoradoresPage extends BasePage {

    public void adicionarUmNovoUsuario(){clicarContent("Adicionar novo usuário");}
    public void cadastrarUmNovoContato(){clicarContent("Cadastrar novo contato");}

    public void clicarNomeNovoMorador(){clicar(By.xpath("//android.widget.EditText[1]"));}
    public void escreverNomeMorador(){escrever(By.xpath("//android.widget.EditText[1]"), "RodrigoMoradorTeste");}
    public void clicarCPFNovoMorador(){clicar(By.xpath("//android.widget.EditText[2]"));}
    public void escreverCPFNovoMorador(){escrever(By.xpath("//android.widget.EditText[2]"), "33186367700");}
    public void clicarEmailNovoMorador(){clicar(By.xpath("//android.widget.EditText[3]"));}
    public void escreverEmailMorador(){escrever(By.xpath("//android.widget.EditText[3]"), "rodrigo.hamblas@lello.com.br");}

    public void clicarCelularNovoMoradorDDD(){clicar(By.xpath("//android.widget.EditText[4]"));}
    public void escreverCelularlMoradorDDD(){escrever(By.xpath("//android.widget.EditText[4]"), "11");}
    public void clicarCelularNovoMorador(){clicar(By.xpath("//android.widget.EditText[5]"));}
    public void escreverCelularlMorador(){escrever(By.xpath("//android.widget.EditText[5]"), "970216812");}
    public void clicarMenuDrop(){clicarContent("Escolha uma opção");}
    public void clicarMenuDropProprietario(){clicarContent("Proprietário");}
    public void clicarConcluir(){clicarContent("Concluir");}



}
