package model.domain;

import java.util.ArrayList;

/**
 * All items seters.
 */
public class ItemManager {

  // A list to store all the items ids to check if the id already exist when we
  // generate a new one.
  ArrayList<String> itemIdList = new ArrayList<>();

  public ItemManager() {

  }

  /**
   * Gets the all the items ids and adds them to a list so that we-
   * can check if the id already exist. This only needs to be run once-
   * because if not it would be very performance heavy.
   */

  public void getItemIds(ArrayList<Member> memberList) {
    for (Member member : memberList) {
      for (Item item : member.getItemList()) {
        itemIdList.add(item.getItemId());
      }
    }
  }

  /**
   * Deletes the item id string.
   */

  public void delItemId(String itemId) {
    itemIdList.remove(itemId);
  }

  /**
   * Checks if the id exists and returns true or false.
   */
  public Boolean idExists(String itemId) {
    return itemIdList.contains(itemId);
  }

  /**
   * Takes the highest value id in the id list and adds one so that the id is
   * unique then returns it so it can be used under item creation.
   */
  public String generateId() {
    Integer tempId = 0;
    for (String id : itemIdList) {
      if (Integer.parseInt(id) > tempId) {
        tempId = Integer.parseInt(id);
      }
    }
    tempId++;
    if (!idExists(String.valueOf(tempId))) {
      return String.valueOf(tempId);
    } else {
      return null;
    }
  }

}
