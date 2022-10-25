package com.example.restful.user;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepository {

    private static List<User> userRepository = new ArrayList<>();

    private static int userCount = 3;

    static {
        userRepository.add(new User(1, "Jinseok", LocalDate.now()));
        userRepository.add(new User(2, "Suchon", LocalDate.now()));
        userRepository.add(new User(3, "Roni", LocalDate.now()));
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }

        userRepository.add(user);

        return user;
    }

    public List<User> findAll() {
        return userRepository;
    }

    public User find(Integer id) {
        for (User user : userRepository) {
            if (Objects.equals(user.getId(), id)) return user;
        }

        return null;
    }

    public User deleteById(Integer id) {
        Iterator<User> iterator = userRepository.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (Objects.equals(user.getId(), id)) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
