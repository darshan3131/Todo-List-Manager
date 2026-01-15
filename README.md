# To-Do List Manager (Java Console App)

[![Java Version](https://img.shields.io/badge/Java-8%2B-blue)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

A simple yet powerful console-based To-Do List application built using **Core Java**. This project demonstrates key programming concepts like Object-Oriented Programming (OOP), collections, file I/O with serialization, and user input handling. Tasks are persisted across sessions, making it a practical utility tool.

Perfect for beginners learning Java or building a portfolio to showcase foundational skills for Java developer roles.

## Features
- **Add Tasks**: Create new tasks with auto-generated unique IDs.
- **View Tasks**: Display all tasks with completion status (✓ for completed, blank for pending).
- **Mark Complete**: Toggle a task as done.
- **Delete Tasks**: Remove unwanted tasks.
- **Data Persistence**: Tasks are automatically saved to a file (`tasks.dat`) using Java serialization—data survives program restarts.
- **Input Validation**: Handles empty descriptions, invalid IDs, and non-numeric inputs gracefully.
- **User-Friendly Menu**: Intuitive console interface with clear prompts and feedback.

## Tech Stack
- **Language**: Java (JDK 8 or higher)
- **Key Concepts Used**:
  - OOP (Classes, Encapsulation, toString override)
  - Collections (`ArrayList<Task>`)
  - File I/O (`ObjectOutputStream`, `ObjectInputStream`, `Serializable`)
  - Exception Handling
  - Scanner for user input

No external libraries or frameworks—pure Core Java!

## Project Structure

todo-list-manager-java/
├── src/
│   ├── Task.java                                                                                                          // Task model class
│   ├── TodoManager.java                                                                                                   // Core logic (CRUD + persistence)
│   └── TodoApp.java                                                                                                       // Main class with menu loop
├── tasks.dat                                                                                                              // Auto-generated data file (git ignore recommended)
└── README.md
