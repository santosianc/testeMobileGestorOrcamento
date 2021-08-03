package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.GestorPage;
import static utils.Utils.*;

import java.util.List;

import org.openqa.selenium.Keys;

public class GestorSteps {

	GestorPage c = new GestorPage(driver);
	
	@Quando("o usuario selecionar a opcao adicionar uma nova despesa")
	public void o_usuario_selecionar_a_opcao_adicionar_uma_nova_despesa() throws InterruptedException {
		c.acessarPaginaParaAdicionarDespesa();
		c.ignorarTutorial();
	}

	@Quando("inserir um valor {string}")
	public void inserir_um_valor(String despesa) {
	   c.alterarDespesa(despesa);
	}

	@Quando("selecionar uma categoria {string}")
	public void selecionar_uma_categoria(String categoria) {
	    c.selecionarCategoria(categoria);
	}

	@Quando("pressionar o botao adicionar")
	public void pressionar_o_botao_adicionar() {
	    c.adicionarDespesa();
	}
	
	@Dado("a despesa {string} {string} {string}")
	public void a_despesa(String categoria, String valor, String comentario) {
	    c.acessarDespesa(categoria, valor, comentario);
	}
	
	@Quando("pressionar o botao salvar")
	public void pressionar_o_botao_salvar() {
	    c.pressionarBotaoSalvar();
	}


	@Quando("o usuario selecionar a opcao editar")
	public void o_usuario_selecionar_a_opcao_editar() {
	    c.pressionarBotaoEditar();
	}

	@Quando("alterar o valor da despesa para {string}")
	public void alterar_o_valor_da_despesa_para(String despesa) {
	    c.alterarDespesa(despesa);
	}
	
	@Quando("depois deve excluir o item")
	public void depois_deve_excluir_o_item() {
	    c.pressionarBotaoExcluir();
	    c.pressionarBotaoSim();
	}
	
}
