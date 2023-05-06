package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.domain.ContractManager;
import model.domain.ItemManager;
import model.domain.Member;
import model.domain.MemberManager;
import model.domain.Time;
import model.persistence.FileManager;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {

    FileManager loading = new FileManager();
    MemberManager memberManager = new MemberManager();
    loading.getMembers(memberManager);
    loading.getItems(memberManager);
    ContractManager contractManager = new ContractManager();
    loading.getContract(memberManager, contractManager);
    ArrayList<Member> memberList = memberManager.memberList;
    controller.MainMenu main = new controller.MainMenu();
    ItemManager itemManager = new ItemManager();
    Time day = new Time();
    Scanner info = new Scanner(System.in, "UTF-8");
    main.mainMenu(info, day, memberList, contractManager, memberManager, itemManager);

  }
}
