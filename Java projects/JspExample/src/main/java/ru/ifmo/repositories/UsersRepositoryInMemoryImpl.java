package ru.ifmo.repositories;

import ru.ifmo.fake.FakeStorage;
import ru.ifmo.models.User;

import java.util.List;

public class UsersRepositoryInMemoryImpl implements UsersRepository{

  public UsersRepositoryInMemoryImpl() {

  }
  public List<User> getAll(){
    return FakeStorage.storage().users();
  }

  public void save(User user){
    FakeStorage.storage().users().add(user);
  }

  @Override
  public boolean exists(String name, String password) {
    for (User user : FakeStorage.storage().users()) {
      if (user.getName().equals(name) &&
              user.getPassword().equals(password)) {
        return true;
      }
    }

    return false;
  }
}
