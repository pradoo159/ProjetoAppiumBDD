package br.com.rsinet.hub_bdd.appium.util;

public class Data {
	
	public static String getCategoria() throws Exception {
		return ExcelUtils.getCellData(1, 1);
	}

	public static String getPesquisa() throws Exception {
		return ExcelUtils.getCellData(1, 1);
	}
	
	public static String getProduto() throws Exception {
		return ExcelUtils.getCellData(1, 0);
	}

}
