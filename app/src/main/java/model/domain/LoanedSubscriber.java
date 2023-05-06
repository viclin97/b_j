package model.domain;

import java.util.ArrayList;

/**
 * interface for the subscriber in the observer pattern.
 */
public interface LoanedSubscriber {

  public void update(ArrayList<Contract> endingList, ArrayList<Contract> startingList);
}