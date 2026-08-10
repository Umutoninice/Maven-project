## Overview
This project demonstrates key Object-Oriented Programming concepts in Java including:
- Abstract classes and method overriding
- Interface implementation with default methods
- Polymorphism and type casting
- The Liskov Substitution Principle
- SOLID principles (Single Responsibility)

## Project Structure

### 1. Shape Hierarchy (`shapes` package)
- **Shape**: Abstract class with `area()` and `perimeter()` abstract methods
- **Circle**: Implements area (`πr²`) and perimeter (`2πr`)
- **Rectangle**: Implements area (`width × height`) and perimeter (`2(width + height)`)
- **Triangle**: Implements area and perimeter (`a + b + c`)

### 2. Bank Account Hierarchy (`banking` package)
- **BankAccount**: Base class with deposit/withdraw functionality
- **SavingsAccount**: Extends with interest rate and `applyInterest()` method
- **CheckingAccount**: Extends with monthly fee and `chargeMonthlyFee()` method

### 3. Printable Interface (`printable` package)
- **Printable**: Interface with `printSummary()` method and default `printHeader()` method
- **Student**: Implements Printable for student summaries
- **Card**: Implements Printable for card summaries

### 4. RPG Character System (`rpg` package)
- **Character**: Abstract class with name, health, and abstract `attack()` method
- **Warrior**: High health, moderate speed, consistent high damage (15-20)
- **Mage**: Low health, high speed, high variance spell damage (20-30)
- **Rogue**: Moderate health, highest speed, 30% critical hit chance (3x damage)

## Key OOP Concepts Demonstrated

### Abstract Classes
- Used when there's shared behavior but incomplete implementation
- `Shape` provides common methods but leaves `area()` and `perimeter()` abstract
- `Character` provides battle logic but leaves `attack()` abstract

### Method Overriding with `@Override`
- All subclasses override abstract methods

### Interfaces and Default Methods
- `Printable` interface with default `printHeader()` method
- Multiple implementations (Student, Card)

### Polymorphism and Liskov Substitution
- Collections of supertypes (`List<Shape>`, `List<BankAccount>`) containing subtypes
- All subtypes work correctly when substituted for their supertype

### Single Responsibility Principle (SRP)
- Each class has a single, well-defined purpose
- Shape classes handle geometry, BankAccount handles banking, RPG handles combat


