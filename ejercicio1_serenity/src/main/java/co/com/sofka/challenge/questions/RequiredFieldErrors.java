package co.com.sofka.challenge.questions;

import co.com.sofka.challenge.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class RequiredFieldErrors implements Question<Boolean> {

    public static RequiredFieldErrors areDisplayed() {
        return new RequiredFieldErrors();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> errors = CheckoutPage.REQUIRED_FIELD_ERRORS.resolveAllFor(actor).texts();
        return !errors.isEmpty();
    }
}
