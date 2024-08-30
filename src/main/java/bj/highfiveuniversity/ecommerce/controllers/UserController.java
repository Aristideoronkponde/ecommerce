package bj.highfiveuniversity.ecommerce.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.ecommerce.models.User;
import bj.highfiveuniversity.ecommerce.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
     
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
       user= userRepository.findById(id);
      .orElsethrow(()-> new RuntimeException("user non trouvé"));

       return ResponseEntity.ok(user); 
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
    User  newUser = userRepository.save(user);
    return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User update = userRepository.findById(id).orElseThrow(()-> new RuntimeException("user avec id" + id + "non valide"));
    }
    public ResponseEntity<void> deleteUser(){}


}
