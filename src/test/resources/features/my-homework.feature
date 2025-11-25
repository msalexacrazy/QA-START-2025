Feature: homework scenarios

  Scenario Outline: Record random people in the database
    Given request <amount> random location from API with fields "gender,name,nat,location" as "apiData"
    And I store "apiData" in database with location
    And I pick a random person location from DB as "randomLocation"

    When I set search to random location
    Then persons from "apiData" are present in database with location
    Examples:
      | amount |
      | 3      |
      | 5      |

  Scenario: Recording the cost of an item in the database
    Given Search "IPhone" coast
    And I write the cost "IPhone" in the database
    When I query the database for "IPhone"
    Then the cost for "IPhone" is present in the database







