# Todo API Backend en Java Spring Boot

Ce projet est une API backend développée en Java avec Spring Boot. Il s'agit d'une première approche personnelle pour se familiariser avec la programmation orientée objet (POO) en Java et les concepts de développement d'API RESTful.

## Fonctionnalités

- CRUD (Create, Read, Update, Delete) pour les utilisateurs (`User`)
- CRUD pour les tâches (`Todo`)
- Relations entre les utilisateurs et les tâches

## Prérequis

- Java JDK 11 ou plus
  - Téléchargez le JDK depuis [Oracle](https://www.oracle.com/java/technologies/downloads/) ou [OpenJDK](https://adoptium.net/)
  - Installez le JDK en suivant les instructions pour votre système d'exploitation
  - Configurez la variable d'environnement JAVA_HOME :
    - Windows : 
      ```
      setx JAVA_HOME "C:\Program Files\Java\jdk-11"
      setx PATH "%PATH%;%JAVA_HOME%\bin"
      ```
    - Linux/Mac : 
      ```bash
      export JAVA_HOME=/usr/lib/jvm/java-11
      export PATH=$PATH:$JAVA_HOME/bin
      ```
- Maven (version 3.6+)
  - Téléchargez Maven depuis [Apache Maven](https://maven.apache.org/download.cgi)
  - Configurez la variable d'environnement MAVEN_HOME
- IDE (IntelliJ IDEA, Eclipse, VSCode, etc.)

## Installation

### Méthode 1 : Installation via Terminal/Command Line

1. Vérifiez votre environnement Java :
    ```bash
    java -version
    mvn -version
    ```

2. Clonez le repository :
    ```bash
    git clone https://github.com/votre-utilisateur/votre-repo.git
    cd votre-repo
    ```

3. Construisez le projet avec Maven :
    ```bash
    mvn clean install
    ```

4. Résolution des problèmes courants de build :
   - Si vous rencontrez des erreurs de dépendances :
     ```bash
     mvn dependency:purge-local-repository
     mvn clean install
     ```
   - Si vous avez des problèmes de version Java :
     ```bash
     mvn clean install -Dmaven.compiler.source=11 -Dmaven.compiler.target=11
     ```

5. Exécutez l'application Spring Boot :
    ```bash
    mvn spring-boot:run
    ```

### Méthode 2 : Installation via IntelliJ IDEA

1. Préparation d'IntelliJ IDEA :
   - Assurez-vous d'avoir la version Ultimate ou Community d'IntelliJ IDEA
   - Installez le plugin "Spring Boot" si vous utilisez Ultimate
   - Vérifiez la configuration du JDK dans File → Project Structure → Project SDK

2. Cloner le projet :
   - Ouvrez IntelliJ IDEA
   - Cliquez sur "Get from VCS" sur l'écran d'accueil
   - Collez l'URL du repository : `https://github.com/votre-utilisateur/votre-repo.git`
   - Choisissez le dossier de destination
   - Cliquez sur "Clone"

3. Configuration du projet :
   - Attendez que IntelliJ indexe le projet
   - Cliquez droit sur le fichier `pom.xml`
   - Sélectionnez "Add as Maven Project"
   - Dans la fenêtre Maven (généralement à droite), cliquez sur le bouton "Reload All Maven Projects"

4. Configuration du SDK :
   - Allez dans File → Project Structure → Project
   - Vérifiez que le SDK est bien configuré sur Java 11
   - Si nécessaire, cliquez sur "New..." pour ajouter un nouveau SDK
   - Appliquez les changements

5. Résolution des problèmes courants :
   - Si les dépendances ne se chargent pas :
     - File → Invalidate Caches / Restart
     - Supprimez le dossier `.idea` et rechargez le projet
   - Si le SDK n'est pas reconnu :
     - Vérifiez que JAVA_HOME pointe vers le bon JDK
     - Réimportez le projet Maven : clic droit sur `pom.xml` → Maven → Reimport

6. Lancement de l'application :
   - Trouvez la classe principale avec l'annotation `@SpringBootApplication`
   - Cliquez sur le bouton vert "Run" à côté de la classe
   - Ou utilisez la configuration "Spring Boot" automatiquement créée par IntelliJ

## Vérification de l'Installation

1. Accédez à l'application :
   - Interface Swagger : `http://localhost:8080/swagger-ui/index.html`
   - Console H2 : `http://localhost:8080/h2-console`

2. Testez un endpoint simple :
   ```bash
   curl http://localhost:8080/api/users
   ```

3. Vérifiez les logs de l'application pour détecter d'éventuelles erreurs

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

