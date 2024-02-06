# language: en

@login
  #noinspection CucumberTableInspection
  Feature: User login
    In order to make a purchase on the website
    As an user of the system
    I want to successfully log in into the website

    Background: Access the login page
      Given the user is on the store's page
      And they click on the signup and login button

    @login-success
    Scenario: User can successfully log in to the website
      When the user enters their email "testUser@test.com.brERRO" and password "test@Selenium123" on the login section
      And clicks on the login button
      Then the user is logged to the website

    @login-error
    Scenario Outline:  User tries to log in <name>
      When the user enters their email "<email>" and password "<password>" on the login section
      And clicks on the login button
      Then the user sees an error "<message>"

      Examples:
      | email                          | password            | message                                        | name                               |
      | invalidEmail@email.com         | test@Selenium123    | Your email or password is incorrect!           | using the wrong email              |
      | testUser@test.com.br           | invalidPassword     | Your email or password is incorrect!           | using the wrong password           |
      | invalidEmail@email.com         | invalidPassword     | Your email or password is incorrect!           | using the wrong email and password |