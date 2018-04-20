import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
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
    public void canAddBook(){
        library1.addBook(book2);
    }
    @Test
    public void canGetGenreList(){
        library1.addBook(book2);
       assertEquals(1, library1.getGenreCount(Genre.CHILDRENS));
       assertEquals(1, library1.getGenreCount(Genre.DRAMA));
       assertEquals(0, library1.getGenreCount(Genre.THRILLER));
    }
    @Test
    public void canCheckOutBook(){
        assertEquals(1, library1.getStockTotal());
        assertEquals(1, library1.getGenreCount(Genre.DRAMA));
        library1.checkoutBook(borrower1, book1);
        assertEquals(0, library1.getStockTotal());
        assertEquals(0, library1.getGenreCount(Genre.DRAMA));
    }

}
