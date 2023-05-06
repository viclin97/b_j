package model.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;

/**
 * Class for member creation.
 */
public class Member {
  private String name;
  private String mail;
  private String memberId;
  private String phoneNumber;
  private Integer credits;
  private Integer createDay;
  public ArrayList<Item> itemList = new ArrayList<Item>();

  /**
   * For creating member objects.
   */
  public Member(String name, String mail, String memberId, String phoneNumber, Integer credits, int createDay) {
    this.name = name;
    this.mail = mail;
    this.memberId = memberId;
    this.phoneNumber = phoneNumber;
    this.credits = credits;
    this.createDay = createDay;
  }

  public Member() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getpNumber() {
    return phoneNumber;
  }

  public void setpNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Integer getCredits() {
    return credits;
  }

  public void setCredits(Integer credits) {
    this.credits = credits;
  }

  public Integer getCreateDay() {
    return createDay;
  }

  public void setCreateDay(Integer createDay) {
    this.createDay = createDay;
  }

  /**
   * Getter for getting a specific members whole list if items.
   *
   * @return List of a members items.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "To not have to deal with deep copies.")
  public ArrayList<Item> getItemList() {
    ArrayList<Item> copyList = new ArrayList<>();
    for (Item item : itemList) {
      copyList.add(item);
    }
    return copyList;
  }

  /**
   * will remove a item from a member by adding all of the members items to a copy
   * list
   * except for the item the user wants to delete.
   *
   * @param member Takes member so the function can know which member it wants to
   *               delete item from.
   * @param itemId Takes item id so the function can know which item to remove.
   */
  public void delItem(Member member, String itemId) {
    ArrayList<Item> templist = new ArrayList<>();
    for (Item item : itemList) {
      if (!item.getItemId().equals(itemId)) {
        templist.add(item);
      }
    }
    itemList = templist;
  }

  public void addItem(Item item) {
    itemList.add(item);
  }

  /**
   * Get a specific item from a member using a item's id.
   *
   * @param itemId requires a item's id to get a specific item.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "To not have to deal with deep copies.")
  public Object getItem(String itemId) {
    for (Item item : itemList) {
      if (item.getName().equals(itemId)) {
        return item;
      }
    }
    return null;
  }

}
