package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import model.domain.Contract;
import model.domain.Item;
import model.domain.LoanedSubscriber;

/**
 * Menu choices for contract.
 */

public class ContractChoices implements LoanedSubscriber {

  /**
   * Lets user make an basic input to set a start day of a new contract.
   */
  public String contractStartDay(Scanner info) {
    System.out.print("Enter the start day of the contract: ");
    String startDay = info.next();
    while (startDay.length() < 1 || !(Pattern.matches("[0-9]+", startDay))) {
      System.out.print("Select a valid day: ");
      startDay = info.next();
    }
    return startDay;
  }

  /**
   * Lets user make an basic input to set a end day of a new contract.
   */
  public String contractEndDay(Scanner info) {
    System.out.print("Enter the End day of the contract: ");
    String endDay = info.next();
    while (endDay.length() < 1 || !(Pattern.matches("[0-9]+", endDay))) {
      System.out.print("Select a valid day: ");
      endDay = info.next();
    }
    return endDay;
  }

  /**
   * Lets user choose a item through its ID.
   */
  public String contractId(Scanner info) {
    System.out.print("Enter the ID of the item for the contract: ");
    String contractId = info.next();
    while (contractId.length() < 1 || !(Pattern.matches("[0-9]+", contractId))) {
      System.out.print("Select a valid ID: ");
      contractId = info.next();
    }
    return contractId;
  }

  /**
   * Lets user choose who will be the lender of a contract.
   */
  public String contractLender(Scanner info) {
    System.out.print("Enter the ID of the lender: ");
    String lender = info.next();
    while (lender.length() != 6 || !(Pattern.matches("[a-zA-Z0-9]+", lender))) {
      System.out.print("Select a valid ID: ");
      lender = info.next();
    }
    return lender;
  }

  public void contractStartDayPrint(String day) {
    System.out.println(
        "start day of current contract: " + day);
  }

  public void contractEndDayPrint(String day) {
    System.out.println(
        "end day of current contract: " + day);
  }

  /**
   * Creates a new Contract object and returns it to controller.
   *
   * @param info Scanner.
   * @param item Item we're making the contract for.
   * @return new Contract object for the item.
   */
  public Contract createContract(Scanner info, Item item) {
    String startDay = contractStartDay(info);
    String endDay = contractEndDay(info);
    String lender = contractLender(info);
    return new Contract(startDay, endDay, item, item.getCost(), lender);
  }

  @Override
  public void update(ArrayList<Contract> endingList, ArrayList<Contract> startingList) {
    for (Contract con : endingList) {
      System.out.println("Item: " + con.getItem().getName() + "s contract has expired.");
    }
    for (Contract con : startingList) {
      System.out.println("Item: " + con.getItem().getName() + "s contract has started.");

    }

  }

}
