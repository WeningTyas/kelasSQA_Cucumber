## ==== Testing bagian Login ==== ##
#  Hanya boleh ada satu "Feature" di dalam satu file .feature

Feature: Login Page Test
  Scenario: Login Valid Test
    Given User enter url HRM
    When User enter valid username
    And User enter valid password
    And User click button login
    Then User get test title page dashboard

  Scenario: Login Invalid Test
    Given User enter url HRM
    When User enter invalid username
    And User enter invalid password
    And User click button login
    Then User get message invalid credentials

  Scenario: Login Required Password Test
    Given User enter url HRM
    When User enter valid username
    And User click button login
    Then User get message password required

  Scenario: Login Required Username Test
    Given User enter url HRM
    When User enter valid password
    And User click button login
    Then User get message usename required