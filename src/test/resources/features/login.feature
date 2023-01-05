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
    Then The user is connected with  "Z-Train"
    Examples:
      |          email   |     password    |
      |  test@test.com   |   12345678      |


  @loginTestCase02
  Scenario Outline: loginTestCase02- Login failed
    When I'm in the login page
    And I enter email address "<email>" and password "<password>"
    And I clicks to the login button
    Then Access is denied with the message "Email ou mot de passe incorrect"
    Examples:
      |          email      |     password   |
      |  test@test.com      |   745$         |

  @loginTestCase03
  Scenario Outline: loginTestCase02 - Login fail mail
    When I'm in the login page
    And I enter email address "<email>" and password "<password>"
    And I clicks to the login button
    Then Access is denied with "Le format de l'email est invalid"
    Examples:
      |          email      |     password    |
      |         toto        |        12345678 |

    @LogoutTestCase02
  Scenario Outline: LogoutTestCase02 - Logout
    When I enter email address "<email>" and password "<password>"
    And I clicks to the logout button
    Then I'm logout
    Examples:
      |          email      |     password    |
      |  test@test.com      |   12345678      |

