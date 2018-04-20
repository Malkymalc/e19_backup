import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;
    private Borrower borrower1;

    @Before
    public void before(){
        this.book = new Book("The Very Hungry Caterpillar", "Eric Carle", Genre.CHILDRENS);
        this.borrower1 = new Borrower("Alan");
    }

    @Test
    public void canGetTitle(){
        assertEquals("The Very Hungry Caterpillar", book.getTitle());
    }
    @Test
    public void canGetAuthor(){
        assertEquals("Eric Carle", book.getAuthor());
    }
    @Test
    public void canGetGenre(){
        assertEquals(Genre.CHILDRENS, book.getGenre());
    }
    @Test
    public void canGetGenreDescription(){
        assertEquals("Children's", book.getGenreDescription());
    }
    @Test
    public void canCheckOut(){
        this.book.checkOut(borrower1);
        assertEquals("Alan", this.book.getBorrower());
        System.out.println(this.book.getReturnDateString());
    }
    @Test
    public void canCheckIn(){
        this.book.checkOut(borrower1);
        this.book.checkIn();
        assertEquals(null, this.book.getBorrower());
        assertEquals(null, this.book.getReturnDateString());
    }
}
