@regression
Feature: Factorial
  As a factorial user,
  I want to do some factorial operation,
  So I can get some equations done.

  Scenario Outline: Factorial operations
    Given The factorial page is displayed
    When I search for <operation>
    Then results equals <result>

    Examples: Operations
      | operation   | result |
      | "4"         | "24"    |
      | "0"         | "1"   |
      | "5"         | "120"    |