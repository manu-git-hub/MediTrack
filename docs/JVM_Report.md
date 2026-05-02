# JVM Architecture & Basics

This report outlines the foundational components of the Java Virtual Machine (JVM) and how it processes our MediTrack
application.

## 1. Class Loader Subsystem

The Class Loader is the mechanism that loads our compiled `.class` files into the JVM memory at runtime. It operates in
three phases:

* **Loading:** Locates and imports the binary data for our classes.
* **Linking:** Verifies that the bytecode is valid, allocates memory for static fields, and resolves symbolic
  references.
* **Initialization:** Assigns defined values to our static variables and executes any static blocks within our code.

## 2. Runtime Data Areas

Once loaded, the JVM allocates memory into specific areas to manage our program's execution:

* **Method Area:** Stores class-level structures, including method code, constructors, and the runtime constant pool.
* **Heap Area:** The primary memory pool where all our instantiated objects (like new `Patient` or `Doctor` entities)
  and arrays are stored.
* **Stack Area:** Thread-specific memory that stores local variables and method call frames. A new frame is created
  every time we invoke a method.
* **PC (Program Counter) Register:** Keeps track of the exact address of the JVM instruction currently being executed by
  a thread.
* **Native Method Stack:** Handles execution for methods written in languages other than Java.

## 3. Execution Engine

The Execution Engine is responsible for reading the bytecode from the Runtime Data Areas and executing it piece by
piece.

## 4. JIT Compiler vs. Interpreter

To execute the code, the engine utilizes two primary components:

* **Interpreter:** Reads and translates bytecode into machine code line-by-line. While it starts executing quickly, it
  can be inefficient for repetitive code.
* **JIT (Just-In-Time) Compiler:** Works alongside the interpreter to improve performance. It identifies "hotspots" (
  frequently executed blocks of code) and compiles them entirely into native machine code, preventing the interpreter
  from having to re-translate the same code multiple times.

## 5. Write Once, Run Anywhere

Java's platform independence is achieved through the JVM. When we write MediTrack, the Java compiler translates our
source code into platform-agnostic bytecode. Because every major operating system has its own specific implementation of
the JVM, that exact same bytecode can be executed on any machine without requiring us to alter or recompile our original
code.