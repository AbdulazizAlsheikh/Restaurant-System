# Cloud-Based Restaurant System

## Project Overview
This repository contains a cloud-based restaurant system designed for a Data Structures course at the Al Imam Mohammad Ibn Saud Islamic University. The system aims to streamline the ordering and collection process in a virtual restaurant environment, enhancing efficiency and customer satisfaction through intelligent use of data structures.

## Problem Statement
The cloud-based restaurant system is intended to provide a seamless ordering and collection experience. The project involves complex functionalities:
- Menu Browsing and Order Placement: Structured as a tree where each node represents a menu category, facilitating easy navigation and item selection.
- Inventory Management: Ensures sufficient stock for selected items, prompting updates where necessary.
- Order Processing: Utilizes queues to manage order flow in the kitchen, ensuring a first-come, first-serve processing basis.

## Solution Techniques
The system was developed using Java and incorporates various data structures to optimize operations:
- Tree: For menu organization, allowing for efficient category and item browsing.
- Linked Lists: To store item details within orders and manage inventory dynamically.
- Queues: To handle order processing in the kitchen, ensuring timely preparation based on order sequence.
- Stack:: To order in multiple orders before preforming the order operation. 
- File Extracting: To extract file list of menu items. 
- Arrays: Used throughout in simple forms.

## Getting Started
### Prerequisites
- Java JDK 8 or later

### Installation
Clone the repository to your local machine:
```bash
git clone https://github.com/your-username/restaurant-system.git
cd restaurant-system
```

Compile the source code:
```bash
javac RestaurantSystem.java
```

Run the application:
```bash
java RestaurantSystem
```

## Usage
The application allows users to:
- Navigate through the menu structured as a tree.
- Select items with the desired quantity and add them to the order.
- Check inventory levels and update them as necessary before finalizing orders.
- Print final receipt with all orders and drinks.
- Ask user if order, exit or get drinks to showcase all data structures techniques used. 

## Contact
- GitHub @AbdulazizAlsheikh (https://github.com/AbdulazizAlsheikh)
- LinkedIn Abdulaziz Alsheikh (http://linkedin.com/in/abdulaziz-alsheikh-3b099a2bb)

## Acknowledgements
- Data Structures Course (CS252), Imam Mohammed Ibn Saud Islamic University.
- Java Programming Language.
