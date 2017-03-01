package dk.cphbusiness.algorithm.examples.searching;

@FunctionalInterface
public interface HashFunction<T> {
  int function(T key);
  }
