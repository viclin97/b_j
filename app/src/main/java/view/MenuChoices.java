package view;

import java.util.Scanner;

/**
 * Class containing choises related to the main menu.
 */
public class MenuChoices {

  /**
   * Constant values for use in switch case.
   */
  public static enum MainMenuEvent {

    MemberMenu,

    ItemMenu,

    Contract,

    IncreaseDay,

    Quit

  }

  /**
   * Menu that shows up as the application is started.
   *
   * @param day print for the current day.
   */
  public MainMenuEvent startMenu(Scanner info, int day) {
    System.out.println("""
        ----------------------------------------
        1. Member menu.
        2. Item menu.
        3. Contract creation.
        4. increase day
        today is day """ + " " + day + "\n" + """
        press anywhere else to exit the program.""");
    System.out.print("Select one of the options: ");
    try {
      String choice = info.next();
      if (choice.equals("1")) {
        return MainMenuEvent.MemberMenu;
      } else if (choice.equals("2")) {
        return MainMenuEvent.ItemMenu;
      } else if (choice.equals("3")) {
        return MainMenuEvent.Contract;
      } else if (choice.equals("4")) {
        return MainMenuEvent.IncreaseDay;
      } else {
        return MainMenuEvent.Quit;
      }
    } catch (Exception e) {
      System.out.println("invalid input");
      return MainMenuEvent.Quit;
    }

  }

  /**
   * Constant values for use in switch case.
   */
  public static enum MemberMenuEvent {

    MemberCreate,

    MemberDelete,

    MemberModify,

    ShowSpecificMember,

    SimpleMemberList,

    VerboseMemberList,

    GoBack

  }

  /**
   * Menu with all the member choices.
   */
  public MemberMenuEvent memberMenu(Scanner info) {

    System.out.println("""
        ----------------------------------------
        1. Member creation.
        2. Member deletion.
        3. Change member information.
        4. Specific member information.
        5. Simple member list.
        6. Verbose member list.
        press anywhere else to go back.""");
    System.out.print("Select one of the options: ");
    try {
      String choice = info.next();
      if (choice.equals("1")) {
        return MemberMenuEvent.MemberCreate;
      } else if (choice.equals("2")) {
        return MemberMenuEvent.MemberDelete;
      } else if (choice.equals("3")) {
        return MemberMenuEvent.MemberModify;
      } else if (choice.equals("4")) {
        return MemberMenuEvent.ShowSpecificMember;
      } else if (choice.equals("5")) {
        return MemberMenuEvent.SimpleMemberList;
      } else if (choice.equals("6")) {
        return MemberMenuEvent.VerboseMemberList;
      } else {
        return MemberMenuEvent.GoBack;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return MemberMenuEvent.GoBack;

  }

  /**
   * Constant values for use in switch case.
   */
  public static enum ItemMenuEvent {

    ItemCreate,

    ItemDelete,

    ItemModify,

    ShowSpecificItem,

    GoBack

  }

  /**
   * View all the item choices.
   */
  public ItemMenuEvent itemMenu(Scanner info) {

    System.out.println("""
        ----------------------------------------
        1. Item creation.
        2. Item deletion.
        3. Change item information.
        4. View a specific items information.
        press anywhere else to go back.""");
    System.out.print("Select one of the options: ");
    try {
      String choice = info.next();
      if (choice.equals("1")) {
        return ItemMenuEvent.ItemCreate;
      } else if (choice.equals("2")) {
        return ItemMenuEvent.ItemDelete;
      } else if (choice.equals("3")) {
        return ItemMenuEvent.ItemModify;
      } else if (choice.equals("4")) {
        return ItemMenuEvent.ShowSpecificItem;
      } else {
        return ItemMenuEvent.GoBack;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return ItemMenuEvent.GoBack;

  }

}
