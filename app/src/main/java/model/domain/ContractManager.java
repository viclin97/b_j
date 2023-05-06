package model.domain;

import java.util.ArrayList;

/**
 * Mangeing the contracts.
 */
public class ContractManager implements LoanedObserver {

  public ArrayList<Contract> contractList = new ArrayList<Contract>();

  public ContractManager() {
  }

  public ArrayList<LoanedSubscriber> subscriberList = new ArrayList<>();

  public void addSub(LoanedSubscriber newSub) {
    subscriberList.add(newSub);
  }

  @Override
  public void loanedMessage(String day) {
    for (LoanedSubscriber sub : subscriberList) {
      sub.update(getContractEndDay(day), getContractStartDay(day));
    }
  }

  /**
   * adds a contract.
   */
  public void addContract(Contract contract) {
    contractList.add(contract);
  }

  /**
   * Gets an item within a contract.
   */
  public ArrayList<Contract> getItemsContracts(String itemId) {
    ArrayList<Contract> tempContracts = new ArrayList<>();

    for (Contract contract : contractList) {
      if (contract.getItem().getItemId().equals(itemId)) {
        tempContracts.add(contract);
      }
    }
    return tempContracts;
  }

  /**
   * Deletes a contract.
   */
  public void delContract(Contract delContract) {
    contractList.remove(delContract);
  }

  /**
   * Getter for an items contracts.
   *
   * @param item Item you want to get contracts for.
   * @return The contract of the item inserted in the parameter.
   */
  public ArrayList<Contract> getContractsForItem(Item item) {
    ArrayList<Contract> itemContracts = new ArrayList<>();
    for (Contract cont : contractList) {
      if (cont.getItem().equals(item)) {
        itemContracts.add(cont);
      }
    }
    return itemContracts;
  }

  /**
   * What contracts are ending on a specific day.
   */
  public ArrayList<Contract> getContractEndDay(String day) {
    ArrayList<Contract> endingList = new ArrayList<Contract>();

    for (Contract contract : contractList) {
      if (contract.getEndDay().equals(day)) {
        endingList.add(contract);
      }
    }
    return endingList;
  }

  /**
   * What contracts are starting on a specific day.
   */
  public ArrayList<Contract> getContractStartDay(String day) {
    ArrayList<Contract> ongoingList = new ArrayList<Contract>();

    for (Contract contract : contractList) {
      if (contract.getStartDay().equals(day)) {
        ongoingList.add(contract);
      }
    }
    return ongoingList;
  }

  /**
   * Calculates the cost of every memeber who has a contract, and sumbtracts that
   * amaount for each passing day.
   */
  public void calculateCosts(ArrayList<Member> memberList, Integer currentDay, Member lenderMember) {
    Integer cost = 0;

    for (Contract contract : contractList) {
      cost = contract.getCost();
      if (Integer.parseInt(contract.getEndDay()) >= currentDay
          && Integer.parseInt(contract.getStartDay()) <= currentDay) {
        for (Member member : memberList) {
          if (member.getMemberId().equals(contract.getLender())) {
            lenderMember = member;
          }
        }
        lenderMember.setCredits(lenderMember.getCredits() - cost);
        for (Member member : memberList) {
          for (Item item : member.getItemList()) {
            if (item.equals(contract.getItem())) {
              member.setCredits(member.getCredits() + cost);
            }
          }
        }
      }
    }
  }

}
