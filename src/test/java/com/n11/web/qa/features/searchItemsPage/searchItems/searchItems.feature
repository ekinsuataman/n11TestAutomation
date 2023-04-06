

Feature: searchItems scenarios

  @done
  Scenario: check searchIphoneItems scenarios
    Given user navigate to n11.com homepage
    And user fills in SearchArea field with "Iphone"
    And user clicks to Search Button
    And scroll down to page
    Then user clicks to Add Basket Button for First Item
    And user clicks to Phone Color
    And user clicks to Internal Memory
    And user clicks to Add Basket Green Button
    And scroll down to end of page
    Then user clicks to Add Basket Button for Last Item
    And user clicks to White Basket Button
    And user clicks to Privacy Approval Button
    And user clicks to Buy Button

  @done
  Scenario: check searchPhoneItems scenarios
    Given user navigate to n11.com homepage
    And user fills in SearchArea field with "Telefon"
    And user clicks to Search Button
    And user selects Second Brand from Filter
    And user clicks to Sorting Button
    And user clicks to Sort by Comment Button
    And user selects to Free Shipping Filter






