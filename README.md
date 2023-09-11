# clammy-jeans-4153
# Thunder Electric System 

## Description
The Thunder Electric System is a Java application for managing consumer accounts, bills, and complaints in an electric utility service. It provides functionalities for both administrators and consumers.

## Features
- **Admin Functionality:**
  - Admin login with username and password.
  - Register new consumers.
  - View all consumers.
  - View all bills.
  - Create bills for consumers.
  - View all complaints.
  - Change the status of complaints.
  - Delete consumers.
  
- **Consumer Functionality:**
  - Consumer login with email and password.
  - Pay bills.
  - View all bills.
  - View unpaid bills.
  - Raise complaints.
  - View individual complaints.
  
## Installation
1. Clone the repository:
   ```
   git clone <repository_url>
   ```

2. Open the project in your preferred Java IDE.

3. Build the project.

4. Run the `Main` class to start the application.

## Usage
- Upon starting the application, you will be prompted to choose between admin and consumer login.
- Admin login credentials: Username: "admin", Password: "admin".
- Consumer login requires a registered email and password.
- Follow the on-screen menu to perform various tasks based on your role (admin or consumer).

## Dependencies
- Java 8 or higher

## Project Structure
- `com.masai.entities`: Contains classes for Consumer, Bills, and Complain entities.
- `com.masai.utility`: Provides utility classes for file operations.
- `com.masai.exceptions`: Contains custom exception classes.
- `com.masai.service`: Service interfaces and implementations.
- `Main.java`: The main class to run the application.

## File Persistence
- Consumer, bills, and complaints data are persisted using Java Serialization.
- Data files: `consumerFile.ser`, `billsFile.ser`, `complainFile.ser`.
