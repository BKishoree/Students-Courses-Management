# Students-Courses-Management
The Students-Courses Management System is an advanced web application designed to facilitate the comprehensive management of student records and course enrollments. This system integrates a React frontend with a Spring Boot backend, utilizing MongoDB for flexible and efficient data storage.

# Technologies Used
Frontend: React 
Backend: Spring Boot 
Database: MongoDB 
API Testing: Postman 
Logging and Debugging: Logger

# Features
Comprehensive CRUD Operations: Supports full Create, Read, Update, and Delete functionalities for both students and courses. 
Dynamic User Interface: Built with React to provide an engaging and interactive user experience. 
Efficient Data Management: Utilizes Spring Boot and MongoDB for seamless data handling and scalability. 
Robust Error Handling: Implements custom exceptions to ensure reliable error management and clear user feedback. 
Detailed Logging: Employs advanced logging mechanisms for effective monitoring and debugging.

# Prerequisites
Java Development Kit (JDK) 11 or higher Node.js and npm (Node Package Manager) MongoDB Postman (for API testing)

# Backend Setup
cd backend Install Dependencies Ensure you have Maven installed, then run: mvn install

# Configure MongoDB
Update the application.properties file with your MongoDB connection details. spring.data.mongodb.uri=mongodb://localhost:27017/students

# Frontend Setup
Navigate to the Frontend Directory and install Dependencies --> npm install 
Run the Application npm start Access the UI

Open your browser and navigate to http://localhost:5173.

# API Testing with Postman
Endpoints: Use Postman to test the API endpoints for CRUD operations. 
Common Routes: 
GET /students - Fetch all students 
POST /students - Create a new student 
PUT /students/{id} - Update an existing student 
DELETE /students/{id} - Delete a student 
GET /courses - Fetch all courses 
POST /courses - Create a new course 
PUT /courses/{id} - Update an existing course 
DELETE /courses/{id} - Delete a course

# Exception Handling
Custom exceptions are implemented to handle errors and provide meaningful error messages. 
Ensure to review the ExceptionHandler class for details on how exceptions are managed.

# Logging
The application uses a logging framework to monitor and debug operations. 
Logs are configured in the logback.xml file and can be found in the logs directory.

# Frontend UI
Data Display: Student and course data is displayed in tables. 
CRUD Operations: Use the provided forms to add, update, or delete records. 
Error Handling: User-friendly messages are displayed for any errors or issues encountered during operations. 
Contribution Contributions are welcome! Please fork the repository and submit a pull request with any improvements or fixes.

Contact For any questions or issues, please contact B. Kishore at bkishore008@gmail.com.
