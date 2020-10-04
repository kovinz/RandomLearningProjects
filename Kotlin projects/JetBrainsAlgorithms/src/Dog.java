public class Dog {
  private String name;
  private int age;

  public Dog() {
  }

  public Dog(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Dog)) return false;

    Dog dog = (Dog) o;

    if (age != dog.age) return false;
    return name != null ? name.equals(dog.name) : dog.name == null;

  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + age;
    return result;
  }
}
