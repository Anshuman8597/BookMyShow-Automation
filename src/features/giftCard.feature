Feature: Gift Card Module
  The feature will validate Gift Card functionalities.

  Background:
    Given User is on home page and select city "Kolkata"

  @GiftCardIcon
  Scenario: Validate Check Gift Card balance icon
    When User navigates to Gift Card section
    Then Verify Check Gift Card balance icon is visible

  @InvalidVoucher
  Scenario Outline: Validate error message for invalid voucher
    When User navigates to Gift Card section
    And User clicks on bottom "Check Gift Card Balance"
    And User enters invalid voucher "<voucherCode>" in the balance input box
    And Clicks on Check Balance button
    Then Verify error message "<errorMessage>"

    Examples:
      | voucherCode  | errorMessage                                |
      | 12345ABCDEF  | Invalid Gift voucher Code. (#-4426)         |
      | 98765XYZ123  | Invalid Gift voucher Code. (#-4426)         |
      | ABC12345678  | Invalid Gift voucher Code. (#-4426)         |
