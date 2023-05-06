package model.domain;

/**
 * Class of type toy for item creation.
 */
public class Toy extends Item {

  /**
   * For item creation of toy type.
   */
  public Toy(String name, Boolean loaned, Integer cost, String info, String type, String itemId) {
    this.name = name;
    this.loaned = loaned;
    this.cost = cost;
    this.info = info;
    this.type = type;
    this.itemId = itemId;
  }

  public Toy() {

  }

}
