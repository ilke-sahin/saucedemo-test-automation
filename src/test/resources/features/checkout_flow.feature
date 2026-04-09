Feature: End-to-end Checkout Flow


  Background:
    Given User is on the Saucedemo login page
    When User logs in with valid credentials

  Scenario: UC-1 Checkout Flow with one item
    When User adds "Sauce Labs Backpack" to the cart
    And User goes to the cart
    And User validates that "Sauce Labs Backpack" is present in the cart
    And User proceeds to checkout
    And User fills the information form with "Ilke", "Sahin", "00000"
    And User completes the checkout
    Then User should see the success message "Thank you for your order!"

  Scenario: UC-2 Checkout Flow with several items and price validation
    When User adds "Sauce Labs Backpack" to the cart
    And User adds "Sauce Labs Bike Light" to the cart
    And User goes to the cart
    And User validates that both items are present in the cart
    And User proceeds to checkout
    And User fills the information form with "Ilke", "Sahin", "00000"
    And User validates the final price equals the sum of both product prices
    And User completes the checkout
    Then User should see the success message "Thank you for your order!"