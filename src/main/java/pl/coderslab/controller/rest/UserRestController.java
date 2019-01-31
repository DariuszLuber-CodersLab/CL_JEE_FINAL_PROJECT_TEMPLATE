package pl.coderslab.controller.rest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.model.ValidationError;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("")
    @ResponseBody
    public String list() {
        List<User> userList = userRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(userList);
            return json;
        }catch (Exception e){
            return "{'error': 'Parse problem'}";
        }
    }

    @PostMapping("")
    @ResponseBody
    public String add(@RequestBody String requestBody) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            User user =  mapper.readValue(requestBody, User.class);
            List<ValidationError> violations = userService.register(user);
            if(violations.size() > 0){
                return mapper.writeValueAsString(violations);
            }else{
                return mapper.writeValueAsString(user);
            }
        } catch (IOException e) {
            return "{'error':'Parse error'}";
        }
    }



}
