import java.util.Date;

public class TechnicalItem extends GenericItem implements Cloneable {
  private short warrantyTime;

  public TechnicalItem clone() {
    return new TechnicalItem(ID, name, price, analog != null ? analog.clone() : null, category, (short) warrantyTime);
  }

  public TechnicalItem() {
  }

  public TechnicalItem(int ID, String name, float price, GenericItem analog, Category category, short warrantyTime) {
    super(ID, name, price, analog, category);
    this.warrantyTime = warrantyTime;
  }

  @Override
  public void printAll() {
    super.printAll();
    System.out.printf("WarrantyTime: %d\n", warrantyTime);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TechnicalItem)) return false;

    TechnicalItem that = (TechnicalItem) o;

    return warrantyTime == that.warrantyTime;
  }

  @Override
  public int hashCode() {
    return warrantyTime;
  }

  @Override
  public String toString() {
    return "TechnicalItem{" +
            "warrantyTime=" + warrantyTime +
            ", ID=" + ID +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", analog=" + analog +
            ", category=" + category +
            '}';
  }
}
