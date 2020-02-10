package br.com.rsinet.hub_bdd.appium.stepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import br.com.rsinet.hub_bdd.appium.manager.TestContext;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import hub_bdd.appium.pageObject.HomeScreen;
import hub_bdd.appium.pageObject.ProdutoScreen;

public class ProdutoSteps {

	private TestContext testContext;
	private ProdutoScreen produtos;
	private String nomeProduto;

	public ProdutoSteps(TestContext context) {
		testContext = context;
		produtos = testContext.getPageObjectManager().getProdutoScreen();
	}

	@E("^clicar no produto desejado$")
	public void clicar_no_produto_desejado() throws Throwable {
		nomeProduto = "HP PRO TABLET 608 G1";
		produtos.click_MouseEscolhido(nomeProduto);
	}

	// Pesquisas validas
	@Entao("^a tela do produto deverá ser exibida$")
	public void a_tela_do_produto_deverá_ser_exibida() throws Throwable {
		assertTrue(nomeProduto.equalsIgnoreCase(produtos.getTituloProduto()));
	}
	
	// Pesquisa por texto invalida
	@Entao("^será exibido na tela uma mensagem dizendo que o produto não foi encontrado$")
	public void será_exibido_na_tela_uma_mensagem_dizendo_que_o_produto_não_foi_encontrado() throws Throwable {
		assertTrue(produtos.getMensagemErro().contains("No results for"));
	}

	// Pesquisa por categoria invalida
	@Entao("^o titulo do produto será diferente$")
	public void o_titulo_do_produto_será_diferente() throws Throwable {
		assertFalse(nomeProduto.equalsIgnoreCase(produtos.getTituloProduto()));
	}

}
