package crud;

import crud.config.AppConfig;
import crud.model.User;
import crud.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (GenericApplicationContext springContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            UserService service = springContext.getBean(UserService.class);
            try {
                service.add(new User("User1", "LastNameUser1", 35));
                service.add(new User("User2", "LastNameUser2", 37));
                service.add(new User("User3", "LastNameUser3", 48));
                service.add(new User("User4", "LastNameUser4", 54));


                var all = service.getAll();
                for (User user : all) {
                    System.out.println(user);
                }

                System.out.println("\n\n\n-------- get By ID -----------\n");
                System.out.println(service.get(2));
                User updateUser = service.get(2);
                updateUser.setAge(49);
                service.update(updateUser);

                System.out.println("\n\n\n-------- updating User -----------\n");
                System.out.println(service.get(2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}