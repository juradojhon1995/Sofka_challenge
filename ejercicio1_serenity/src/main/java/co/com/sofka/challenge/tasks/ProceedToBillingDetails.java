package co.com.sofka.challenge.tasks;

import co.com.sofka.challenge.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProceedToBillingDetails implements Task {

    public static ProceedToBillingDetails onCheckout() {
        return Tasks.instrumented(ProceedToBillingDetails.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.ACCOUNT_CONTINUE_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.ACCOUNT_CONTINUE_BUTTON),
                WaitUntil.the(CheckoutPage.FIRST_NAME_INPUT, isVisible()).forNoMoreThan(15).seconds()
        );
    }
}
