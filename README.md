# fis-coding-assessment

**Assessment completed by Nishad Chayanakhawa on 7th January**

## Project Structure:
- **`io.github.nishadchayanakhawa.fiscodingassessment.tests.pages`**: Contains page object models and their implementations. For each page, an interface is defined which can be implemented for both web or mobile channels. For this assessment, only the web implementation is demonstrated.
- **`io.github.nishadchayanakhawa.fiscodingassessment.tests.pages.web`**: Holds the web implementations of the page object models.
- **`io.github.nishadchayanakhawa.fiscodingassessment.tests.web`**: Contains test classes for UI tests.
- **`io.github.nishadchayanakhawa.fiscodingassessment.tests.api`**: Contains test classes for API tests.

## Framework:
A custom framework is used to extend TestNG's reporting capabilities and simplify web UI and REST API interactions. The custom framework is created and maintained by me and is hosted at [GitHub - automation-testing-framework](https://github.com/NishadChayanakhawa/automation-testing-framework). A Maven distribution is also available at [Maven Repository](https://mvnrepository.com/artifact/io.github.nishadchayanakhawa).

## Reporting:
- Test execution report is generated at - target/TestExecutionReport.html
- Mailable report is generated at - target/MailableSummary.html
- Raw json report is generated at - target/testResults.json

## Execution:
As the tests are integration tests, they are tied to the **verify** goal of Maven. To trigger the tests, use the following Maven command:

```bash
mvn clean verify