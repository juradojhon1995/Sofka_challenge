package co.com.sofka.challenge.stepdefinitions;

import co.com.sofka.challenge.models.CustomerInfo;
import co.com.sofka.challenge.questions.OrderConfirmationMessage;
import co.com.sofka.challenge.questions.RequiredFieldErrors;
import co.com.sofka.challenge.tasks.AddProducts;
import co.com.sofka.challenge.tasks.FillRegistrationAndBilling;
import co.com.sofka.challenge.tasks.FinalizeShippingAndPayment;
import co.com.sofka.challenge.tasks.GoToCheckout;
import co.com.sofka.challenge.tasks.NavigateTo;
import co.com.sofka.challenge.tasks.ProceedToBillingDetails;
import co.com.sofka.challenge.tasks.SubmitEmptyBillingForm;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class PurchaseStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario ingresa a la pagina principal de OpenCart")
    public void elUsuarioIngresaALaPaginaPrincipalDeOpenCart() {
        theActorCalled("Jhon").wasAbleTo(
                NavigateTo.openCartHomePage()
        );
    }

    @When("agrega los productos {string} y {string} al carrito de compras")
    public void agregaLosProductosAlCarritoDeCompras(String product1, String product2) {
        theActorInTheSpotlight().attemptsTo(
                AddProducts.toCart(product1, product2)
        );
    }

    @And("visualiza el carrito desplegable y accede al checkout")
    public void visualizaElCarritoDesplegableYAccedeAlCheckout() {
        theActorInTheSpotlight().attemptsTo(
                GoToCheckout.fromCartDropdown()
        );
    }

    @And("avanza al formulario de facturacion")
    public void avanzaAlFormularioDeFacturacion() {
        theActorInTheSpotlight().attemptsTo(
                ProceedToBillingDetails.onCheckout()
        );
    }

    @And("envia el formulario de registro sin diligenciar los campos")
    public void enviaElFormularioDeRegistroSinDiligenciarLosCampos() {
        theActorInTheSpotlight().attemptsTo(
                SubmitEmptyBillingForm.withoutData()
        );
    }

    @Then("visualiza los mensajes de error indicando que los campos son obligatorios")
    public void visualizaLosMensajesDeErrorIndicandoQueLosCamposSonObligatorios() {
        theActorInTheSpotlight().should(
                seeThat("Los mensajes de error de campos obligatorios son visibles",
                        RequiredFieldErrors.areDisplayed(),
                        is(true))
        );
    }

    @And("completa el proceso de registro y facturacion con datos dinamicos")
    public void completaElProcesoDeRegistroYFacturacionConDatosDinamicos() {
        CustomerInfo uniqueCustomer = CustomerInfo.uniqueCustomer();
        theActorInTheSpotlight().attemptsTo(
                FillRegistrationAndBilling.withCustomer(uniqueCustomer)
        );
    }

    @And("finaliza los pasos de envio y metodo de pago")
    public void finalizaLosPasosDeEnvioYMetodoDePago() {
        theActorInTheSpotlight().attemptsTo(
                FinalizeShippingAndPayment.order()
        );
    }

    @Then("visualiza la confirmacion de la orden con el mensaje {string}")
    public void visualizaLaConfirmacionDeLaOrdenConElMensaje(String expectedMessage) {
        theActorInTheSpotlight().should(
                seeThat("El mensaje de confirmacion de la orden",
                        OrderConfirmationMessage.displayed(),
                        containsString(expectedMessage))
        );
    }
}
