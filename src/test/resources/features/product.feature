@productTestsCase
Feature: Product detail page
  As a user
  I want to be able to add and remove a product from my bag
  So that I can command something


  @productTestCase01
  Scenario Outline: productTestCase01 - Add a product to my bag
    #    Given I am connected to my account "<email>" and "<password>"
    Given I am connected to my account with "<email>" and "<password>"
    And I added to my bag
    Then I can see the message "Votre panier à été mis à jour"
    Examples:
      |          email      |     password    |
      |  test@test.com      |   12345678      |