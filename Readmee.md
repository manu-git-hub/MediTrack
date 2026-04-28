# MediTrack — Clinic & Appointment Management System

## Brief

### Learning Objectives

By completing MediTrack, we will demonstrate proficiency in:

* **Java setup and JVM basics** (JDK, JRE, JVM internals).
* **Core OOP**: Encapsulation, inheritance, polymorphism, abstraction.
* **Advanced OOP**: Cloning (deep vs shallow), immutability, enums, static initialization.
* **Collections**: Generics, comparators, iterators, equals/hashCode.
* **Exception handling**: Custom exceptions, chaining, try-with-resources.
* **File I/O**: CSV parsing, serialization/deserialization.
* **Intro to concurrency**: Threads, synchronization, `AtomicInteger`, `TimerTask`.
* **Design patterns**: Singleton, Factory, Strategy, Template Method, Observer (optional).
* **Java 8+ features**: Streams & lambdas.
* **Testing**: Manual runner, JavaDocs, and command-line usage.
* **Git-based collaboration**.

---

## Project Requirements & Grading Breakdown

### 1. Environment Setup & JVM Understanding (10 pts)

* Install & configure Java (JDK/JRE). Provide `Setup_Instructions.md` with screenshots.
* `JVM_Report.md` covering:
    * Class Loader
    * Runtime Data Areas (Heap, Stack, Method Area, PC Register)
    * Execution Engine
    * JIT Compiler vs Interpreter
    * "Write Once, Run Anywhere"
* **Deliverables**: `docs/Setup_Instructions.md`, `docs/JVM_Report.md`

### 2. Package Structure & Java Basics (10 pts)

* **Base package**: `com.airtribe.meditrack`
* **Sub-packages**:
    * `entity`: Person, Doctor, Patient, Appointment, Bill, BillSummary (immutable)
    * `service`: DoctorService, PatientService, AppointmentService
    * `util`: Validator, DateUtil, CSVUtil, IdGenerator, AIHelper (optional), DataStore<T> (generic)
    * `exception`: AppointmentNotFoundException, InvalidDataException
    * `interface`: Searchable, Payable
    * `constants`: Constants (tax rate, file paths)
    * `test`: TestRunner (manual tests)
* **Demonstrate**:
    * Access modifiers
    * Variable scopes (static vs instance); use static blocks & initialization
    * Primitive types and casting

### 3. Core OOP Implementation (35 pts)

#### A. Encapsulation (8 pts)

* Private fields + getters/setters.
* Centralized validation via `Validator`.

#### B. Inheritance (10 pts)

* `Person` → `Doctor`, `Patient`.
* Use `super`, `this`, and constructor chaining.

#### C. Polymorphism (7 pts)

* **Overloading**: `searchPatient()` by ID / name / age.
* **Overriding**: `generateBill()` behavior in appropriate classes.
* Demonstrate dynamic dispatch.

#### D. Abstraction & Interfaces (10 pts)

* Abstract class `MedicalEntity` for common behavior.
* Interfaces: `Payable`, `Searchable` with default methods where suitable.

### 4. Advanced OOP Additions

* **Deep vs Shallow Copy**: Implement `Cloneable` for `Patient` and `Appointment`; demonstrate deep copy semantics (
  clone nested objects correctly).
* **Immutable Class**: `BillSummary` — final fields, no setters, thread-safe.
* **Enums**: `Specialization`, `AppointmentStatus` (e.g., `CONFIRMED`, `CANCELLED`, `PENDING`).
* **Static blocks**: Initialize application-wide config or counters.

### 5. Application Logic (15 pts)

* CRUD for Patients & Doctors.
* **Appointments**: Create, view, cancel. Use `AppointmentStatus` enum.
* **Billing**: `Bill` object, taxes, multiple billing strategies (**Strategy Pattern** bonus).
* **Search**: Dynamic search for doctors/patients.
* Menu-driven console UI in `Main.java`.
* Use `ArrayList`, `HashMap`, `DataStore<T>` generic class for storage.

---

## Bonus Features — Choose any two (20 pts total)

### A. File I/O & Persistence (10 pts)

* Save/load Patient/Doctor/Appointment via CSV and/or Java Serialization.
* Use **try-with-resources**.
* Implement `CSVUtil` with `String.split(",")`.
* Persisted data loaded by `--loadData` command-line arg.

### B. Design Patterns (10 pts)

* **Singleton**: App configuration / IdGenerator (eager & lazy examples).
* **Factory**: Bill creation (refined factory returning different `Bill` types).
* **Observer**: Appointment notifications (console reminders).

### C. AI Feature (10 pts)

* Rule-based doctor recommendation by symptoms.
* Auto-suggest appointment slots.

### D. Java Streams + Lambdas (10 pts)

* Filter doctors by specialization, compute average fee, and analytics (appointments per doctor) using streams.