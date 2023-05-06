package model.persistence;

import model.domain.Contract;
import model.domain.ContractManager;
import model.domain.Game;
import model.domain.Item;
import model.domain.Member;
import model.domain.MemberManager;
import model.domain.Other;
import model.domain.Sport;
import model.domain.Toy;
import model.domain.Vehicle;

/**
 * Class that has loading functions for hardcoded members/items/contracts.
 */
public class FileManager {

  /**
   * Creates hardcoded members.
   *
   * @param memberList List of all members.
   * 
   */
  public void getMembers(MemberManager memberList) {

    memberList.addMember(new Member("victor", "perkele@msn.se", "12aga2", "12346554", 500, 0));
    memberList.addMember(new Member("alex", "apgoma@hotmail.com", "1dgdga", "12387974", 100, 0));
    memberList.addMember(new Member("tim", "ompoampg@hotmail.com", "gop3m1", "12434542", 100, 0));
  }

  /**
   * Creates hardcoded items.
   *
   * @param memberList List of all members.
   * 
   */
  public void getItems(MemberManager memberList) {
    for (Member member : memberList.memberList) {
      if (member.getMemberId().equals("12aga2")) {
        member.addItem(new Game("Skyrim: special edition", true, 50, "Game of the year", "game", "1"));
        member.addItem(new Other("water bottle 3000", false, 10, "just a regular water bottle", "other", "2"));
      } else if (member.getMemberId().equals("gop3m1")) {
        member.addItem(new Other("nokia 3310", false, 8, "hardest phone in existence", "other", "5"));
        member.addItem(new Sport("adidas r37", false, 8, "bestest pair of fotball shoes", "sport", "6"));
        member.addItem(new Toy("hotwheels red car", true, 3, "fast toy car", "toy", "7"));
        member.addItem(new Vehicle("volvo 740", true, 2, "v8 engine, turbo", "vehicle", "8"));
        member.addItem(new Vehicle("volvo V90", false, 10, "v6 engine, turbo", "vehicle", "9"));
        member.addItem(new Vehicle("volvo S90", false, 9, "v8 engine", "vehicle", "10"));
        member.addItem(new Vehicle("volvo 142", false, 11, "v4 engine", "vehicle", "11"));
        member.addItem(new Vehicle("volvo 360", false, 4, "i6", "vehicle", "12"));
      }
    }

  }

  /**
   * Creates hardcoded contracts for every item with start day 0 and end day 10.
   *
   * @param memberList List of all members.
   */
  public void getContract(MemberManager memberList, ContractManager contractmanager) {
    for (Member member : memberList.memberList) {
      for (Item item : member.getItemList()) {
        if (member.getMemberId().equals("12aga2") && item.getItemId().equals("2")) {
          contractmanager.addContract(new Contract("5", "7", item, item.getCost(), "gop3m1"));
          
        }
      }
    }
  }
}
