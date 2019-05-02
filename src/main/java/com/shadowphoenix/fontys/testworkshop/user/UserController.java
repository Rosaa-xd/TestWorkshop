package com.shadowphoenix.fontys.testworkshop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/test")
    public User getTestUser() {
        return userService.getTestUser();
    }

    @PostMapping("/user/login")
    public Object login(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userService.login(email, password);
    }

    @PostMapping("/user/create")
    public Map<UUID, User> create(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/user/addInterest")
    public Map<UUID, User> addInterest(@RequestParam("uuid") String uuid, @RequestParam String interest) {
        return userService.addInterest(uuid, interest);
    }

    @GetMapping("/user/byId")
    public Map<UUID, User> getById(@RequestParam("uuid") String uuid) {
        return userService.getById(uuid);
    }

    @GetMapping("/user/byInterest")
    public HashMap<UUID, User> getByInterest(@RequestParam("interest") String interest) {
        return userService.getByInterest(interest);
    }

    @GetMapping("/user/byAge")
    public HashMap<UUID, User> getByAge(@RequestParam("age") int age) {
        return userService.getByAge(age);
    }

    @GetMapping("/user/byAgeRange")
    public HashMap<UUID, User> getByAgeRange(@RequestParam("minAge") int minAge, @RequestParam("maxAge") int maxAge) {
        return userService.getByAgeRange(minAge, maxAge);
    }

    @PostMapping("/user/addMatch")
    public Map<UUID, User> addMatch(@RequestParam("uuid") String uuid, @RequestParam("matchuuid") String matchuuid) {
        return userService.addMatch(uuid, matchuuid);
    }

    @GetMapping("/user/matches")
    public List<User> getMatches(@RequestParam("uuid") String uuid) {
        return userService.getMatches(uuid);
    }

    @GetMapping("/users")
    public Map<UUID, User> getUsers() {
        return userService.getAll();
    }
}
