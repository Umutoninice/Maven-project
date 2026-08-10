Java Object-Oriented Programming Practice
========================================
Overview
========
This project contains three Java classes that demonstrate core
Object-Oriented Programming (OOP) concepts: BankAccount, Student, and Card/Deck.
Each class implements key Java features including encapsulation,
validation, and proper method overriding.

Key Concepts Covered
====================
Class Design Fundamentals
-------------------------
Fields & Constructors: Defining instance variables and initializing objects.

this Keyword: Referencing current instance members. Helps java differencing instance variables
and method parameters.

Access Modifiers:

private – hidden from outside the class

package-private (default) – accessible within the same package

protected – accessible in subclasses and same package

public – accessible from anywhere

Object Class Overrides
--------------------
toString() – Provide human-readable string representation

equals() – Define logical equality between objects

hashCode() – Required when overriding equals() for hash-based collections

Encapsulation Best Practices
---------------------------
Getters – Expose necessary data

Setters – Control how state is modified (or omit for immutability)

Validation – Protect object integrity (e.g., balance ≥ 0, valid grades)

