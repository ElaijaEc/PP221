package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   @PersistenceContext
   private Session session;

   @Override
   public void add(User user) {
      session.save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=session.createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(int series, String model) {
      TypedQuery<User> query = session.createQuery("from User user where car.model = :model and car.series = :series");
      query
              .setParameter("series",series)
              .setParameter("model",model);
      return query.getSingleResult();
   }

}
