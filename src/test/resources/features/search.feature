@searchTestsCase
Feature: home
  - As a user
  I want to search for products
  So that I can quickly find what I am looking for

    @searchTestCase201
  Scenario Outline: searchTestCase01-valid search
      Given I am connected to my account with "test@test.com" and "12345678"
      When I do a search with "<keyword>"
      Then I see a result
#      Then I see a result "Ampoule Vecteur Incandescent"
    Examples:
      | keyword         |
      |Ampoule          |



  @searchTestCase202
  Scenario Outline:   searchTestCase02-fail search
    Given I am connected to my account with "test@test.com" and "12345678"
    When I do a search with "<keyword>"
    Then I see a message "Aucun produit trouvé"
    Examples:
      |keyword         |
      |mw              |



#
#  @productTestCased01
#  Scenario Outline: pdt01 - Add a product to my bag
#    Given I am connected to my account with "<email>" and password "<password>"
#    When I select one of the items
#    And I added to my bag
#    Then I can see the product in my bag
#    Examples:
#      |          email   |     password    |
#      |  test@test.com   |   12345678      |





#  @logoutTestsCase01
#  Scenario: logoutTestsCase01 - Logout
#    Given I am logged in on the site with <"coriane@smartds.fr"> and <"123">
#    When I click the Log out button
#    Then I receive feedback that I am logged out
#    And I cannot visit my account page anymore

#  @acc03
#  Scenario: acc03 - Check orders
#    Given I am logged in on the site with <"coriane@smartds.fr"> and <"123">
#    When I navigate to my orders
#    Then I see a list of my orders
#    And I can open an order to see the order details

#  @ignore
#  Scenario: acc04 - Edit account
#    Given I am logged in on the site with <"coriane@smartds.fr"> and <"123">
#    When I navigate to the personal information page
#    And I update my details
#    Then I receive feedback that my account is updated
#
#  @ignore
#  Scenario: acc05 - Change address
#    Given I am logged in on the site with <"coriane@smartds.fr"> and <"123">
#    When I navigate to the personal information page
#    And I change my street name
#    Then I receive feedback that my account is updated