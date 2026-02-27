package com.designpatterns.iterator.core;

/**
 * Generic iterator abstraction.
 * Defines the contract for sequential traversal
 * without exposing the underlying collection structure.
 *
 * @param <T> the type of elements returned by this iterator
 */
public interface CustomIterator<T> {

  /**
   * Checks whether the iteration has more elements.
   *
   * @return true if more elements are available, false otherwise
   */
  boolean hasNext();

  /**
   * Returns the next element in the sequence.
   *
   * @return the next element
   * @throws java.util.NoSuchElementException if no elements remain
   */
  T next();
}