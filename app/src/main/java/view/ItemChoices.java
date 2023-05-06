package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import model.domain.Contract;
import model.domain.ContractManager;
import model.domain.Item;

/**
 * Class containing choises related to items.
 */
public class ItemChoices {

  /**
   * Constant values for use in switch case.
   */
  public static enum ItemChoiceEvent {

    Tool,

    Vehicle,

    Game,

    Toy,

    Sport,

    Other,

    GoBack

  }

  /**
   * Menu for item creation, lets user choose what type of item to create.
   * Has simple error checking.
   */
  public ItemChoiceEvent itemChoice(Scanner info) {
    System.out.println("""
        ----------------------------------------
        1. Tool.
        2. Vehicle.
        3. Game.
        4. Toy.
        5. Sport.
        6. Other.
        press anywhere else to go back.""");
    System.out.print("Select a item: ");
    String choice = info.next();
    try {
      if (choice.equals("1")) {
        return ItemChoiceEvent.Tool;
      } else if (choice.equals("2")) {
        return ItemChoiceEvent.Vehicle;
      } else if (choice.equals("3")) {
        return ItemChoiceEvent.Game;
      } else if (choice.equals("4")) {
        return ItemChoiceEvent.Toy;
      } else if (choice.equals("5")) {
        return ItemChoiceEvent.Sport;
      } else if (choice.equals("6")) {
        return ItemChoiceEvent.Other;
      } else {
        return ItemChoiceEvent.GoBack;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return ItemChoiceEvent.GoBack;
  }

  /**
   * Lets user set a name for a new or existing item.
   * Has simple error checking.
   */
  public String itemName(Scanner info) {
    System.out.print("Select a name for the item: ");
    info.nextLine();
    String itemName = info.nextLine();
    while (itemName.length() < 3 || !(Pattern.matches("[a-zA-Z ]+", itemName))) {
      System.out.print("Select a valid name: ");
      itemName = info.next();
    }
    return itemName;
  }

  /**
   * Lets user set a cost for a new or existing item.
   * Has simple error checking.
   */
  public Integer itemCost(Scanner info) {
    String itemCost = "0";
    System.out.print("Select a cost of the item: ");
    itemCost = info.next();
    while (itemCost.toString().length() > 10000000 || !(Pattern.matches("[0-9]+", itemCost.toString()))) {
      System.out.print("Select a valid integer: ");
      itemCost = info.next();
    }
    return Integer.parseInt(itemCost);
  }

  /**
   * Lets user set a description for a new or existing item.
   * Has simple error checking.
   */
  public String itemDescription(Scanner info) {
    System.out.print("describe the item: ");
    info.nextLine();
    String itemDescription = info.nextLine();
    while (itemDescription.length() < 3 || !(Pattern.matches("[a-zA-Z.!? ]+", itemDescription))) {
      System.out.print("write a valid description: ");
      itemDescription = info.next();
    }
    return itemDescription;
  }

  /**
   * Lets user select an item through item id input.
   */
  public String itemSelection(Scanner info) {
    System.out.print("Select item id: ");
    String id = info.next();
    while (id.length() < 1 || !(Pattern.matches("[0-9]+", id))) {
      System.out.print("Select a valid ID: ");
      id = info.next();
    }
    return id;
  }

  /**
   * Lets user get information about an item and its contracts.
   */
  public void itemInformation(ContractManager contractmanager, String itemId, Item item) {
    System.out.println("Name: " + item.getName());
    System.out.println("Cost: " + String.valueOf(item.getCost()));
    System.out.println("Description: " + item.getInfo());
    System.out.println("Type: " + item.getType());
    ArrayList<Contract> itemsContracts = contractmanager.getItemsContracts(itemId);
    if (item.getLoaned()) {
      System.out.println("Is loaned: Yes");
    } else {
      System.out.println("Is loaned: No");
    }
    System.out.println("Contract amount: " + String.valueOf(itemsContracts.size()));
    for (Contract contract : itemsContracts) {
      System.out.println("Start day: " + contract.getStartDay());
      System.out.println("End day: " + contract.getEndDay());
      System.out.println("Cost: " + contract.getCost());
      System.out.println("Lender id: " + contract.getLender());
    }
  }

  public void itemPrint(String itemName) {
    System.out.println("<------item------>");
    System.out.println("item name: " + itemName);
  }

  public void showItemId(String id) {
    System.out.println("Item ID: " + id);
  }

  public void showItemCost(int cost) {
    System.out.println("Item cost: " + cost);
  }

  public void showItemType(String type) {
    System.out.println("Item type: " + type + "\n");
  }

  /**
   * function to print items from a list, together with their cost.
   */
  public void printPriceSearchList(ArrayList<Item> list) {
    for (Item item : list) {
      System.out.println("Item name: " + item.getName() + " price: " + item.getCost());
    }
  }

  /**
   * function to print the name of all items from a list.
   */
  public void printNameSearchList(ArrayList<Item> list) {
    for (Item item : list) {
      System.out.println("Item name: " + item.getName());
    }
  }

}
