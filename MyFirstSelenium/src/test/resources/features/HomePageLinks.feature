Feature: Home Page Links
  The home page of the website has numerous links that take you to different pages within the website.


#Scenario: Clicking the new button should take me to the 'newest' page.
#Given I am on the home page
#  When I click on the 'new' button
#  Then It will take me to the 'new' page
#
#Scenario: Clicking the past button should take me to the 'front' page.
#Given I am on the home page
#When I click on the 'past' button
#Then It will take me to the 'front' page
#
#Scenario: Clicking the show button should take me to the 'show' page.
#Given I am on the home page
#When I click on the 'show' button
#Then It will take me to the 'show' page
#
#Scenario: Clicking the ask button should take me to the 'ask' page.
#Given I am on the home page
#When I click on the 'ask' button
#Then It will take me to the 'ask' page

  Scenario Outline: Running different pages within the Home Screen
    Given I am on the home page
    When I click on "<page>" page
    Then It will take me to the "<result>" page

    Examples:
      | page | result |
      | past | front  |
      | new  | new    |
      | ask  | ask    |
      | show |show