@RegistrationTestsCase
Feature: User Registration Process Functionality
  As a visitor of the ecommerce website
  I want to create an account


  @RegistrationTestCase01
  Scenario Outline: RegistrationTestCase01-Registration successfully
    Given i'm Ztrain login page
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then after registration The user is connected, the "Z-Train" logo is observed


    Examples:
      |      Email     | Mot de passe |Confirmer votre mot de passe |
      |test005@test.com  |   12236987   |         12236988          |
#      |test789@test.com  |   12236987   |         12236988          |
#      |test@test.com|   12345678   |        12345678            |


  @RegistrationTestCase02
  Scenario Outline: RegistrationTestCase02-Registration failed "The two passwords are not identical"
    Given i'm Ztrain login page
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then Access is denied  "Les deux mots de passe ne sont pas identiques"

    Examples:
      |      Email| Mot de passe |Confirmer votre mot de passe|
      |te@test.com|   Ulr789     |          7855              |
      |tet0@test.com|   12345678   |        12345678            |


    @RegistrationTestCase03
  Scenario Outline: RegistrationTestCase03-Registration failed "This user already exists"
    Given i'm Ztrain login page
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then the user is existing  "Cet utilisateur existe déjà"

    Examples:
      |      Email  | Mot de passe |Confirmer votre mot de passe|
#      |tet@test.com|   12345678   |        12345678            |
      |test@test.com|   12345678   |        12345672            |
