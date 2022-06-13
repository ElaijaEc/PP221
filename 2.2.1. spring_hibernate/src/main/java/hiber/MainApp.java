package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car(443107,"Priora");
      Car car2 = new Car(443108,"Волга");
      Car car3 = new Car(443109,"GLS Coupe");
      Car car4 = new Car(443110,"A45s");

      userService.add(new User("Harry", "Potter", "potter@hogwarts.com",car1));
      userService.add(new User("Hermione", "Granger", "granger@hogwarts.com",car2));
      userService.add(new User("Ron", "Weasley", "weasley@hogwarts.com",car3));
      userService.add(new User("Sirius", "Black", "black@hogwarts.com",car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      System.out.println(userService.getUserByCar(443110,"A45s"));
      context.close();
   }
}
