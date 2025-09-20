@tag
Feature: Create a HSM Auction
  I want to use this template for my feature file

Background: 
Given I landed on Enterprise pannel

  @tag2
  Scenario Outline: positive test case of HSM auction
    Given user logged in with mobile number
    When user open enterprise pannel
    And open sell auction page
    And clone the same and submit it
    Then auction is created successfully

    Examples: 
      | mobile     |
      | 5718117745 |
