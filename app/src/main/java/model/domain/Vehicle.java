package model.domain;

/**
 * Class of type vehicle for item creation.
 */
public class Vehicle extends Item {

  /**
   * For item creation of vehicle type.
   */
  public Vehicle(String name, Boolean loaned, Integer cost, String info, String type, String itemId) {
    this.name = name;
    this.loaned = loaned;
    this.cost = cost;
    this.info = info;
    this.type = type;
    this.itemId = itemId;
  }

  public Vehicle() {

  }

}
