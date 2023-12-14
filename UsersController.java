package com.Neeharika.CRUDDemo.Controller;

import com.Neeharika.CRUDDemo.Model.Orders;
import com.Neeharika.CRUDDemo.Model.Users;
import com.Neeharika.CRUDDemo.Repository.OrdersRepo;
import com.Neeharika.CRUDDemo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {
    @Autowired
    private UserRepo userRepo;
    //get

    @GetMapping("/")
    public String welcomeMessage(){
        return "Welcome";
    }
    @GetMapping("/getUsers")
    public List<Users> getUsers(){
        return this.userRepo.findAll();
    }

    //get user by id
    @GetMapping("/getUsers/{id}")
    public Optional<Users> getUserById(@PathVariable(value = "id") int id ){
        Optional<Users> user;
        user = userRepo.findById(id);
        return (user);
    }

    //create user
    @PostMapping("/getUsers")
    public Users createUser(@RequestBody  Users user){
        return this.userRepo.save(user);
    }

    //Update User
    @PutMapping("/getUsers/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable(value = "id") int id, @RequestBody Users newUser ){
        Users user;
        user = userRepo.findById(id).orElse(null);
        assert user != null;
        user.setEmail(newUser.getEmail());
        user.setName(newUser.getName());
        return ResponseEntity.ok(this.userRepo.save(user));
    }


    //Delete User
    @DeleteMapping("/getUsers/{id}")
    public String deleteEmployee( @PathVariable (value ="id") int id){
        Users user;
        user = userRepo.findById(id).orElse(null);
        this.userRepo.delete(user);
        return "Deleted: "+ user.getName();
    }



}
