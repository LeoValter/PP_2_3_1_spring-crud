package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    User get(Integer id);

    void update(User user);

    void delete(int id);

    List<User> getAll();
}
