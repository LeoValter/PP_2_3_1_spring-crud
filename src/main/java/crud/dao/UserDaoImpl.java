package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
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
//        TypedQuery<User> query = entityManager
//                .createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
//                .setParameter("id", id);
//        return query.setMaxResults(1).getSingleResult();
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}