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
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value="getAll", method= RequestMethod.GET)
    public List<Order> getAll(){
        List<Order> orders;
        orders = orderRepository.findAll();
        return orders;
    }

    @RequestMapping(value="addOrder", method=RequestMethod.POST)
    public void addOrder(Long iduser, Long idbook){
        Order order = new Order();
        User user = userRepository.getOne(iduser);
        order.setUser(user);
        Book book = bookRepository.getOne(idbook);
        order.setBook(book);
        order.setOrdertime(LocalDateTime.now());
        order.setStatus("waiting");
        orderRepository.save(order);
    }
}
