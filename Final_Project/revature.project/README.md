# Revature Banking Project

A Java/Maven banking application built as a training project demonstrating database connectivity, authentication, and a layered application design.

## Overview

The application models a banking system for customers and employees. It provides console-driven workflows for login, customer registration, deposits, withdrawals, and employee-related tasks.

The project uses a layered structure consisting of:

- **Models** for customers, employees, login data, and the current user
- **DAOs** for database access and persistence operations
- **Services** for authentication and user-flow logic
- **Utilities** for application startup, menus, deposits, withdrawals, and customer registration
- **Logging and console helpers** for application diagnostics and terminal output

## Project Structure

```text
src/main/java/revature/project/
├── banking/
│   ├── dao/
│   │   ├── CustomerDAO.java
│   │   ├── CustomerDAOImpl.java
│   │   ├── EmployeeDAO.java
│   │   ├── EmployeeDAOImpl.java
│   │   ├── LoginDAO.java
│   │   └── LoginDAOImpl.java
│   ├── models/
│   │   ├── CurrentUser.java
│   │   ├── Customer.java
│   │   ├── Employees.java
│   │   └── Login.java
│   └── utilities/
│       ├── Banking.java
│       ├── ConnectionUtility.java
│       ├── Deposit.java
│       ├── EmpMenu.java
│       ├── EmpTask.java
│       ├── NewCustomer.java
│       ├── SignIn.java
│       ├── Start.java
│       └── Withdraw.java
├── colors/
├── logging/
└── services/
    ├── AuthenticateWithdraw.java
    ├── LoginAuthentication.java
    └── NotANewUser.java
```

Additional project resources include:

- `db_resources/` — database connection properties
- `src/main/resources/Log4j2.properties` — Log4j configuration
- `src/test/java/` — JUnit and service-oriented tests
- `pom.xml` — Maven build and dependency configuration

## Technologies

- Java 8
- Maven
- PostgreSQL
- JDBC
- JUnit 4.13.2
- Mockito 3.9.0
- Log4j 2.14.0

## Building the Project

From this directory, run:

```bash
mvn clean package
```

To run the test suite:

```bash
mvn test
```

## Database Configuration

Before running the application, configure the PostgreSQL connection details in:

```text
db_resources/db-props.properties
```

The database must provide the tables and data expected by the DAO implementations.

## Testing

The test suite includes coverage for authentication, getters, and new-user behavior. Tests are located under:

```text
src/test/java/revature/project/testServices/
```

## Entry Point

The application startup flow begins in:

```text
src/main/java/revature/project/banking/utilities/Start.java
```
