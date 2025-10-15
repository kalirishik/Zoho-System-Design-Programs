# Task Management System 📝:
    Task Management System Implementation
    This portal contains the system design task asked in Zoho Round 3 on April 6, 2025. The task consists of 7 versions that build upon each other:
    
    Duration: 4 hours to complete all versions
    Role: Software Developer
    Requirements: Complete each version before moving to the next, take user input, validate formats, and finally implement file storage
    
    ## Version 1 - Basic Task Creation
    Objective: Get task details from the user (Task ID and Task Name), store multiple tasks, and display all tasks in a formatted view.
    
    Sample Input:
    Enter Task ID: 101
    Enter Task Name: Complete Assignment
    Enter Task ID: 102
    Enter Task Name: Buy Groceries
    
    Sample Output:
    Task ID: 101 | Task Name: Complete Assignment
    Task ID: 102 | Task Name: Buy Groceries
    
    ## Version 2 - Add Task Description
    Objective: Extend Version 1 by adding a task description for each task.
    
    Sample Input:
    Enter Task ID: 103
    Enter Task Name: Workout
    Enter Task Description: Morning gym session
    
    Sample Output:
    Task ID: 103 | Task Name: Workout | Description: Morning gym session
    
    ## Version 3 - Add Due Date  
    Objective: Add a Due Date for each task (in dd-mm-yyyy format) and validate the date format.
    
    Sample Input:
    Enter Task ID: 104
    Enter Task Name: Pay Bills
    Enter Task Description: Electricity and Water bills
    Enter Due Date (dd-mm-yyyy): 10-04-2025
    
    Sample Output:
    Task ID: 104 | Task Name: Pay Bills | Description: Electricity and Water bills | Due Date: 10-04-2025
    
    ## Version 4 - Priority Management
    Objective: Add Priority to each task (LOW/MEDIUM/HIGH) with MEDIUM as default. Include option to view tasks by priority level.
    
    Sample Input:
    Enter Task ID: 105
    Enter Task Name: Prepare Presentation
    Enter Description: Slides for meeting
    Enter Due Date: 09-04-2025
    Enter Priority (LOW/MEDIUM/HIGH): HIGH
    Enter Task ID: 106
    Enter Task Name: Clean Room
    Enter Description: Weekend cleaning
    Enter Due Date: 12-04-2025
    (Priority not entered - defaults to MEDIUM)
    
    Sample Output:
    --- HIGH Priority Tasks ---
    Task ID: 105 | Task Name: Prepare Presentation | Description: Slides for meeting | Due Date: 09-04-2025 | Priority: HIGH
    
    --- MEDIUM Priority Tasks ---
    Task ID: 106 | Task Name: Clean Room | Description: Weekend cleaning | Due Date: 12-04-2025 | Priority: MEDIUM
    
    ## Version 5 - Add Categories to Tasks
    Objective: Allow users to add multiple categories (comma-separated) to tasks and view tasks by category.
    
    Sample Input:
    Enter Task ID: 107
    Enter Task Name: Study Java
    Enter Description: Practice coding
    Enter Due Date: 15-04-2025
    Enter Priority: HIGH
    Enter Categories (comma separated): Education, Programming, Important
    
    Sample Output (Category View):
    --- Tasks under Category: Education ---
    Task ID: 107 | Task Name: Study Java | Description: Practice coding | Due Date: 15-04-2025 | Priority: HIGH | Categories: Education, Programming, Important
    
    --- Tasks under Category: Programming ---
    Task ID: 107 | Task Name: Study Java | Description: Practice coding | Due Date: 15-04-2025 | Priority: HIGH | Categories: Education, Programming, Important


# Stock Management System 🛠️:

    Stock Management System
    Language: Any object-oriented programming language (Java/Python preferred)
    
    Focus: System Design, OOP, Logical thinking, Code quality
    
    Problem Statement:
    Design and implement an In-Memory Stock Management System for a small-scale store. The system should be menu-driven and allow a store manager to perform the following operations.
    
    Modules to Implement:
    
    1. Add New Product to Inventory
    Input: Product ID, Product Name, Category, Quantity, Price per Unit, Supplier Name
    Store it in memory
    Product ID should be unique
    
    2. Update Stock Quantity
    Input: Product ID, Quantity to add or remove
    If removing, ensure quantity doesn't go below 0
    Update the product details accordingly
    
    3. Search Product
    Search by: Product ID, Product Name, or Category
    Display complete product details
    
    4. Track Sales and Purchases
    Support recording sales (reduces stock) and purchases (increases stock)
    For each transaction, store: Transaction ID, Product ID, Type (Sale/Purchase), Quantity, Date
    
    5. Generate Reports
    Low Stock Alert Report – List all products with stock below threshold
    Sales Report – Show total quantity sold per product
    Purchase Report – Show total quantity purchased per product
    
    6. Update Product Details
    Modify name, category, supplier, or price

# Taxi Booking Application 🚕:

    Design a call taxi booking application with the following constraints:
    
    1. There are 6 points (A, B, C, D, E, F) arranged linearly, and the distance between consecutive points is 15 km.
    2. The travel time between two consecutive points is 1 hour.
    3. All taxis start from point A.
    4. Minimum fare: Rs. 100 for the first 5 km. For every additional kilometer, Rs. 10 is charged.
    5. Allocate a free taxi that is closest to the customer. If two taxis are at the same distance, the one with lower earnings should be allotted.
    6. If no taxis are available, reject the booking.
    7. Display the earnings and booking details of each taxi after every booking.

# Railway Ticket Booking Application 🚅:

    Design a Railway Ticket booking application with the following constraints:

    1. Book
    2. Cancel
    3. Print booked tickets (details with summary)
    4. Print available tickets (details with summary)
    
    The application requires handling different ticket categories:
    
    --- Confirmed Tickets: 63 berths (Lower, Upper, Middle).
    --- RAC Tickets: 9 berths (18 passengers).
    --- Waiting List Tickets: 10 tickets max.
    
    Conditions for Booking:
    
    --- If the passenger is a senior citizen (>60 years) or a female, a lower berth should be allocated if available.
    --- If all berths are full, assign RAC.
    --- If RAC is full, assign Waiting List.
    --- If Waiting List exceeds 10 passengers, display “No tickets available”.
    
    Conditions for Cancellation:
    
    --- On canceling a confirmed ticket, an RAC ticket should move to confirmed, and a waiting-list ticket should move to RAC.
    
    Conditions for Printing Tickets:
    
    --- Booked Tickets: Display all confirmed passengers with details.
    --- Available Tickets: Show available berths, RAC slots, and Waiting List slots.
