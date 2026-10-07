package co.com.sofka.challenge.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage extends PageObject {

    public static final Target CART_TITLE = Target.the("Titulo de la pagina de carrito")
            .located(By.xpath("//div[@id='content']//h1[contains(.,'Shopping Cart')]"));

    public static final Target PRODUCT_IN_CART = Target.the("Producto {0} en el carrito")
            .locatedBy("//div[@id='content']//table[contains(@class,'table')]//tbody//tr[contains(.,'{0}')]");

    public static final Target CHECKOUT_BUTTON = Target.the("Boton Proceder al Checkout")
            .located(By.xpath("//div[@class='buttons clearfix']//a[contains(@href,'checkout/checkout')] | //a[contains(@class,'btn-primary') and contains(text(),'Checkout')]"));
}
