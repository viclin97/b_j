package model.domain;

import java.util.ArrayList;

/**
 * strategy for searching for items via a its price. if the price is lower or equal
 * to the input, then it will be displayed.
 */
public class PriceSearchStrategy implements SearchStrategy<Integer> {
  Integer price;
  ArrayList<Item> itemPrices = new ArrayList<>();
  /**
   * goes through all the items, and compares them with the price input.
   *
   * @return an arraylist with the items that match the price.
   * 
   */
  
  public ArrayList<Item> getPriceList(MemberManager memberManager) {
    for (Item item : memberManager.getAllItems()) {
      if (item.getCost() <= price) {
        itemPrices.add(item);
      }
    }
    return itemPrices;
  }

  @Override
  public void searchQuery(Integer price) {
    this.price = price;

  }

}
