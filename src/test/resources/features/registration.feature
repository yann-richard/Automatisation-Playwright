@Registration
Feature: User Registration Process Functionality
  As a visitor of the ecommerce website
  I want to create an account


  @reg01
  Scenario Outline: Registration
    Given i'm Ztrain login page
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then The user is connected "Z-Train"


    Examples:
      |      Email     | Mot de passe |Confirmer votre mot de passe |
      |test78@test.com  |   12236987   |         12236987           |
      |test789@test.com  |   12236987   |         12236987          |


  @RegistrationTestCase02
  Scenario Outline: Registration fail "Les deux mots de passe ne sont pas identiques"
    Given i'm Ztrain login page
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then Access is denied  "Les deux mots de passe ne sont pas identiques"

    Examples:
      |      Email| Mot de passe |Confirmer votre mot de passe|
      |te@test.com|   Ulr789     |          7855              |


    @RegistrationTestCase02
  Scenario Outline: Registration fail "Cet utilisateur existe déjà"
    Given i'm Ztrain login page
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then the user is existing  "Cet utilisateur existe déjà"

    Examples:
      |      Email  | Mot de passe |Confirmer votre mot de passe|
      |test@test.com|   12345678   |        12345678            |
