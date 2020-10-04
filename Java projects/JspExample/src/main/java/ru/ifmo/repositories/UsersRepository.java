package ru.ifmo.repositories;

import ru.ifmo.models.User;

import java.util.List;

public interface UsersRepository {
  List<User> getAll();
  void save(User user);
  boolean exists(String name, String password);
}
