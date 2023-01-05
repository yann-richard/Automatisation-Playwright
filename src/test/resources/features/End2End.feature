@End
Feature: End2End
  As a visitor of the ecommerce website
  - I want to create an account
  - I want to be able to login
  As a user
  - I want to search for products So that I can quickly find what I am looking for
  - I want to be able to add and remove a product from my bag So that I can command something
  - I want to logout from app



  @End2End @End2EndSearchProduct @End2EndAddProduct
  Scenario Outline: Registration (case passing success)
    Given i'm Ztrain login page
    When I click on register button
    And I fill in the form with the information "<Email>" "<Mot de passe>" "<Confirmer votre mot de passe>"
    And I clicks validation button
    Then The user is connected "Z-Train"


    Examples:
      |      Email     | Mot de passe |Confirmer votre mot de passe |
      |tata2@test.com   |   12236987   |         12236987           |

  @End2End @End2EndSearchProduct @End2EndAddProduct
  Scenario Outline: Login (case passing success)
    Given I open Ztrain login page
    When I'm in the login page
    And I enter email address "<email>" and password "<password>"
    And I clicks to the login button
    Then The user is connected with  "Z-Train"
    Examples:
      |          email     |     password     |
      |  tata2@test.com      |    12236987       |

  @End2EndSearchProduct @End2End
  Scenario Outline: valid search (case passing success)
      Given I am connected to my account with "<email>" and "<password>"
      When I do a search with "<keyword>"
      Then I see a result
#      Then I see a result "Ampoule Vecteur Incandescent"
    Examples:
      | keyword         |       email     |     password    |
      |caque            | tata2@test.com    |    12236987      |


  @End2End @End2EndAddProduct
  Scenario Outline: Add a product to my bag
#    Given I am connected to my account "<email>" and "<password>"
    Given I am connected to my account with "<email>" and "<password>"
    And I added to my bag
    Then I can see the message "Votre panier à été mis à jour"
    Examples:
      |          email      |     password    |
      |  tata2@test.com        |    12236987      |



  @End2End @End2EndSearchProduct @End2EndAddProduct
  Scenario Outline: Logout (case passing success)
    Given I am connected to my account with "<email>" and "<password>"
    And I clicks to the logout button
    Then I'm logout
    Examples:
      |          email     |     password     |
      |  tata2@test.com    |    12236987      |









