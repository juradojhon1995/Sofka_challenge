package co.com.sofka.challenge.tasks;

import co.com.sofka.challenge.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FinalizeShippingAndPayment implements Task {

    public static FinalizeShippingAndPayment order() {
        return Tasks.instrumented(FinalizeShippingAndPayment.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // En caso de que se despliegue el Paso 3 (Direccion de envio)
        if (CheckoutPage.SHIPPING_ADDRESS_CONTINUE_BUTTON.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    WaitUntil.the(CheckoutPage.SHIPPING_ADDRESS_CONTINUE_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(CheckoutPage.SHIPPING_ADDRESS_CONTINUE_BUTTON)
            );
        }

        // Paso 4: Metodo de Envio (Delivery Method)
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.SHIPPING_METHOD_CONTINUE_BUTTON, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(CheckoutPage.SHIPPING_METHOD_CONTINUE_BUTTON)
        );

        // Paso 5: Metodo de Pago (Payment Method)
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.PAYMENT_METHOD_CONTINUE_BUTTON, isClickable()).forNoMoreThan(15).seconds(),
                Scroll.to(CheckoutPage.PAYMENT_TERMS_CHECKBOX),
                JavaScriptClick.on(CheckoutPage.PAYMENT_TERMS_CHECKBOX),
                Click.on(CheckoutPage.PAYMENT_METHOD_CONTINUE_BUTTON)
        );

        // Paso 6: Confirmar Orden
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.CONFIRM_ORDER_BUTTON, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(CheckoutPage.CONFIRM_ORDER_BUTTON),
                WaitUntil.the(CheckoutPage.ORDER_PLACED_HEADING, isVisible()).forNoMoreThan(20).seconds()
        );
    }
}
