Feature: Dominos task

Scenario: Login page
  Given User Launch "Chrome" browser and url "https://www.dominos.co.in/"
  When User click on order online now button
  And User click the delivery address
  And User click the Enter area/Locality
  And User enter the pincode "600118"
  And User select the first suggestion
  Then User should navigate to the product page
    And User adds two quantities of Margherita pizza
    And User adds two quantities of Peppy Paneer pizza
    And User adds two quantities of Corn & Cheese pizza
    And User verifies subtotal value and sum of all product values are same
    And User adds tweleve quantities of pepsi
    And User verifies the subtotal value and sum of all product values are same
    And User removes one quantity of Margherita pizza
    And User removes six quanties of pepsi
    When User click on checkout
    And User verifies the checkout subtotal value and place order subtotal are same
    Then User close the browser


