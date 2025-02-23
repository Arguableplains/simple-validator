# RG/CPF Java Validator

A Java-based RG and CPF validator that uses a **pushdown automata** for format verification. This project ensures that the input RG (Registro Geral) and CPF (Cadastro de Pessoas Físicas) numbers comply with the required formatting rules.

# Automatons

## RG Automatons

![alt text](https://github.com/Arguableplains/simple-validator/blob/master/RG-automaton.png?raw=true)

## CPF Automatons

![alt text](https://github.com/Arguableplains/simple-validator/blob/master/CPF-automaton.png?raw=true)

---

## 💻 Requirements

Before running the project, ensure your system meets the following requirements:

- **Java 19** or newer
- **Maven** (latest version)
- **Operating System**: Windows, Linux, or any machine that supports Java JVM

---

## 🚀 Installation

Follow these steps to set up and run the project:

1. Clone the repository:

    `git clone https://github.com/Arguableplains/simple-validator.git`

2. Navigate to the project directory:

    `cd simple-validator`

3. Build the project using Maven:

    `mvn clean package`

4. Run the Spring Boot application:

    `mvn spring-boot:run`

---

## ☕ How to Use

Once the Spring Boot application is running:

1. Open your browser and navigate to:

    `http://localhost:8080`

2. Enter the RG or CPF number in the provided input field.

3. The application will validate the input and display whether the RG or CPF is valid or not.

---

## 📂 Project Structure

The project is structured as follows:

```
    simple-validator/
    ├── src/
    │ ├── main/
    │ │ ├── java/ # Java source files
    │ │ └── resources/ # Configuration and static files
    │ └── test/ # Unit tests
    ├── pom.xml # Maven configuration file
    └── README.md # Project documentation
```

---

## 🛠️ Built With

- **Java 19**: The core programming language used.
- **Maven**: Dependency management and build automation.
- **Spring Boot**: Framework for building the web application.

---

## 🙏 Acknowledgments

- Inspired by a faulty project requiring for efficient RG and CPF validation in Brazilian systems.
- Special thanks to the Java and Spring Boot communities for their excellent documentation and support.
