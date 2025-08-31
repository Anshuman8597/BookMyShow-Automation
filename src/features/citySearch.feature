Feature: City Search on BookMyShow
  The feature will validate city search and selection functionalities.

  Background:
    Given User is on city selection page 

  @ValidCitySearch
  Scenario Outline: Search for a valid city name
    When I search for city "<cityName>"
    Then I should see "<cityName>" in the search results
    And verify dropdown text should be "<cityName>"

    Examples:
      | cityName     |
      | Kolkata      |
      | Mumbai       |
      | Delhi        |

  @InvalidCitySearch
  Scenario Outline: Search for an invalid city name
    When I search for city "<invalidCity>"
    Then I should see an error message "No results found."

    Examples:
      | invalidCity  |
      | AbcCity      |
      | XYZTown      |

  @SelectCityIcon
  Scenario Outline: Select city by clicking on popular city icon
    When User clicks on popular city "<cityIcon>"
    Then verify dropdown text should be "<cityIcon>"

    Examples:
      | cityIcon     |
      | Mumbai       |
      | Chennai      |
      | Hyderabad    |

  @ViewAllCities
  Scenario: Validate cities in View All Cities list
    When User opens View All Cities
    And validate that cities like "Srinagar", "Bhubaneswar", "Ajmer" are visible
