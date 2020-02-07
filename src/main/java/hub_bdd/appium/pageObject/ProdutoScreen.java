package hub_bdd.appium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.util.Scroll;
import io.appium.java_client.android.AndroidDriver;

public class ProdutoScreen {

	AndroidDriver driver;

	public ProdutoScreen(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void click_MouseEscolhido(String nomeMouse) {
		Scroll.scrollAndClick(driver, nomeMouse);
	}

}
