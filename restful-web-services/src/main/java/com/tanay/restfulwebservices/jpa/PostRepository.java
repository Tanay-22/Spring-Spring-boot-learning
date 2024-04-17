package com.tanay.restfulwebservices.jpa;

import com.tanay.restfulwebservices.hateoas.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer>
{

}
