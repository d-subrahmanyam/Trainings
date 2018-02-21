package com.subbu.estore.scripts;

import com.subbu.estore.entities.User;
import com.subbu.estore.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subbu on 21/02/18.
 */

@Component
public class SeedDataComponent implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void run(String... strings) throws Exception {
        List<User> users = users();
        userRepo.save(users);
    }

    private List<User> users() {
        List<User> users = new ArrayList<>();
        User subbu = new User("subbu", "test123", "Subrahmanyam", "Devarakonda","Flat-205, Block-A, SHT", "Miyapur", "Hyderbad","TS","500049","India");
        users.add(subbu);
        User karthik = new User("subbud", "test123", "Karthikeya", "Devarakonda","Flat-205, Block-A, SHT", "Miyapur", "Hyderbad","TS","500049","India");
        users.add(karthik);
        return users;
    }
}
