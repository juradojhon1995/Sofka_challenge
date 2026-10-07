package co.com.sofka.challenge.tasks;

import co.com.sofka.challenge.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SubmitEmptyBillingForm implements Task {

    public static SubmitEmptyBillingForm withoutData() {
        return Tasks.instrumented(SubmitEmptyBillingForm.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(CheckoutPage.REGISTER_CONTINUE_BUTTON),
                WaitUntil.the(CheckoutPage.REGISTER_CONTINUE_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.REGISTER_CONTINUE_BUTTON),
                WaitUntil.the(CheckoutPage.REQUIRED_FIELD_ERRORS, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
