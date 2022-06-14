package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private SessionFactory sessionFactory;
   @Autowired
   public void SessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }
   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(int series, String model) {
      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("from User user where car.model = :model and car.series = :series");
      query
              .setParameter("series",series)
              .setParameter("model",model);
      return query.getSingleResult();
   }

}
