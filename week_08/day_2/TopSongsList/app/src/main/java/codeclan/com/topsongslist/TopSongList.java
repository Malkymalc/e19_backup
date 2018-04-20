package codeclan.com.topsongslist;

import java.util.ArrayList;

/**
 * Created by user on 20/03/2018.
 */

public class TopSongList {

    private ArrayList<Song> songList;

    public TopSongList(){
        songList = new ArrayList<>();
        songList.add(new Song("Tangled Up In Blue", "Bob Dylan", 1973));
        songList.add(new Song("Tangled Up In Blue", "Bob Dylan", 1973));
        songList.add(new Song("Tangled Up In Blue", "Bob Dylan", 1973));
        songList.add(new Song("Tangled Up In Blue", "Bob Dylan", 1973));
        songList.add(new Song("Tangled Up In Blue", "Bob Dylan", 1973));
        songList.add(new Song("Tangled Up In Blue", "Bob Dylan", 1973));
        songList.add(new Song("Tangled Up In Blue", "Bob Dylan", 1973));
        songList.add(new Song("Tangled Up In Blue", "Bob Dylan", 1973));
    }

    public ArrayList<Song> getTopSongs(){
        return new ArrayList<>(songList);
    }
}
