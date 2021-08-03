package pageObjects;

import static utils.Utils.driver;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class GestorPage {

	private TouchAction touchAction;

	private Keyboard keyboard;

	private Actions actions;

	public GestorPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		touchAction = new TouchAction(driver);
		keyboard = driver.getKeyboard();
		actions = new Actions(driver);

	}


	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
	private MobileElement btnAdicionarDespesa;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Selecionar o tipo de transação\"]")
	private MobileElement viewTutorial;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]")
	private MobileElement inputNovoSaldoDespesa;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]")
	private MobileElement inputComentarioDespesa;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Transporte\"]")
	private MobileElement opcaoTransporte;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Adicionar\"]")
	private MobileElement btnAdicionar;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement campoEditText;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SIM']")
	private MobileElement btnSim;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Barium']")
	private MobileElement opcaoCombo;

	@AndroidFindBy(xpath = "//android.widget.Switch[@text='ON'][1]")
	private MobileElement switchApp;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Repeat']")
	private MobileElement check;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout")
	private MobileElement currentPage;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
	private MobileElement btnEditar;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Salvar\"]")
	private MobileElement btnSalvar;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"EXCLUIR\"]")
	private MobileElement btnExcluir;

	public void clicarNaHora(String hora) throws Exception {

		MobileElement clickHora = (MobileElement) driver.findElement(MobileBy.AccessibilityId(hora));
		clickHora.click();

	}

	public void acessarPaginaParaAdicionarDespesa() {
		btnAdicionarDespesa.click();

	}

	public void ignorarTutorial() throws InterruptedException {
		for (int i = 0; i < 9; i++) {
			Thread.sleep(500);
			touchAction.tap(PointOption.point(800, 720)).perform();
		}
	}

	public void alterarDespesa(String despesa) {
		inputNovoSaldoDespesa.click();
		apagarCampo(inputNovoSaldoDespesa);
		keyboard.sendKeys(despesa);
	}
	
	private void apagarCampo(MobileElement campo) {
		String text = campo.getText();	
		if(StringUtils.isBlank(text)) {
			return;
		}
		while (StringUtils.isNotBlank(campo.getText())) {
			System.out.println(campo.getText());
			driver.getKeyboard().sendKeys(Keys.DELETE);
			driver.getKeyboard().sendKeys(Keys.BACK_SPACE);
		}
	}

	public void selecionarCategoria(String categoria) {
		MobileElement categoriaElement = currentPage
				.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"" + categoria + "\"]"));
		categoriaElement.click();
	}

	public void adicionarDespesa() {
		btnAdicionar.click();
	}

	public void acessarDespesa(String categoria, String comentario, String valor) {
		List<MobileElement> categoriaElement = currentPage.findElements(
				By.xpath("//android.widget.ImageView[contains(@content-desc,'"+valor+"')]"));
		categoriaElement.get(0).click();
		List<MobileElement> categoriaElement2 = currentPage.findElements(By.xpath("//android.widget.ImageView[contains(@content-desc,'"+valor+"')]"));
		categoriaElement2.get(0).click();
	}

	public void pressionarBotaoEditar() {
		btnEditar.click();
	}
	
	
	public void pressionarBotaoSalvar() {
		btnSalvar.click();
	}	
	
	public void pressionarBotaoExcluir() {
		btnExcluir.click();
	}
	
	public void pressionarBotaoSim() {
		btnSim.click();
	}
}
