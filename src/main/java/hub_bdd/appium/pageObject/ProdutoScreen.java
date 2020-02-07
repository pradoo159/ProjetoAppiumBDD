package hub_bdd.appium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.util.Scroll;
import io.appium.java_client.android.AndroidDriver;

public class ProdutoScreen {

	AndroidDriver driver;

	public ProdutoScreen(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewNoProductsToShow")
	private WebElement txt_Error;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewProductName")
	private WebElement titulo_Produto;
	
	public String getTituloProduto() {
		return titulo_Produto.getText();
	}
	
	public String getMensagemErro() {
		return txt_Error.getText();
	}

	public void click_MouseEscolhido(String nomeMouse) {
		Scroll.scrollAndClick(driver, nomeMouse);
	}

}
