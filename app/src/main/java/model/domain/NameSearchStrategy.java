package model.domain;

import java.util.ArrayList;

/**
 * strategy for searching for items via a its name. if the item contains the 
 * input name then it will be displayed.
 */
public class NameSearchStrategy implements SearchStrategy<String> {
  String name;
  ArrayList<Item> searchNameList = new ArrayList<>();
  /**
   * goes through all the items, and compares them with the name input.
   *
   * @return an arraylist with the items that match the name.
   * 
   */
  
  public ArrayList<Item> getNameList(MemberManager memberManager) {
    for (Item item : memberManager.getAllItems()) {
      if (item.getName().contains(name)) {
        searchNameList.add(item);
      }
    }
    return searchNameList;
  }

  @Override
  public void searchQuery(String name) {
    this.name = name;
  }

}
