Feature: Pizza Order

  Scenario: This scenario will be used to Place the Order
    Given I have launched Pizzahutt application
    When I enter the location as "Pune"
    And I select the very first suggestion from the list
    Then I should land on the Deals page with page url "https://www.pizzahut.co.in/order/deals/"
    And I select the tab as "Pizzas"
    And I add Selected Pizza to the basket "Margherita Ultimate Cheese"
    And I note down the price displayed on the screen "Margherita Ultimate Cheese"
    Then I should see the pizza "Margherita Ultimate Cheese" is added to the cart
    And price is also displayed correctly 
    And I click on the Checkout button
    Then I should be landed on the secured checkout page with url " https://www.pizzahut.co.in/order/checkout/"
    And I enter the First Name "Rajesh"
    And I enter the Mobile  "99999999999"
    And I enter the email "Rajesh@yopmail.com"
