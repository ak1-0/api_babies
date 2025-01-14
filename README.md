# README: API Tests for Student Management

## Overview
This project contains automated API tests for managing student entities using the CRUD API provided by `crudcrud.com`. The tests are written in Java with the use of RestAssured and test libraries.

## Features
- **Student Creation**: Tests the ability to create a new student entity.
- **Student Deletion**: Validates the ability to delete an existing student and ensures it no longer exists.

## Technology Stack
- **Programming Language**: Java
- **Testing Framework**: JUnit 5
- **HTTP Client**: RestAssured
- **JSON Serialization/Deserialization**: Jackson and Gson

## Project Structure

### `SimpleTest.java`
Contains test cases for student creation and deletion:
- `userShouldBeAbleCreateStudent`: Validates student creation by sending a POST request.
- `userShouldBeAbleDeleteExistingStudent`: Tests the deletion of a student after creation and verifies the deletion.

### `Student.java`
A POJO representing a student with fields:
- `name`: Name of the student.
- `grade`: Grade of the student.
- `id`: Unique identifier mapped to `_id` from the server response.

### `StudentRequests.java`
Contains methods for API operations:
- `createStudent`: Sends a POST request to create a student and returns the created `Student` object.
- `deleteStudent`: Sends a DELETE request to remove a student by ID.

### `JsonMapper.java`
Utility class for JSON operations:
- `studentToJson`: Converts a `Student` object to JSON format.
- `jsonToStudent`: Converts JSON to a `Student` object.

## Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Install Dependencies**:
   Ensure you have Maven installed. Run:
   ```bash
   mvn clean install
   ```

3. **Set up Base URI**:
   The base URI for the CRUD API is set in `SimpleTest.java`:
   ```java
   RestAssured.baseURI = "https://crudcrud.com/api/<your-api-key>";
   ```
   Replace `<your-api-key>` with a valid API key from `crudcrud.com`.

4. **Run Tests**:
   Execute the tests using Maven:
   ```bash
   mvn test
   ```

## Key Annotations
- `@Data`, `@Builder`: From Lombok for generating boilerplate code.
- `@SerializedName("_id")`: Maps the server's `_id` field to the `id` field in the `Student` object.
- `@JsonInclude(JsonInclude.Include.NON_NULL)`: Ensures null fields are excluded from serialization.

## Sample JSON
### Student Creation Request
```json
{
  "name": "Саша Петров",
  "grade": 2
}
```

### Server Response
```json
{
  "name": "Саша Петров",
  "grade": 2,
  "_id": "678686b5f9e0f703e867618a"
}
```

## Future Enhancements
- Add tests for updating student details.
- Include negative test cases for invalid inputs.
- Integrate with a CI/CD pipeline for automated testing.

## Troubleshooting
- Ensure the API key is valid and the server is reachable.
- Check for null pointer exceptions if the server response is malformed.

## License
This project is open-source and free to use under the MIT License.

