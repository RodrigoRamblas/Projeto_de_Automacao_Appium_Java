package lello.appium.page.MorarPages;

import com.github.javafaker.Faker;
import lello.appium.core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Objects;

public class MorarMenuPage extends BasePage {

	private MorarLoginPage login = new MorarLoginPage();
	private Faker faker = new Faker();

	String[] repetirArray = {"D", "S", "T", "Q"};

	public void acessarContas() throws InterruptedException { clicarPorTexto("Contas"); }
	public void pular(){ clicarContent("Pular"); }
	public void singUp(){ clicarContent("Faça Login"); }
	public void fecharPopUpNovidades(){ clicarContent("AGORA NÃO"); }
	public void acessarNotificacoes(){ clicarContent("17"); }
	public void acessarUnidade(){ clicarContent("Unidade"); }

	public void acessarAutorizar(){
		clicarContent("Autorizar Entrada");
		clicarContent("Sair da apresentação");
	}

// Menu Unidade

	public void acessarMoradores(){ clicarContent("Moradores");}
	public void acessarVeiculos(){ clicarContent("Veículos");}
	public void acessarComodidades(){ clicarContent("Comodidades");}
	public void acessarSeguros(){clicarContent("Seguros");}
	public void acessarCorrespondencias(){clicarContent("Correspondências");}
	public void acessarOcorrencias(){clicarContent("Ocorrências");}

	public void registrarNovaOcorrenciaSemAnexo(String texto, String status, String assunto) throws InterruptedException {
		clicarContent("Registrar nova ocorrência");
		clicarContent("Escolha uma opção");
		clicarContent(assunto);
		clicarPorTexto("Escreva aqui.");
		escrever(By.className("android.widget.EditText"), texto);
		fecharTeclado();
		if (status.equalsIgnoreCase("Sim")) {
			clicar(By.xpath("//android.view.View[@index='4']"));
		} else if (status.equalsIgnoreCase("Não") || status.equalsIgnoreCase("Nao")) {
			clicar(By.xpath("//android.view.View[@index='5']"));
		}
		clicar(By.xpath("//android.widget.Button[@index='2']"));
	}

	public void adicionarNovoVeiculo(String status, String placa) throws InterruptedException {
		clicarContent("Adicionar novo Veículo");
		clicarContent("Escolha o tipo");
		clicarContent("Carro");
		clicarPorTexto("XXX-0000");
		escrever(By.xpath("//android.widget.EditText[@index='6']"), placa);
		clicar(By.xpath("//android.widget.Button[@index='10']"));
		clicar(By.xpath("//android.view.View[@content-desc=\"Verde\"]"));
		clicar(By.xpath("//android.widget.EditText[@index='14']"));
		escrever(By.xpath("//android.widget.EditText[@index='12']"), "SUV");
		fecharTeclado();
		if (status.equalsIgnoreCase("Sim")) {
			clicar(By.xpath("//android.view.View[@content-desc='Sim']"));
		} else if (status.equalsIgnoreCase("Não") || status.equalsIgnoreCase("Nao")) {
			clicar(By.xpath("//android.view.View[@content-desc='Não']"));
		}
		clicar(By.xpath("//android.widget.Button[@content-desc='Adicionar']"));
	}

	public void cadastroNovoVisitante(String status, String tipoAcesso) throws Exception {
		Thread.sleep(2000);
		clicarContent("Cadastrar novo visitante");
		clicarEscrever(By.xpath("//android.widget.EditText[@index='3']"), faker.name().fullName());
		clicarEscrever(By.xpath("//android.widget.EditText[@index='5']"), faker.number().digits(11));
		try {
			if (status.equalsIgnoreCase("Interfonar")) {
				clicar(By.xpath("//android.view.View[@index='7']"));
			} else if (status.equalsIgnoreCase("Acesso Direto")) {
				clicar(By.xpath("//android.view.View[@index='9']"));
				fecharTeclado();
				clicar(By.xpath("//android.widget.Button[@content-desc='Pontual']"));
				clicarContent(tipoAcesso);
				if (Objects.equals(tipoAcesso, "Pontual")){
					clicar(By.xpath("//android.widget.Button[@content-desc='Pontual']"));
					clicar(By.xpath("//android.view.View[@content-desc='dd/mm/aa']"));
					clicar(By.xpath("//android.widget.Button[@content-desc='Confirmar']"));
				} else if (Objects.equals(tipoAcesso, "Recorrente")){
					clicar(By.xpath("//android.view.View[@index='19']"));
					clicar(By.xpath("//android.widget.Button[@content-desc='Confirmar']"));
					clicar(By.xpath("//android.view.View[@index='20']"));
					clicar(By.xpath("//android.widget.Button[@content-desc='Confirmar']"));
					for(int i = 0; i < repetirArray.length; i++){
						String dias = repetirArray[i];
						String xpath = "//android.view.View[@content-desc='"+ dias + "']";
						if(existeElementoPorXpath(xpath)){ clicar(By.xpath(xpath));	}
					}
					scrollDown();
				}
			}
			clicar(By.xpath("//android.widget.Button[@content-desc='Salvar']"));
		}catch(Exception ex){
			throw new Exception("Encontramos um visitante já cadastrado com este CPF.");
		}
    }

	public void enviarVeiculo() throws InterruptedException {
		clicar(By.xpath("//android.widget.Button[@content-desc=\"Adicionar\"]"));
	}

	public void enviarOcorrencia() throws InterruptedException {
		clicar(By.xpath("//android.widget.Button[@index='2']"));
	}

	public void validarMensagemDeSucessoOcorrencia(String mensagem){
		Assert.assertEquals(mensagem,recuperarMensagemXpath("//android.view.View[@content-desc=\"Ocorrência registrada com sucesso\"]"));
	}
	public void validarMensagemCadastroAluguel(String mensagem){
		Assert.assertEquals(mensagem,recuperarMensagemXpath("//android.view.View[@content-desc='Logo Lello Imóveis']/android.view.View/android.widget.Image"));
	}
	public void validarMensagemDeSucessoVeiculo(String mensagem){
		Assert.assertEquals(mensagem,recuperarMensagemXpath("//android.view.View[@content-desc='Veículo adicionado com sucesso']"));
	}

	public void validarMensagemDeSucessoAutorizar(String mensagem){
		Assert.assertEquals(mensagem,recuperarMensagemXpath("//android.view.View[@content-desc='Cadastro do visitante criado com sucesso']"));
	}

	public void clicarEmConcluir(){clicarContent("Concluir");}

	public void clicarNovaOcorrencia() throws InterruptedException {
		clicar(By.xpath("//android.view.View[@index='0']"));
	}

	public void clicarNovoVeiculo() throws InterruptedException {
		clicar(By.xpath("//android.view.View[@index='6']"));
	}

	public void minhasOcorrencias(){ clicarContent("Minhas ocorrências"); }
	public void acessarAutorizarEntrada(){ clicarContent("Autorizar Entrada"); }
	public void acessarAlugueOuVendaSeuImovel(){ clicarContent("Alugue ou venda o seu imóvel"); }
	public void popUpAluguel(String status){
		if (status.equalsIgnoreCase("SAIBA MAIS")) {
			clicar(By.xpath("//android.widget.Button[@content-desc='SAIBA MAIS']"));
		} else if (status.equalsIgnoreCase("Mais tarde")) {
			clicar(By.xpath("//android.widget.Button[@content-desc='Mais tarde']"));
		}
	}

}




