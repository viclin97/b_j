package model.domain;

/**
 * strategy interface for a search function.
 */
public interface SearchStrategy<T> {
  
  /**
   * var is used as a String when searching by name. and integer when searching by max price.
   *
   * @param var used as whatever datatype you put into it.
   */
  void searchQuery(T var);

}
