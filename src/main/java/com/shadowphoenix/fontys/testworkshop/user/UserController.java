package com.shadowphoenix.fontys.testworkshop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/user/create")
    public Map<UUID, User> create(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/user/addInterest")
    public User create(@RequestParam("uuid") int uuid, @RequestParam String interest) {
        return null;
    }

    @GetMapping("/user/byId")
    public User getById(@RequestParam("uuid") int uuid) {
        return null;
    }

    @GetMapping("/user/byInterest")
    public List<User> getByInterest(@RequestParam("interest") String interest) {
        return null;
    }

    @GetMapping("/user/byAge")
    public List<User> getByAge(@RequestParam("age") int age) {
        return null;
    }

    @GetMapping("/user/byAgeRange")
    public List<User> getByAgeRange(@RequestParam("minAge") int minAge, @RequestParam("maxAge") int maxAge) {
        return null;
    }

    @GetMapping("/user/matches")
    public List<User> getMatches(@RequestParam("uuid") int uuid) {
        return null;
    }

    @GetMapping("/users")
    public Map<UUID, User> getUsers() {
        return userService.getAll();
    }
}
