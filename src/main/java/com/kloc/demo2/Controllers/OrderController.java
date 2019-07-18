package com.kloc.demo2.Controllers;

import com.kloc.demo2.Entities.Book;
import com.kloc.demo2.Entities.Order;
import com.kloc.demo2.Entities.User;
import com.kloc.demo2.Repositories.BookRepository;
import com.kloc.demo2.Repositories.OrderRepository;
import com.kloc.demo2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    private OrderRepository or;
    @Autowired
    private UserRepository ur;
    @Autowired
    private BookRepository br;

    @RequestMapping(value="getAll", method= RequestMethod.GET)
    public List<Order> getAll(){
        List<Order> orders = new ArrayList<>();
        orders = or.findAll();
        return orders;
    }

    @RequestMapping(value="addOrder", method=RequestMethod.POST)
    public void addOrder(Long iduser, Long idbook){
        Order o = new Order();
        User user = ur.getOne(iduser);
        o.setUser(user);
        Book book = br.getOne(idbook);
        o.setBook(book);
        Date ordertime = new Date();
        o.setOrdertime(ordertime);
        o.setStatus("waiting");
        or.save(o);
    }
}
