package step;

import net.thucydides.core.annotations.Step;
import page.DemoblazePage;

public class DemoblazeSignUpStep {
	
	private DemoblazePage demoblazePage;

	@Step
	public void ingresarWeb() {
		demoblazePage.inicializar();
	}

	//Sign Up
	
	@Step
	public void signUpMenu() {
		demoblazePage.clickMenuSignUp();
	}
	
	@Step
	public void signUpCredenciales(String username, String password) {
		demoblazePage.ingresarCredencialesSignUp(username,password);
	}
	
	@Step
	public void botonSignUp() {
		demoblazePage.clickBotonSignUp();
	}
	
	@Step
	public String registroExitoso() {
		return demoblazePage.usuarioCreadoExitosamente();
	}

	//Login
	
	@Step
	public void logInMenu() {
		demoblazePage.clickMenuLogIn();
	}

	@Step
	public void logInCredenciales(String username, String password) {
		demoblazePage.ingresarCredencialesLogIn(username,password);
	}

	@Step
	public void botonLogIn() {
		demoblazePage.clickBotonLogIn();
	}

	@Step
	public boolean welcomeUser(String username) {
		return demoblazePage.usuarioLogueado(username);
	}
	
	//Logout
	
	@Step
	public void logOutMenu() {
		demoblazePage.clickMenuLogOut();
	}
	
	@Step
	public boolean validarLogOut() {
		return demoblazePage.validarCierreSesion();
	}
	
	//Agregar Laptop

	public void seleccionoCategoria(String categoria) {
		demoblazePage.clickCategoria(categoria);
	}

	public void buscarProducto(String producto) {
		demoblazePage.buscarProducto(producto);
	}

	public void agregarProductoCarrito() {
		demoblazePage.agregarCarrito();
	}

	public String productoAgregado() {
		return demoblazePage.productoAgregadoExitosamente();
	}

	public void agregarProductos(String producto) {
		demoblazePage.buscarProducto(producto);
		demoblazePage.agregarCarrito();
		
	}

	public void validarCart() {
		demoblazePage.clickMenuCart();

	}

	public boolean validarProductoAgregado(String producto) {
		return demoblazePage.validarProductoAgregado(producto);
	}
}