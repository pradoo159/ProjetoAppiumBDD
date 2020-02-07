package br.com.rsinet.hub_bdd.appium.stepDefinitions;

import static org.junit.Assert.assertTrue;

import br.com.rsinet.hub_bdd.appium.manager.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import hub_bdd.appium.pageObject.HomeScreen;
import hub_bdd.appium.pageObject.ProdutoScreen;
import junit.framework.Assert;

public class HomeSteps {

	private HomeScreen home;
	private TestContext testContext;
	private ProdutoScreen produtos;
	private String nomeProduto;

	public HomeSteps(TestContext context) {
		testContext = context;
		home = testContext.getPageObjectManager().getHomeScreen();
		produtos = testContext.getPageObjectManager().getProdutoScreen();
	}

	@Dado("^que eu esteja com o app aberto$")
	public void que_eu_esteja_com_o_app_aberto() throws Throwable {

	}

	@Quando("^eu navegar até a página de cadastro$")
	public void eu_navegar_até_a_página_de_cadastro() throws Throwable {
		home.click_Menu();
		home.click_Login();
		home.click_SignUp();
	}

	@Quando("^eu pesquisar na barra de pesquisa por um produto valido$")
	public void eu_pesquisar_na_barra_de_pesquisa_por_um_produto_valido() throws Throwable {
		home.click_Lupa();
		home.escreverPesquisa("MOUSE");
		home.click_Lupa();
	}

	@Quando("^clicar no produto desejado$")
	public void clicar_no_produto_desejado() throws Throwable {
		nomeProduto = "HP Z8000 BLUETOOTH MOUSE";
		produtos.click_MouseEscolhido(nomeProduto);
	}

	@Entao("^a tela do produto deverá ser exibida$")
	public void a_tela_do_produto_deverá_ser_exibida() throws Throwable {
		assertTrue(nomeProduto.equals(produtos.getTituloProduto()));
	}

	@Quando("^eu pesquisar na barra de pesquisa por um produto invalido$")
	public void eu_pesquisar_na_barra_de_pesquisa_por_um_produto_invalido() throws Throwable {
		home.click_Lupa();
		home.escreverPesquisa("Celular");
		home.click_Lupa();
	}

	@Entao("^será exibido na tela uma mensagem dizendo que o produto não foi encontrado$")
	public void será_exibido_na_tela_uma_mensagem_dizendo_que_o_produto_não_foi_encontrado() throws Throwable {
		assertTrue(produtos.getMensagemErro().contains("No results for"));
	}
}
