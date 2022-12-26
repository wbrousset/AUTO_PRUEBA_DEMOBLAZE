package xpath;

public class DemoblazeXpath {
	
	private static DemoblazeXpath obj = null;
	
	private DemoblazeXpath() {
		
	}
	
	public static DemoblazeXpath getInstancia() {
		instanciar();
		return obj;
	}
	
	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new DemoblazeXpath();
		}
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	//Sign Up
	public final String opc_signUp = "//a[@class='nav-link' and contains(text(), 'Sign up')]";
	public final String txt_usernameSingUp = "//input[@class='form-control' and @id='sign-username']";
	public final String txt_passwordSingUp = "//input[@class='form-control' and @id='sign-password']";
	public final String btn_signUp = "//button[@class='btn btn-primary' and contains(text(), 'Sign up')]";
	
	//Log In
	public final String opc_logIn = "//a[@class='nav-link' and contains(text(), 'Log in')]";
	public final String txt_usernameLogIn = "//input[@class='form-control' and @id='loginusername']";
	public final String txt_passwordLogIn = "//input[@class='form-control' and @id='loginpassword']";
	public final String btn_logIn = "//button[@class='btn btn-primary' and contains(text(), 'Log in')]";
	
	//Log out
	public final String opc_logOut = "//a[@class='nav-link' and contains(text(), 'Log out')]"; 
	
	//Agregar Carrito
	public final String opc_categoriaPhones = "//a[@class='list-group-item' and contains(text(), 'Phones')]";
	public final String opc_categoriaLaptop = "//a[@class='list-group-item' and contains(text(), 'Laptops')]";
	public final String opc_categoriaMonitors = "//a[@class='list-group-item' and contains(text(), 'Monitors')]";
	public final String btn_nandp = "//button[@class='page-link']";
	public final String btn_netx = "//button[@class='page-link' and contains(text(), 'Next')]";
	public final String btn_addCart = "//a[@class='btn btn-success btn-lg' and contains(text(), 'Add to cart')]";
	
	//Cart
	public final String opc_cart = "//a[@class='nav-link' and contains(text(), 'Cart')]";

}