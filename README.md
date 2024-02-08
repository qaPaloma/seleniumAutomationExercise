
# Selenium Automation Exercise Project

An automation testing repository using Selenium, Java and Cucumber. These tests are focused on the Login and Signup scenarios, using the [Automation Exercise](https://automationexercise.com/) website.
## Author

Paloma Rodrigues

[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
](https://github.com/qaPaloma)

[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/paloma-rsilva/)


## Tools

![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white)

4.16.1

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

20

![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

4.0.0

![Cucumber](https://img.shields.io/badge/Cucumber-43B02A?style=for-the-badge&logo=cucumber&logoColor=white)

7.15.0


### WebDrivers (Windows x64)

All WebDrivers used in this project were added to the repository, inside:

`seleniumProjectDemoQA\drivers`

When executing the tests, you may have to update them depending on your browser's version. To do that, download the new version using the links down below and replace the file in the drivers' directory.

The default WebDriver for this project is Chrome. To change it:
- Go Run/Debug configuration 
- On Build and Run, change 'chrome' to either 'firefox' or 'edge'

#### Versions and links

[![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white)](https://googlechromelabs.github.io/chrome-for-testing/)

120.0.6099.109

[![Edge](https://img.shields.io/badge/Edge-0078D7?style=for-the-badge&logo=Microsoft-edge&logoColor=white)
](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver)

120.0.2210.133

[![Firefox](https://img.shields.io/badge/Firefox-FF7139?style=for-the-badge&logo=Firefox-Browser&logoColor=white)](https://github.com/mozilla/geckodriver/releases/) 

0.34.0

## Reports

- Cluecumber 2.9.4
- Maven Surefire: 3.2.5

On the terminal, type:

`mvn test -Dtest=RunCucumberTest -Dbrowser=BROWSER_NAME cluecumber-report:reporting`

##### BROWSER_NAME:
- "chrome"
- "firefox"
- "edge"
- "chrome-headless" (executes without opening the browser)

## Tests

- Login
    - Successful login, logout
    - Login fail
- Signup
    - Successful signup
    - Signup with existing user

## GitHub Actions

- [Checkout](https://github.com/marketplace/actions/checkout)
- [Setup Java JDK](https://github.com/marketplace/actions/setup-java-jdk)
- [Setup Chrome](https://github.com/marketplace/actions/setup-chrome)
- [setup-chromedriver](https://github.com/marketplace/actions/setup-chromedriver)
- [Upload a Build Artifact](https://github.com/marketplace/actions/upload-a-build-artifact)

