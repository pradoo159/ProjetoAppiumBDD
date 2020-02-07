package br.com.rsinet.hub_bdd.appium.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature",
		glue = {"br.com.rsinet.hub_bdd.appium.stepDefinitions"},
		monochrome = true
		)
public class TestRunner {

	
	
}
