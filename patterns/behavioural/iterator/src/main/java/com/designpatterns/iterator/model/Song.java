package com.designpatterns.iterator.model;

/**
 * Domain model representing a Song.
 * Immutable data holder.
 */
public class Song {

  private final String title;
  private final String artist;

  public Song(String title, String artist) {
    this.title = title;
    this.artist = artist;
  }

  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  @Override
  public String toString() {
    return "Song{" +
        "title='" + title + '\'' +
        ", artist='" + artist + '\'' +
        '}';
  }
}