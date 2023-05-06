package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.domain.Contract;
import model.domain.ContractManager;
import model.domain.Item;
import model.domain.Member;
import model.domain.MemberManager;
import model.domain.Time;
import view.ContractChoices;
import view.ItemChoices;
import view.MemberChoices;
import view.MemberChoices.MemberModifyEvent;
import view.MenuChoices;
import view.MenuChoices.MemberMenuEvent;

/**
 * Class for the member menu.
 *
 */
public class MemberMenu {

  /**
   * Switch case to navigate the different options for members.
   */
  public void memberMenu(Scanner info, MenuChoices menu, ContractManager contractManager,
      MemberManager memberManager, Time day, MemberChoices memberChoices, ArrayList<Member> memberList,
      ItemChoices itemChoices, ContractChoices contractChoices) {
    MemberMenuEvent choice = menu.memberMenu(info);
    switch (choice) {
      // creates a new member
      case MemberCreate:
        createMember(info, contractManager, memberManager, day, memberChoices);
        break;
      // removes a selected member
      case MemberDelete:
        deleteMember(info, memberManager, memberChoices);
        break;
      // modifies member
      case MemberModify:
        modifyMember(info, memberManager, memberChoices);
        break;
      // look at specific members information
      case ShowSpecificMember:
        showMember(info, memberList, contractManager, day, memberChoices, itemChoices, contractChoices);
        break;
      // list all members in a simple way
      case SimpleMemberList:
        showSimpleMemberList(memberList, memberChoices, itemChoices);
        break;
      // list all members in a verbose way
      case VerboseMemberList:
        showVerboseMemberList(memberList, contractManager, day, contractChoices, memberChoices, itemChoices);
        break;
      default:
        break;
    }
  }

  /**
   * Function that lets user modify members information.
   *
   * @param info          Scanner.
   * @param memberList    List of members to get the member we want.
   * @param memberManager Used in view to use getter functions.
   * @param memberChoices Used to get enum for the switch case and to get input from user.
   */
  private void modifyMember(Scanner info, MemberManager memberManager,
      MemberChoices memberChoices) {
    String modId = memberChoices.memberSelection(info);
    MemberModifyEvent choice = memberChoices.modificationMenu(info);
    switch (choice) {
      // change name of specific member
      case ChangeName:
        memberManager.getMember(modId).setName(memberChoices.memberName(info));
        break;
      // change mail of specific member
      case ChangeMail:
        memberManager.getMember(modId).setMail(memberChoices.memberMail(info, memberManager));
        break;
      // change phone number of specific member
      case ChangeNumber:
        memberManager.getMember(modId).setpNumber(memberChoices.memberPnumber(info, memberManager));
        break;
      case GoBack:
        break;
      default:
        break;
    }
  }

  private void createMember(Scanner info, ContractManager contractManager, MemberManager memberManager, Time day,
      MemberChoices memberChoices) {
    memberManager.addMember(memberChoices.createMember(info, day, memberManager));
  }

  private void deleteMember(Scanner info, MemberManager memberManager, MemberChoices memberChoices) {
    String delId = memberChoices.memberSelection(info);
    memberManager.delMember(delId);
  }

  private void showMember(Scanner info, ArrayList<Member> memberList, ContractManager contractManager, Time day,
      MemberChoices memberChoices, ItemChoices itemChoices, ContractChoices contractChoices) {
    String memId = memberChoices.memberSelection(info);
    for (Member member : memberList) {
      if (member.getMemberId().equals(memId)) {
        memberChoices.memberInfo(member.getName(), member.getMail(), member.getCredits(), member.getItemList(),
            member.getMemberId(), member.getpNumber());
        for (Item item : member.getItemList()) {
          itemChoices.itemPrint(item.getName());
          itemChoices.showItemId(item.getItemId());
          for (Contract contract : contractManager.getItemsContracts(item.getItemId())) {
            if (day.getDay().toString().equals(contract.getStartDay())) {
              contractChoices.contractStartDayPrint(contract.getStartDay());
              contractChoices.contractEndDayPrint(contract.getEndDay());
            }
          }
        }
      }
    }
  }

  private void showSimpleMemberList(ArrayList<Member> memberList, MemberChoices memberChoices,
      ItemChoices itemChoices) {
    for (Member member : memberList) {
      memberChoices.memberInfo(member.getName(), member.getMail(), member.getCredits(), member.getItemList(),
          member.getMemberId(), member.getpNumber());
      for (Item item : member.getItemList()) {
        itemChoices.itemPrint(item.getName());
        itemChoices.showItemId(item.getItemId());
      }

    }
  }

  private void showVerboseMemberList(ArrayList<Member> memberList, ContractManager contractManager, Time day,
      ContractChoices contractChoices, MemberChoices memberChoices, ItemChoices itemChoices) {
    for (Member member : memberList) {
      memberChoices.memberInfo(member.getName(), member.getMail(), member.getCredits(), member.getItemList(),
          member.getMemberId(), member.getpNumber());

      for (Item item : member.getItemList()) {
        itemChoices.itemPrint(item.getName());
        itemChoices.showItemId(item.getItemId());
        itemChoices.showItemCost(item.getCost());
        itemChoices.showItemType(item.getType());
        for (Contract c : contractManager.getItemsContracts(item.getItemId())) {
          if (day.getDay().toString().equals(c.getStartDay())) {
            contractChoices.contractStartDayPrint(c.getStartDay());
            contractChoices.contractEndDayPrint(c.getEndDay());
          }
        }
      }
    }
  }

}
