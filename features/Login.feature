Feature: Test login page

  Scenario: Test login page
    Given I am on main application page
    When I login as correct user
    Then I see logout link

  Scenario Outline: Test negative login page
    Given I am on main application page
    When I login as user with "<number>"
    Then I see error message
    Examples:
      | number |
      | 2      |
      | 3      |

#  Scenario Outline: Test negative login page XML
#    Given I am on main application page
#    When I login as user with "<id>" XML
#    Then I see error message
#    Examples:
#      | id |
#      | 1  |
#      | 2  |
#      | 3  |
#
#  Scenario: Test logout page
#    Given I am on main application page
#    Given I login as correct user
#    When I click logout link
#    Then I see registration link
