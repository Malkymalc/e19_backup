import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book {
    private String title;
    private String author;
    private Genre genre;
    private String borrower;
    private Calendar returnDate;


    public Book(String title, String author, Genre genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.borrower = null;
        this.returnDate = null;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public Genre getGenre(){
        return this.genre;
    }

    public String getGenreDescription(){
        return this.genre.getDescription();
    }

    public String getBorrower(){
        return this.borrower;
    }
    public String getReturnDateString(){
        DateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        if (this.returnDate != null) {
            return formatter.format(this.returnDate.getTime());
        } else {
            return null;
        }
    }

    public void checkOut(Borrower borrower){
        this.borrower = borrower.getName();
        Calendar date = Calendar.getInstance();
        date.add(Calendar.MONTH, 1);
        this.returnDate = date;
    }

    public void checkIn(){
        this.borrower = null;
        this.returnDate = null;
    }

}
