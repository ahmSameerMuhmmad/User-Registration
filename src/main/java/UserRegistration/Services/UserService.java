package UserRegistration.Services;

import UserRegistration.Models.User;
import UserRegistration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    public String addUser(User user){
        if (userRepository.existsByEmail(user.getEmail())) {
            return("Email already exists");
        }
        User newUser=new User();
        newUser.setName(user.getName());
        newUser.setGender(user.getGender());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
        return "User registration done successfully!";
    }

    public String checkValidation(String email,String password){
        User newUser= userRepository.findByEmail(email);
        if(newUser==null){
            return "User does not found";
        }
        if(!newUser.getPassword().equals(password)){
            return "Password is not correct Match";
        }
        return "Validation successfully done!";
    }

    public List<User> getAllUsers() {
        List<User>users=userRepository.findAll();
        return users;
    }

    public  String deleteUserByEmail(String email) {
        User newUser= userRepository.findByEmail(email);

        if(newUser==null){
            return "User not Found";
        }
            userRepository.delete(newUser);
            return "User successfully deleted!";


    }
}
