//package com.tanay.restfulwebservices.hateoas.user;
//
//import com.tanay.restfulwebservices.hateoas.user.User;
//import com.tanay.restfulwebservices.hateoas.user.UserDaoService;
//import com.tanay.restfulwebservices.hateoas.user.UserNotFoundException;
//import jakarta.validation.Valid;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//class  UserResource
//{
//    private UserDaoService service;
//
//    public UserResource(UserDaoService service)
//    {
//        this.service = service;
//    }
//
//    @GetMapping("/users")
//    public List<User> retrieveAllUsers()
//    {
//        return service.findAll();
//    }
//
//    @GetMapping("/users/{id}")
//    public User retrieveUserById(@PathVariable int id )
//    {
//        User user = service.findOne(id);
//
//        if(user == null)
//            throw new UserNotFoundException("id : " + id);
//        return user;
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity<User> createUser(@Valid @RequestBody User user)
//    {
//        User savedUser =  service.save(user);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .build(savedUser.getId());
//
//        return ResponseEntity.created(location).build();
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable int id)
//    {
//        service.deleteById(id);
//    }
//}
