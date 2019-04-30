package com.shadowphoenix.fontys.testworkshop.user;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class UserService {

    public User getTestUser() {
        return new User(
                "Test",
                "Test",
                "feMALE",
                23,
                "Street",
                1,
                "1234AB",
                "Tilburg",
                null);
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
