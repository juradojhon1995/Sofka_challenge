# language: en
@E2EPurchase
Feature: Flujo de compra E2E y validacion de campos obligatorios en OpenCart
  Como usuario visitante de la tienda OpenCart
  Quiero agregar dos productos al carrito, validar los campos obligatorios del checkout y completar la compra
  Para verificar la robustez del formulario y la confirmacion exitosa del pedido

  @MandatoryFieldsValidation
  Scenario: Validar que los campos de datos personales y facturacion son obligatorios
    Given que el usuario ingresa a la pagina principal de OpenCart
    When agrega los productos "MacBook" y "iPhone" al carrito de compras
    And visualiza el carrito desplegable y accede al checkout
    And avanza al formulario de facturacion
    And envia el formulario de registro sin diligenciar los campos
    Then visualiza los mensajes de error indicando que los campos son obligatorios

  @SuccessfulPurchase
  Scenario: Realizar la compra exitosa de dos productos hasta la confirmacion de la orden
    Given que el usuario ingresa a la pagina principal de OpenCart
    When agrega los productos "MacBook" y "iPhone" al carrito de compras
    And visualiza el carrito desplegable y accede al checkout
    And avanza al formulario de facturacion
    And completa el proceso de registro y facturacion con datos dinamicos
    And finaliza los pasos de envio y metodo de pago
    Then visualiza la confirmacion de la orden con el mensaje "Your order has been placed!"
