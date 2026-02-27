package com.designpatterns.iterator.collection;

import com.designpatterns.iterator.core.CustomIterator;
import com.designpatterns.iterator.core.ReverseSongIterator;
import com.designpatterns.iterator.core.SongIterator;
import com.designpatterns.iterator.model.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of a playlist.
 *
 * Internally stores songs using a List,
 * but exposes traversal only via an iterator.
 */
public class SongPlaylist implements IterableCollection<Song> {

    private final List<Song> songs = new ArrayList<>();

    /**
     * Adds a song to the playlist.
     */
    public void addSong(Song song) {
        songs.add(song);
    }

    /**
     * Removes a song from the playlist.
     */
    public void removeSong(Song song) {
        songs.remove(song);
    }

    /**
     * Factory method that creates a new iterator instance.
     * Each call returns a fresh iterator with independent traversal state.
     */
    @Override
    public CustomIterator<Song> iterator() {
        return new SongIterator(songs);
    }

    public CustomIterator<Song> reverseIterator() {
        return new ReverseSongIterator(songs);
    }
}