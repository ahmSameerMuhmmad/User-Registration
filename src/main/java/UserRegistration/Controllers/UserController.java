package UserRegistration.Controllers;

import UserRegistration.Models.User;
import UserRegistration.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<String>addUser(@RequestBody User user){
        //// use try and catch block
        try{
            String response=userService.addUser(user);
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);

        }catch (Exception e){
            String response="Registration not successfully done";
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/checkValidation")
    public ResponseEntity<String> checkValidation(@RequestParam("email") String email, @RequestParam("password") String password){

        try{
            String response=userService.checkValidation(email,password);
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        }catch (Exception e){
            String response="User validation not successfully done";
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<User>>getAllUsers(){
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteUserByEmail")
    public ResponseEntity<String> deleteUserByEmail(@RequestParam("email")String email){
        try{
            userService.deleteUserByEmail(email);
            return new ResponseEntity<>("User deleted successfully!",HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            String response="User not deleted";
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }
}
