import java.util.Date;

public class FoodItem extends GenericItem implements Cloneable{
  private Date dateOfIncome;
  private short expires;

  public FoodItem clone() {
    return new FoodItem(ID, name, price, analog != null ? analog.clone() : null, category, new Date(dateOfIncome.getTime()), expires);
  }

  public FoodItem() {
  }

  public FoodItem(int ID, String name, float price, Category category, Date dateOfIncome, short expires) {
    super(ID, name, price, category);
    this.dateOfIncome = dateOfIncome;
    this.expires = expires;
  }

  public FoodItem(int ID, String name, float price, GenericItem analog, Category category, Date dateOfIncome, short expires) {
    super(ID, name, price, analog, category);
    this.dateOfIncome = dateOfIncome;
    this.expires = expires;
  }

  @Override
  public void printAll() {
    super.printAll();
    System.out.printf("DateOfIncome: %s, Expires: %d\n", dateOfIncome, expires);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof FoodItem)) return false;
    if (!super.equals(o)) return false;

    FoodItem foodItem = (FoodItem) o;

    if (expires != foodItem.expires) return false;
    return dateOfIncome != null ? dateOfIncome.equals(foodItem.dateOfIncome) : foodItem.dateOfIncome == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (dateOfIncome != null ? dateOfIncome.hashCode() : 0);
    result = 31 * result + (int) expires;
    return result;
  }

  @Override
  public String toString() {
    return "FoodItem{" +
            "dateOfIncome=" + dateOfIncome +
            ", expires=" + expires +
            ", ID=" + ID +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", analog=" + analog +
            ", category=" + category +
            '}';
  }
}
