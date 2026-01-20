# PetStore Backend SpringBoot MySQL

Getting started

This is a monolithic api made with springboot, composed of 3 controllers (Pet , Order and User). Each controller handles CRUD operations (create , read , update , delete).

## Running the App

### Prerequisites

MacOS, JDK 21, homebrew installed.

### Configuration

The API uses by default a MySQL database. You can change it by modifying the application.properties file.

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/petstore
spring.datasource.username=root
spring.datasource.password=messi123
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

You can also change the application port and name.

```bash
server.port=8000
spring.application.name=PetStore-Monolithique
```

### Running the App locally

#### Database

Install MySQL locally with homebrew

```bash
brew install mysql
```

Start the database server

```bash
brew services start mysql
```

Set password, and create database
```bash
mysql -u root -e "ALTER USER 'root'@'localhost' IDENTIFIED BY 'password'; FLUSH PRIVILEGES; CREATE DATABASE petstore;"
```

#### Generate the JAR

```bash
mvn clean package
```

#### Run the JAR

```bash
java -jar target/PetStore-Monolithique-0.0.1-SNAPSHOT.jar
```

### Running the JAR with the Otel Agent

```bash
chmod +x ./energy.sh
./energy.sh
```

### Using the API

On startup, the application creates a default admin user with the following credentials:

-   **Email**: `admin@petstore.com`
-   **Password**: `admin`

#### Authentication

To authenticate and get an access token, make a POST request to the login endpoint:

**Endpoint**: `POST http://localhost:8000/auth/login`

**Request Body**:

```json
{
    "email": "admin@petstore.com",
    "password": "admin"
}
```

**Response**: You will receive a JWT token that should be included in the Authorization header for subsequent API calls.

**Example using curl**:

```bash
curl --request POST \
  --url http://localhost:8000/auth/login \
  --header 'content-type: application/json' \
  --data '{
  "password": "admin",
  "email": "admin@petstore.com"
}'
```
