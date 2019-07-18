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
    private UserRepository ur;

    @RequestMapping(value="getAll", method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users = ur.findAll();
        return users;
    }

    @RequestMapping(value="addUser", method=RequestMethod.POST)
    public void addUser(String name, String surname, String email, String password, String address){
        User u = new User();
        u.setName(name);
        u.setSurname(surname);
        u.setEmail(email);
        u.setPassword(password);
        u.setAddress(address);
        ur.save(u);
    }

    @RequestMapping(value="findByEmail", method=RequestMethod.GET)
    public User findByEmail(String email){
        User u = ur.findByEmail(email);
        return u;
    }

    @RequestMapping(value="deleteUser", method=RequestMethod.DELETE)
    public void deleteUser(String email){
        ur.delete(ur.findByEmail(email));
    }
}
