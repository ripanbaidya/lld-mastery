package com.designpatterns.iterator;

import com.designpatterns.iterator.collection.SongPlaylist;
import com.designpatterns.iterator.core.CustomIterator;
import com.designpatterns.iterator.model.Song;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IteratorApplication {

  public static void main(String[] args) {
//    SpringApplication.run(IteratorApplication.class, args);

    SongPlaylist playlist = new SongPlaylist();

    playlist.addSong(new Song("Truth", "Bayka"));
    playlist.addSong(new Song("Harry Potter", "JKY"));
    playlist.addSong(new Song("Patola", "Guru Randhawa"));

    CustomIterator<Song> songIterator = playlist.iterator();
    System.out.println("Playing songs in original order:");
    playSongs(songIterator);

    System.out.println("*-------------- * --------------*");

    CustomIterator<Song> reverseSongIterator = playlist.reverseIterator();
    System.out.println("Playing songs in reverse order:");
    playSongs(reverseSongIterator);

  }

  // Helper method

  private static void playSongs(CustomIterator<Song> iterator) {
    while (iterator.hasNext()) {
      System.out.println("Now Playing: " + iterator.next());
    }
  }

}
