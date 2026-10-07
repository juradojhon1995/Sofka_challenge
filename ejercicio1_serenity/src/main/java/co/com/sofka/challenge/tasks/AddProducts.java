package co.com.sofka.challenge.tasks;

import co.com.sofka.challenge.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProducts implements Task {

    private final List<String> products;

    public AddProducts(List<String> products) {
        this.products = products;
    }

    public static AddProducts toCart(String... products) {
        return Tasks.instrumented(AddProducts.class, Arrays.asList(products));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String product : products) {
            actor.attemptsTo(
                    Scroll.to(HomePage.PRODUCT_ADD_BUTTON.of(product)),
                    Click.on(HomePage.PRODUCT_ADD_BUTTON.of(product)),
                    WaitUntil.the(HomePage.ALERT_SUCCESS, isVisible()).forNoMoreThan(10).seconds()
            );
        }
    }
}
