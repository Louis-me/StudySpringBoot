package xyz.shi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.shi.pojo.User;
import xyz.shi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("findPage")
    public List<User> findPage(Integer CurrentPage, Integer PageSize) {
        return userService.findPage(CurrentPage, PageSize);
    }
}