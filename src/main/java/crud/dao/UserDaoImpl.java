package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = getById(id);
        entityManager.remove(user);
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }
}
