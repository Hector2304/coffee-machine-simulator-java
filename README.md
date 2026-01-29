# Coffee Machine Simulator (Java)

Console-based coffee machine simulator built as a learning project in Java using **Hyperskill**.

The project simulates the behavior of a real coffee machine: managing resources, validating user input, handling actions, and updating internal state.

---

## Learning goals

This project focuses on practicing and reinforcing core Java concepts, including:

- Object-Oriented Programming (OOP)
- Input validation
- State management
- Conditional logic and control flow
- Incremental development through well-defined stages

---

## Project stages

The project was developed incrementally, following Hyperskill’s staged approach:

1. **Basic output**
   - Print the steps involved in making coffee.

2. **Ingredient calculation**
   - Calculate the required amounts of water, milk, and coffee beans based on the number of cups requested.

3. **Resource validation**
   - Validate available resources and calculate the maximum number of cups that can be made.

4. **Machine actions**
   - Implement actions such as:
     - `buy` (espresso, latte, cappuccino)
     - `fill` (refill resources)
     - `take` (collect money)
   - Update and display the machine state accordingly.
     
5. **Interactive loop**
   - Allow continuous user interaction until `exit`.
   - Add commands:
     - `remaining` to show current machine state
     - `back` to return to the main menu when buying coffee

6. **Cleaning cycle**
   - Track how many coffees have been made.
   - Require cleaning after 10 coffees.
   - Add a `clean` action to reset the machine and resume operation.
---

## Features

- Resource tracking (water, milk, coffee beans, disposable cups, money)
- Input validation to prevent invalid or negative values
- Interactive command loop (`buy`, `fill`, `take`, `remaining`, `clean`, `exit`)
- Automatic cleaning requirement after 10 coffees
- Clear separation of responsibilities using classes
- Console-based interaction

---
This project can be run from any Java-compatible IDE or from the command line.
It was developed as part of a learning exercise using Hyperskill.
