package model.domain;

/**
 * Class of type tool for item creation.
 */
public class Tools extends Item {

  /**
   * For item creation of tool type.
   */
  public Tools(String name, Boolean loaned, Integer cost, String info, String type, String itemId) {
    this.name = name;
    this.loaned = loaned;
    this.cost = cost;
    this.info = info;
    this.type = type;
    this.itemId = itemId;
  }

  public Tools() {

  }

}
