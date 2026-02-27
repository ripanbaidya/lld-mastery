package com.designpatterns.prototype;

/**
 * Prototype Interface
 *
 * @param <T> the type of object to be cloned
 */
public interface Prototype<T> {

  /**
   * Clone method to be implemented by the concrete prototype
   *
   * @return a clone of the object
   */
  T clone();
}
