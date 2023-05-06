package model.domain;

/**
 * Abstract class item used to create and modify item subclasses.
 */
public abstract class Item {
  protected String name;
  protected Boolean loaned;
  protected Integer cost;
  protected String info;
  protected String type;
  protected String itemId;

  public Item() {
  }

  public void setName(String thename) {
    name = thename;
  }

  public String getName() {
    return name;
  }

  public void setLoaned(Boolean theloan) {
    loaned = theloan;
  }

  public Boolean getLoaned() {
    return loaned;
  }

  public void setCost(Integer thecost) {
    cost = thecost;
  }

  public Integer getCost() {
    return cost;
  }

  public void setInfo(String theinfo) {
    info = theinfo;
  }

  public String getInfo() {
    return info;
  }

  public void setType(String thetype) {
    type = thetype;
  }

  public String getType() {
    return type;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getItemId() {
    return itemId;
  }
}
