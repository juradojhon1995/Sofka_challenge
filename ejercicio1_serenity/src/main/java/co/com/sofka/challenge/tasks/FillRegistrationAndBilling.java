package co.com.sofka.challenge.tasks;

import co.com.sofka.challenge.models.CustomerInfo;
import co.com.sofka.challenge.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillRegistrationAndBilling implements Task {

    private final CustomerInfo customer;

    public FillRegistrationAndBilling(CustomerInfo customer) {
        this.customer = customer;
    }

    public static FillRegistrationAndBilling withCustomer(CustomerInfo customer) {
        return Tasks.instrumented(FillRegistrationAndBilling.class, customer);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.FIRST_NAME_INPUT, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(customer.getFirstName()).into(CheckoutPage.FIRST_NAME_INPUT),
                Enter.theValue(customer.getLastName()).into(CheckoutPage.LAST_NAME_INPUT),
                Enter.theValue(customer.getEmail()).into(CheckoutPage.EMAIL_INPUT),
                Enter.theValue(customer.getTelephone()).into(CheckoutPage.TELEPHONE_INPUT),
                Enter.theValue(customer.getPassword()).into(CheckoutPage.PASSWORD_INPUT),
                Enter.theValue(customer.getPassword()).into(CheckoutPage.PASSWORD_CONFIRM_INPUT),
                Enter.theValue(customer.getAddress()).into(CheckoutPage.ADDRESS_INPUT),
                Enter.theValue(customer.getCity()).into(CheckoutPage.CITY_INPUT),
                Enter.theValue(customer.getPostCode()).into(CheckoutPage.POSTCODE_INPUT),
                SelectFromOptions.byVisibleText(customer.getCountry()).from(CheckoutPage.COUNTRY_SELECT)
        );

        // Breve pausa para la carga AJAX de las zonas del pais
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }

        actor.attemptsTo(
                SelectFromOptions.byVisibleText(customer.getZone()).from(CheckoutPage.ZONE_SELECT),
                Scroll.to(CheckoutPage.PRIVACY_POLICY_CHECKBOX),
                JavaScriptClick.on(CheckoutPage.PRIVACY_POLICY_CHECKBOX),
                WaitUntil.the(CheckoutPage.REGISTER_CONTINUE_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.REGISTER_CONTINUE_BUTTON)
        );
    }
}
