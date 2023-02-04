package userapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userapi.model.User;
import userapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/all-users", produces = "application/json", method=RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(produces = "application/json", method=RequestMethod.GET)
    public ResponseEntity<User> getUserByUserName(@RequestParam(value = "userName") String userName) {
        Optional<User> user = Optional.ofNullable(userRepository.findUserByUserName(userName));
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "/create", produces = "application/json", method=RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User newUser = new User(
                    user.getUserId(),
                    user.getUserName(),
                    user.getEmail(),
                    user.getCreatedAt(),
                    user.getUserToken());
            return new ResponseEntity<>(userRepository.save(newUser), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/delete/{userName}", produces = "application/json", method=RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteUserByUserName(@PathVariable(value="userName") String userName) {
        try {
            userRepository.deleteUserByUserName(userName);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
