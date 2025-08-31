Feature: Login to BookMyShow
  The feature will validate login functionality with valid and invalid mobile numbers.

  Background:
    Given User is on home page and select city "Kolkata"

  @ValidLogin
  Scenario: Valid login with mobile and OTP
    When User is on Login Page
    And User enters mobile number "<phone>"
    And Clicks on Continue
    Then Verify Otp page 
    And back to login page
    And close popup
    
    Examples:
    |phone     |
    |8597209662|

  @InvalidLogin
  Scenario: Invalid login with mobile
    When User is on Login Page
    And User enters mobile number "<phone>"
    Then Verify message "<message>"
    And close popup
    
    Examples:
    |phone       |message              |
    |1234567890  |Invalid mobile number|

  @UIValidation
  Scenario: Verify all login UI elements are functional and visible
    When User is on Login Page
    Then Verify that mobile number field is visible
    And Verify that Continue button is not visible
    When User enters mobile number "<validphone>"
    Then verify continue button is visible but should disable
    When User enters mobile number "<invalidphone>"
    Then Verify continue button should enabled
    And close popup
    
     Examples:
    |validphone|invalidphone|
    |1234567812|8770762352  |