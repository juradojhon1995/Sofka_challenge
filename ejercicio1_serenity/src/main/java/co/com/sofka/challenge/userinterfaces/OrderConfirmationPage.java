package co.com.sofka.challenge.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrderConfirmationPage extends PageObject {

    public static final Target ORDER_CONFIRMATION_TITLE = Target.the("Mensaje de orden confirmada")
            .located(By.xpath("//div[@id='content']//h1[contains(text(), 'Your order has been placed!')]"));

    public static final Target ORDER_CONTENT = Target.the("Contenido de confirmacion de orden")
            .located(By.id("content"));
}
