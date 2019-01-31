package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.User;
import pl.coderslab.model.ValidationError;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<ValidationError> register(User user){
        List<ValidationError> errors = new ArrayList<>();

        if(!user.getPassword().equals(user.getRepeatPwd())){
            errors.add(new ValidationError("pwdErr","repeatPwd","Wprowadzone hasła są różne"));
        }

        if(errors.size() == 0){
            user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
            userRepository.save(user);
        }

        return errors;
    }

    public List<ValidationError> login(String login, String password, HttpSession session){
        List<ValidationError> errors = new ArrayList<>();

        User user = userRepository.findFirstByUsername(login);
        if(user == null){
            errors.add(new ValidationError("loginErr","username","Użytkownik nie istnieje"));
            return errors;
        }

        if(!BCrypt.checkpw(password, user.getPassword())){
            errors.add(new ValidationError("pwdErr","password","Niepoprawne hasło"));
            return errors;
        }

        session.setAttribute("user", user);
        return errors;

    }

}
