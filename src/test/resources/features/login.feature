@loginTestsCase
Feature: Login
  As a visitor of the ecommerce website
  I want to be able to login

  Background: pre-requisites
    Given I open Ztrain login page

  @loginTestCase01
  Scenario Outline: loginTestCase01 - Login successfully
    When I'm in the login page
    And I enter email address "<email>" and password "<password>"
    And I clicks to the login button
    Then The user is connected, the "Z-Train" logo is observed

    Examples:
      |          email   |     password    |
      |  test@test.com   |   12345678      |
#      |  tt@test.com     |   12345678      |
#      |  tt@test.com     | invalid_password$  |
      |     invalid_email|        12345678 |


  @loginTestCase02
  Scenario Outline: loginTestCase02- Login failed with the error message 'Incorrect email or password'
    When I'm in the login page
    And I enter email address "<email>" and password "<password>"
    And I clicks to the login button
    Then Access is denied with the message "Email ou mot de passe incorrect"
    Examples:
      |          email   |     password    |
      |  tt@test.com     |   12345678      |
#      |  tt@test.com     | invalid_password$ |
#      |     invalid_email|        12345678 |
      |  test@test.com   |   12345678      |


  @loginTestCase03
  Scenario Outline: loginTestCase03 - Login failed with the error message 'The email format is invalid'
    When I'm in the login page
    And I enter email address "<email>" and password "<password>"
    And I clicks to the login button
    Then Access is denied with "Le format de l'email est invalid"
    Examples:
      |          email   |     password    |
      |     invalid_email|        12345678 |
      |  tt@test.com     |   12345678      |
#      |  tt@test.com     |   invalid_password$|
      |  test@test.com   |   12345678      |



