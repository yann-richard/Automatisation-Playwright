@logoutTestsCase
Feature: Logout
  As a visitor of the ecommerce website
  I want to logout from app

  Background: pre-requisites
    Given I open Ztrain login page

  @LogoutTestCase01
  Scenario Outline: LogoutTestCase01 - Logout
    And I login into app with email address "<email>" and password "<password>"
    And I clicks to the logout button
    Then I'm logout
    Examples:
      |          email      |     password    |
      |  test@test.com      |   12345678      |