import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private String name;
    private int capacity;
    private ArrayList<Book> books;
    private HashMap<String, Integer> genresCount;

    public Library(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.books = new ArrayList<>();
        this.genresCount = new HashMap<>();
    }

    public int getStockTotal(){
        return books.size();
    }

    public void addBook(Book newBook){
        if(getStockTotal() < this.capacity) {
            this.books.add(newBook);
            String bookGenre = newBook.getGenreDescription();
            int count = genresCount.containsKey(bookGenre) ? genresCount.get(bookGenre) : 0;
            genresCount.put(bookGenre, count + 1);
        } else {
            System.out.println("Can't add book - " + this.name + " is full!");
        }
    }

    public void checkoutBook(Borrower borrower, Book requestedBook){
        if( books.contains(requestedBook) ){
            requestedBook.checkOut(borrower);
            borrower.takeBook(requestedBook);
            this.books.remove(requestedBook);
            String bookGenre = requestedBook.getGenreDescription();
            int count = genresCount.containsKey(bookGenre) ? genresCount.get(bookGenre) : 0;
            genresCount.put(bookGenre, count - 1);
        } else {
            System.out.println("We don't have that book in stock");
        }
    }

    public void checkinBook(Book returnedBook){
        returnedBook.checkIn();
        addBook(returnedBook);
    }

    public int getGenreCount(Genre genre){
        Integer count = genresCount.get(genre.getDescription());
        if (count == null) { count = 0; }
        System.out.println("We have " + count + " books in the genre section " + genre.getDescription());
        return count;
    }

}
