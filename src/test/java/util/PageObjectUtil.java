package util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PageObjectUtil {

	// singleton
	private static PageObjectUtil obj = null;
	private long wdwTimeOut = 5L;
	public String textoAlerta;

	private PageObjectUtil() {
	}

	public static PageObjectUtil getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new PageObjectUtil();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public WebElement seleniumWebElement(WebDriver webDriver, final String path, int pos) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			return lista.get(pos);
		}

		return null;
	}

	public void sleep(double seg) {
		long miliseg = (new Double(seg * 1000)).longValue();

		try {
			// System.out.println("sleep:\t\t" + seg + " seg... <--> " + miliseg +
			// "miliseg...");
			Thread.sleep(miliseg);
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	//	/**
	//	 * Metodo pintar
	//	 * @param webDriver
	//	 * @param xpath
	//	 */
	public void paintXPath(WebDriver webDriver, String xpath, int pos) {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		WebElement element = seleniumWebElement(webDriver, xpath, pos);
		js.executeScript("arguments[0].setAttribute('style', 'background: #F9F93E!important')", element);
	}

	//	/**
	//	 * Metodo pintar los click
	//	 * @param webDriver
	//	 * @param xpath
	//	 * @param pos
	//	 */
	public void seleniumClickPaint(WebDriver webDriver, final String xpath, int pos) {
		paintXPath(webDriver, xpath, pos);

		//		List<WebElement> webl = webDriver.findElements(By.xpath(xpath));
		//		executor.executeScript("arguments[0].click();",webl.get(pos));

		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(1.5);
			}
		}
	}
	//	/**
	//	 * Metodo Pintar los Input
	//	 * @param webDriver
	//	 * @param path
	//	 * @param pos
	//	 * @param valor
	//	 * @param key
	//	 */
	public void seleniumEscribirPaint(WebDriver webDriver, final String path, int pos, String valor, Keys key) {
		paintXPath(webDriver, path, pos);
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(0.25);
				we.clear();
				we.sendKeys(valor);

				if (key != null) {
					sleep(1.50);
					we.sendKeys(key);
				}

				sleep(1);
			}
		}
	}

	/**
	 * 
	 * @param webDriver
	 * @param xpath
	 */
	public void verificarCarga(WebDriver webDriver, String xpath) {
		WebDriverWait wdw = new WebDriverWait(webDriver, 120);
		wdw.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	//	/**
	//	 * Verifica si existe un dom especifico
	//	 * 
	//	 * @param webDriver
	//	 * @param path
	//	 * @param pos
	//	 * @return
	//	 */
	public String verificarExistencia(WebDriver webDriver, final String path, int pos) {
		String r = "";
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (lista.isEmpty()) {
			r = "";
		} else {
			lista.get(0);
			r = "OK";
		}
		return r;
	}

	/**
//	 * METODO PARA ESCRIBIR EN UNA ETIQUETA INPUT
//	 * @param webDriver
//	 * @param path
//	 * @param pos
//	 * @param valor
//	 * @param key
//	 */
	public void seleniumWrite(WebDriver webDriver, final String path, int pos, String valor, Keys key) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			this.seleniumWaitPathClickable2(webDriver, we, 100);
			if (we.isDisplayed()) {
				we.click();
				sleep(0.4);
				we.clear();
				we.sendKeys(valor);
				if (key != null) {
					we.sendKeys(key);
				}
			}
		}
	}

	//	/**
	//	 * METODO QUE ESPERA QUE UNA ETIQUETA ESTE CLICKABLE
	//	 * @param webDriver
	//	 * @param path
	//	 * @param time
	//	 */
	public void seleniumWaitPathClickable2(WebDriver webDriver, WebElement path, int time) {
		WebDriverWait wait = new WebDriverWait(webDriver, time);
		wait.until(ExpectedConditions.elementToBeClickable(path));
	}

	//	/**
	//	 * Metodo mover scroll de acuerdo a la ubicacion de un dom
	//	 * 
	//	 * @param webDriver
	//	 * @param xpath
	//	 */
	public void scroll(WebDriver webDriver, String xpath, int pos) {
		WebElement scroll = seleniumWebElement(webDriver, xpath, pos);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
	}


	//	/**
	//	 * METODO QUE OBTIENBE EL TEXTO DE UNA ALERTA
	//	 * @param webDriver
	//	 * @param path
	//	 * @param time
	//	 */
	public String obtenerTextoAlerta(WebDriver webDriver,int time) {
		WebDriverWait wait = new WebDriverWait(webDriver, time);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		textoAlerta=alert.getText();
		alert.accept();
		return textoAlerta;
	}
}
