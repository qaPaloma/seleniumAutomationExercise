# language: en
  @signup
  Feature: User registration
    In order to signup into the website
    As an user of the system
    I want to successfully submit my data in the signup page

    Background: Entering the account information page
      Given the user is on the store's page
      And they click on the signup and login button

    @signup-success
    Scenario:  User can successfully signup into the website
      And the user enters their name and email on the signup section
      And clicks the signup button
      And goes to the account information page
      When the user adds their information
      And clicks on the create account button
      Then the user sees a signup confirmation message

    @signup-with-existing-user
    Scenario: User tries to signup using an existing e-mail
      When the user enters their name and <"testUser@test.com.br"> on the signup section
      And clicks the signup button
      Then the user sees an error message


