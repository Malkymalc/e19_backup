import java.util.ArrayList;

public class Borrower {
    private String name;
    private ArrayList<Book> borrowedBooks;

    public Borrower(String name){
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }
    public ArrayList<Book> getBorrowedBooks(){
        return this.borrowedBooks;
    }


    public void requestBook(Library library, Book bookWanted){
        library.checkoutBook(this, bookWanted);
    }

    public void takeBook(Book book){
        this.borrowedBooks.add(book);
    }

    public void returnBook(Library library, Book book){
        this.borrowedBooks.remove(book);
        library.checkinBook(book);

    }
}
