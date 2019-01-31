package pl.coderslab.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.model.ValidationError;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;
import pl.coderslab.validationGroups.FullValidationGroup;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid User user, BindingResult errors, HttpSession session, Model model){
        if(errors.hasErrors()){
            return "user/loginForm";
        }
        List<ValidationError> violations = userService.login(user.getUsername(), user.getPassword(), session);
        if(violations.size() > 0){
            violations.forEach( err -> model.addAttribute(err.getSymbol(), err.getMessage()) );
            return "user/loginForm";
        }

        return "redirect:/";
    }


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "user/registerForm";
    }

    @PostMapping("/register")
    public String register(@Validated({FullValidationGroup.class}) User user, BindingResult errors, HttpSession session, Model model){
        if(errors.hasErrors()){
            return "user/registerForm";
        }
        List<ValidationError> violations = userService.register(user);
        if(violations.size() > 0){
            violations.forEach( err -> model.addAttribute(err.getSymbol(), err.getMessage()) );
            return "user/registerForm";
        }

        return "redirect:/";
    }

}

