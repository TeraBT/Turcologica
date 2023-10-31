package com.turcologica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

//	@Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/add")
//    public String addUser(@RequestParam String first, @RequestParam String last) {
//        User user = new User();
//        user.setFirstName(first);
//        user.setLastName(last);
//        userRepository.save(user);
//        return "User added to repository.";
//    }
//
//    @GetMapping("/list")
//    public Iterable<User> getUsers() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/find/{id}")
//    public User findUserById(@PathVariable Integer id) {
//        return userRepository.findUserById(id);
//    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String addUser(@RequestParam String first, @RequestParam String last) {
        User user = new User();
        user.setFirstName(first);
        user.setLastName(last);
        userRepository.save(user);
        return "New user account was added to the repository.";
    }

    @GetMapping("/list")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public User findUserById(@PathVariable Long id) {
        return userRepository.findUserById(id);
    }
}
