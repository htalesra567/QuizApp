# Quiz App

## Overview
The **Quiz App** is a RESTful application designed to deliver interactive quizzes and manage user scoring. It is built using **Java**, **Spring Boot**, and **MySQL**. The project follows a **Microservices Architecture**, ensuring a modular and scalable design.

## Features
- **Interactive Quizzes**: Create and participate in quizzes.
- **User Scoring**: Automatically calculate and display scores.
- **Microservices Architecture**: Designed for scalability and maintainability.
- **API Testing**: Verified service interactions and functionality using Postman.

## Technologies Used
- **Programming Language**: Java
- **Framework**: Spring Boot
- **Database**: MySQL
- **Tools**: Postman, IntelliJ IDEA, Eclipse

## Architecture
The application adopts a **Microservices Architecture**, dividing functionalities into separate, scalable modules. This architecture allows for independent development, deployment, and scaling of services.

## Installation

1. **Clone the Repository**
   ```bash
   git clone <repository_url>
   cd quiz-app
   ```
2. **Set Up the Database**
   - Install MySQL and create a database for the application.
   - Update database configurations in the `application.properties` file:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/quiz_app_db
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```
3. **Build and Run the Application**
   ```bash
   mvn spring-boot:run
   ```

## Usage
- Access the application at `http://localhost:8080`.
- Use Postman to test available REST APIs for quiz creation, participation, and scoring.

## API Endpoints
| Endpoint              | Method | Description                    |
|-----------------------|--------|--------------------------------|
| `/quizzes`            | GET    | Retrieve all available quizzes |
| `/quizzes/{id}`       | GET    | Get details of a specific quiz |
| `/quizzes`            | POST   | Create a new quiz              |
| `/quizzes/{id}`       | PUT    | Update an existing quiz        |
| `/quizzes/{id}`       | DELETE | Delete a quiz                  |
| `/quizzes/{id}/score` | GET    | Retrieve user scores           |

## Future Enhancements
- Add advanced features like timer-based quizzes and leaderboards.
- Implement a front-end interface using frameworks like React or Angular.
- Enhance security and user authentication for quiz access.

## Contributors
- **Hitesh Talesra**
  - LinkedIn: [Your LinkedIn Profile](https://www.linkedin.com)
  - Email: [hitesh.talesra12@gmail.com](mailto:hitesh.talesra12@gmail.com)

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contact
For any questions or feedback, feel free to reach out to me!
