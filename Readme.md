# MediTrack — Advanced Clinic & Appointment Management System

## Overview

Welcome to **MediTrack**, a robust, console-based Java application engineered to streamline the daily operations of a
modern medical clinic. We built this system to efficiently manage Patients, Doctors, Appointments, and Billing
lifecycles.

Beyond its core functionality, MediTrack serves as a comprehensive showcase of modern Java development, demonstrating a
deep understanding of Object-Oriented Programming (OOP) paradigms, generic data structures, file persistence, and Java
8+ functional programming features.

---

## Key Features & Technical Implementation

We designed this application to meet strict software engineering standards. Here is a breakdown of how the core
mechanics operate:

### 1. Core & Advanced OOP Principles

* **Encapsulation & Validation:** All entity attributes are strictly private, accessible only via getters/setters, with
  centralized data validation to prevent invalid states.
* **Inheritance & Polymorphism:** The system utilizes a base `Person` class extended by `Doctor` and `Patient`. We
  implemented method overloading (e.g., searching patients by ID, Name, or Age) and method overriding for customized
  entity behaviors.
* **Abstraction:** Leverages interfaces like `Payable` and `Searchable` to define contracts across disparate classes.
* **Advanced Concepts:**
    * **Deep Cloning:** Custom `Cloneable` implementations guarantee that nested objects (like Appointments) are deeply
      copied, preventing unintended side effects.
    * **Immutability:** The `BillSummary` class is designed as purely immutable (final fields, no setters) ensuring
      thread safety during financial calculations.
    * **Enums:** Type-safe enums (`AppointmentStatus`, `Specialization`) replace brittle string constants.

### 2. Intelligent Data Management

* **Generics:** We implemented a custom `DataStore<T>` generic class to abstract and manage in-memory storage for any
  entity type.
* **Collections Framework:** Heavy utilization of `ArrayList` and `HashMap` for fast data retrieval and relationship
  mapping.

### 3. Application Logic & Workflow

* **Appointment Lifecycle:** Full CRUD support for creating, viewing, and canceling appointments, strictly governed by
  state transitions (`PENDING` → `CONFIRMED` or `CANCELLED`).
* **Automated Billing:** Generates comprehensive bills calculating base consultation fees and dynamic tax rates fetched
  from system properties.

### 4. Persistence & File I/O

* **CSV Data Loading:** On startup, the system automatically parses and loads historical data from local `.csv` files (
  `doctors.csv`, `patients.csv`, `appointments.csv`, `bills.csv`).
* **Try-With-Resources:** Guarantees safe file handling and prevents resource memory leaks during I/O operations.

### 5. Modern Java (Streams & Lambdas)

* We replaced traditional loops with functional **Java Streams** to process data elegantly. For example, filtering
  available doctors by `Specialization` or computing the average clinic consultation fee is handled via chained lambda
  expressions.

---

## Project Architecture

We structured the project using standard Java enterprise packaging conventions :

```text
src/
└── com/airtribe/meditrack/
    ├── Main.java               # Application entry point and CLI menu
    ├── constants/              # Application-wide static constants
    ├── csv/                    # CSV parsing and persistence logic
    ├── entity/                 # Domain models (Patient, Doctor, Bill, etc.)
    ├── enums/                  # Type-safe enumerations
    ├── exception/              # Custom domain exceptions
    ├── interfaces/             # Shared behavioral contracts
    ├── service/                # Business logic and entity orchestration
    ├── test/                   # Manual test runners and validations
    └── util/                   # Utilities (Generics, Configs, ID Generators)