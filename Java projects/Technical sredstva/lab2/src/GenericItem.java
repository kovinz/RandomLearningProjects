public class GenericItem implements Cloneable{
  protected int ID;
  protected String name;
  protected float price;
  protected GenericItem analog;
  protected Category category = Category.GENERAL;

  public GenericItem clone() {
    return new GenericItem(ID, name, price, analog != null ? analog.clone() : null, category);
  }

  public GenericItem() {
  }

  public GenericItem(int ID, String name, float price) {
    this.ID = ID;
    this.name = name;
    this.price = price;
  }

  public GenericItem(int ID, String name, float price, Category category) {
    this.ID = ID;
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public GenericItem(int ID, String name, float price, GenericItem analog, Category category) {
    this.ID = ID;
    this.name = name;
    this.price = price;
    this.analog = analog;
    this.category = category;
  }

  public void printAll() {
    System.out.printf("ID: %d, Name: %-20s, price: %5.2f, category: %s \n", ID, name, price, category);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GenericItem)) return false;

    GenericItem that = (GenericItem) o;

    if (ID != that.ID) return false;
    if (Float.compare(that.price, price) != 0) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (analog != null ? !analog.equals(that.analog) : that.analog != null) return false;
    return category == that.category;
  }

  @Override
  public int hashCode() {
    int result = ID;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
    result = 31 * result + (analog != null ? analog.hashCode() : 0);
    result = 31 * result + (category != null ? category.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "GenericItem{" +
            "ID=" + ID +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", analog=" + analog +
            ", category=" + category +
            '}';
  }
}
