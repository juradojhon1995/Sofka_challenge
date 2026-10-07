Feature: Pruebas del API de PetStore - Operaciones de Usuario
  Como ingeniero de automatización
  Quiero probar los servicios REST del modelo User en Swagger PetStore
  Para verificar que las operaciones CRUD funcionen correctamente

  Background:
    * url baseUrl
    * def uniqueId = java.lang.System.currentTimeMillis()
    * def initialUsername = 'sofkaUser_' + uniqueId
    * def initialEmail = 'sofka_' + uniqueId + '@test.com'
    * def updatedName = 'Sofka_Updated'
    * def updatedEmail = 'sofka_updated_' + uniqueId + '@test.com'
    
    * def userPayload =
      """
      {
        "id": #(uniqueId),
        "username": "#(initialUsername)",
        "firstName": "Sofka",
        "lastName": "Challenge",
        "email": "#(initialEmail)",
        "password": "Password123",
        "phone": "1234567890",
        "userStatus": 1
      }
      """

  Scenario: Flujo E2E - Crear, Consultar, Actualizar y Eliminar un usuario
    
    # 1. Crear un usuario
    Given path '/user'
    And request userPayload
    When method post
    Then status 200
    And match response.code == 200
    And match response.message == uniqueId + ''
    * print 'Usuario creado exitosamente con username: ', initialUsername
    * def responseCreate = response

    # 2. Buscar el usuario creado
    Given path '/user', initialUsername
    When method get
    Then status 200
    And match response.username == initialUsername
    And match response.email == initialEmail
    * print 'Consulta exitosa del usuario: ', response
    * def responseGet = response

    # 3. Actualizar el nombre (firstName) y el correo del usuario
    * set userPayload.firstName = updatedName
    * set userPayload.email = updatedEmail
    
    Given path '/user', initialUsername
    And request userPayload
    When method put
    Then status 200
    And match response.code == 200
    * print 'Usuario actualizado exitosamente'
    * def responseUpdate = response

    # 4. Buscar el usuario actualizado
    Given path '/user', initialUsername
    When method get
    Then status 200
    And match response.username == initialUsername
    And match response.firstName == updatedName
    And match response.email == updatedEmail
    * print 'Consulta exitosa del usuario actualizado: ', response
    * def responseGetUpdated = response

    # 5. Eliminar el usuario
    Given path '/user', initialUsername
    When method delete
    Then status 200
    And match response.code == 200
    And match response.message == initialUsername
    * print 'Usuario eliminado exitosamente'
    * def responseDelete = response
    
    # Verificación extra: Asegurar que fue eliminado
    Given path '/user', initialUsername
    When method get
    Then status 404
    And match response.message == 'User not found'
    * print 'Verificación final de eliminación exitosa.'
