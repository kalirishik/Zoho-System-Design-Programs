# Task Management System
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
