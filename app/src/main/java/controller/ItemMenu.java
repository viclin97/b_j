package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.domain.ContractManager;
import model.domain.Game;
import model.domain.Item;
import model.domain.ItemManager;
import model.domain.Member;
import model.domain.Other;
import model.domain.Sport;
import model.domain.Tools;
import model.domain.Toy;
import model.domain.Vehicle;
import view.ItemChoices;
import view.ItemChoices.ItemChoiceEvent;
import view.MemberChoices;
import view.MenuChoices;
import view.MenuChoices.ItemMenuEvent;

/**
 * Class for the member menu.
 * 
 */
public class ItemMenu {

  /**
   * Switch case to navigate the different options for items.
   */
  public void itemMenu(Scanner info, ContractManager contractManager, ArrayList<Member> memberList,
      ItemManager itemManager, MenuChoices menu, ItemChoices itemChoices, MemberChoices memberChoices) {
    ItemMenuEvent choice = menu.itemMenu(info);
    switch (choice) {

      // item creation
      case ItemCreate:
        createItem(info, memberList, itemManager, itemChoices, memberChoices);
        break;
      // item deletion
      case ItemDelete:
        deleteItem(info, memberList, itemChoices);
        break;

      // change item information
      case ItemModify:
        modifyItem(info, memberList, itemChoices);
        break;

      // view item information
      case ShowSpecificItem:
        itemInfo(info, memberList, contractManager, itemChoices);
        break;
      default:
        break;
    }
  }

  private void createItem(Scanner info, ArrayList<Member> memberList, ItemManager itemManager, ItemChoices itemChoices,
      MemberChoices memberChoices) {
    ItemChoiceEvent itemType = itemChoices.itemChoice(info);
    String itemName = itemChoices.itemName(info);
    int itemCost = itemChoices.itemCost(info);
    String memId = memberChoices.memberSelection(info);
    String itemInfo = itemChoices.itemDescription(info);
    switch (itemType) {
      // tool
      case Tool:
        for (Member member : memberList) {
          if (member.getMemberId().equals(memId)) {
            member.setCredits(member.getCredits() + 100);
            member.addItem(new Tools(itemName, false, itemCost, itemInfo, "Tool",
                itemManager.generateId()));
          }
        }
        break;

      // vehicle
      case Vehicle:
        for (Member member : memberList) {
          if (member.getMemberId().equals(memId)) {
            member.setCredits(member.getCredits() + 100);
            member.addItem(new Vehicle(itemName, false, itemCost, itemInfo, "Vehicle",
                itemManager.generateId()));
          }
        }
        break;

      // Game
      case Game:
        for (Member member : memberList) {
          if (member.getMemberId().equals(memId)) {
            member.setCredits(member.getCredits() + 100);
            member.addItem(new Game(itemName, false, itemCost, itemInfo, "Game",
                itemManager.generateId()));
          }
        }
        break;

      // toy
      case Toy:
        for (Member member : memberList) {
          if (member.getMemberId().equals(memId)) {
            member.setCredits(member.getCredits() + 100);
            member.addItem(new Toy(itemName, false, itemCost, itemInfo, "Toy",
                itemManager.generateId()));
          }
        }
        break;

      // sport
      case Sport:
        for (Member member : memberList) {
          if (member.getMemberId().equals(memId)) {
            member.setCredits(member.getCredits() + 100);
            member.addItem(new Sport(itemName, false, itemCost, itemInfo, "Sport",
                itemManager.generateId()));
          }
        }
        break;

      // other
      case Other:
        for (Member member : memberList) {
          if (member.getMemberId().equals(memId)) {
            member.setCredits(member.getCredits() + 100);
            member.addItem(new Other(itemName, false, itemCost, itemInfo, "Other",
                itemManager.generateId()));
          }
        }
        break;
      default:
        break;
    }
  }

  private void deleteItem(Scanner info, ArrayList<Member> memberList, ItemChoices itemChoices) {
    String itemId = itemChoices.itemSelection(info);
    for (Member member : memberList) {
      member.delItem(member, itemId);
    }
  }

  private void modifyItem(Scanner info, ArrayList<Member> memberList, ItemChoices itemChoices) {
    String itemId = itemChoices.itemSelection(info);
    String itemName = itemChoices.itemName(info);
    int itemCost = itemChoices.itemCost(info);
    String itemInfo = itemChoices.itemDescription(info);
    for (Member member : memberList) {
      for (Item item : member.getItemList()) {
        if (item.getItemId().equals(itemId)) {
          item.setName(itemName);
          item.setCost(itemCost);
          item.setInfo(itemInfo);
        }
      }
    }
  }

  private void itemInfo(Scanner info, ArrayList<Member> memberList, ContractManager contractManager,
      ItemChoices itemChoices) {
    String itemId = itemChoices.itemSelection(info);
    for (Member member : memberList) {
      for (Item item : member.getItemList()) {
        if (item.getItemId().equals(itemId)) {
          itemChoices.itemInformation(contractManager, itemId, item);
        }
      }
    }
  }
}
