package com.tanay.restfulwebservices.jpa;

import com.tanay.restfulwebservices.hateoas.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>
{

}
