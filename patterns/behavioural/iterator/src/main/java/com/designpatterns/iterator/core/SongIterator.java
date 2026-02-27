package com.designpatterns.iterator.core;

import com.designpatterns.iterator.model.Song;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Concrete iterator implementation for SongPlaylist.
 * Maintains internal cursor state to track current position.
 */
public class SongIterator implements CustomIterator<Song> {

  private final List<Song> songs;
  private int currentIndex = 0;

  public SongIterator(List<Song> songs) {
    this.songs = songs;
  }

  /**
   * Returns true if the cursor has not yet
   * reached the end of the collection.
   */
  @Override
  public boolean hasNext() {
    return currentIndex < songs.size();
  }

  /**
   * Returns the next song and advances the cursor.
   *
   * @throws NoSuchElementException if iteration is complete
   */
  @Override
  public Song next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more songs in playlist.");
    }

    return songs.get(currentIndex++);
  }
}