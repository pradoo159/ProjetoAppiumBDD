package br.com.rsinet.hub_bdd.util;

import org.junit.After;
import org.junit.Before;

import br.com.rsinet.hub_bdd.appium.manager.AppManager;
import br.com.rsinet.hub_bdd.appium.manager.TestContext;
import io.appium.java_client.android.AndroidDriver;

public class Hooks {
	private TestContext testContext;
	private AppManager manager;
	private AndroidDriver driver;
	
	public Hooks(TestContext context) {
		testContext = context;
		manager = testContext.getAppManager();
		driver = manager.getDriver();
	}
	
	@After
	public void AfterSteps() {
		testContext.getAppManager().closeDriver();
	}

}
