@login
Feature: Login
  As a visitor of the ecommerce website
  I want to be able to login

  Background: pre-requisites
    Given i open Ztrain login page

  @log01
  Scenario Outline: log01 - Login successfully
    When I'm in the login page
    And I enter email address "<email>" and password "<password>"
    And I clicks to the login button
    Then The user is connected
    Examples:
      |          email      |     password    |
      |  ubogni@gmail.com   |   Ulrich77      |


  @acc02
  Scenario: acc02 - Logout
    Given I am logged in on the site with <"coriane@smartds.fr"> and <"123">
    When I click the Log out button
    Then I receive feedback that I am logged out
    And I cannot visit my account page anymore

  @acc03
  Scenario: acc03 - Check orders
    Given I am logged in on the site with <"coriane@smartds.fr"> and <"123">
    When I navigate to my orders
    Then I see a list of my orders
    And I can open an order to see the order details

  @ignore
  Scenario: acc04 - Edit account
    Given I am logged in on the site with <"coriane@smartds.fr"> and <"123">
    When I navigate to the personal information page
    And I update my details
    Then I receive feedback that my account is updated

  @ignore
  Scenario: acc05 - Change address
    Given I am logged in on the site with <"coriane@smartds.fr"> and <"123">
    When I navigate to the personal information page
    And I change my street name
    Then I receive feedback that my account is updated