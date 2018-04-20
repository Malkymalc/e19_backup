import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BorrowerTest {
    Borrower borrower1;
    Book book1;
    Book book2;
    Library library1;

    @Before
    public void before() {
        this.borrower1 = new Borrower("Alan");
        this.book1 = new Book("One Flew Over The Cuckoo's Nest", "Ken Kesey", Genre.DRAMA);
        this.book2 = new Book("The Very Hungry Caterpillar", "Eric Carle", Genre.CHILDRENS);
        this.library1 = new Library("Texas Book Repository", 500);
        library1.addBook(book1);
    }

    @Test
    public void canGetName() {
        assertEquals("Alan", this.borrower1.getName());
    }
    @Test
    public void canRequestBookInStock(){
        this.borrower1.requestBook(library1, book1);
        assertEquals(1, borrower1.getBorrowedBooks().size());
    }
    @Test
    public void canRequestBookNotInStock(){
        this.borrower1.requestBook(library1, book2);
        assertEquals(0, borrower1.getBorrowedBooks().size());
    }
    @Test
    public void canReturnBook(){
        this.borrower1.requestBook(library1, book1);
        assertEquals(1, borrower1.getBorrowedBooks().size());
        this.borrower1.returnBook(library1, book1);
        assertEquals(0, borrower1.getBorrowedBooks().size());
    }

}
