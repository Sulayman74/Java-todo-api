# Todo API Backend en Java Spring Boot

Ce projet est une API backend développée en Java avec Spring Boot. Il s'agit d'une première approche personnelle pour se familiariser avec la programmation orientée objet (POO) en Java et les concepts de développement d'API RESTful.

## Fonctionnalités

- CRUD (Create, Read, Update, Delete) pour les utilisateurs (`User`)
- CRUD pour les tâches (`Todo`)
- Relations entre les utilisateurs et les tâches

## Prérequis

- Java 11 ou plus
- Maven
- IDE (IntelliJ IDEA, Eclipse, VSCode, etc.)

## Installation

1. Clonez le repository :
    ```bash
    git clone https://github.com/votre-utilisateur/votre-repo.git
    cd votre-repo
    ```

2. Construisez le projet avec Maven :
    ```bash
    mvn clean install
    ```

3. Exécutez l'application Spring Boot :
    ```bash
    mvn spring-boot:run
    ```

L'application sera disponible sur `http://localhost:8080`.

## Utilisation

### Endpoints

- **Users**
    - `GET /api/users` : Récupérer tous les utilisateurs
    - `POST /api/users` : Créer un nouvel utilisateur
    - `GET /api/users/{id}` : Récupérer un utilisateur par ID
    - `PUT /api/users/{id}` : Mettre à jour un utilisateur par ID
    - `DELETE /api/users/{id}` : Supprimer un utilisateur par ID

- **Todos**
    - `GET /api/todos` : Récupérer toutes les tâches
    - `POST /api/todos` : Créer une nouvelle tâche
    - `GET /api/todos/{id}` : Récupérer une tâche par ID
    - `PUT /api/todos/{id}` : Mettre à jour une tâche par ID
    - `DELETE /api/todos/{id}` : Supprimer une tâche par ID

### Exemples de Requêtes avec Postman

#### Créer un Utilisateur
POST /api/users
Content-Type: application/json

```json

{
    "title": "Mr.",
    "firstname": "John",
    "lastname": "Doe",
    "email": "john.doe@example.com",
    "password": "securepassword"
}
```
#### Créer une Tâche
POST /api/todos
Content-Type: application/json

```json
{
    "title": "Faire les courses",
    "description": "Acheter des légumes et du lait",
    "completed": false,
    "user": {
        "id": 1
    }
}
```
### Dépendances
```
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- H2 Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>

    <!-- Spring Boot Starter Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```
### Configuration
```
spring.application.name=todo
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testDb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
logging.level.org.hibernate.SQL=debug
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=trace
server.port=8080
```

