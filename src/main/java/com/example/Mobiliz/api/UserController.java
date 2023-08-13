package com.example.Mobiliz.api;

import com.example.Mobiliz.model.User;
import com.example.Mobiliz.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/endpoint")
    public ResponseEntity<String> someEndpoint(@RequestHeader("X-User") String xUserHeader) {
        try {
            JSONObject userJson = new JSONObject(xUserHeader);
            String userId = userJson.getString("userId");
            String name = userJson.getString("name");
            String surname = userJson.getString("surname");
            String companyId = userJson.getString("companyId");
            String companyName = userJson.getString("companyName");
            String role = userJson.getString("role");

            return ResponseEntity.ok("Endpoint response");
        } catch (JSONException e) {
            return ResponseEntity.badRequest().body("Invalid X-User header");
        }
    }

}
