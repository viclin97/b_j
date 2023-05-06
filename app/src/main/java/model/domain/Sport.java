package model.domain;

/**
 * Class of type sport for item creation.
 */
public class Sport extends Item {

  /**
   * For item creation of sport type.
   */
  public Sport(String name, Boolean loaned, Integer cost, String info, String type, String itemId) {
    this.name = name;
    this.loaned = loaned;
    this.cost = cost;
    this.info = info;
    this.type = type;
    this.itemId = itemId;
  }

  public Sport() {

  }

}
