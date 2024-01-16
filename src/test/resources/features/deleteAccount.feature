# language: en

  @delete-account
  Feature: Delete account
    Scenario: User successfully deletes their account
      Given the user has created an account on the website
      And they are in the store's homepage
      When they click on the delete account button
      Then the user sees a delete confirmation message
      And the user can no longer log in to the website
