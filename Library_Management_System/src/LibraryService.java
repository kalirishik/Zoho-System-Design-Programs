import java.util.*;

public class LibraryService {
    static Scanner scanner=new Scanner(System.in);
    static List<Book> books=new ArrayList<>();
    static List<Member> members=new ArrayList<>();
    static Member loggedInMember=null;
    static String adminUserName="admin";
    static String adminPassword="password";
    public static void main(String[] args) {
        books.add(new Book("Psy Money","Rishi","Money"));
        books.add(new Book("Atomic Habits","hemanth","Habits"));
        System.out.println("------ Library Management System ------");
        while(true){
            System.out.print("Enter Role (admin/user): ");
            String role= scanner.nextLine().toLowerCase();

            if(role.equals("admin"))
                loginAsAdmin();
            else if(role.equals("user"))
                loginAsUser();
            else
                System.out.println("Invalid Role, Please Try Again.");
        }
    }

    public static void loginAsAdmin(){
        System.out.print("Enter Admin Name: ");
        String adminName=scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String adminPwd=scanner.nextLine();
        if(adminName.equals(adminUserName) && adminPwd.equals(adminPassword)){
            System.out.println("Logged in As Admin: "+adminName);
            adminMenu();
        }
        else
            System.out.println("Invalid Admin Credentials.");
    }

    public static void loginAsUser(){
        System.out.print("Enter User Name: ");
        String userName=scanner.nextLine();
        loggedInMember=findOrCreateMember(userName);
        System.out.println("Logged in As User: "+userName);
        userMenu();
    }

    public static Member findOrCreateMember(String userName){
        for(Member member:members){
            if(member.userName.equals(userName))
                return member;
        }
        Member newMember=new Member(userName);
        members.add(newMember);
        return newMember;
    }

    public static void adminMenu(){
        while(true){
            System.out.println("\n------ Library Management System ------");
            System.out.println(" 1. Add Book\n" +
                            " 2. Update Book\n" +
                            " 3. Remove Book\n" +
                            " 4. Add Member\n" +
                            " 5. Display All Books\n" +
                            " 6. Display All Members\n" +
                            " 7. Exit\n");

            System.out.print("Enter Choice (1-7): ");
            int choice= scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    addMember();
                    break;
                case 5:
                    displayAllBooks();
                    break;
                case 6:
                    displayAllMembers();
                    break;
                case 7:
                    System.out.println("Thanks For Visiting");
                    System.exit(0);
                default:
                    System.out.println("Enter Valid Option(1-7)");
            }
        }
    }

    public static void userMenu(){
        while(true){
            System.out.println("\n------ Library Management System ------");
            System.out.println(" 1. Borrow Book\n" +
                    " 2. return Book\n" +
                    " 3. Display All Books\n" +
                    " 4. Display All Members\n" +
                    " 5. Exit\n");

            System.out.print("Enter Choice (1-5): ");
            int choice= scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    borrowBook();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    displayAllBooks();
                    break;
                case 4:
                    displayAllMembers();
                    break;
                case 5:
                    System.out.println("Thanks For Visiting");
                    System.exit(0);
                default:
                    System.out.println("Enter Valid Option(1-5)");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book genre: ");
        String genre = scanner.nextLine();
        //Show in screenshot how the books arraylist stores the values
        books.add(new Book(title, author, genre));
        System.out.println("Book added successfully.");
    }

    private static void updateBook() {
        System.out.print("Enter book title to update: ");
        String title = scanner.nextLine();

        Book book = findBookByTitle(title);
        if (book != null) {
            System.out.print("Enter new author: ");
            book.author = scanner.nextLine();
            System.out.print("Enter new genre: ");
            book.genre = scanner.nextLine();
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void removeBook() {
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();

        Book book = findBookByTitle(title);
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private static void addMember() {
        System.out.print("Enter member username: ");
        String username = scanner.nextLine();
        members.add(new Member(username));
        System.out.println("Member added successfully.");
    }

    private static void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();

        Book book = findBookByTitle(title);
        if (book != null && loggedInMember.borrowBook(book)) {
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is either unavailable or borrow limit reached.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();

        Book book = findBookByTitle(title);
        if (book != null && !book.isAvailable) {
            loggedInMember.returnBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found or it wasn't borrowed.");
        }
    }

    private static void displayAllBooks() {
        if(books.isEmpty()){
            System.out.println("No books available");
        }else{
            System.out.println("\nList of Books:");
            for (Book book : books) {
                System.out.println("Title: " + book.title + ", Author: " + book.author + ", Genre: " + book.genre + ", Available: " + book.isAvailable);
            }
        }
    }

    private static void displayAllMembers() {
        if(members.isEmpty()){
            System.out.println("No memebers exist");
        }else{
            System.out.println("\nList of Members:");
            for (Member member : members) {
                System.out.println("Username: " + member.userName + ", Borrowed Books: " + member.borrowedBooks.size());
            }
        }
    }
}
