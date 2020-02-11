package hub_bdd.appium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.appium.util.Click;
import br.com.rsinet.hub_bdd.appium.util.Scroll;
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
	
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
	private WebElement filtro_ScrollerType;
	
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView")
	private WebElement filtro_Color;
	
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.view.View[3]")
	private WebElement filtro_CorRoxa;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewApply")
	private WebElement btn_Apply;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewFilter")
	private WebElement btn_Filters;

	public String getTituloProduto() {
		return titulo_Produto.getText();
	}
	
	public String getMensagemErro() {
		return txt_Error.getText();
	}

	public void click_ProdutoEscolhido(String nomeProduto) {
		Scroll.scrollAndClick(driver, nomeProduto);
	}
	
	public void click_FiltroScroll() {
		Click.ByVisibleText(driver, "BY SCROLLER TYPE");
	}
	
	public void click_ScrollOpcao(String opcao) {
		Click.ByVisibleText(driver, opcao);
	}
	
	public void click_FiltroColor() {
//		Click.ByVisibleText(driver, "BY CONNECTOR");
		Click.ByVisibleText(driver, "BY COLOR");
	}

	public void click_ColorOpcao() {
//		Click.ByVisibleText(driver, "WIRELESS");
		filtro_CorRoxa.click();
	}

	public void click_Apply() {
		btn_Apply.click();
	}
	
	public void click_Filter() {
		btn_Filters.click();
	}

}
