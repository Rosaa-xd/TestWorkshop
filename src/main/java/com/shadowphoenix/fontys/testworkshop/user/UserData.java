package com.shadowphoenix.fontys.testworkshop.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.*;

public final class UserData {
    private static HashMap<UUID, User> users = new HashMap<>();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String HOME = System.getProperty("user.home");
    private static final String USER_DATA_JSON = HOME + File.separator + "userData.json";

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
            File userDataFile = new File(USER_DATA_JSON);
            List<User> userData;
            if (userDataFile.exists()) {
                userData = OBJECT_MAPPER.readValue(userDataFile,
                        OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, User.class));
            }
            else {
                userData = OBJECT_MAPPER.readValue(new ClassPathResource("userData.json").getFile(),
                        OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, User.class));
            }
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
            File userDataFile = new File(USER_DATA_JSON);
            if (!userDataFile.exists()) userDataFile.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(userDataFile, new ArrayList(users.values()));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
