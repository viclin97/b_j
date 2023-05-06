package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.domain.Contract;
import model.domain.ContractManager;
import model.domain.Item;
import model.domain.ItemManager;
import model.domain.Member;
import model.domain.MemberManager;
import model.domain.NameSearchStrategy;
import model.domain.PriceSearchStrategy;
import model.domain.Time;
import view.ContractChoices;
import view.ItemChoices;
import view.MemberChoices;
import view.MenuChoices;
import view.MenuChoices.MainMenuEvent;

/**
 * Class for the main menu.
 * 
 */
public class MainMenu {
  MenuChoices menu = new MenuChoices();
  MemberChoices memberChoices = new MemberChoices();
  ItemChoices itemChoices = new ItemChoices();
  ContractChoices contractChoices = new ContractChoices();
  MemberMenu memberMenu = new MemberMenu();
  ItemMenu itemMenu = new ItemMenu();
  boolean activeMenu = true;

  /**
   * The main menu of the program, all navigation starts from here.
   * 
   */
  public void mainMenu(Scanner info, Time day, ArrayList<Member> memberList, ContractManager contractManager,
      MemberManager memberManager, ItemManager itemManager) {

    contractManager.addSub(contractChoices);
    PriceSearchStrategy priceStrat = new PriceSearchStrategy();
    System.out.println("------------------------------");
    priceStrat.searchQuery(10);
    itemChoices.printPriceSearchList(priceStrat.getPriceList(memberManager));
    System.out.println("------------------------------");
    NameSearchStrategy nameStrat = new NameSearchStrategy();
    nameStrat.searchQuery("volvo");
    itemChoices.printNameSearchList(nameStrat.getNameList(memberManager));

    while (activeMenu) {
      MainMenuEvent choice = menu.startMenu(info, day.getDay());
      switch (choice) {
        // member menu
        case MemberMenu:
          memberMenu.memberMenu(info, menu, contractManager, memberManager, day, memberChoices, memberList, itemChoices,
              contractChoices);
          break;

        case ItemMenu:
          // item menu
          itemMenu.itemMenu(info, contractManager, memberList, itemManager, menu, itemChoices, memberChoices);
          break;
        case Contract:
          contractCreation(memberChoices, contractChoices, info, memberList, contractManager, memberManager);
          break;
        case IncreaseDay:
          contractManager.loanedMessage(day.getDay().toString());
          // increase day
          day.increaseDay();
          contractManager.calculateCosts(memberList, day.getDay(), new Member());

          break;
        case Quit:
          activeMenu = false;
          break;
        default:
          break;

      }
    }
  }

  private void contractCreation(MemberChoices memberChoices, ContractChoices contractChoices, Scanner info,
      ArrayList<Member> memberList, ContractManager contractManager, MemberManager memberManager) {
    String memberId = memberChoices.memberSelection(info);
    String itemId = contractChoices.contractId(info);
    for (Member member : memberList) {
      if (member.getMemberId().equals(memberId)) {
        for (Item item : member.getItemList()) {
          if (item.getItemId().equals(itemId)) {
            Contract contract = contractChoices.createContract(info, item);
            contractManager.addContract(contract);
          }
        }
      }
    }
  }

}
