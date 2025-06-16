package com.Farhan675.NoteSharer.controller;

import com.Farhan675.NoteSharer.model.User;
import com.Farhan675.NoteSharer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {



    public UserService userService = new UserService();

    @PostMapping("register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
}
