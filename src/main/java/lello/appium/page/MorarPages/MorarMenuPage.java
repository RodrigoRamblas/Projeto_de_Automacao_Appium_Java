package lello.appium.page.MorarPages;

import lello.appium.core.BasePage;

public class MorarMenuPage extends BasePage {

	public void acessarContas(){
		clicarPorTexto("Contas");
	}

	public void pular(){
		clicarContent("Pular");
	}

	public void fecharPopUpNovidades(){
		clicarContent("AGORA NÃO");
	}
	public void acessarNotificacoes(){ clicarContent("17");}
	public void acessarUnidade(){ clicarContent("Unidade\nGuia 3 de 3");}

// Menu Unidade

	public void acessarMoradores(){ clicarContent("Moradores");}

	public void acessarVeiculos(){ clicarContent("Veículos");}

	public void acessarComodidades(){ clicarContent("Comodidades");}
	public void acessarSeguros(){clicarContent("Seguros");}

	public void acessarCorrespondencias(){clicarContent("Correspondências");}

	public void acessarOcorrências(){clicarContent("Ocorrências");}

	public void acessarAutorizarEntrada(){clicarContent("Autorizar Entrada");}

	public void acessarAlugueOuVendaSeuImovel(){clicarContent("Autorizar Entrada");}

	}




