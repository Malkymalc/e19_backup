package codeclan.com.topsongslist;

/**
 * Created by user on 20/03/2018.
 */

public class Song {
    private String title;
    private String artist;
    private Integer releaseDate;

    public Song(String title, String artist, Integer releaseDate){
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

}
