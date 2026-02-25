package com.designpatterns.builder;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * In Java 8, lambda expressions and method references opened up new possibilities,
 * including a more generic form of the Builder Pattern.
 * Our implementation introduces a GenericBuilder class, which can construct various
 * types of objects by leveraging generics:
 */
public class GenericBuilder<T> {

  private final Supplier<T> supplier;

  public GenericBuilder(Supplier<T> supplier) {
    this.supplier = supplier;
  }

  public static <T> GenericBuilder<T> of(Supplier<T> supplier) {
    return new GenericBuilder<>(supplier);
  }

  public <P> GenericBuilder<T> with(BiConsumer<T, P> consumer, P value) {
    return new GenericBuilder<>(() -> {
      T object = supplier.get();
      consumer.accept(object, value);
      return object;
    });
  }

  public T build() {
    return supplier.get();
  }
}
