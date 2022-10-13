package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(int id);
    List<User> getAll();

    User getById(Integer id);

    void update(User user);
}
