package model.domain;

/**
 * interface for the subject in the observer pattern.
 */
public interface LoanedObserver {

  /**
   * update function for the subject.
   */
  void loanedMessage(String day);

}
