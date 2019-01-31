package pl.coderslab.controller.rest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<User> list() {
        List<User> userList = userRepository.findAll();
        return userList;
    }
}
