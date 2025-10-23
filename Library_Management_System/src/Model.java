import java.util.*;

public class Model {
}

class Book{
    String title;
    String author;
    String genre;
    boolean isAvailable;

    public Book(String title,String author,String genre) {
        this.genre = genre;
        this.author = author;
        this.title = title;
        this.isAvailable=true;
    }
}

class Member{
    String userName;
    List<Book> borrowedBooks;

    public Member(String userName) {
        this.userName = userName;
        this.borrowedBooks=new ArrayList<>();
    }

    public boolean borrowBook(Book book){
        if(borrowedBooks.size() < 5 && book.isAvailable){
            borrowedBooks.add(book);
            book.isAvailable=false;
            return true;
        }
        return false;
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
        book.isAvailable=true;
    }
}