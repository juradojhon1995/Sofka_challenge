package co.com.sofka.challenge.tasks;

import co.com.sofka.challenge.userinterfaces.CheckoutPage;
import co.com.sofka.challenge.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToCheckout implements Task {

    public static GoToCheckout fromCartDropdown() {
        return Tasks.instrumented(GoToCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.CART_DROPDOWN_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.CART_DROPDOWN_BUTTON),
                WaitUntil.the(HomePage.CART_DROPDOWN_CHECKOUT_LINK, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.CART_DROPDOWN_CHECKOUT_LINK),
                WaitUntil.the(CheckoutPage.ACCOUNT_CONTINUE_BUTTON, isVisible()).forNoMoreThan(15).seconds()
        );
    }
}
