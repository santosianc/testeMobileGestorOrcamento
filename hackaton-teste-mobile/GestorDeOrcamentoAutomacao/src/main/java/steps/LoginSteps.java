package steps;

import static utils.Utils.driver;

import io.cucumber.java.pt.Dado;
import pageObjects.LoginPage;

public class LoginSteps {

	LoginPage l = new LoginPage(driver);
	
	@Dado("que o usuario esteja na pagina principal do app")
	public void que_o_usuario_esteja_na_pagina_principal_do_app() throws Exception {
	    l.comecarSemLogar();
	}
}
