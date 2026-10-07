package co.com.sofka.challenge.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage extends PageObject {

    // Paso 1: Opciones de Cuenta
    public static final Target ACCOUNT_CONTINUE_BUTTON = Target.the("Boton Continuar de opciones de cuenta")
            .located(By.id("button-account"));

    // Paso 2: Datos Personales
    public static final Target FIRST_NAME_INPUT = Target.the("Campo Primer Nombre")
            .located(By.id("input-payment-firstname"));

    public static final Target LAST_NAME_INPUT = Target.the("Campo Apellido")
            .located(By.id("input-payment-lastname"));

    public static final Target EMAIL_INPUT = Target.the("Campo Correo Electronico")
            .located(By.id("input-payment-email"));

    public static final Target TELEPHONE_INPUT = Target.the("Campo Telefono")
            .located(By.id("input-payment-telephone"));

    // Paso 2: Contraseñas
    public static final Target PASSWORD_INPUT = Target.the("Campo Contraseña")
            .located(By.id("input-payment-password"));

    public static final Target PASSWORD_CONFIRM_INPUT = Target.the("Campo Confirmar Contraseña")
            .located(By.id("input-payment-confirm"));

    // Paso 2: Direccion
    public static final Target ADDRESS_INPUT = Target.the("Campo Direccion")
            .located(By.id("input-payment-address-1"));

    public static final Target CITY_INPUT = Target.the("Campo Ciudad")
            .located(By.id("input-payment-city"));

    public static final Target POSTCODE_INPUT = Target.the("Campo Codigo Postal")
            .located(By.id("input-payment-postcode"));

    public static final Target COUNTRY_SELECT = Target.the("Selector Pais")
            .located(By.id("input-payment-country"));

    public static final Target ZONE_SELECT = Target.the("Selector Departamento / Region / Estado")
            .located(By.id("input-payment-zone"));

    // Paso 2: Checkbox Politica de Privacidad y Boton Continuar Registro
    public static final Target PRIVACY_POLICY_CHECKBOX = Target.the("Checkbox Politica de Privacidad")
            .located(By.xpath("//div[@id='collapse-payment-address']//input[@name='agree'] | //input[@name='agree' and @value='1']"));

    public static final Target REGISTER_CONTINUE_BUTTON = Target.the("Boton Continuar Registro")
            .located(By.id("button-register"));

    // Paso 2: Mensajes de Error de Campos Obligatorios
    public static final Target REQUIRED_FIELD_ERRORS = Target.the("Mensajes de error de campos obligatorios")
            .locatedBy("//div[@id='collapse-payment-address']//div[contains(@class, 'text-danger')]");

    public static final Target PRIVACY_POLICY_ALERT = Target.the("Alerta de politica de privacidad requerida")
            .locatedBy("//div[@id='collapse-payment-address']//div[contains(@class, 'alert-danger')]");

    // Paso 3: Direccion de Entrega (Delivery Details)
    public static final Target SHIPPING_ADDRESS_CONTINUE_BUTTON = Target.the("Boton Continuar Direccion de Entrega")
            .located(By.id("button-shipping-address"));

    // Paso 4: Metodo de Envio (Delivery Method)
    public static final Target SHIPPING_METHOD_CONTINUE_BUTTON = Target.the("Boton Continuar Metodo de Envio")
            .located(By.id("button-shipping-method"));

    // Paso 5: Metodo de Pago (Payment Method)
    public static final Target PAYMENT_TERMS_CHECKBOX = Target.the("Checkbox Terminos y Condiciones de Pago")
            .located(By.xpath("//div[@id='collapse-payment-method']//input[@name='agree']"));

    public static final Target PAYMENT_METHOD_CONTINUE_BUTTON = Target.the("Boton Continuar Metodo de Pago")
            .located(By.id("button-payment-method"));

    // Paso 6: Confirmacion de Orden
    public static final Target CONFIRM_ORDER_BUTTON = Target.the("Boton Confirmar Orden")
            .located(By.id("button-confirm"));

    // Pagina de Exito
    public static final Target ORDER_PLACED_HEADING = Target.the("Encabezado de orden confirmada")
            .located(By.xpath("//div[@id='content']//h1[contains(text(), 'Your order has been placed!')]"));
}
