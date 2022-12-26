package definition;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.*;
import junit.framework.Assert;
import net.thucydides.core.annotations.Steps;
import step.DemoblazeSignUpStep;

public class DemoblazeSignUpDefinition {

	@Steps
	private DemoblazeSignUpStep demoblazeStep;

	@Given("^ingreso a la web de demoblaze$")
	public void ingreso_a_la_web_de_demoblaze() {
		demoblazeStep.ingresarWeb();
	}

	//Sign up

	@When("^hago click en la opcion Sign up del menu$")
	public void hago_click_en_la_opcion_Sign_up_del_menu() {
		demoblazeStep.signUpMenu();
	}

	@When("^ingreso credenciales nuevas \"([^\"]*)\" y \"([^\"]*)\"$")
	public void ingreso_credenciales_nuevas_y(String username, String password) {
		demoblazeStep.signUpCredenciales(username, password);
	}

	@When("^hago click en el boton Sign up$")
	public void hago_click_en_el_boton_Sign_up() {
		demoblazeStep.botonSignUp();
	}

	@Then("^visualizare una alerta que indica que mi usuario ha sido creado exitosamente$")
	public void visualizare_una_alerta_que_indica_que_mi_usuario_ha_sido_creado() {
		Assert.assertEquals(demoblazeStep.registroExitoso(), "Sign up successful.");
	}

	//Log in

	@When("^hago click en la opcion Log in del menu$")
	public void hago_click_en_la_opcion_Log_in_del_menu() {
		demoblazeStep.logInMenu();
	}

	@When("^ingreso credenciales \"([^\"]*)\" y \"([^\"]*)\"$")
	public void ingreso_credenciales_y(String username, String password) {
		demoblazeStep.logInCredenciales(username, password);
	}

	@When("^hago click en el boton Log in$")
	public void hago_click_en_el_boton_Log_in() {
		demoblazeStep.botonLogIn();
	}

	@Then("^visualizare en el menu el mensaje de welcome \"([^\"]*)\"$")
	public void visualizare_en_el_menu_el_mensaje_de_welcome(String username) {
		assert demoblazeStep.welcomeUser(username);
	}

	//Log out

	@Given("^existe un usuario logueado con \"([^\"]*)\" y \"([^\"]*)\" en la web de demoblaze$")
	public void existe_un_usuario_logueado_con_y_en_la_web_de_demoblaze(String username, String password) {
		demoblazeStep.ingresarWeb();
		demoblazeStep.logInMenu();
		demoblazeStep.logInCredenciales(username, password);
		demoblazeStep.botonLogIn();
	}

	@When("^hago click en la opcion Log out del menu$")
	public void hago_click_en_la_opcion_Log_out_del_menu() {
		demoblazeStep.logOutMenu();
	}

	@Then("^visualizare en el menu la opcion de Log in nuevamente$")
	public void visualizare_en_el_menu_la_opcion_de_Log_in_nuevamente() {
		assert demoblazeStep.validarLogOut();
	}
	
	//Agregar Laptop
	
	@When("^selecciono la categoria \"([^\"]*)\"$")
	public void selecciono_la_categoria(String categoria) {
		demoblazeStep.seleccionoCategoria(categoria);
	}

	@When("^busco un producto \"([^\"]*)\"$")
	public void busco_un_producto(String producto) {
		demoblazeStep.buscarProducto(producto);
	}

	@When("^agrego el producto al carrito$")
	public void agrego_el_producto_al_carrito() {
		demoblazeStep.agregarProductoCarrito();
	}

	@Then("^visualizare una alerta que indica que mi producto ha sido agregado$")
	public void visualizare_una_alerta_que_indica_que_mi_producto_ha_sido_agregado() {
		Assert.assertEquals(demoblazeStep.productoAgregado(), "Product added.");
	}
	
	//Validar carrito

	@Given("^agrego producto \"([^\"]*)\" al carrito$")
	public void agrego_producto_al_carrito(String producto) {
		demoblazeStep.agregarProductos(producto);
	}

	@When("^hago click en la opcion Cart del menu$")
	public void hago_click_en_la_opcion_Cart_del_menu() {
		demoblazeStep.validarCart();
	}

	@Then("^visualizare mis productos agregados \"([^\"]*)\"$")
	public void visualizare_mis_productos_agregados(String producto) {
		assert demoblazeStep.validarProductoAgregado(producto);
	}
}