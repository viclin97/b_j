package model.domain;

/**
 * Day counter, allowing us to go forward one day, or go backwards one day.
 */
public class Time {

  private Integer days = 0;

  public Time() {
  }

  public void setDay(Integer currentDay) {
    days = currentDay;
  }

  public Integer getDay() {
    return days;
  }

  public void increaseDay() {
    days++;
  }

  /**
   * Decreases current day by one, with basic error checking.
   */
  public void decreaseDay() {
    if (days == 0) {
      ;
    } else {
      days--;
    }

  }
}
