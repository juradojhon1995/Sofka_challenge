package co.com.sofka.challenge.questions;

import co.com.sofka.challenge.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OrderConfirmationMessage implements Question<String> {

    public static OrderConfirmationMessage displayed() {
        return new OrderConfirmationMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.ORDER_PLACED_HEADING, isVisible()).forNoMoreThan(15).seconds()
        );
        return Text.of(CheckoutPage.ORDER_PLACED_HEADING).answeredBy(actor).trim();
    }
}
