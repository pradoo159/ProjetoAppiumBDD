package hub_bdd.appium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.appium.manager.AppManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreen {
	AndroidDriver driver;

	public HomeScreen(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement btn_Menu;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement lnk_Login;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewSingUpToday")
	private WebElement lnk_SignUp;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewSearch")
	private WebElement lupa;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/editTextSearch")
	private WebElement txtbx_Search;

	public void click_Menu() {
		btn_Menu.click();
	}

	public void click_Login() {
		lnk_Login.click();
	}

	public void click_SignUp() {
		lnk_SignUp.click();
	}

	public void click_Lupa() {
		lupa.click();
	}

	public void escreverPesquisa(String produto) {
		txtbx_Search.sendKeys(produto);
	}
	
}
