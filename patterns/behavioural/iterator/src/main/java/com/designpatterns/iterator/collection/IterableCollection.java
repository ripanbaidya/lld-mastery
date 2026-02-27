package com.designpatterns.iterator.collection;

import com.designpatterns.iterator.core.CustomIterator;

/**
 * Aggregate abstraction in the Iterator pattern.
 * Represents a collection capable of creating an iterator to traverse
 * its elements.
 *
 * @param <T> the type of elements in the collection
 */
public interface IterableCollection<T> {

  /**
   * Creates a new iterator instance for traversing the collection.
   *
   * @return a CustomIterator for this collection
   */
  CustomIterator<T> iterator();
}