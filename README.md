# Experiment 5 – Dynamic Matchers in Spring Cloud Contract

## Requirements
- JDK 17
- Maven 3.8+
- IntelliJ IDEA or Spring Tool Suite (STS)

Docker and a database are not required for this self-contained experiment.

## Run the contract test
1. Extract this ZIP.
2. Open IntelliJ IDEA / STS and import the folder containing `pom.xml` as a Maven project.
3. Wait for Maven dependencies to download.
4. Ensure the project uses JDK 17.
5. Open the terminal in the project folder and run:

   `mvn clean test`

6. Maven generates and runs a contract test from `src/test/resources/contracts/signin.yml`.
7. Successful execution should show `BUILD SUCCESS`.

## Test the endpoint manually (optional)
1. Run `AuthApplication.java`.
2. In Postman, send POST to `http://localhost:8080/ms1/signin`.
3. Header: `Content-Type: application/json`
4. Body → raw → JSON:
   `{ "username": "student", "password": "password123" }`
5. Expected response: `{ "token": "<non-empty dynamic token>" }`

The controller creates a JWT-shaped demonstration string for this lab. It is not a cryptographically signed production JWT.

## Contract matcher
`$.token` selects the token field in the JSON response. Regex `.+` accepts any non-empty string, so the contract does not depend on a fixed token.
