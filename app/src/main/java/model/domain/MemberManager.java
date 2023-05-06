package model.domain;

import java.util.ArrayList;
import java.util.UUID;

/**
 * All the members seters.
 */
public class MemberManager {
  public ArrayList<Member> memberList = new ArrayList<Member>();

  public MemberManager() {

  }

  /**
   * adds a member to the memberlist.
   */
  public void addMember(Member member) {
    memberList.add(member);
  }

  /**
   * Deletes a member.
   */
  public void delMember(String memberId) {
    ArrayList<Member> templist = new ArrayList<>();
    for (Member member : memberList) {
      if (!member.getMemberId().equals(memberId)) {
        templist.add(member);
      }
    }
    memberList = templist;
  }

  /**
   * Calls for a member.
   */
  public Member getMember(String memberId) {
    for (Member member : memberList) {
      if (member.getMemberId().equals(memberId)) {
        return member;
      }
    }
    return null;
  }

  /**
   * Checks if the ID is unique.
   */
  public boolean idExists(String memberId) {
    for (Member member : memberList) {
      if (member.getMemberId().equals(memberId)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if the mail is unique.
   */
  public boolean mailExists(String mail) {
    for (Member member : memberList) {
      if (member.getMail().equals(mail)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if the phone number is unique.
   */
  public boolean phoneNumberExists(String phoneNumber) {
    for (Member member : memberList) {
      if (member.getpNumber().equals(phoneNumber)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Creates a ID for the member.
   */
  public String generateMemberId() {
    String memberId = "";
    UUID randomAplhanumeric = UUID.randomUUID();
    memberId = randomAplhanumeric.toString().replaceAll("-", "");
    memberId = memberId.substring(0, 6);
    return memberId;

  }

  /**
   * Creates a deep copy of the items.
   */
  public Object getItem(Member member, String itemId) {
    for (Item item : member.getItemList()) {
      if (item.getName().equals(itemId)) {
        return item;
      }
    }
    return null;
  }

  /**
   * Goes through all the members to add all their items to a list.
   *
   * @return a list of all the existing items.
   */
  public ArrayList<Item> getAllItems() {
    ArrayList<Item> itemList = new ArrayList<>();
    for (Member member : memberList) {
      for (Item item : member.getItemList()) {
        itemList.add(item);
      }
    }
    return itemList;
  }

}
