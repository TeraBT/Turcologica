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
    private UserAccountRepository userAccountRepository;

    @PostMapping("/add")
    public String addUserAccount(@RequestParam String first, @RequestParam String last) {
        UserAccount user = new UserAccount();
        user.setFirstName(first);
        user.setLastName(last);
        userAccountRepository.save(user);
        return "Added new customer to repo!";
    }

    @GetMapping("/list")
    public Iterable<UserAccount> getUserAccounts() {
        return userAccountRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public UserAccount findUserAccountById(@PathVariable Integer id) {
        return userAccountRepository.findUserAccountById(id);
    }
}
