package ru.ifmo.fake;

import ru.ifmo.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FakeStorage {
  // переменная, которая хранит ссылку на единственный экземпляр объекта класса FakeStorage
  private static final FakeStorage storage;

  // статически инициализатор, создающий объект класса FakeStorage. Вызывается один раз при загрузке класса в JVM
  static {
    storage = new FakeStorage();
  }

  // поле-список, хранящее список пользователей системы
  private List<User> users;

  // приватный констуктор, выполняющий инициализацию списка
  private FakeStorage() {
    this.users = new ArrayList<>();
    User user1 = new User("Roma", "qwe", LocalDate.parse("1984-02-02"));
    User user2 = new User("Gleb", "qwe123", LocalDate.parse("1999-03-02"));
    User user3 = new User("Stepa", "q456we", LocalDate.parse("1904-02-02"));
    this.users.addAll(Arrays.asList(user1, user2,user3));
  }

  // метод, предоставляющий доступ к объекту класса
  public static FakeStorage storage() {
    return storage;
  }

  // метод, возвращающий список пользователей
  public List<User> users() {
    return users;
  }
}