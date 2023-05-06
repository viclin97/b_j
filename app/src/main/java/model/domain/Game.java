package model.domain;

/**
 * Class of type game for item creation.
 */
public class Game extends Item {

  /**
   * For item creation of game type.
   */
  public Game(String name, Boolean loaned, Integer cost, String info, String type, String itemId) {
    this.name = name;
    this.loaned = loaned;
    this.cost = cost;
    this.info = info;
    this.type = type;
    this.itemId = itemId;
  }

  public Game() {

  }

}
