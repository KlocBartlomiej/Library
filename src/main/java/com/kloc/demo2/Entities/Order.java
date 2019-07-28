package com.kloc.demo2.Entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
    @OneToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;
    private LocalDateTime ordertime;
    private LocalDateTime deliverdate;
    //TODO  enum ze statusami
    private String status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(LocalDateTime ordertime) {
        this.ordertime = ordertime;
    }

    public LocalDateTime getDeliverdate() {
        return deliverdate;
    }

    public void setDeliverdate(LocalDateTime deliverdate) {
        this.deliverdate = deliverdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
