package pageObjects;

import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	private Keyboard keyboard;

	public LoginPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		keyboard = driver.getKeyboard();
		
	}


	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Continuar sem criar uma conta\"]")
	private MobileElement buttonContinuarSemCriarUmaConta;
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Começar\"]")
	private MobileElement buttonComecar;
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Próximo\"]")
	private MobileElement buttonProximo;
	
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	private MobileElement inputSaldoPrincipal;

	public void comecarSemLogar() throws Exception {
		System.out.println("comecando sem logar");
		buttonContinuarSemCriarUmaConta.click();
		buttonComecar.click();
		buttonProximo.click();
		inputSaldoPrincipal.click();
		keyboard.sendKeys("1200");
		buttonProximo.click();
	}
}
