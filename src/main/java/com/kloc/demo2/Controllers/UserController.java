package com.kloc.demo2.Controllers;

import com.kloc.demo2.Entities.User;
import com.kloc.demo2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="getAll", method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        return users;
    }

    @RequestMapping(value="addUser", method=RequestMethod.POST)
    public void addUser(String name, String surname, String email, String password, String address){
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        userRepository.save(user);
    }

    @RequestMapping(value="findByEmail", method=RequestMethod.GET)
    public User findByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }

    @RequestMapping(value="deleteUser", method=RequestMethod.DELETE)
    public void deleteUser(String email){
        userRepository.delete(userRepository.findByEmail(email));
    }
}
