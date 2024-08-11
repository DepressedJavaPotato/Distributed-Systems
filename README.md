# Java RMI Calculator Server

## Overview

This assignment implements a simple Java RMI-based Calculator Server that supports multiple remote methods to perform operations on a stack of integers. The server allows multiple clients to connect and interact with the same stack, performing operations such as finding the minimum value, maximum value, least common multiple (LCM), greatest common divisor (GCD), and delayed pop operations.

## Features
This is our first assignment of Distributed Systems.

This Calculator Server supports the following remote methods:

- **`void pushValue(int val)`**: Pushes an integer value onto the stack.
- **`void pushOperation(String operator)`**: Performs 4 operations (`min`, `max`, `lcm`, `gcd`) on the stack and pushes the result back onto the stack.
- **`int pop()`**: Pops and returns the top value from the stack.
- **`boolean isEmpty()`**: Checks if the stack is empty.
- **`int delayPop(int millis)`**: Waits for the specified number of milliseconds before popping the top value from the stack.

## Assignment Structure


```plaintext
.
├── bin/                  # Directory for compiled class files
├── src/                  # Java source files
│   ├── Calculator.java
│   ├── CalculatorClient.java
│   ├── CalculatorImplementation.java
│   └── CalculatorServer.java
├── makefile              # Makefile for building and running the project
└── README.md             # This readme file

```
## Setup Instructions

# Prerequisites
- Java Development Kit (JDK) 
- Terminal or command prompt

## Compilation of source files
To compile, just type make in command prompt.

## Running the server
After compilation of files, run the server by typing in the command "java -cp bin CalculatorServer"

## Running the client
Once the server is ready, run the client requests by typing "java -cp bin CalculatorClient"

