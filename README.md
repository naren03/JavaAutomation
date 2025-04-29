# Zomato Automation Project

## Overview
The Zomato Automation Project is designed to automate the testing of the Zomato application. This project utilizes the Page Object Model (POM) design pattern to enhance test maintenance and reduce code duplication. The automation framework is built using Java and Maven, ensuring a robust and scalable solution for testing.

## Features
- **Page Object Model**: Organizes test code into reusable components, making it easier to maintain and extend.
- **Data-Driven Testing**: Supports multiple test data sets to validate application behavior under various conditions.
- **Logging**: Integrated logging using Log4j2 for better traceability and debugging.
- **Reporting**: Generates comprehensive test reports to provide insights into test execution results.
- **Configuration Management**: Centralized configuration management through properties files.

## Directory Structure
- `src/main/java/com/epam/pages/`: Contains the Page Object classes that represent the various pages of the Zomato application.
- `src/main/java/com/epam/utils/`: Utility classes that provide common functionalities used across tests.
- `src/main/java/com/epam/config/`: Configuration classes for managing application settings and environment variables.
- `src/test/java/com/epam/tests/`: Contains the test classes that execute the automation scripts.
- `src/main/resources/config.properties`: Configuration properties for the application, such as URLs and timeouts.
- `src/main/resources/log4j2.xml`: Configuration file for Log4j2 logging.
- `src/test/resources/testdata/`: Contains test data files used for data-driven testing.
- `logs/`: Directory for storing log files generated during test execution.
- `reports/`: Directory for storing test reports generated after execution.
- `pom.xml`: Maven configuration file that manages project dependencies and build configurations.

## Getting Started
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   ```
2. **Navigate to the Project Directory**:
   ```bash
   cd zomato-automation
   ```
3. **Install Dependencies**:
   ```bash
   mvn install
   ```
4. **Run Tests**:
   ```bash
   mvn test
   ```

## Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue for any enhancements or bug fixes.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.