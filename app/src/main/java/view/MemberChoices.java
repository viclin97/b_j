package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import model.domain.Item;
import model.domain.Member;
import model.domain.MemberManager;
import model.domain.Time;

/**
 * Class containing choises related to members.
 */
public class MemberChoices {

  /**
   * Returns a chosen name with error checking.
   */
  public String memberName(Scanner info) {
    System.out.print("Select a first name: ");
    String firstName = info.next();
    System.out.print("Select a family name: ");
    info.nextLine();
    String familyName = info.nextLine();
    String fullname = firstName + " " + familyName;

    while (fullname.length() < 2 || !(Pattern.matches("[a-zA-Z ]+", fullname))) {
      System.out.print("Select a valid name");
      System.out.print("Select a first name: ");
      firstName = info.next();
      System.out.print("Select a family name: ");
      familyName = info.next();
      fullname = firstName + " " + familyName;
    }
    return fullname;
  }

  /**
   * Returns a chosen mail with error checking.
   */
  public String memberMail(Scanner info, MemberManager memberManager) {
    System.out.print("Select a mail: ");
    String mail = info.next();
    while (mail.length() < 6 || !(Pattern.matches("[a-zA-Z_0-9@._-]+", mail)) || memberManager.mailExists(mail)) {
      System.out.print("Select a valid mail and one that is not in use: ");
      mail = info.next();
    }
    return mail;
  }

  /**
   * Returns a chosen phone number with error checking.
   */
  public String memberPnumber(Scanner info, MemberManager memberManager) {
    String pnumber = "0";
    System.out.print("Select a phone number: ");
    pnumber = info.next();
    while (pnumber.toString().length() < 3 || !(Pattern.matches("[0-9]+", pnumber.toString()))
        || memberManager.phoneNumberExists(pnumber)) {
      System.out.print("Select a valid phone number and one that is not in use: ");
      pnumber = info.next();
    }
    return pnumber;
  }

  /**
   * Rets the user type a member id for member selection.
   */
  public String memberSelection(Scanner info) {
    System.out.print("ID of member you want to select: ");
    return info.next();
  }

  /**
   * Constant values for use in switch case.
   */
  public static enum MemberModifyEvent {

    ChangeName,

    ChangeMail,

    ChangeNumber,

    GoBack

  }

  /**
   * Menu inside the member menu for modifying a member.
   */
  public MemberModifyEvent modificationMenu(Scanner info) {

    System.out.println("""
        ----------------------------------------
        1. Change name.
        2. Change mail.
        3. Change phone number.
        press anywhere else to go back.""");
    System.out.print("Select one of the options: ");
    String choice = info.next();
    if (choice.equals("1")) {
      return MemberModifyEvent.ChangeName;
    } else if (choice.equals("2")) {
      return MemberModifyEvent.ChangeMail;
    } else if (choice.equals("3")) {
      return MemberModifyEvent.ChangeNumber;
    } else {
      return MemberModifyEvent.GoBack;
    }
  }

  /**
   * Prints a list of member information.
   */
  public void memberInfo(String name, String mail, Integer credits, ArrayList<Item> itemList, String memberId,
      String phoneNumber) {
    System.out.println("<-------member------->");
    System.out
        .println("Member: " + name + "\nMail: " + mail + "\nCredits: " + credits + "\nPhone number: " + phoneNumber
            + "\nID: " + memberId + "\nOwned items: " + itemList.size() + "\n");
  }

  /**
   * Creates a new Member object and returns it to the controller.
   *
   * @param info          Scanner.
   * @param day           Used to get the current day.
   * @param memberManager Used to generate a unique id for the member.
   * @return new Member object
   */
  public Member createMember(Scanner info, Time day, MemberManager memberManager) {
    String name = memberName(info);
    String mail = memberMail(info, memberManager);
    String phoneNumber = memberPnumber(info, memberManager);
    return new Member(name, mail, memberManager.generateMemberId(), phoneNumber, 0, day.getDay());
  }

}
