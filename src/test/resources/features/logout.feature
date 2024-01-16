# language: en

@logout
  Feature: Logout from profile
    Scenario: User can successfully logout of their account
      Given the user is logged in to the website
      When the user clicks on the Logout button
      Then the user is taken to the Login page