Feature: Find way to the Privokzalna street
  Scenario:Find way
    Given I go to easyWay page
    And I chose Vinnitsa city
    When Add streets
    And Press make a route
    Then I check best result

