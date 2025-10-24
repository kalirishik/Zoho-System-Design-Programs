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

# Taxi Booking System 🚕:

    Design a call taxi booking application with the following constraints:
    
    1. There are 6 points (A, B, C, D, E, F) arranged linearly, and the distance between consecutive points is 15 km.
    2. The travel time between two consecutive points is 1 hour.
    3. All taxis start from point A.
    4. Minimum fare: Rs. 100 for the first 5 km. For every additional kilometer, Rs. 10 is charged.
    5. Allocate a free taxi that is closest to the customer. If two taxis are at the same distance, the one with lower earnings should be allotted.
    6. If no taxis are available, reject the booking.
    7. Display the earnings and booking details of each taxi after every booking.

# Railway Ticket Booking System 🚅:

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

# Flight Ticket Booking System ✈️:

    Design a Flight Ticket booking application with the following constraints:
    
    1. Booking Ticket
        Booking Conditions:
            --- Each flight has 50 seats.
            --- Get passenger details, including flight name and seats required.
            --- Ticket starting price is ₹5000.
            --- Ticket price increases by ₹200 for every successful booking.
       
    2. Cancel Ticket
        Cancel Conditions:
            --- Issue a refund for the cancelled ticket.
            --- Ticket price reduces by ₹200 per cancelled seat.
       
    3. Print Flight Details with Passengers

# Mail Management System ✉️:

    Design a Mail Management System with the following constraints:

    1. Store module:
        --- Mail has Sender, Receiver, Subject, Content, Tag.
    
    2. Delete module:
       --- Delete By Mail Index.
        
    4. Tag module:
        --- User can add tags to mails.
    
    5. Stats module:
        --- It shows the count of mail, groups of tags, recent N mails.
    
    6. Spam module:
        --- We need to tag spam based on the dictionary of words.
    
    7. Search:
        --- We need to search based on the query.
    
    8. WildCard:
       --- We need to search based on the WildCard query.

# Invoice Management System 🧾:

    Design an Invoice Management System with the following constraints:
    
    1. Add a customer
    2. Add an invoice
    3. Add items to an invoice
    4. List all customers
    5. List all invoices
    6. List all invoices of a customer
    7. Display the full details of an invoice

# Library Management System 📚:

    Design a Library Management System with the following constraints:
    
    It was our task to design a system that would allow the firm to:
    
        --> You may borrow up to 5 books and keep them for 30 days.
        --> Admins are allowed to manage which books are available (adding, updating and removing books).
        --> Anyone can sign up, take out a book and return it once they’re finished.
        --> Keep a record of what books are available and who has them.
        --> Make it possible to locate songs by searching by title, the author’s name or genre.
        
    The Solution:
    
        --> Understanding Individual Masculinity, Femininity and Gender Neutral
        --> To function well, a Library Management System (LMS) ought to fulfil the requirements of both admins and users (members). 
        --> Everyone acts differently on the website, so we break their actions down into individual modules.
    
    Admin Actions:
    
        --> You can add, update and remove books.
        --> All the books and all the members are displayed here.
        
    User Actions:
    
        --> Sign up to be a member.
        --> Borrow your books during the scheduled documentary hours.
        
    You can look up books by either the book’s title, the name of the writer or the subject area.

# Toll Payment Process System 🛣:

    Design a Toll Payment Process System with the following constraints:
    
    Application Description:
    
        --> There are ’n’ points on a highway. Some of these points are toll gates.
        --> Each toll gate has a unique charging scheme based on vehicle type (Car, Bike, Truck) and whether the user is VIP.
        --> VIP users receive a 20% discount on toll charges.
        --> A vehicle passing through multiple tolls must pay at each toll according to its respective scheme.
        --> The highway is considered circular, allowing vehicles to travel in both directions.
    
    Modules:
    
        1. Process Journey:
             Calculate the toll charges for a journey, including discounts if applicable.
            
        2. Display Toll Details:
             Display details of vehicles passing each toll and the total revenue collected.
        
        3. Display Vehicle Details:
             Show journeys taken by each vehicle, tolls passed, and total toll charges paid.
        
        4. Find Shortest Route and Calculate Toll:
             Identify the shortest path between two points and calculate the toll.
        
        5. Exit:
             Terminate the program.
