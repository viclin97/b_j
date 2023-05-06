package model.domain;

/**
 * Class of type other for item creation.
 */
public class Other extends Item {

  /**
   * For item creation of other type.
   */
  public Other(String name, Boolean loaned, Integer cost, String info, String type, String itemId) {
    this.name = name;
    this.loaned = loaned;
    this.cost = cost;
    this.info = info;
    this.type = type;
    this.itemId = itemId;
  }

  public Other() {

  }

}
