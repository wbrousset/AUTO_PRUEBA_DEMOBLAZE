package page;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import util.PageObjectUtil;
import xpath.DemoblazeXpath;

@DefaultUrl("https://www.demoblaze.com/index.html")
public class DemoblazePage extends PageObject{

	protected DemoblazeXpath demoblazeXpath = DemoblazeXpath.getInstancia();
	protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();

	private WebDriverWait wdw = null;
	private long wdwTimeOut = 300L;
	public String textoAlertaSignUp, textoAlertaAddCart;

	public long getWdwTimeOut() {
		return wdwTimeOut;
	}

	public void inicializar() {
		open();
		System.out.println("url: " + getDriver().getCurrentUrl());
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		// getDriver().manage().window().fullscreen();
		getDriver().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
	}

	protected WebDriverWait getWDW() {
		// return new WebDriverWait(getDriver(), wdwTimeOut, wdwPollingEvery);
		if (wdw == null) {
			// wdw = new WebDriverWait(getDriver(), 300L, 1L);
			wdw = new WebDriverWait(getDriver(), wdwTimeOut, 1L);
		}
		return wdw;
	}

	public void clickMenuSignUp() {
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.opc_signUp);
		pageObjectUtil.seleniumClickPaint( getDriver(), demoblazeXpath.opc_signUp, 0);
		Serenity.takeScreenshot();
	}

	public void ingresarCredencialesSignUp(String username, String password) {
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.txt_usernameSingUp);
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.txt_passwordSingUp);
		pageObjectUtil.seleniumWrite( getDriver(), demoblazeXpath.txt_usernameSingUp, 0, username, null);
		pageObjectUtil.seleniumWrite( getDriver(), demoblazeXpath.txt_passwordSingUp, 0, password, null);
		Serenity.takeScreenshot();
	}

	public void clickBotonSignUp() {
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.btn_signUp);
		pageObjectUtil.seleniumClickPaint( getDriver(), demoblazeXpath.btn_signUp, 0);
		pageObjectUtil.sleep(3);
		textoAlertaSignUp=pageObjectUtil.obtenerTextoAlerta(getDriver(), 10);
	}

	public String usuarioCreadoExitosamente() {
		return textoAlertaSignUp;
	}

	public void clickMenuLogIn() {
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.opc_logIn);
		pageObjectUtil.seleniumClickPaint( getDriver(), demoblazeXpath.opc_logIn, 0);
		Serenity.takeScreenshot();		
	}

	public void ingresarCredencialesLogIn(String username, String password) {
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.txt_usernameLogIn);
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.txt_passwordLogIn);
		pageObjectUtil.seleniumWrite( getDriver(), demoblazeXpath.txt_usernameLogIn, 0, username, null);
		pageObjectUtil.seleniumWrite( getDriver(), demoblazeXpath.txt_passwordLogIn, 0, password, null);
		Serenity.takeScreenshot();
	}

	public void clickBotonLogIn() {
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.btn_logIn);
		pageObjectUtil.seleniumClickPaint( getDriver(), demoblazeXpath.btn_logIn, 0);
	}

	public boolean usuarioLogueado(String username) {
		String xpathWelcome = "//a[@class='nav-link' and contains(text(), 'Welcome " + username + "')]";
		pageObjectUtil.verificarCarga(getDriver(), xpathWelcome);
		Serenity.takeScreenshot();
		return true;
	}

	public void clickMenuLogOut() {
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.opc_logOut);
		pageObjectUtil.seleniumClickPaint( getDriver(), demoblazeXpath.opc_logOut, 0);
	}

	public boolean validarCierreSesion() {
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.opc_logIn);
		Serenity.takeScreenshot();
		return true;
	}

	public void clickCategoria(String categoria) {
		switch(categoria) {
		case "Phone":
			pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.opc_categoriaPhones);
			pageObjectUtil.seleniumClickPaint( getDriver(), demoblazeXpath.opc_categoriaPhones, 0);
			Serenity.takeScreenshot();	
			break;
		case "Laptops":
			pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.opc_categoriaLaptop);
			pageObjectUtil.seleniumClickPaint( getDriver(), demoblazeXpath.opc_categoriaLaptop, 0);
			Serenity.takeScreenshot();	
			break;
			
		case "Monitors":
			pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.opc_categoriaMonitors);
			pageObjectUtil.seleniumClickPaint( getDriver(), demoblazeXpath.opc_categoriaMonitors, 0);
			Serenity.takeScreenshot();	
			break;
		}	
	}

	public void buscarProducto(String producto) {
		String xpathProducto = "//a[@class='hrefch' and contains(text(), '"+ producto + "')]";
		String encontrarProducto = pageObjectUtil.verificarExistencia(getDriver(), xpathProducto,0);
		if(encontrarProducto=="OK") {
			pageObjectUtil.verificarCarga(getDriver(), xpathProducto);
			pageObjectUtil.seleniumClickPaint( getDriver(), xpathProducto, 0);
			Serenity.takeScreenshot();	
		}
		else {
			pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.btn_netx);
			pageObjectUtil.seleniumClickPaint( getDriver(), demoblazeXpath.btn_netx, 0);
			buscarProducto(producto);
			Serenity.takeScreenshot();	
		}
	}

	public void agregarCarrito() {
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.btn_addCart);
		pageObjectUtil.seleniumClickPaint( getDriver(), demoblazeXpath.btn_addCart, 0);
		pageObjectUtil.sleep(3);
		textoAlertaAddCart=pageObjectUtil.obtenerTextoAlerta(getDriver(), 10);
	}

	public String productoAgregadoExitosamente() {
		return textoAlertaAddCart;
	}

	public void clickMenuCart() {
		pageObjectUtil.verificarCarga(getDriver(), demoblazeXpath.opc_cart);
		pageObjectUtil.seleniumClickPaint( getDriver(), demoblazeXpath.opc_cart, 0);
		Serenity.takeScreenshot();	
	}

	public boolean validarProductoAgregado(String producto) {
		String xpathProuctoCart = "//td[contains(text(), '" + producto + "')]";
		pageObjectUtil.sleep(3);
		pageObjectUtil.verificarCarga(getDriver(), xpathProuctoCart);
		pageObjectUtil.seleniumClickPaint( getDriver(), xpathProuctoCart, 0);

		Serenity.takeScreenshot();
		return true;
	}

}
