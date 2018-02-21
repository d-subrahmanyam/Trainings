package com.subbu.estore.scripts;

import com.subbu.estore.dtos.User;
import com.subbu.estore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by subbu on 21/02/18.
 */

@Component
public class SeedDataComponent implements CommandLineRunner {

    @Autowired
    private UserService userService;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        /**
        System.out.println("*** Creating users ***");
        users().stream().forEach(user -> userService.add(user));
        */
        System.out.println("*** Finding a user by username ***");
        User _user = userService.findByUsername("subbu");
        System.out.println(_user);
        System.out.println("*** AuthN a user by username and password ***");
        User subbu = userService.authenticate("subbu", "test123");
        System.out.println(subbu);
        System.out.println("*** Get all users ***");
        Collection<User> users = userService.all();
        users.stream().forEach(user -> System.out.println(user));
    }

    private List<User> users() {
        List<User> users = new ArrayList<>();
        User subbu = new User("subrahmanyamd", "test123", "Subrahmanyam", "Devarakonda","Flat-205, Block-A, SHT", "Miyapur", "Hyderbad","TS","500049","India");
        users.add(subbu);
        User karthik = new User("d.subrahmanyam", "test123", "Karthikeya", "Devarakonda","Flat-205, Block-A, SHT", "Miyapur", "Hyderbad","TS","500049","India");
        users.add(karthik);
        return users;
    }
}
