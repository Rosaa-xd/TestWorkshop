package com.shadowphoenix.fontys.testworkshop.user;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Map<UUID, User> addInterest(String uuidString, String interest) {
        UUID uuid = UUID.fromString(uuidString);
        User user = UserData.getUser(uuid);
        user.addInterest(interest);
        UserData.updateUserData(uuid, user);
        return UserData.getUserMap(uuid);
    }

    public Map<UUID, User> getById(String uuidString) {
        UUID uuid = UUID.fromString(uuidString);
        return UserData.getUserMap(uuid);
    }

    public HashMap<UUID, User> getByInterest(String interest) {
        Map<UUID, User> users = UserData.getUserMap();
        HashMap<UUID, User> matches = new HashMap<>();
        for (Map.Entry<UUID, User> entry : users.entrySet()) {
            if (entry.getValue().getInterests().contains(interest))
                matches.put(entry.getKey(), entry.getValue());
        }
        return matches;
    }

    public HashMap<UUID, User> getByAge(int age) {
        Map<UUID, User> users = UserData.getUserMap();
        HashMap<UUID, User> matches = new HashMap<>();
        for (Map.Entry<UUID, User> entry: users.entrySet()) {
            if (entry.getValue().getAge() == age) {
                matches. put(entry.getKey(), entry.getValue());
            }
        }
        return matches;
    }

    public HashMap<UUID, User> getByAgeRange(int minAge, int maxAge) {
        Map<UUID, User> users = UserData.getUserMap();
        HashMap<UUID, User> matches = new HashMap<>();
        for (Map.Entry<UUID, User> entry : users.entrySet()) {
            if (entry.getValue().getAge() < minAge || entry.getValue().getAge() > maxAge) {
                matches.put(entry.getKey(), entry.getValue());
            }
        }

        return matches;
    }

    public Map<UUID, User> addMatch(String uuidString, String matchuuidString) {
        UUID uuidUser = UUID.fromString(uuidString);
        UUID uuidMatch = UUID.fromString(matchuuidString);
        User user = UserData.getUser(uuidUser);
        user.addMatch(UserData.getUser(uuidMatch));
        UserData.updateUserData(uuidUser, user);
        return UserData.getUserMap(uuidUser);
    }

    public List<User> getMatches(@RequestParam("uuid") String uuidString) {
        UUID uuid = UUID.fromString(uuidString);
        return UserData.getUser(uuid).getMatches();
    }

    public Map<UUID, User> getAll() {
        return UserData.getUserMap();
    }
}
