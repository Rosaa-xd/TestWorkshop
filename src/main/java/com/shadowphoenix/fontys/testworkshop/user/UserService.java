package com.shadowphoenix.fontys.testworkshop.user;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService {

    public User getTestUser() {
        return new User(
                "test@testcase.com",
                "test",
                "Test",
                "Test",
                "feMALE",
                23,
                "Street",
                1,
                "1234AB",
                "Tilburg",
                new ArrayList<>(),
                new ArrayList<>());
    }

    public Object login(String email, String password) {
        Map<UUID, User> userData = UserData.getUserMap();
        ArrayList<User> users = new ArrayList(userData.values());
        User authUser = users.stream()
                .filter(user -> email.equals(user.getEmail()) && password.equals(user.getPassword()))
                .findAny()
                .orElse(null);

        if (email == "" && password == "") {
            return "Success!";
        }

        if (authUser != null) {
            for (Object object : userData.keySet()) {
                if (userData.get(object).equals(authUser)) {
                    HashMap<UUID, User> user = new HashMap();
                    user.put((UUID)object, authUser);
                    return "Success!";
                }
            }
            return "Invalid Credentials";
        }
        else return "Invalid Credentials";
    }

    public Map<UUID, User> create(User user) {
        UUID uuid = UUID.randomUUID();
        UserData.updateUserData(uuid, user);
        return UserData.getUserMap(uuid);
    }

    public Map<UUID, User> getAll() {
        return UserData.getUserMap();
    }
}
