package model.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * class for creating contract objects.
 */
public class Contract {
  private String startDay;
  private String endDay;
  private Item item;
  private Integer cost;
  private String lender;

  /**
   * Constructor for creating contract objects.
   * Contains deepcopy of item.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "To not have to deal with deep copies.")
  public Contract(String startDay, String endDay, Item item, Integer cost, String lender) {
    this.startDay = startDay;
    this.endDay = endDay;
    this.item = item;
    this.cost = cost;
    this.lender = lender;
  }

  public Contract() {

  }

  public String getStartDay() {
    return startDay;
  }

  public void setStartDay(String startDay) {
    this.startDay = startDay;
  }

  public String getEndDay() {
    return endDay;
  }

  public void setEndDay(String endDay) {
    this.endDay = endDay;
  }

  /**
   * Returns a copy to prevent untrusted code to access the internal
   * representation.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "To not have to deal with deep copies.")
  public Item getItem() {
    return item;
  }

  /**
   * Creates a deepcopy of item before setter is used.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "To not have to deal with deep copies.")
  public void setItem(Item item) {
    this.item = item;

  }

  public Integer getCost() {
    return cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }

  public String getLender() {
    return lender;
  }

  public void setLender(String lender) {
    this.lender = lender;
  }
}
