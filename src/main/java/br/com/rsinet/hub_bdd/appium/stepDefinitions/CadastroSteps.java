package br.com.rsinet.hub_bdd.appium.stepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.appium.manager.TestContext;
import br.com.rsinet.hub_bdd.appium.util.Scroll;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import hub_bdd.appium.pageObject.CadastroScreen;
import hub_bdd.appium.pageObject.HomeScreen;
import io.appium.java_client.android.AndroidDriver;

public class CadastroSteps {
	
	private HomeScreen home;
	private CadastroScreen cadastro;
	private TestContext testContext;
 	private String usuario;
	
	public CadastroSteps(TestContext context) {
		testContext = context;
		home = testContext.getPageObjectManager().getHomeScreen();
		cadastro = testContext.getPageObjectManager().getCadastroScreen();
	}


	@E("^eu inserir dados válidos nos campos$")
	public void eu_inserir_dados_válidos_nos_campos() throws Throwable {
		usuario = "pradoo1116";
	    cadastro.escreveUser(usuario);
	    cadastro.escreveEmail("emerson.prado@rsinet.com.br");
	    cadastro.escreveSenha("Teste@1234");
	    cadastro.escreveConfirmaSenha("Teste@1234");
	    cadastro.escreveSobrenome("Prado");
	    cadastro.escreveNome("Emerson");
	    cadastro.escreveTelefone("11111111");
	    cadastro.escolhePais("Brazil");
	    cadastro.escreveEstado("Sao Paulo");
	    cadastro.escreveEndereco("Avenida dos remedios");
	    cadastro.escreveCEP("06293110");
	    cadastro.escreveCidade("Osasco");
	}

	@E("^clicar no botão de Registrar$")
	public void clicar_no_botão_de_Registrar() throws Throwable {
		cadastro.click_Register();
	}

	@Então("^o usuario deverá ser redirecionado para a tela inicial logado na conta cadastrada$")
	public void o_usuario_deverá_ser_redirecionado_para_a_tela_inicial_logado_na_conta_cadastrada() throws Throwable {
		home.click_Menu();
		assertTrue(home.usuarioLogado().equals(usuario));
	}

	@E("^eu inserir dados inválidos nos campos$")
	public void eu_inserir_dados_inválidos_nos_campos() throws Throwable {
		cadastro.escreveUser("pradoo");
	    cadastro.escreveEmail("emerson.pradorsinet.com.br");
	    cadastro.escreveSenha("Teste@1234");
	    cadastro.escreveConfirmaSenha("Teste@1234");
	    cadastro.escreveSobrenome("Prado");
	    cadastro.escreveNome("Emerson");
	    cadastro.escreveTelefone("11111111");
	    cadastro.escolhePais("Brazil");
	    cadastro.escreveEstado("Sao Paulo");
	    cadastro.escreveEndereco("Avenida dos remedios");
	    cadastro.escreveCEP("06293110");
	    cadastro.escreveCidade("Osasco");
	}

	@Então("^não será possível clicar no botão de registrar$")
	public void não_será_possível_clicar_no_botão_de_registrar() throws Throwable {
		cadastro.click_Register();
		assertFalse(cadastro.verificarBtnRegistrar());
	}
	
}
