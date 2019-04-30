package com.shadowphoenix.fontys.testworkshop.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.*;

public final class UserData {
    private static HashMap<UUID, User> users = new HashMap<>();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static User getUser(UUID uuid) {
        return users.get(uuid);
    }

    public static Map<UUID, User> getUserMap(UUID uuid) {
        Map<UUID, User> userMap = new HashMap<>();
        userMap.put(uuid, getUser(uuid));
        return userMap;
    }

    public static Map<UUID, User> getUserMap() {
        return users;
    }

    public static void updateUserData(UUID uuid, User user) {
        users.put(uuid, user);
        writeUserData();
    }

    public static void loadUserData() {
        try {
            List<User> userData = OBJECT_MAPPER.readValue(new ClassPathResource("userData.json").getFile(),
                    OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, User.class));
            for (User user :
                    userData) {
                UUID uuid = UUID.randomUUID();
                users.put(uuid, user);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void writeUserData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new ClassPathResource("userData.json").getFile(), new ArrayList(users.values()));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
