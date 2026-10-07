package co.com.sofka.challenge.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    public static final String OPENCART_HOME_URL = "http://opencart.abstracta.us/";

    // Botones de agregar al carrito para productos en Home
    public static final Target PRODUCT_ADD_BUTTON = Target.the("Boton agregar al carrito de {0}")
            .locatedBy("//div[contains(@class,'product-thumb') and .//a[text()='{0}']]//button[contains(@onclick, 'cart.add')]");

    public static final Target MACBOOK_ADD_BUTTON = Target.the("Boton agregar al carrito de MacBook")
            .located(By.xpath("//button[contains(@onclick, \"cart.add('43')\")]"));

    public static final Target IPHONE_ADD_BUTTON = Target.the("Boton agregar al carrito de iPhone")
            .located(By.xpath("//button[contains(@onclick, \"cart.add('40')\")]"));

    public static final Target ALERT_SUCCESS = Target.the("Alerta de producto agregado exitosamente")
            .located(By.cssSelector("div.alert.alert-success"));

    // Boton desplegable del carrito en la cabecera
    public static final Target CART_DROPDOWN_BUTTON = Target.the("Boton del carrito de compras")
            .located(By.cssSelector("#cart > button"));

    // Enlace directo a Checkout dentro del desplegable del carrito
    public static final Target CART_DROPDOWN_CHECKOUT_LINK = Target.the("Enlace Checkout en menu desplegable del carrito")
            .located(By.xpath("//div[@id='cart']//a[contains(@href, 'checkout/checkout')]"));

    // Enlace superior a Checkout en top-links
    public static final Target TOP_CHECKOUT_LINK = Target.the("Enlace Checkout en barra superior")
            .located(By.xpath("//div[@id='top-links']//a[contains(@href, 'checkout/checkout')]"));
}
