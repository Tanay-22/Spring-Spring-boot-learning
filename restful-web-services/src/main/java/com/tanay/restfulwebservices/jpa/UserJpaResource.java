package com.tanay.restfulwebservices.jpa;

import com.tanay.restfulwebservices.hateoas.user.Post;
import com.tanay.restfulwebservices.hateoas.user.User;
import com.tanay.restfulwebservices.hateoas.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class UserJpaResource
{

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJpaResource(UserRepository repository, PostRepository postRepository)
    {
        this.userRepository = repository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable int id )
    {
        Optional<User> user = userRepository.findById(id);
        /*A container object which may or may not contain a non-null value.
        If a value is present, isPresent() will return true and get() will return the value.*/

        if(user.isEmpty())
            throw new UserNotFoundException("id : " + id);

        EntityModel<User> model = EntityModel.of(user.get());
        //wrapping a domain object and adding links to it

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        //Builder to ease building Link instances pointing to Spring MVC controllers.

        model.add(link.withRel("all-users"));

        return model;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user)
    {
        User savedUser =  userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .build(savedUser.getId());

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllPosts(@PathVariable int id)
    {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id : " + id);

        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post)
    {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id : " + id);

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .build(savedPost.getId());

        return ResponseEntity.created(location).build();
    }
}
